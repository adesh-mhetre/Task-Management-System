# Task Management System

## Description

The Task Management System is a web application developed to help users manage their tasks efficiently. It provides a user-friendly interface for creating, reading, updating, and deleting tasks. The backend is built with Java and Spring Boot, while the frontend uses Angular. MySQL is used for data storage.

## Features

- **CRUD Operations**: Create, Read, Update, and Delete tasks seamlessly.
- **User-friendly Interface**: Developed with HTML and CSS for an intuitive user experience.
- **Data Storage**: Uses MySQL for robust and reliable data storage.

## Technologies Used

- **Backend**: Java, Spring Boot
- **Frontend**: Angular, HTML, CSS
- **Database**: MySQL

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 8 or later
- Node.js and npm
- Angular CLI
- MySQL

## Installation

### Backend

1. Clone the repository:
    ```bash
    git clone <repository-url>
    ```

2. Navigate to the backend directory:
    ```bash
    cd Task Management SpringBoot
    ```

3. Build the project:
    ```bash
    ./mvnw clean install
    ```

4. Run the application:
    ```bash
    ./mvnw spring-boot:run
    ```

5. The backend server will be running at `http://localhost:8080`.

### Frontend

1. Navigate to the frontend directory:
    ```bash
    cd Task Management Angular
    ```

2. Install the dependencies:
    ```bash
    npm install
    ```

3. Run the application:
    ```bash
    ng serve
    ```

4. The frontend application will be running at `http://localhost:4200`.

## Database Setup

1. Create a MySQL database:
    ```sql
    CREATE DATABASE task_management_system;
    ```

2. Configure the database connection in the `application.properties` file located in the `src/main/resources` directory of the backend project:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/task_management
    spring.datasource.username=<your-username>
    spring.datasource.password=<your-password>
    ```

## Usage

1. Open your web browser and navigate to `http://localhost:4200`.
2. Use the interface to create, read, update, and delete tasks.

## Project Structure

