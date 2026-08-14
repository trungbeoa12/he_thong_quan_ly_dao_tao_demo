# PHASE 1 PLAN - Organization, Employee, User, Role

## Mục Tiêu

Triển khai các module nền tảng đầu tiên của TMS: Organization, Employee, User, Role và tinh chỉnh login để có thể demo phân quyền cơ bản.

## Yêu Cầu Nghiệp Vụ

- BR-ORG-001: Hệ thống quản lý cơ cấu tổ chức dạng phân cấp.
- BR-EMP-001: Hệ thống quản lý thông tin nhân viên/học viên.
- BR-USER-001: Hệ thống quản lý tài khoản đăng nhập.
- BR-ROLE-001: Hệ thống gán role cho user để phân quyền truy cập.

## Chức Năng

- Danh sách và tạo mới Department.
- Danh sách và tạo mới Employee.
- Danh sách và tạo mới User, gán một role chính.
- Sidebar link thật cho Dashboard, Departments, Employees, Users.
- Validation và thông báo lỗi form cơ bản.

## Thay Đổi Database

- Tạo bảng `department`.
- Tạo bảng `employee`.
- Seed dữ liệu mẫu cho organization và employee.
- Giữ bảng `users` và `authorities` từ Phase 0, bổ sung service/UI quản lý.

## API

Phase 1 tập trung vào UI Thymeleaf và service layer. REST business API chi tiết sẽ mở rộng ở các phase sau.

## UI

- `/departments`: danh sách department.
- `/departments/new`: tạo department.
- `/employees`: danh sách employee.
- `/employees/new`: tạo employee.
- `/admin/users`: danh sách user.
- `/admin/users/new`: tạo user và gán role.

## Business Rules

- Department code là duy nhất.
- Employee code là duy nhất.
- Employee email là duy nhất.
- Employee bắt buộc thuộc một department đang tồn tại.
- Username là duy nhất.
- User phải có ít nhất một role.
- Password khi tạo user phải được encode bằng BCrypt.

## Validation

- Validate mandatory fields ở DTO.
- Validate email format.
- Validate date hợp lệ cho employee.
- Validate duplicate code/username/email ở service layer.

## Test Cases

- Application context load.
- Department service tạo mới department.
- Employee service tạo mới employee với department hợp lệ.
- User service tạo user và encode password.

## File Cần Tạo

- Entity: `Department`, `Employee`, `UserAccount`, `Authority`.
- Enum: department type, status, gender, employee level, role.
- Repository cho department, employee, user, authority.
- DTO và mapper cho Phase 1.
- Service và service implementation.
- Controller và Thymeleaf templates cho Department, Employee, User.
- Flyway migration `V2__phase_1_organization_employee.sql`.
- `PHASE_1_SUMMARY.md` ở cuối phase.

## File Cần Chỉnh Sửa

- `layout/base.html`.
- `dashboard/index.html`.
- `app.css`.
- `GlobalExceptionHandler`.
