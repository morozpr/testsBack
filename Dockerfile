FROM openjdk:22-slim
VOLUME /tmp
EXPOSE 8080
COPY app_new.jar app_new.jar
ENTRYPOINT ["java","-jar","/app_new.jar"]
