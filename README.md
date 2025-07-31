# api--customer

Projeto para utilização de Serviço Rest com Spring Boot


O projeto contém alguns exemplos de serviço REST. O projeto já está configurado em modo standalone


```
Java 21 : ([https://www.oracle.com/br/java/technologies/javase/jdk17-archive-downloads.html]);

Spring Boot na versão 3.2.6:  (https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-dependencies/3.2.6);

Maven 3.9.5: (https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz)

Eclipse ou Intellij

Docker: Para Rodar o arquivo docker-compose (Contido no projeto principal) que contém a imagem do mysql para facilitar a integração

Postman para Testes : (https://www.postman.com/downloads/)
```

Para acessar a documentação do Swagger, utilize o link abaixo (Local):

```
http://localhost:5000/swagger-ui/index.html
```


Utilize o postman Para rodar os testes.

Collection estão na raiz do repositório.


```
api--customer.postman_collection.json
```


Inicie com a classe Application.java


Basta executar o comando maven install

Para rodar, vá na pasta target onde tem o artefato gerado e execute o comando:

```
java -jar api--customer-0.0.1-SNAPSHOT.jar
```

## Rodando via Docker (Precisa ter o Docker Instalado)

Rodando via docker-compose

Para criar o banco de dados postgresql, execute o comando abaixo:

```
docker-compose up
```

Execute o comando para gerar a imagem via Docker

```
docker build -t api--customer .
```

Para executar o container, rode o comando abaixo:

```
docker run --name api--customer \
      --network iaton-network \  
      -p 5000:5000 \
      -e SPRING_PROFILES_ACTIVE=dev,jsonlog,logbook
      -e KAFKA_BOOTSTRAP_SERVER=<URL DO KAFKA>
      -e KAFKA_SCHEMA_REGISTRY=<URL DO SCHEMA REGISTRY DO KAFKA>      
      -e POSTGRES_HOST=<IP DO BANCO>
      -e POSTGRES_DATABASE=<DATABASE DO BANCO>
      -e POSTGRES_USERNAME=<USUARIO DE BANCO>
      -e POSTGRES_PASSWORD=<SENHA DO BANCO>
      -e OTEL_EXPORTER_OTLP_ENDPOINT=<URL DO OPEN TELEMETRY>
      api--customer:latest
      
```


* **Clayton Morais de Oliveira**
