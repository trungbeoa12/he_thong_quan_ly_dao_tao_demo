# PHASE 2 PLAN - Instructor, Course, Course Category

## Mục Tiêu

Triển khai module quản lý giảng viên và chương trình đào tạo để chuẩn bị cho Phase 3 mở Training Class và Training Session.

## Yêu Cầu Nghiệp Vụ

- BR-INSTRUCTOR-001: Hệ thống quản lý giảng viên nội bộ và bên ngoài.
- BR-COURSE-001: Hệ thống quản lý danh mục course/chương trình đào tạo.
- BR-CATEGORY-001: Hệ thống chuẩn hóa course category để phục vụ filter và report.

## Chức Năng

- Danh sách và tạo mới Instructor.
- Danh sách và tạo mới Course.
- Course category được quản lý bằng enum/master value trong Phase 2.
- Sidebar link thật cho Instructors và Courses.
- Validation form cơ bản và kiểm tra duplicate code/email.

## Thay Đổi Database

- Tạo bảng `instructor`.
- Tạo bảng `course`.
- Seed dữ liệu mẫu cho instructor và course.

## API

Phase 2 tiếp tục tập trung vào Thymeleaf UI và service layer. REST API nghiệp vụ sẽ được chuẩn hóa ở phase API/report sau.

## UI

- `/instructors`: danh sách instructor.
- `/instructors/new`: tạo instructor.
- `/courses`: danh sách course.
- `/courses/new`: tạo course.

## Business Rules

- Instructor code phải unique.
- Instructor email phải unique.
- Instructor type bắt buộc là INTERNAL hoặc EXTERNAL.
- Hourly rate phải lớn hơn hoặc bằng 0.
- Course code phải unique.
- Course category, training type, training method là bắt buộc.
- Default duration hours phải lớn hơn 0.
- Action tạo Instructor và Course phải ghi audit.

## Validation

- Validate mandatory fields ở DTO.
- Validate email format.
- Validate amount/duration bằng numeric constraint.
- Validate duplicate code/email ở service layer.

## Test Cases

- Instructor service tạo instructor hợp lệ.
- Course service tạo course hợp lệ.
- Application context load và Flyway migration pass.

## File Cần Tạo

- Entity: `Instructor`, `Course`.
- Enum: `InstructorType`, `CourseCategory`, `TrainingType`, `TrainingMethod`.
- Repository cho instructor và course.
- DTO, mapper, service, service implementation.
- Controller và Thymeleaf templates cho Instructor, Course.
- Flyway migration `V3__phase_2_instructor_course.sql`.
- `PHASE_2_SUMMARY.md` ở cuối phase.

## File Cần Chỉnh Sửa

- `layout/base.html`.
- `dashboard/index.html`.
- `app.css` nếu cần bổ sung UI nhỏ.
- `README.md`.
