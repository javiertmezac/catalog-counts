#/bin/bash
cd ../
docker build -t cc-service-image .

docker run -it -p 8080:8080 \
  -e JDBC_URL="jdbc:mysql://host.docker.internal:3306/catalog_count?serverTimezone=UTC" \
  -e JDBC_USERNAME=root \
  -e JDBC_PASSWORD=Password1 cc-service-image