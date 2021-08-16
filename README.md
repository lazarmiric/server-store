# Store application - Clojure 

## About application

This is is a Leiningen project written in clojure that provides a REST API for an tehnical shop, where we use customer,order and product. It uses korma to communicate with MySQL, ring for writing web application, swagger for api testing and documentation.

## Project architecture

/src/domain - there is domain database entities

/src/connection - there is code which provide connection with MySQL server

/src/queries - there is SQL query for entities, data layer

/src/handler - provides application logic  - API routes, respond for HTTP request

## Requirements

First you need to install JAVA on your Machine. After that install Leiningen and MySQL for creating database.

## Running application

Run next command in the root of the project.
>.\lein ring server

This command will start a server and open a Swagger API Documentation.

![swagger documentation](https://i.ibb.co/MN8dM1W/swagger.png)
## Test

Tests is in test\server\core_test.clj class. 
Tests can be run by typing command:
>.\lein test

After running this command, if everything is OK, the following message will appear:
>Ran 4 tests containing 4 assertions.
0 failures, 0 errors.

## License
Copyright © 2021 Lazar Miric