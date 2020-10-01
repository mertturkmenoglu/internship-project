# Internship Project
* * *
## Description
* This repository contains my internship Spring Boot and Vue.js projects.
## Project Structure
* Each folder contains a different service.
* Four of them are Spring Boot and one of them is a Vue.js project.
## Prerequisites
* You need Maven (v3.6.3 or higher)
* You need Node.js (v14.10.0 or higher)
* You need MongoDB (v3.6.8 or higher)
## Installing and Using the Projects
* You may use an IDE to import Maven projects
        * Or `cd` into each directories and run this command:
                * `mvn spring-boot:run`
* For Vue.js:
        * You may import project from Vue UI
        * Or type this commands:
                * `npm install`
                * `npm run serve`
* Please check the server port numbers from `application.properties` file for Spring projects.
* Vue.js runs on default port 8080.
* You need to populate MongoDB. You can use `Postman` and send requests to each server.
* Each request body must match model class of the project. (These classes are annotated with @Document annotation)
