# API Specification

## Foundation API

| Method | URL | Purpose | Authorization |
| --- | --- | --- | --- |
| GET | `/api/health` | Application health smoke test | Authenticated |

## Planned Business APIs

| Method | URL | Purpose | Authorization |
| --- | --- | --- | --- |
| GET | `/api/courses` | Search courses | TRAINING_ADMIN, EMPLOYEE, MANAGER |
| POST | `/api/courses` | Create course | TRAINING_ADMIN |
| PUT | `/api/courses/{id}` | Update course | TRAINING_ADMIN |
| DELETE | `/api/courses/{id}` | Deactivate course | TRAINING_ADMIN |
| GET | `/api/classes` | Search classes | Authenticated |
| POST | `/api/classes` | Create class | TRAINING_ADMIN |
| POST | `/api/classes/{id}/register` | Register learner | EMPLOYEE, TRAINING_ADMIN |
| POST | `/api/sessions/{id}/attendance` | Record attendance | INSTRUCTOR |
| GET | `/api/reports/training-hours` | Training hour report | TRAINING_ADMIN, MANAGER |
| GET | `/api/reports/training-cost` | Training cost report | TRAINING_ADMIN, MANAGER |

Each later API implementation must document request, response, validation, error codes, and traceability.
