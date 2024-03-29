#!/bin/bash
clear

DEFAULT_DB_PASS="Password1"
DEFAULT_CC_SERVICE_KEY="some_random_value_here_what_else_can_I_use"
export MYSQL_ROOT_PASSWORD=$DEFAULT_DB_PASS
export CC_SERVICE_KEY=$DEFAULT_CC_SERVICE_KEY


printf "[INFO] Packaging application\n"
mvn install

printf "[INFO] Creating infrastructure....\n"
docker compose -f ./docker-compose.yml up \
  -d --build --force-recreate

unset MYSQL_ROOT_PASSWORD
unset CC_SERVICE_KEY
