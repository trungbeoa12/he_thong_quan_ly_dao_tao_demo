# PHASE MIGRATE H2 TO MYSQL

## Mục tiêu

Phase này chuyển database runtime chính của project từ H2 sang MySQL, giữ nguyên business logic và các endpoint đã có.

## Phạm vi thay đổi

- MySQL là database mặc định cho local development.
- H2 chỉ còn dùng cho automated test qua `src/test/resources/application.yml`.
- Flyway migration được chuyển sang cú pháp tương thích MySQL.
- Thêm Docker Compose để chạy MySQL nhanh.
- Cập nhật tài liệu chạy app và kết nối DBeaver.

## Luồng kiến trúc sau migration

```text
Browser
   ↓
Bootstrap UI
   ↓
Spring MVC Controller
   ↓
Service
   ↓
Repository
   ↓
JPA / Hibernate
   ↓
MySQL
```

```text
Flyway
   ↓
Schema migration
   ↓
MySQL
```

## Database local

- Database: `training_management`
- Host: `localhost`
- Port: `3306`
- App user: `tms`
- App password demo: `tms123`

## Cách chạy

```bash
docker compose up -d
mvn spring-boot:run
```

Hoặc truyền biến môi trường rõ ràng:

```bash
DB_URL='jdbc:mysql://localhost:3306/training_management?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Ho_Chi_Minh' \
DB_USERNAME=tms \
DB_PASSWORD=tms123 \
mvn spring-boot:run
```

## Kết nối DBeaver

- Database: MySQL
- Host: localhost
- Port: 3306
- Database: training_management
- Username: tms
- Password: tms123

SQL kiểm tra nhanh:

```sql
SELECT * FROM employee;
SELECT * FROM instructor;
SELECT * FROM course;
SELECT * FROM flyway_schema_history;
```

## Dữ liệu seed

Flyway seed dữ liệu demo cho các bảng đã có tới Phase 2:

- `users`
- `authorities`
- `department`
- `employee`
- `instructor`
- `course`
- `audit_log`

Các domain `training_class`, `training_session`, `registration`, `attendance`, `training_result`, `training_cost` chưa có entity/table trong code hiện tại, nên chưa seed trong phase này để tránh thay đổi business scope.

## Kiểm thử đã chạy

- `mvn clean test`: BUILD SUCCESS
- Tổng số test: 7
- Failures: 0
- Errors: 0
- Skipped: 0
- Dependency check: runtime có `mysql-connector-j`, H2 chỉ còn `test` scope.

## Ghi chú môi trường

Trong môi trường hiện tại, Docker engine đang trỏ tới Colima socket nhưng daemon chưa chạy, và Docker Compose plugin chưa khả dụng. Vì vậy bước chạy MySQL thật bằng Docker cần thực hiện sau khi bật Docker/Colima và cài Compose plugin nếu máy chưa có.
