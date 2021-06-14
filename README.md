# Catalog Counts Service
> Custom development

## Tools
- MyBatis
- Jetty
- Jersey
- Junit
- Flyway
- Google Guice

##Deployment (Manual)
> Digital Ocean App: docker image
1. `mvn package` to generate .jar with latest changes
2. `docker build -t cc-service-image:<tag> .`
3. `docker tag cc-service-image:<tag> registry.digitalocean.com/cc-service/cc-service-image:<tag>`
4. Make sure you are login into registry: `doctl registry login`
5. Push image: `docker push registry.digitalocean.com/cc-service/cc-service-image:<tag>`
6. `doctl apps list` : and make sure to pick correct app id
7. `doctl apps update <id> --spec /path/to/spec.yaml`