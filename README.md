# testsBack 11/27/2023

## Introduction

This project provides a testing backend implementation using Java Spring framework. It allows you to easily test your frontend applications by simulating API endpoints and database interactions.

## **Features**

Implemented using Java Spring Boot framework
Supports RESTful APIs and SQL databases
Configurable endpoint URLs and query parameters
Customizable response data and error messages

## **Getting Started**

Clone the repository and import it into your IDE.
Use your preferred testing framework to send requests to the server and verify responses.
Customize the configuration by modifying the application.properties file.
Enjoy!

## **Configuration**

The configuration of the project is done through the application.properties file. You can modify the following properties to customize the behavior of the server:

* server.port: 5432

* database.url: localhost

* database.username: postgres

* database.password: postgres

* api.endpoint: /api

* response.data: [{fullName: test, roleID: {id: 2, name: 'ROLE_TEST'}, universityID: 1, studentsGroupID: 0, email: 'test@mail.com', telegramLogin: test, phoneNumber: 9999999999}]

* response.error: Bad request

## **Installation**

### **Docker (in development):**

#### **Download image from Docker Hub**

docker pull morozpr/testsback:latest

#### **Launch**

docker run -d morozpr/testsback:latest

#### **Installation DB**
docker pull morozpr/testsdb14.9:testsdb14.9

#### **Launch**
docker pull morozpr/testsdb14.9:testsdb14.9

## **Contributing:**

Pull requests are welcome! Please fork the project, make changes, and submit a pull request with a clear description of your changes.
