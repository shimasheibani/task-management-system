# Task Management System

A microservice-style task management backend built with Spring Boot. Currently in active development — the authentication and user-management foundation is in place; task/project management endpoints are the next milestone.

## Features (built so far)

- User model with role-based types (`ADMIN`, `COORDINATOR`, `HEAD`, `SENIOR`, `JUNIOR`)
- Password hashing via Spring Security's `PasswordEncoder`
- JWT utility for issuing and validating tokens
- User lookup by email via Spring Data JPA

## Roadmap

- [ ] REST endpoints for registration and login
- [ ] Task and project entities
- [ ] Spring Security filter chain wiring the JWT utility into request auth
- [ ] Role-based authorization on endpoints

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 17, Spring Boot |
| Auth | Spring Security, JWT (jjwt) |
| Database | MySQL |
| Deployment | Docker, Kubernetes manifests (`k8s/`) |

## Getting Started

### Prerequisites
- Java 17
- Maven
- MySQL (or Docker/Kubernetes — manifests provided under `tms/k8s/`)

### Configuration

Set these environment variables before running (see `tms/src/main/resources/application.properties`):

```
DB_USERNAME=root
DB_PASSWORD=your-db-password
JWT_SECRET=a-long-random-secret
```

### Run

```bash
cd tms
mvn spring-boot:run
```

## License

MIT
