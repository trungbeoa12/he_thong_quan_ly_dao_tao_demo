# PHASE 0 PLAN - Project Foundation

## Objective

Build the technical and documentation foundation for Training Management System (TMS) without implementing business CRUD modules from later phases.

## Business Requirements

- Establish an enterprise-style Spring Boot project structure for BA traceability.
- Define the target database model for all TMS modules.
- Prepare authentication and role-based authorization skeleton.
- Prepare base Thymeleaf and Bootstrap UI shell.
- Prepare documentation folders for the full BA learning lifecycle.

## Features

- Spring Boot application bootstrap.
- Global exception handler.
- Security login/logout skeleton.
- JDBC-backed demo users and authorities.
- Audit logging service skeleton.
- Dashboard placeholder for future KPI implementation.
- Health API endpoint for smoke testing.

## Database Changes

- Flyway enabled.
- Initial migration creates Spring Security tables: `users`, `authorities`.
- Initial migration creates `audit_log` table.
- Target enterprise ERD documented under `docs/database/`.

## API

- `GET /api/health` returns application health status.
- Future business APIs are documented only; implementation starts in later phases.

## UI

- Login page.
- Bootstrap sidebar, topbar, and main content layout.
- Dashboard placeholder with KPI cards marked for Phase 7.

## Business Rules

- Role-based access skeleton recognizes ADMIN, TRAINING_ADMIN, INSTRUCTOR, EMPLOYEE, and MANAGER.
- Business module rules are documented in Phase 0 and implemented in later phases.

## Validation

- Spring Validation dependency configured.
- Global validation error response DTO created.

## Test Cases

- Application context load test.
- Manual smoke path: `/login`, `/`, `/api/health`.

## Files to Create

- Maven project files and Spring Boot source tree.
- `src/main/resources/application.yml`.
- `src/main/resources/db/migration/V1__phase_0_security_audit_foundation.sql`.
- Thymeleaf layout, login, dashboard templates.
- `docs/database/*`.
- `docs/ba/*` folder structure and starter BA documents.
- `README.md`.
- `PHASE_0_SUMMARY.md`.

## Files to Modify

- None. The repository is empty at the start of Phase 0.
