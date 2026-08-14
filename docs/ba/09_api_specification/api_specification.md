# API Specification

## Foundation API

| Method | URL | Mục đích | Authorization |
| --- | --- | --- | --- |
| GET | `/api/health` | Smoke test trạng thái ứng dụng | Authenticated |

## Planned Business APIs

| Method | URL | Mục đích | Authorization |
| --- | --- | --- | --- |
| GET | `/api/courses` | Search courses | TRAINING_ADMIN, EMPLOYEE, MANAGER |
| POST | `/api/courses` | Tạo course | TRAINING_ADMIN |
| PUT | `/api/courses/{id}` | Cập nhật course | TRAINING_ADMIN |
| DELETE | `/api/courses/{id}` | Deactivate course | TRAINING_ADMIN |
| GET | `/api/classes` | Search classes | Authenticated |
| POST | `/api/classes` | Tạo class | TRAINING_ADMIN |
| POST | `/api/classes/{id}/register` | Đăng ký learner vào class | EMPLOYEE, TRAINING_ADMIN |
| POST | `/api/sessions/{id}/attendance` | Ghi attendance | INSTRUCTOR |
| GET | `/api/reports/training-hours` | Report training hours | TRAINING_ADMIN, MANAGER |
| GET | `/api/reports/training-cost` | Report training cost | TRAINING_ADMIN, MANAGER |

Mỗi API được implement ở phase sau cần mô tả request, response, validation, error code và traceability.
