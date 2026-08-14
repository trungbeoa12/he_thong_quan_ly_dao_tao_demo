# PHASE 2 SUMMARY - Instructor, Course, Course Category

## Phạm vi đã hoàn thành

Phase 2 đã triển khai danh mục đào tạo nền tảng để chuẩn bị cho module mở lớp ở Phase 3.

Các phần đã làm:

- Quản lý danh mục giảng viên.
- Quản lý danh mục khóa học.
- Phân loại khóa học theo category.
- Phân biệt loại đào tạo nội bộ/bên ngoài.
- Phân biệt hình thức đào tạo offline, online, e-learning và blended.
- Seed dữ liệu mẫu cho giảng viên và khóa học.
- Màn hình danh sách và tạo mới cho Instructor/Course.
- Service validation và ghi audit log khi tạo dữ liệu.

## Thay đổi database

Migration mới: `V3__phase_2_instructor_course.sql`

Bảng mới:

- `instructor`
- `course`

Ràng buộc chính:

- `instructor.instructor_code` là duy nhất.
- `instructor.email` là duy nhất.
- `course.course_code` là duy nhất.
- `hourly_rate` không âm.
- `default_duration_hours` phải lớn hơn 0.
- Các trường phân loại bắt buộc dùng enum để tránh nhập tự do.

## Màn hình đã có

- `/instructors`: danh sách và tìm kiếm giảng viên.
- `/instructors/new`: tạo giảng viên.
- `/courses`: danh sách và tìm kiếm khóa học.
- `/courses/new`: tạo khóa học.

Các màn hình này chỉ dành cho `ADMIN` và `TRAINING_ADMIN`.

## Business rules đã cài

- Không cho tạo trùng mã giảng viên.
- Không cho tạo trùng email giảng viên.
- Không cho tạo trùng mã khóa học.
- Chuẩn hóa mã giảng viên và mã khóa học về chữ hoa.
- Chuẩn hóa email giảng viên về chữ thường.
- Khi tạo Instructor/Course, hệ thống ghi audit log.

## Kiểm thử

Đã bổ sung test:

- Tạo mới Instructor.
- Tạo mới Course.
- Render các trang `/instructors`, `/instructors/new`, `/courses`, `/courses/new` với quyền `ADMIN`.

Kết quả kiểm thử cuối phase:

- `mvn test`: BUILD SUCCESS
- Tổng số test: 7
- Failures: 0
- Errors: 0
- Skipped: 0

## Giới hạn của phase này

Phase 2 mới là master data cho đào tạo. Chưa có:

- Mở lớp đào tạo.
- Gán khóa học vào lớp.
- Gán giảng viên phụ trách lớp.
- Lịch học.
- Đăng ký học viên.
- Điểm danh, kết quả, chi phí.

Các phần này sẽ được triển khai từ Phase 3 trở đi.

## Phase tiếp theo

Lệnh khuyến nghị tiếp theo:

`START PHASE 3`
