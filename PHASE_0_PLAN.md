# PHASE 0 PLAN - Nền Móng Dự Án

## Mục Tiêu

Xây dựng nền tảng kỹ thuật và tài liệu cho Training Management System (TMS), không triển khai CRUD nghiệp vụ thuộc các phase sau.

## Yêu Cầu Nghiệp Vụ

- Thiết lập cấu trúc project Spring Boot theo phong cách doanh nghiệp để BA dễ trace.
- Thiết kế mô hình database mục tiêu cho toàn bộ module TMS.
- Chuẩn bị skeleton authentication và role-based authorization.
- Chuẩn bị layout Thymeleaf + Bootstrap cơ bản.
- Chuẩn bị cấu trúc tài liệu cho toàn bộ vòng đời học BA.

## Chức Năng

- Bootstrap ứng dụng Spring Boot.
- Global Exception Handler.
- Skeleton login/logout bằng Spring Security.
- Demo users và authorities lưu bằng JDBC.
- Skeleton Audit Log Service.
- Dashboard placeholder cho KPI ở phase sau.
- Health API endpoint để smoke test.

## Thay Đổi Database

- Bật Flyway.
- Migration đầu tiên tạo bảng Spring Security: `users`, `authorities`.
- Migration đầu tiên tạo bảng `audit_log`.
- ERD mục tiêu được tài liệu hóa trong `docs/database/`.

## API

- `GET /api/health` trả về trạng thái ứng dụng.
- API nghiệp vụ tương lai chỉ được tài liệu hóa, chưa implement trong Phase 0.

## UI

- Trang login.
- Layout Bootstrap gồm sidebar, topbar và main content.
- Dashboard placeholder với KPI card đánh dấu cho Phase 7.

## Business Rules

- Skeleton phân quyền nhận diện ADMIN, TRAINING_ADMIN, INSTRUCTOR, EMPLOYEE và MANAGER.
- Business rule của module nghiệp vụ được tài liệu hóa ở Phase 0 và implement ở phase sau.

## Validation

- Đã cấu hình dependency Spring Validation.
- Đã tạo DTO chuẩn cho validation error response.

## Test Cases

- Test load Spring application context.
- Smoke path thủ công: `/login`, `/`, `/api/health`.

## File Cần Tạo

- Maven project files và source tree Spring Boot.
- `src/main/resources/application.yml`.
- `src/main/resources/db/migration/V1__phase_0_security_audit_foundation.sql`.
- Thymeleaf layout, login, dashboard templates.
- `docs/database/*`.
- Cấu trúc thư mục và tài liệu starter trong `docs/ba/*`.
- `README.md`.
- `PHASE_0_SUMMARY.md`.

## File Cần Chỉnh Sửa

- Không có. Repository trống ở thời điểm bắt đầu Phase 0.
