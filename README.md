# Forum Application (REST)

Forum is a RESTful web application built using the Spring framework. The main entry point of the application is the `ForumApplication` class. The project was developed as the final project for a REST course and functions as a forum for questions and answers. To operate correctly, it requires a database to be set up.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [How to Run](#how-to-run)
- [Database Setup](#database-setup)

## Introduction

The Forum Application is a RESTful API that facilitates interactions between users by allowing them to ask questions and provide answers in a forum-style setting. It adheres to REST principles, offering a seamless experience for communication and engagement.

## Technologies Used

- Spring Framework
- Spring Boot
- Maven
- PostgreSQL

## How to Run

To run the Forum Application on your local machine, follow these steps:

1. Clone this repository to your local machine

2. Navigate to the project directory

3. Make sure you have JDK 17 installed on your system.

4. Build the application using Maven or your preferred build tool:

5. Run the `ForumApplication` class to start the Spring Boot application.

6. The RESTful API will be available at `http://localhost:8080`.

7. Use your preferred API client (e.g., Postman) to interact with the forum.

## Database Setup

Before running the application, set up a database and configure its connection in the `application.properties` file.
