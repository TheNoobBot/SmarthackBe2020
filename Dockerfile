# select parent image
FROM maven:3.6.3-jdk-11
# copy the source tree and the pom.xml to our new container
COPY ./ ./
# package our application code
RUN mvn clean package -DskipTests -Djar.finalName=app && ls target/
ENTRYPOINT ["java","-jar","target/app.jar"]
