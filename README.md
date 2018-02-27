# News Browser

## Requirements
1. Java 8
2. Maven
3. GIT

## Install Maven project
`mvn clean install`

## Run server
`mvn spring-boot:run`

## Run tests
`mvn test`

## API
### Top News
http://localhost:8080/news/{lang}/{category}
### Searching
http://localhost:8080/news/search/{query}/{page}
