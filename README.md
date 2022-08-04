# Worst-Movie API

> Desenvolvido por Lucas Bortolatto da Conceição

## Tecnologias utilizadas

- [Spring Boot] - Framework para criação de aplicações web com Java (utilizado nesse projeto) ou Kotlin.
- [JUnit 5] - Framework de testes para Java.
- [H2] - Sistema de Gerenciamento de Banco de Dados embarcado.


## Instalação e utilização

A API foi criada utilizando Java 11, então será necessária a utilização da [JDK 11] para a execução da mesma.
Além da JDK você também precisará ter o [Maven] configurado na máquina.
Após a configuração de ambas as ferramentas você pode instalar as dependências do projeto através da sua IDE preferida ou rodando os seguintes comandos:
```sh
mvn install
```

Caso deseje rodar a suíte de testes via terminal (você também consegue rodar através da sua IDE preferida), pode seguir os comandos abaixo:
```sh
mvn test
```

Para executar a aplicação, execute o comando abaixo
```sh
mvn spring-boot:run
```

> Observação: O caminho padrão para o arquivo .CSV dos filmes é `src/main/resources/movielist.csv`, podendo ser alterado através do arquivo de propriedades padrão do Spring Boot `application.properties` pela configuração `awards.file.path`. Sinta-se à vontade para utilizar novos arquivos visando essa configuração.

### Realizando a requisição do produtor com maior intervalo entre dois prêmios consecutivos e do que obteve dois prêmios mais rápido

`GET /producers/max-min-intervals`

    curl -i -H 'Accept: application/json' http://localhost:8080/producers/max-min-intervals

### Exemplo de Resposta

    HTTP/1.1 200 
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Thu, 04 Aug 2022 18:06:25 GMT


    {
        "min": [
            {
                "producer": "Joel Silver",
                "interval": "1",
                "previousWin": "1990",
                "followingWin": "1991"
            }
        ],
        "max": [
            {
                "producer": "Matthew Vaughn",
                "interval": "13",
                "previousWin": "2002",
                "followingWin": "2015"
            }
        ]
    }

[JUnit 5]: <https://junit.org/junit5/>
[H2]: <https://www.h2database.com/html/main.html>
[Maven]: <https://maven.apache.org/>
[JDK 11]: <https://bell-sw.com/pages/downloads/#/java-11-lts>
[Spring Boot]: <https://spring.io/projects/spring-boot>