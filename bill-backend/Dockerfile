FROM eclipse-temurin:17-jdk-alpine as build
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
#use new features to extract fat jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /opt
ENV PORT 8088
EXPOSE 8088
#layers
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./

ENV API_SECRET_KEY=place_holder

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]