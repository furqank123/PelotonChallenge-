#!/bin/bash

CITY=$1
URL="http://api.openweathermap.org/data/2.5/weather?q=${CITY}&APPID=2b4478678efbea7c59c32a6df3ac4a62"
TEMP_MIN=$(curl -s ${URL} | jq -r '.main.temp_min')
TEMP_MAX=$(curl -s ${URL} | jq -r '.main.temp_max')

echo "The minimum temperature in ${CITY} is ${TEMP_MIN} Kelvin and a maximum of ${TEMP_MAX} Kelvin today."