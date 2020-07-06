# husenko-ukrposhta-test-task [![Build Status](https://travis-ci.com/vztot/husenko-ukrposhta-test-task.svg?branch=master)](https://travis-ci.com/vztot/husenko-ukrposhta-test-task)

## Project purpose
This project is my solution of a [test-task](TEST_TASK.md) from UkrPoshta. 

## Project structure
* Java 11
* Maven
* Spring Boot
* H2 (in memory database)
* Maven Checkstyle Plugin
* Travis CI

## For developer
To run this project:

1. Open the project in your IDE.
  
2. Run TestTaskApplication.

3. You can inject test data via GET request "/inject" (see src/main/java/com/vztot/controller/InjectData.java)

## Author
[Oleksandr Husenko](https://www.linkedin.com/in/oleksandr-husenko-6a63a2b3/)
