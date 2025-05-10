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
java -jar api--customer-user-0.0.1-SNAPSHOT.jar
```



* **Clayton Morais de Oliveira**
