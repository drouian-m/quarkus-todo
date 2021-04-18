# quarkus-todo project

My first dummy app to discover Quarkus 🎉

## Run postgres db

```
docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 --name quarkus_test -e POSTGRES_USER=hibernate -e POSTGRES_PASSWORD=hibernate -e POSTGRES_DB=quarkus_todo -p 5432:5432 postgres:latest
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Swagger UI

http://localhost:8080/q/swagger-ui/#/

## Health UI

http://localhost:8080/q/health-ui/
