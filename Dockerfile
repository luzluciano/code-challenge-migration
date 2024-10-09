# Use a imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho no container
WORKDIR /app

# Copie o JAR gerado para o diretório de trabalho
COPY target/dummyjson-client-1.0-SNAPSHOT.jar app.jar

# Exponha a porta em que sua aplicação Spring Boot será executada
EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
