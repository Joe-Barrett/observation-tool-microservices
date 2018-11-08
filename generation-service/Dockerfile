# ALMA - Atacama Large Millimeter Array
# Copyright (c) UKATC - UK Astronomy Technology Centre, Science and Technology Facilities Council, 2018
# (in the framework of the ALMA collaboration).
# All rights reserved.
#
# This library is free software; you can redistribute it and/or
# modify it under the terms of the GNU Lesser General Public
# License as published by the Free Software Foundation; either
# version 2.1 of the License, or (at your option) any later version.
#
# This library is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
# Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public
# License along with this library; if not, write to the Free Software
# Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA

FROM maven:3.5-jdk-8-alpine AS MAVEN
COPY /src /usr/src
COPY /lib /usr/lib
COPY /pom.xml /usr/
COPY /Dockerfile /usr
RUN mvn -f /usr/pom.xml clean
RUN mvn -f /usr/pom.xml package

FROM openjdk:8-jre-alpine
COPY --from=MAVEN /usr/target/generation-service-0.0.1.jar //
ENTRYPOINT ["java", "-jar", "/generation-service-0.0.1.jar", "-Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n"]