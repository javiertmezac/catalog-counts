# Catalog Counts Service
> Custom development

## Tools
- MyBatis
- Jetty
- Jersey
- Junit
- Flyway
- Google Guice
- Docker, Docker compose

## Deployment
### Specifications
- Mysql Engine: 8.0.28


### Dockerized the service
1. `mvn package` to generate .jar with latest changes
2. `docker build -t cc-service-image:<tag> .`
3. `docker tag cc-service-image:<tag> <repo>:<tag>`

### Deployment to ECS - Fargate
1. Push image: `docker push public-repo:<tag>`
2. Log in into AWS Console
3. update Task definition - create new task definition with correct image tag
4. Manually launch new task (this will create new ip address)
5. For now, edit application load balancer target group and register new task internal ipv4

###Deployment (Manual) - deprecated
> Digital Ocean App: docker image
> registry.digitalocean.com/cc-service/cc-service-image
1. Make sure you are login into registry: `doctl registry login`
2. Push image: `docker push registry.digitalocean.com/cc-service/cc-service-image:<tag>`
3. `doctl apps list` : and make sure to pick correct app id
4. `doctl apps update <id> --spec /path/to/spec.yaml`

## How to set CC-Service Version
`mvn versions:set -DnewVersion= < version >`

## Local Development
`mysql.server start`

### Environment Variables
```text
JDBC_USERNAME=root; JDBC_PASSWORD=Password1; JDBC_URL=jdbc:mysql://localhost:3306/catalog_count?serverTimezone\=UTC
```