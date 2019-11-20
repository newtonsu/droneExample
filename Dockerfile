FROM maven:3-jdk-8 as builder
WORKDIR /usr/src/mymaven
COPY . /usr/src/mymaven
#RUN mvn assembly:assembly

FROM maven:3-jdk-8
COPY --from=builder /usr/src/mymaven/target/ /usr/src/mymaven
ENTRYPOINT ["java",  "-jar", "/usr/src/mymaven/example-1.0-SNAPSHOT-jar-with-dependencies.jar"]