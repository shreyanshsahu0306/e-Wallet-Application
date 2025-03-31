E-Wallet Application

Overview

The E-Wallet Application is a secure and efficient digital wallet system built using Spring Boot. It follows a Microservices Architecture with four independent services: User Service, Wallet Service, Transaction Service, and Notification Service. The application leverages Redis caching, Kafka messaging, MySQL, and Spring Security to enhance performance, scalability, and security.

Microservices Overview

1. User Service

Handles user registration and authentication.

Publishes an event via Kafka when a new user is created.

2. Wallet Service

Listens for user creation events from Kafka and creates a wallet for the user.

Updates wallet balances during transactions.

Communicates with Transaction Service via Kafka.

3. Transaction Service

Handles fund transfers between users.

Initiates transactions by producing an event in Kafka.

Listens for wallet update events and completes transactions accordingly.

Sends transaction completion messages to the Notification Service.

4. Notification Service

Listens for transaction completion messages from Kafka.

Sends email notifications to users using Gmail Service.

Features

Microservices Architecture: Ensures scalability and maintainability.

User Authentication & Authorization: Implemented using Spring Security.

Redis Caching: Improves performance by caching frequently accessed data.

Kafka Messaging: Ensures reliable event-driven communication between services.

Transactional Fund Transfers: Securely transfers funds between users.

Email Notifications: Sends transaction alerts using Gmail Service.

MySQL Database: Used for persistent storage.

Tech Stack

Backend: Java, Spring Boot

Microservices: Spring Cloud

Security: Spring Security, JWT

Database: MySQL

Caching: Redis

Messaging: Apache Kafka

Email Service: Gmail SMTP

Build Tool: Maven/Gradle

Containerization: Docker (optional)
