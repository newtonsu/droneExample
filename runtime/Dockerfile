FROM maven:3-jdk-8 as builder
WORKDIR /usr/src/mymaven
COPY ../ /usr/src/mymaven
#RUN mvn assembly:assembly
RUN mvn install
