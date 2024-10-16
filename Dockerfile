# Use uma imagem base do JDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven para o container
COPY target/seu-app.jar app.jar

# Exponha a porta que o Render espera (10000)
EXPOSE 10000

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]