#!/bin/bash
clear

mvn package
docker compose kill cc-app
docker compose build --no-cache cc-app
docker compose create cc-app
docker compose start cc-app
