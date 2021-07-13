#!/bin/bash

# 1. mvn package
# 2. docker build with tag
  #docker build -t cc-service-image:0.4.1  .
# 3. docker tag
  #docker tag cc-service-image:0.4.1 public.ecr.aws/c5b3a9t9/catalog-counts:0.4.1
# 4. login
  #aws ecr-public get-login-password \ 
  #--region us-east-1 --profile javier.meza | docker login --username AWS --password-stdin public.ecr.aws/c5b3a9t9
# 5. docker push with tag
  #docker push public.ecr.aws/c5b3a9t9/catalog-counts:0.4.1

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
