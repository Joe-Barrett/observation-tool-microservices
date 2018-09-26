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

package com.prototype.ot.microservices.generationservice.receivers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static alma.obsprep.newot.functionality.BatchGenerateSBs.Result;
import static alma.obsprep.newot.functionality.BatchGenerateSBs.generateSBsForProject;

/**
 * Handler used to handle background updates to the Project on the server.
 * Currently performs a batch update of the SBs in the project.
 *
 * A request is created each time a project is 'put'  or if an explicit request
 * is made to generateSBs
 *
 * The 'alma.obsprep.newot.functionality.BatchGenerateSBs' is a wrapper to the
 * code within the 'batch-generate' jar. This is the code taken from the existing OT
 * used to generate SBs.
 *
 * Errors or Warnings caused during generation are currently logged to the console
 * but no action is taken.
 */
@Component
public class ProjectUpdateReceiver {

    private final static String PROJECT_DIRECTORY = "/data/projects/";

    @RabbitListener(queues = "project-update-queue")
    public void receiveProjectUpdate(String filename) {

        Result result =
                generateSBsForProject(PROJECT_DIRECTORY, filename);

        //TODO Do something better with the reply
        System.out.println(result.description + ":" + result.exception);
    }

}
