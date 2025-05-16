# Spring Boot User Management Demo

## Overview
A simple Spring Boot project demonstrating basic architecture, annotations, and dependency injection.

## Technologies
- Java 17
- Spring Boot 3.x
- JUnit 5
- Mockito (for testing)

## How to Run
1. Clone the repo
2. Run `./gradlew bootRun`
3. Console will print the user interactions
4. (Optional) Access REST endpoints at `http://localhost:8080/api/user/`

## How to Test
Run: `./gradlew test`

## Structure
- Model: `User.java`
- Repository: In-memory `FakeRepo`
- Service: `UserServiceImpl`
- Test: `UserServiceTests.java`
