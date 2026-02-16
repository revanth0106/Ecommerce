Ecommerce Backend API
🔹 Project Description

This is a RESTful E-commerce backend application built using Spring Boot, implementing authentication, role-based authorization, and product management APIs.

The application supports:

User Registration & Login

JWT-based Authentication

Role-based Access (ADMIN / USER)

Product Management APIs

MySQL Database Integration

🛠 Tech Stack

Java 17

Spring Boot

Spring Security

JWT Authentication

MySQL

Maven

JPA / Hibernate

🔐 Authentication Flow

User registers

User logs in

JWT token generated

Token required for protected APIs

Role-based access control implemented

📂 Project Structure
com.ecommerce
 ├── controller
 ├── service
 ├── repository
 ├── security
 ├── entity
 └── config

🗄 Database Design
User Table

id

name

email

password

role

Product Table

id

name

price

description

▶ How to Run

Clone the repository

Configure MySQL in application.properties

Run:

mvn spring-boot:run


Access APIs via Postman
