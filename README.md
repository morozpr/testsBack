# testsBack 11/27/2023

-- Introduction
This project provides a testing backend implementation using Java Spring framework. It allows you to easily test your frontend applications by simulating API endpoints and database interactions.

-- Features
Implemented using Java Spring Boot framework
Supports RESTful APIs and SQL databases
Configurable endpoint URLs and query parameters
Customizable response data and error messages

-- Getting Started
Clone the repository and import it into your IDE.
Run mvn clean package to build the project.
Run java -jar target/tests-back-java-spring.jar to start the server.
Use your preferred testing framework to send requests to the server and verify responses.
Customize the configuration by modifying the application.properties file.
Enjoy!

-- Configuration
The configuration of the project is done through the application.properties file. You can modify the following properties to customize the behavior of the server:

server.port: 5432
database.url: localhost
database.username: postgres
database.password: postgres
api.endpoint: /api
response.data: [{roleID: {ROLE_TEST: ROLE_TEST} ,fullName: test, email: 'test@mail.com', universityID: 1, telegramLogin: test, phoneNumber: 9999999999, studentsGroupID: 0} {id: 2, name: 'Jane Doe'}].
response.error: Bad request

-- Contributing:
Pull requests are welcome! Please fork the project, make changes, and submit a pull request with a clear description of your changes.
