# Catalog Counts Service
> Custom development

## Tools
- MyBatis
- Jetty
- Jersey
- Junit
- Flyway
- Google Guice

## Deployment
### Dockerized the service
1. `mvn package` to generate .jar with latest changes
2. `docker build -t cc-service-image:<tag> .`
3. `docker tag cc-service-image:<tag> registry.digitalocean.com/cc-service/cc-service-image:<tag>`

### Deployment to ECS - Fargate
1. Push image: `docker push public-repo:<tag>`
2. Log in into AWS Console
3. update Task definition - create new task definition with correct image tag
4. Manually launch new task (this will create new ip address)
5. For now, edit application load balancer target group and register new task internal ipv4

###Deployment (Manual) - deprecated
> Digital Ocean App: docker image
1. Make sure you are login into registry: `doctl registry login`
2. Push image: `docker push registry.digitalocean.com/cc-service/cc-service-image:<tag>`
3. `doctl apps list` : and make sure to pick correct app id
4. `doctl apps update <id> --spec /path/to/spec.yaml`