# PassGuard

PassGuard is a secure password manager built using Spring Boot. It allows users to store, manage, and retrieve secrets (such as passwords) in a secure manner, supporting JWT authentication and encryption for data security.

## Features
- User registration and authentication using JWT.
- Secure storage of secrets with encryption.
- Ability to add, retrieve, and delete secrets for each user.
- RESTful API for interacting with the system.

## Technologies Used
- **Spring Boot**: Backend framework.
- **Spring Security**: Authentication and authorization.
- **MySQL**: Database to store user and secret data.
- **Jasypt**: For encrypting secret data.
- **JWT**: For token-based authentication.

## Getting Started

### Prerequisites
Make sure you have the following installed:
- Java 17 or higher
- Maven
- MySQL Database


## API Endpoints
- POST /register: Register a new user.
- POST /login: Authenticate and get a JWT token.
- POST /secrets: Add a secret.
- GET /secrets: Get a list of secrets for a user.
- DELETE /secrets/{id}: Delete a secret by ID.
