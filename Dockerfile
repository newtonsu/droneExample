FROM 172.31.30.5:8083/oracle-jre
#WORKDIR /usr/
#COPY . /usr/
ADD ./build/libs/example.jar example.jar
#RUN mvn assembly:assembly

#FROM maven:3-jdk-8
#CZOPY --from=builder /usr/build/ /usr/src/mymaven
ENTRYPOINT ["java",  "-jar", "example.jar"]