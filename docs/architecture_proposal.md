# Đề Xuất Kiến Trúc

## Bối Cảnh

Training Management System (TMS) là ứng dụng demo theo phong cách doanh nghiệp để quản lý đào tạo nội bộ và phục vụ đào tạo BA. Hệ thống cần dễ đọc, dễ trace và đủ thực tế để học viên phân tích requirement, viết SQL, kiểm thử UAT và kiểm chứng báo cáo.

## Kiểu Kiến Trúc

TMS dùng layered monolith:

```text
Browser
   ↓
Bootstrap UI / Thymeleaf
   ↓
Spring MVC Controller / REST API
   ↓
Service
   ↓
Repository
   ↓
JPA / Hibernate
   ↓
MySQL
```

Cách tổ chức này đủ đơn giản cho người học BA nhưng vẫn giống cấu trúc thường gặp trong project Spring Boot doanh nghiệp.

## Thành Phần Chính

| Component | Trách nhiệm |
| --- | --- |
| Controller | Nhận HTTP request, bind DTO, chọn response/view |
| Service | Xử lý business rules, transaction và orchestration |
| Repository | Truy cập dữ liệu qua Spring Data JPA |
| Entity | Mô hình persistence ánh xạ database |
| DTO | Payload cho API/UI |
| Mapper | Chuyển đổi DTO/entity |
| Security | Login, logout, role và endpoint authorization |
| Exception Handler | Chuẩn hóa error response |
| Report | Query tổng hợp và analytics |
| Audit | Ghi log các thao tác quan trọng |

## Security

Phase 0 cung cấp login/logout bằng Spring Security với users và authorities lưu bằng JDBC. Các phase sau sẽ mở rộng thành màn hình quản lý user, role và permission.

## Database

MySQL là database runtime chính cho local development. H2 chỉ được dùng trong automated test với cấu hình riêng ở `src/test/resources/application.yml`.

Flyway chịu trách nhiệm quản lý schema migration:

```text
Flyway
   ↓
Schema migration
   ↓
MySQL
```

Hibernate dùng `ddl-auto=validate` để kiểm tra mapping, không tự tạo schema bằng `create` hoặc `update`.

## Cách Trace Yêu Cầu

Mỗi chức năng ở phase sau cần duy trì traceability:

`Yêu cầu nghiệp vụ -> SRS Requirement -> UI Screen -> API -> Service -> Repository -> Table -> Test Case`

Ví dụ:

`FR-ATTENDANCE-003 -> AttendanceController -> AttendanceService -> AttendanceRepository -> attendance -> TC-ATT-003`

Với database thật, người học BA có thể trace tiếp từ tài liệu:

`URD -> SRS -> Database Design -> API -> Development -> Testing -> dữ liệu thực tế trong MySQL`
