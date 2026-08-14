# MySQL Local Setup

## Mục tiêu

Tài liệu này hướng dẫn chạy MySQL local cho Training Management System sau phase migrate H2 sang MySQL.

## Chạy MySQL bằng Docker Compose

```bash
docker compose up -d
```

Thông tin database:

| Thuộc tính | Giá trị |
| --- | --- |
| Host | localhost |
| Port | 3306 |
| Database | training_management |
| Username | tms |
| Password | tms123 |

## Chạy Spring Boot

```bash
mvn spring-boot:run
```

Hoặc:

```bash
DB_URL='jdbc:mysql://localhost:3306/training_management?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Ho_Chi_Minh' \
DB_USERNAME=tms \
DB_PASSWORD=tms123 \
mvn spring-boot:run
```

## Kết nối DBeaver

Tạo connection mới:

- Database: MySQL
- Host: `localhost`
- Port: `3306`
- Database: `training_management`
- Username: `tms`
- Password: `tms123`

SQL kiểm tra:

```sql
SELECT * FROM employee;
SELECT * FROM instructor;
SELECT * FROM course;
SELECT * FROM flyway_schema_history;
```

## Các bảng hiện tại

Các bảng đã có tới Phase 2:

- `users`
- `authorities`
- `audit_log`
- `department`
- `employee`
- `instructor`
- `course`
- `flyway_schema_history`

## Vai trò của Flyway

Flyway tạo schema và seed data theo thứ tự migration:

1. `V1__phase_0_security_audit_foundation.sql`
2. `V2__phase_1_organization_employee.sql`
3. `V3__phase_2_instructor_course.sql`

Hibernate chỉ validate mapping với schema, không tự tạo hoặc tự sửa bảng.
