# Training Management System - TMS

TMS is an enterprise-style demo system for managing corporate training activities. The project is also a Business Analyst training case study, helping learners trace business requests through URD, SRS, API, database design, testing, UAT, and change request impact analysis.

## Project Purpose

The target business context is an organization with 3,000 to 5,000 employees, many departments, internal and external instructors, multiple training methods, training costs, attendance, results, and analytics across two demo years: 2025 and 2026.

Phase 0 builds only the foundation. Business modules are intentionally implemented in later phases.

## Architecture

Request flow:

`Controller -> Service -> Repository -> Database`

Package structure:

- `config`: Spring and web configuration
- `controller`: MVC and REST endpoints
- `service`: business service contracts
- `service.impl`: service implementations
- `repository`: Spring Data repositories
- `entity`: JPA entities
- `dto`: DTO and API payload models
- `mapper`: DTO/entity mapping
- `exception`: global error handling
- `security`: security helpers
- `validation`: validation helpers
- `util`: shared utilities
- `report`: reporting support

## Technology Stack

- Java 17
- Spring Boot 3
- Spring MVC
- Spring Security
- Spring Data JPA
- Thymeleaf
- Bootstrap 5
- Flyway
- PostgreSQL preferred, H2 available for local foundation smoke tests
- Maven

## Installation

```bash
mvn clean test
mvn spring-boot:run
```

Open:

- `http://localhost:8080/login`
- `http://localhost:8080/api/health`

## Database Setup

By default the application uses an in-memory H2 database in PostgreSQL compatibility mode.

For PostgreSQL:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/tms
export DB_USERNAME=tms
export DB_PASSWORD=tms
export DB_DRIVER=org.postgresql.Driver
mvn spring-boot:run
```

Flyway migrations are located in `src/main/resources/db/migration`.

## Demo Accounts

| Username | Password | Role |
| --- | --- | --- |
| admin | Admin@123 | ADMIN |
| trainingadmin | Training@123 | TRAINING_ADMIN |
| instructor01 | Instructor@123 | INSTRUCTOR |
| employee01 | Employee@123 | EMPLOYEE |
| manager01 | Manager@123 | MANAGER |

Passwords are seeded as BCrypt hashes.

## Modules

Planned modules:

- Organization
- Employee
- Instructor
- Course
- Training Class
- Training Schedule
- Registration and Approval
- Attendance
- Training Result
- Training Cost
- Reporting and Analytics
- Audit Log
- Change Request simulation

## BA Documentation

BA documents live under `docs/ba`.

Database documents live under `docs/database`.

## Learning Path

1. Read Business Request, Stakeholder Analysis, AS-IS, and TO-BE.
2. Review URD and SRS.
3. Map UI to API, service, database, and test cases.
4. Execute SIT and UAT scenarios.
5. Analyze the sample change request and impact.

## Development Phases

Current phase: PHASE 0 - Project Foundation.

Next recommended command: START PHASE 1
