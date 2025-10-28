#stage 1
#Start with a base image containing Java runtime
FROM openjdk:11-slim AS builder

# Add Maintainer Info
LABEL maintainer="Illary Huaylupo <illaryhs@gmail.com>"

# The application's jar file
#ARG JAR_FILE

# Add the application's jar to the container
#COPY ${JAR_FILE} app.jar
COPY target/*.jar app.jar

#unpackage jar file
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

# Extract the jar file using an efficient layout
#RUN java -Djarmode=tools -jar app.jar extract --layers --destination extracted

#stage 2
#Same Java runtime
FROM openjdk:11-slim

#WORKDIR /application
# Copy the extracted jar contents from the builder container into the working directory in the runtime container
# Every copy step creates a new docker layer
# This allows docker to only pull the changes it really needs
COPY --from=builder /target/dependency/BOOT-INF/lib /application/lib
COPY --from=builder /target/dependency/META-INF /application/META-INF
COPY --from=builder /target/dependency/BOOT-INF/classes /application
# Start the application jar - this is not the uber jar used by the builder
# This jar only contains application code and references to the extracted jar files
# This layout is efficient to start up and CDS/AOT cache friendly
#ENTRYPOINT ["java", "-jar", "application.jar"]
ENTRYPOINT ["java","-cp","app:app/lib/*","com.optimagrowth.eureka.EurekaServerApplication"]

#Add volume pointing to /tmp
#VOLUME /tmp

#Copy unpackaged application to new container
#ARG DEPENDENCY=/target/dependency
# --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

#execute the application
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.optimagrowth.eureka.EurekaServerApplication"]