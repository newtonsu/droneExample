FROM store/oracle/serverjre:8
MAINTAINER newtonsu

ADD example-1.0-SNAPSHOT-jar-with-dependencies.jar example.jar
# 容器启动后执行的命令
CMD java -jar /example.jar