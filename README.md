# Catalog Counts Service
> Custom development

[![ECS CatalogCount Service DesireCount](https://github.com/javiertmezac/catalog-counts/actions/workflows/ecs-service-desire-count.yml/badge.svg)](https://github.com/javiertmezac/catalog-counts/actions/workflows/ecs-service-desire-count.yml)
[![Java CI with Maven](https://github.com/javiertmezac/catalog-counts/actions/workflows/maven.yml/badge.svg)](https://github.com/javiertmezac/catalog-counts/actions/workflows/maven.yml)

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
every push to main branch a github workflow gets executed
and performs deployment to ECS

- [github workflow](.github/workflows/aws-ecs-deploy.yml)

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
mysqldump -h ${CC_SERVICE_DB_HOST} -u admin --extended-insert \
  --ignore-table=catalog_count.flyway_schema_history \
  --ignore-table=catalog_count.catalog_count_enum \
  --ignore-table=catalog_count.timezone_type \
  --no-create-db --no-create-info --compact \
  --password=${MYSQL_ROOT_PASS} \
  --single-transaction --set-gtid-purged=OFF \
  catalog_count > backup.sql
```
cp to docker container: `docker cp backup_08162025.sql cc-service-db:/`

To import the copy to a db
```
mysql --init-command="SET SESSION FOREIGN_KEY_CHECKS=0;" \
-u root -p catalog_count < backup_08162025.sql
```

### Excel Import

Manual process to "update" previous month's movements
1. get last month's movements in excel_sheet file - consider format
2. POST /cc-service/api/v1/excelimport
   1. ```json
      {
         "personProfileId": "c70d4cfe-0f68-482d-8e82-5952fadba5e4",
         "fileStorageKey": "excel-import/example1copy.xlsx",
         "tabName": "Registros 2023"
      }
    ```
3. `docker exec -it cc-service-db`
4. `mysqldump -p --no-create-info catalog_count catalog_count > data_dump.sql`
5. `docker cp cc-service-db:/data_dump.sql .`

---
### Digital Ocean Manual Deployment - deprecated
> Digital Ocean App: docker image
> registry.digitalocean.com/cc-service/cc-service-image
1. Make sure you are login into registry: `doctl registry login`
2. Push image: `docker push registry.digitalocean.com/cc-service/cc-service-image:<tag>`
3. `doctl apps list` : and make sure to pick correct app id
4. `doctl apps update <id> --spec /path/to/spec.yaml`

### Digital Ocean - Single Droplet
1. command to run application - (java -jar )
   1. [/etc/systemd/system/cc-service.service](/documentation/digital_ocean/cc-service.service), systemctl enabled cc-service (reboot)
   2. Nginx - [configuration_file](/documentation/digital_ocean/nginx.conf)
2. environment variables, .env, profile `set -o allexport; source /home/.env; set +o allexport` (cmd)