# Training Management System - TMS

TMS là hệ thống demo quản lý đào tạo theo phong cách project doanh nghiệp. Dự án đồng thời là case study đào tạo Business Analyst, giúp học viên trace từ yêu cầu nghiệp vụ đến URD, SRS, API, database, SIT, UAT và phân tích Change Request.

## Mục Đích Dự Án

Bối cảnh nghiệp vụ mục tiêu là một doanh nghiệp có khoảng 3.000 đến 5.000 nhân viên, nhiều phòng ban, giảng viên nội bộ/bên ngoài, nhiều hình thức đào tạo, chi phí đào tạo, điểm danh, kết quả học tập và báo cáo phân tích trong 2 năm demo: 2025 và 2026.

Phase 0 chỉ xây dựng nền móng. Các module nghiệp vụ được triển khai ở những phase sau.

## Kiến Trúc

Luồng xử lý:

`Controller -> Service -> Repository -> Database`

Cấu trúc package:

- `config`: cấu hình Spring, web, security
- `controller`: MVC controller và REST endpoint
- `service`: interface xử lý nghiệp vụ
- `service.impl`: implementation của service
- `repository`: truy cập dữ liệu bằng Spring Data JPA
- `entity`: mô hình persistence ánh xạ database
- `dto`: payload cho API/UI
- `mapper`: chuyển đổi DTO/entity
- `exception`: xử lý lỗi tập trung
- `security`: helper bảo mật
- `validation`: helper validate
- `util`: tiện ích dùng chung
- `report`: xử lý báo cáo

## Công Nghệ

- Java 17
- Spring Boot 3
- Spring MVC
- Spring Security
- Spring Data JPA
- Thymeleaf
- Bootstrap 5
- Flyway
- PostgreSQL ưu tiên, H2 dùng cho smoke test local
- Maven

## Cài Đặt

```bash
mvn clean test
mvn spring-boot:run
```

Mở:

- `http://localhost:8080/login`
- `http://localhost:8080/api/health`

## Cấu Hình Database

Mặc định ứng dụng dùng H2 in-memory ở chế độ tương thích PostgreSQL.

Nếu dùng PostgreSQL:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/tms
export DB_USERNAME=tms
export DB_PASSWORD=tms
export DB_DRIVER=org.postgresql.Driver
mvn spring-boot:run
```

Flyway migration nằm trong `src/main/resources/db/migration`.

## Tài Khoản Demo

| Username | Password | Role |
| --- | --- | --- |
| admin | Admin@123 | ADMIN |
| trainingadmin | Training@123 | TRAINING_ADMIN |
| instructor01 | Instructor@123 | INSTRUCTOR |
| employee01 | Employee@123 | EMPLOYEE |
| manager01 | Manager@123 | MANAGER |

Password được seed bằng BCrypt hash.

## Module Dự Kiến

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

## Tài Liệu BA

Tài liệu BA nằm trong `docs/ba`.

Tài liệu database nằm trong `docs/database`.

## Lộ Trình Đọc Tài Liệu BA

1. Đọc Business Request và Stakeholder Analysis để hiểu bối cảnh.
2. Đọc AS-IS và TO-BE để hiểu quy trình.
3. Đọc URD và SRS để hiểu yêu cầu.
4. Đọc Business Rules, ERD, Data Dictionary và Data Mapping để hiểu dữ liệu.
5. Đọc API Specification và Traceability Matrix để hiểu cách trace yêu cầu.
6. Đọc SIT, UAT, Change Request và Go-Live Checklist để hiểu kiểm thử, thay đổi và triển khai.

## Development Phases

Phase đã hoàn thành gần nhất: PHASE 2 - Instructor, Course, Course Category.

Lệnh khuyến nghị tiếp theo: START PHASE 3
