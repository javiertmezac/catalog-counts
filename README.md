# Catalog Counts Service
> Custom development

[![ECS CatalogCount Service DesireCount](https://github.com/javiertmezac/catalog-counts/actions/workflows/ecs-service-desire-count.yml/badge.svg)](https://github.com/javiertmezac/catalog-counts/actions/workflows/ecs-service-desire-count.yml)

## Overall Tools
- MyBatis
- Jetty
- Jersey
- Junit
- Flyway
- Google Guice
- Docker, Docker compose

## How to set CC-Service Version
`mvn versions:set -DnewVersion= < version >`

## Deployment
### Specifications
- Mysql Engine: 8.0.28

### Deployment to ECS - Fargate
just run the [push_to_ecr.sh](./provision/push_to_ecr.sh) file
to create a new docker image of the code and after
that upload the image to ECR.

Once docker image is uploaded, we just need to change
the ECS Task definition, so new tasks are updated with
new image.

1. Log in into AWS Console
2. update Task definition - create new task definition with correct image tag
3. ECS Service, should update the task and include the new IP into TARGET GROUP.

## How to launch cc-service locally
just run the [local-provision.sh](./local-provision.sh) file

docker compose will crate following containers:
1. mysql:8.0.28: cc-service-db
2. flyway:6.5.5: cc-service-flyway
3. app: cc-service

Some useful commands to troubleshoot:
- `docker compose up --no-recreate`
- `docker compose restart <service>`

To create a copy of db data
```
  docker exec cc-service-db /usr/bin/mysqldump -u root \
  --extended-insert --ignore-table=catalog_count.flyway_schema_history \
  --no-create-db --no-create-info --compact --password=${MYSQL_ROOT_PASS} \
  catalog_count backup.sql
```
---
### Digital Ocean Manual Deployment - deprecated
> Digital Ocean App: docker image
> registry.digitalocean.com/cc-service/cc-service-image
1. Make sure you are login into registry: `doctl registry login`
2. Push image: `docker push registry.digitalocean.com/cc-service/cc-service-image:<tag>`
3. `doctl apps list` : and make sure to pick correct app id
4. `doctl apps update <id> --spec /path/to/spec.yaml`