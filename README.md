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

The `lang` parameter is language. Only `pl` is supported.

The `category` parameter is news category. Supported values are `business`, `entertainment`, `general`, `health`, `science` `sports` and `technology`

### Searching
http://localhost:8080/news/search/{query}/{page}

The `query` parameter is key word to find an article.

The `page` parameter is page of results. The function sends 10 articles per page.
