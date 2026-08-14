# PHASE 0 SUMMARY - Nền Móng Dự Án

## Nội Dung Đã Implement

- Tạo project Maven dùng Java 17 và Spring Boot.
- Tạo cấu trúc package doanh nghiệp trong `com.example.tms`.
- Tạo Spring MVC dashboard và health endpoint.
- Tạo trang login Thymeleaf và base layout Bootstrap gồm sidebar, topbar, content area.
- Tạo skeleton Spring Security với users/roles lưu bằng JDBC.
- Tạo Global Exception Handler và DTO lỗi chuẩn cho API.
- Tạo skeleton Audit Log Service.
- Tạo nền tài liệu cho architecture, database design, BA lifecycle, SIT, UAT và Change Request.

## Thay Đổi Database

- Cấu hình Flyway migration.
- Thêm `V1__phase_0_security_audit_foundation.sql`.
- Tạo các bảng security:
  - `users`
  - `authorities`
- Tạo bảng audit:
  - `audit_log`
- Seed demo accounts với BCrypt password hash:
  - `admin / Admin@123`
  - `trainingadmin / Training@123`
  - `instructor01 / Instructor@123`
  - `employee01 / Employee@123`
  - `manager01 / Manager@123`

## API Đã Thêm

- `GET /api/health`

## Màn Hình Đã Thêm

- `/login`
- `/` dashboard placeholder
- Shared layout fragment với sidebar và topbar

## Business Rules

- Skeleton phân quyền endpoint nhận diện ADMIN, TRAINING_ADMIN, INSTRUCTOR, EMPLOYEE và MANAGER.
- Business data rules được tài liệu hóa trong `docs/database/business_data_rules.md` và `docs/ba/07_business_rules/business_rules.md`.

## Kết Quả Test

Command đã chạy:

```bash
mvn test
```

Kết quả:

- BUILD SUCCESS
- Tests run: 1
- Failures: 0
- Errors: 0
- Skipped: 0

Ghi chú: Lần chạy Maven đầu tiên bị sandbox chặn khi ghi vào `~/.m2`; command đã được chạy lại với quyền được duyệt và pass.

## Vấn Đề Đã Biết

- CRUD nghiệp vụ chưa được implement trong Phase 0 theo đúng scope.
- Dashboard metrics đang là placeholder đến Phase 7.
- Full demo dataset 2025-2026 nằm trong Phase 8.
- Hoàn thiện đầy đủ tài liệu BA nằm trong Phase 9.
- Change Request CR-001 đã được tài liệu hóa nhưng chưa implement đến Phase 10.

## Phase Tiếp Theo

Phase 1 nên implement:

- Organization
- Employee
- User
- Role
- Login refinement

**Lệnh khuyến nghị tiếp theo: START PHASE 1**
