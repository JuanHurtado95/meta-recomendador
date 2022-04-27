FROM openjdk:11.0.15

RUN mkdir /app
WORKDIR /app

COPY ./build/libs/*.jar
EXPOSE 8083
CMD java -jar meta-recomendador-0.0.1-SNAPSHOT.jar