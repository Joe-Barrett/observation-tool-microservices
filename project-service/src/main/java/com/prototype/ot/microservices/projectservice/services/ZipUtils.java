package com.prototype.ot.microservices.projectservice.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtils {

    public static class ZipReader {

        private ZipInputStream zipInputStream;
        private ByteArrayOutputStream buffer;
        private byte[] minibuffer;

        public ZipReader(InputStream inputStream) {
            zipInputStream = new ZipInputStream(inputStream);
            buffer = new Buffer(256 * 1024);
            minibuffer = new byte[10 * 1024];
        }

        public void close() throws IOException {
            zipInputStream.close();
            buffer.close();
            minibuffer = null;
        }

        public ZipNtry getZipEntry() throws IOException {
            buffer.reset();
            ZipEntry entry = zipInputStream.getNextEntry();
            if (entry == null) {
                return null;
            }

            while (true) {
                int n = zipInputStream.read(minibuffer);
                if (n < 0) {
                    break;
                }
                buffer.write(minibuffer, 0, n);
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

    public static class ZipNtry extends ZipEntry {

        byte data[];

        public ZipNtry(ZipEntry e, byte data[]) {
            super(e);
            this.data = data;
        }

        public byte[] getData () {
            return data;
        }
    }

}
