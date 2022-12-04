# geoLocalized

## Table of Contents
* [Technology Stack](#technology-stack)
* [Features](#features)
* [Setup](#setup)
* [Acknowledgements](#acknowledgements)

## Technology Stack
- Java (JDK Corretto 17.0.5)
- Maven (2.7.6)
- Spring Boot (2.7.6)
- Spring Data (2.7.6)
- Spring Security (2.7.6)
- Project Lombok (1.18.24)
- REST Assured (5.3.0)
- Git (2.33.0.windows.2)
- Log4j (2.19.0)
- Gson (2.10)
- H2 Database (2.1.214)
- IntelliJ IDEA (2022.2.3) 


## Requirements
- Windows 10 (tested)
- JRE 17.0.5 Runtime 61.0 (version which release package was compiled)

## Setup
There is two methods to prepare service to run:

### Using provided package in release

1. Download package from [release](https://github.com/Garin1998/geoLocalized/releases)
2. Repack anywhere you want
3. Run via Windows CMD (not tested on Linux)

        C:\${your_path}>java -jar geoLocalized-${version}.jar


### Build and run project via IDE


## Features

- Abstract class Tree for different types of trees
- Abstract subclasses of Tree for deciduous and conifer trees
- Class representation of tree's elements (Trunk, Branch on trunk, Leaf on branch)
- REST service endpoint for saving information about localization of device
- Basic Authorisation via login and password to service
- Exception handler for global handling
- Basic documentation of source code
- Unit tests
- Store logs in file
- Basic service for connection to the database, where data is stored
- Application properties for various settings configuration in YAML format

## Usage
Currently provide one endpoint to store localization data of device.

With provided release package and default configuration path is set at address:

      http://localhost:8080/geolocalized/add

Example JSON:

      { 
         "deviceId": "12345",
         "latitude": 90000000,
         "longitude": 18000000 
      }

Example cURL:

      curl -u "user:password" -H "Content-Type: application/json" -X POST http://localhost:8080/geolocalized/add -d "{\"deviceId\": \"12345\",\"latitude\": 90000000,\"longitude\": 18000000}"

Expected response:

      Localization of device 12345 has been registered at 19:12:31

Expected response when JSON in request is malformed:

      Malformed JSON in request

Expected response when one of parameters is not valid:

      {
      "longitude": "Longitude must be between 180 West and 180 East degrees"
      }

Logs are stored in:

      ${path_to_working_folder}\logs\geoLocalized.log

## Acknowledgements
- Layout of README.md was inspired by [this project](https://github.com/ritaly/README-cheatsheet)
- [Baeldung](https://www.baeldung.com/) for some fantasic articles about various technologies
