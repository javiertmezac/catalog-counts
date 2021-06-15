#!/bin/bash

# 1. mvn package
# 2. docker build with tag
# 3. docker tag
# 4. login
# 5. docker push with tag

tag=$1
if [[ -z "$tag" ]]; then
  echo "please specify tag version"
  exit 1
fi

echo "tag to be used: $tag"

mvn clean package

echo
echo "BUILDING IMAGE"
cd ../
docker build -t cc-service-image:$tag .
