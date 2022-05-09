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
ECR_REPO="251143205581.dkr.ecr.us-west-1.amazonaws.com"
IMAGE_TAGGED=$ECR_REPO"/catalog-counts":$tag

if [[ -z "$tag" ]]; then
  echo "please specify tag version"
  exit 1
fi

echo "tag to be used: $tag"

cd ../
pwd
mvn clean package

echo
echo "BUILDING IMAGE......"
docker build -t cc-service-image:$tag .

echo
echo "TAGGING IMAGE......"
docker tag cc-service-image:$tag $IMAGE_TAGGED

echo "IMAGE TAGGED.... SEARCHING IMAGE!!"
docker images | grep $ECR_REPO"/catalog-counts"

echo
echo "Would you like to continue pushing the image? [Y/N]" $tag
read varanswer

if [[ "$varanswer" == "Y" ]]; then
  echo "LOGGING INTO ECR REPO...."
  aws ecr get-login-password --profile javier.meza \
    --region us-west-1 | docker login --username AWS --password-stdin $ECR_REPO
  echo
  echo "PUSHING IMAGE.... $IMAGE_TAGGED"
  docker push $IMAGE_TAGGED
else
  echo "CANCELING PUSH OF IMAGE $IMAGE_TAGGED"
  echo "bye.....!"
  exit 1
fi

