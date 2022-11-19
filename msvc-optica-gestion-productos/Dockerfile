FROM openjdk:11.0.13

WORKDIR /app

COPY ./build/libs/msvc-optica-gestion-productos-0.0.1-SNAPSHOT.jar .

EXPOSE 8002

ENTRYPOINT ["java", "-jar", "msvc-optica-gestion-productos-0.0.1-SNAPSHOT.jar"]

#WORKDIR /app/msvc-optica-gestion-productos
#
#COPY ./build.gradle /app
#COPY ./msvc-optica-gestion-productos/ .
#
#RUN ./gradle clean package -DskipTests
#
#EXPOSE 8002
#
#CMD ["java", "-jar", "./build/libs/msvc-optica-gestion-productos-0.0.1-SNAPSHOT.jar"]
#


