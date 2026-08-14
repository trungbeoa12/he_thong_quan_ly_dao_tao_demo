# Architecture Proposal

## Context

Training Management System (TMS) is a demo enterprise application for corporate training management and BA education. The system must be readable, traceable, and realistic enough for requirement analysis, SQL exercises, UAT, and reporting validation.

## Architecture Style

TMS uses a layered monolith:

`Thymeleaf UI / REST API -> Controller -> Service -> Repository -> Database`

This is intentionally simple for BA learners while still matching common enterprise Spring Boot structures.

## Main Components

| Component | Responsibility |
| --- | --- |
| Controller | HTTP request handling, DTO binding, response selection |
| Service | Business rules, transactions, orchestration |
| Repository | Data access through Spring Data JPA |
| Entity | Database persistence model |
| DTO | API/UI payload model |
| Mapper | DTO/entity conversion |
| Security | Login, logout, roles, endpoint authorization |
| Exception Handler | Standard error response |
| Report | Aggregation and analytics queries |
| Audit | Important action logging |

## Security

Phase 0 provides Spring Security login/logout with JDBC-backed users and authorities. Later phases will extend this into user, role, and permission management screens.

## Database

PostgreSQL is the preferred runtime database. H2 is configured for local foundation smoke testing. Flyway owns schema migrations.

## Traceability Approach

Each later feature should maintain traceability:

`Business Requirement -> SRS Requirement -> UI Screen -> API -> Service -> Repository -> Table -> Test Case`

Example:

`FR-ATTENDANCE-003 -> AttendanceController -> AttendanceService -> AttendanceRepository -> attendance -> TC-ATT-003`
