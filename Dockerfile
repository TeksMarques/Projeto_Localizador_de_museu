# Dockerfile para construção da imagem multiestágio

# Primeiro estágio (compilação)
FROM maven:3.8.1-jdk-17 as build-image
# Define o diretório de trabalho
WORKDIR /to-build-app
# Executa o comando para baixar as dependências, aproveitando o cache
RUN mvn dependency:go-offline
# Copia o código-fonte para o diretório de trabalho
COPY . .
# Executa o comando de empacotamento do maven
RUN mvn clean package -DskipTests

# Segundo estágio (imagem final)
FROM openjdk:17-jdk-bullseye
# Define o diretório de trabalho
WORKDIR /app
# Copia o JAR gerado no primeiro estágio para o diretório de trabalho do segundo estágio
COPY --from=build-image /to-build-app/target/*.jar /app/app.jar
# Expõe a porta 8080
EXPOSE 8080
# Define o comando de execução da aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
