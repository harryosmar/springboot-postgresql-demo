
## Start the API

```shell
docker-compose up -d

mvn clean install

# start server http://localhost:8080
mvn spring-boot:run
```


## Open API docs / Swagger

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

![swagger](https://raw.githubusercontent.com/harryosmar/springboot-postgresql-demo/refs/heads/master/swagger.png)