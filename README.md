# User Management API

## Project Overview

This project is a RESTful API for managing users in a system. It allows basic CRUD (Create, Read, Update, Delete) operations on user data, including handling user creation, updating, fetching, and deletion. The project is built with Spring Boot, and uses MySQL for persistent data storage.

### Key Features:
- **Create a new user** with name, email, and CPF (Brazilian taxpayer ID).
- **Retrieve all users** or a specific user by their ID.
- **Update user details** such as name, email, and CPF.
- **Delete a user** by ID.

## Technologies Used:
- **Java**: The primary programming language.
- **Spring Boot**: For building the REST API.
- **MySQL**: Database used for persistent data storage.
- **JPA/Hibernate**: For managing database interactions.
- **Lombok**: To reduce boilerplate code for entity classes.

## How to Run the Project:

1. **Clone the repository** to your local machine.

2. **Set up the MySQL Database**:
   - Ensure MySQL is running locally.
   - The database will be automatically created if it doesn't exist, as defined in the `application.properties` file:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/user?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC
     spring.datasource.username=root
     spring.datasource.password=
     ```

3. **Configure MySQL Credentials**:
   - Update the `spring.datasource.username` and `spring.datasource.password` in the `application.properties` file to match your local MySQL configuration.

4. **Run the Application**:
   - Use the following command to start the application:
     ```bash
     ./mvnw spring-boot:run
     ```
   - The API will be available at `http://localhost:8080/users`.

## API Endpoints:

### 1. Create a User
- **Endpoint**: `POST /users`
- **Request Body**:
  ```json
  {
    "name": "John Doe",
    "email": "john.doe@example.com",
    "cpf": "12345678900"
  }
  ```
- **Response**: Returns the created user's data.

### 2. Get All Users
- **Endpoint**: `GET /users`
- **Response**: A list of all registered users.

### 3. Get User by ID
- **Endpoint**: `GET /users/{id}`
- **Response**: Returns the user data for the given ID.

### 4. Update User
- **Endpoint**: `PUT /users/{id}`
- **Request Body**:
  ```json
  {
    "name": "Jane Doe",
    "email": "jane.doe@example.com",
    "cpf": "98765432100"
  }
  ```
- **Response**: Returns the updated user data.

### 5. Delete User
- **Endpoint**: `DELETE /users/{id}`
- **Response**: No content (`204` status).

## Database Schema:

- **Table**: `User`
  - `id`: Auto-generated unique identifier (Primary key).
  - `name`: User's name (Not nullable).
  - `email`: User's email (Not nullable, unique).
  - `cpf`: User's CPF (Not nullable, unique).

## Exception Handling:

- **UserNotFoundException**: Thrown when an attempt to retrieve or delete a non-existent user is made. This returns a `404 Not Found` response.

## Project Structure:

- `UserController`: Handles HTTP requests for user-related operations.
- `UserService`: Contains the business logic for managing users.
- `UserRepository`: Interface for interacting with the MySQL database.
- `UserDTO`, `UserFormDTO`, `UpdateUserFormDTO`: Data transfer objects (DTOs) for transferring user data between layers.
- `User`: Entity representing a user in the database.

## Dependencies:
The project uses several dependencies which are managed via Maven. Key dependencies include:
- **Spring Boot Starter Web**: For building web applications.
- **Spring Boot Starter Data JPA**: For database persistence with JPA and Hibernate.
- **Lombok**: For simplifying the creation of data models.
- **MySQL Connector**: For connecting to the MySQL database.

## Contact:

If you have any questions or suggestions, feel free to open an issue on the GitHub repository or send an email to:  
[nathanfelipi2006@gmail.com].

---

Developed with ❤️ by [Nathan Felipi Almeida].
