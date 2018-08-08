/*
 * ALMA - Atacama Large Millimeter Array
 * Copyright (c) UKATC - UK Astronomy Technology Centre, Science and Technology Facilities Council, 2018
 * (in the framework of the ALMA collaboration).
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA
 */
/*
 * Created on Aug 10, 2010 by mschilli
 */
package com.prototype.ot.microservices.projectservice.utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/**
 * Utility class for dealing with Zip files. The OT's AOT files for persisting projects on
 * disk are actually Zip files in disguise.
 * 
 * @author M.Schilling, ESO
 */
class ZipSupport {

	/*
	 * msc 2010-08: The code below used to live as static methods in FileUtilities, opposed
	 * to them this code can be instantiated, and thus different threads can have their
	 * own instances.
	 */


	/**
	 * Utility for reading zip contents from a stream.
	 */
	public static class ZipReader {

		private ZipInputStream zin;

		private ByteArrayOutputStream buffer;
		private byte[] minibuf;

		ZipReader(InputStream in) {
			zin = new ZipInputStream(in);

			buffer = new Buffer(256 * 1024); // 256K
			minibuf = new byte[10 * 1024]; // 10K
		}

		public void close () throws IOException {
			zin.close();
			buffer.close();
			minibuf = null;
		}

		ZipNtry getZipEntry() throws IOException {
			buffer.reset();

			// Note: when dealing with ZipInputStreams, method
			// ZipEntry.getSize() always returns -1
			// -------------------------------------------------
			ZipEntry entry = zin.getNextEntry();
			if (entry == null) {
				return null;
			}

			while (true) {
				int n = zin.read(minibuf);
				if (n < 0)
					break;
				buffer.write(minibuf, 0, n);
			}

			byte[] data = buffer.toByteArray();
			entry.setSize(data.length);
			ZipNtry ret = new ZipNtry(entry, data);
			return ret;
		}

		class Buffer extends ByteArrayOutputStream {

			Buffer(int initialSize) {
				super(initialSize);
			}

			@Override
			public void close () throws IOException {
				super.buf = null; // help the garbage collector
			}

		}

	}
	
	
	/**
	 * Utility for reading zip contents to a stream.
	 */
	static class ZipWriter {

		private ZipOutputStream zout;

		ZipWriter(OutputStream out) {
			zout = new ZipOutputStream(out);
		}

		/**
		 * Append a zip entry.
		 * 
		 * @param path - the "path" of the entry
		 * @param data - the content of the entry
		 * @throws IOException If something went wrong while reading the file.
		 */
		void putZipEntry(String path, byte[] data) throws IOException {
			ZipEntry entry = new ZipEntry(path);
			entry.setSize(data.length);
			zout.putNextEntry(entry);
			zout.write(data, 0, data.length);
		}

		void close() throws IOException {
			zout.close();
		}
	}


	/**
	 * This class is an extension of ZipEntry, that includes the actual data of the Zip
	 * file entry.
	 */
	public static class ZipNtry extends ZipEntry {

		byte data[];

		ZipNtry(ZipEntry e, byte data[]) {
			super(e);
			this.data = data;
		}

		public byte[] getData () {
			return data;
		}
	}

	

}
