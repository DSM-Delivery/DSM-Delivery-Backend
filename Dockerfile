FROM eclipse-temurin:18-jre-focal

EXPOSE 8080
ENV TZ=Asia/Seoul

COPY build/libs/*.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]