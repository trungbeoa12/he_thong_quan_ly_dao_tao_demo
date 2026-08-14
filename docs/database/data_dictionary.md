# Data Dictionary

## department

Mục đích: lưu cơ cấu tổ chức và quan hệ phân cấp phòng ban.

| Field | Type | Mandatory | Ý nghĩa nghiệp vụ | Validation |
| --- | --- | --- | --- | --- |
| id | bigint | Yes | Khóa chính | Generated |
| department_code | varchar | Yes | Mã phòng ban/đơn vị | Unique |
| department_name | varchar | Yes | Tên hiển thị của phòng ban | 2-255 ký tự |
| parent_department_id | bigint | No | Phòng ban cha | Tham chiếu `department.id` |
| department_type | varchar | Yes | Loại đơn vị: HO, DIVISION, BRANCH, TEAM | Controlled values |
| status | varchar | Yes | Trạng thái ACTIVE/INACTIVE | Controlled values |
| created_at | timestamp | Yes | Thời điểm tạo | System generated |
| updated_at | timestamp | Yes | Thời điểm cập nhật cuối | System generated |

## employee

Mục đích: lưu nhân viên và học viên.

| Field | Type | Mandatory | Ý nghĩa nghiệp vụ | Validation |
| --- | --- | --- | --- | --- |
| id | bigint | Yes | Khóa chính | Generated |
| employee_code | varchar | Yes | Mã nhân viên từ HR | Unique |
| full_name | varchar | Yes | Họ tên nhân viên | 2-255 ký tự |
| email | varchar | Yes | Email công việc | Đúng định dạng email, unique |
| department_id | bigint | Yes | Đơn vị trực thuộc | FK tới `department` |
| employee_level | varchar | Yes | Cấp bậc nhân viên | Controlled values |
| status | varchar | Yes | Trạng thái làm việc | ACTIVE/INACTIVE |

## instructor

Mục đích: lưu giảng viên nội bộ và bên ngoài.

| Field | Type | Mandatory | Ý nghĩa nghiệp vụ | Validation |
| --- | --- | --- | --- | --- |
| id | bigint | Yes | Khóa chính | Generated |
| instructor_code | varchar | Yes | Mã giảng viên | Unique |
| instructor_type | varchar | Yes | INTERNAL/EXTERNAL | Controlled values |
| hourly_rate | numeric | Yes | Đơn giá giảng dạy theo giờ | Lớn hơn hoặc bằng 0 |
| status | varchar | Yes | Trạng thái sẵn sàng giảng dạy | ACTIVE/INACTIVE |

## course

Mục đích: lưu chương trình/khóa đào tạo dùng lại nhiều lần.

| Field | Type | Mandatory | Ý nghĩa nghiệp vụ | Validation |
| --- | --- | --- | --- | --- |
| id | bigint | Yes | Khóa chính | Generated |
| course_code | varchar | Yes | Mã khóa học | Unique |
| course_name | varchar | Yes | Tên khóa học | 2-255 ký tự |
| category | varchar | Yes | Nhóm nội dung đào tạo | Controlled values |
| training_type | varchar | Yes | INTERNAL/EXTERNAL | Controlled values |
| training_method | varchar | Yes | OFFLINE/ONLINE/E_LEARNING/BLENDED | Controlled values |
| default_duration_hours | numeric | Yes | Thời lượng mặc định | Lớn hơn 0 |
| status | varchar | Yes | Trạng thái khóa học | ACTIVE/INACTIVE |

## training_class

Mục đích: lưu lớp đào tạo thực tế được mở từ một course.

| Field | Type | Mandatory | Ý nghĩa nghiệp vụ | Validation |
| --- | --- | --- | --- | --- |
| id | bigint | Yes | Khóa chính | Generated |
| class_code | varchar | Yes | Mã lớp | Unique |
| course_id | bigint | Yes | Khóa học nguồn | FK tới `course` |
| instructor_id | bigint | Yes | Giảng viên chính | FK tới `instructor` |
| start_date | date | Yes | Ngày bắt đầu lớp | Không sau `end_date` |
| end_date | date | Yes | Ngày kết thúc lớp | Không trước `start_date` |
| max_participants | integer | Yes | Sức chứa lớp | Lớn hơn 0 |
| class_status | varchar | Yes | Trạng thái vòng đời lớp | PLANNED/OPEN/IN_PROGRESS/COMPLETED/CANCELLED |

## users, authorities

Mục đích: skeleton authentication và authorization của Spring Security.

| Table | Primary Key | Ý nghĩa |
| --- | --- | --- |
| users | username | Tài khoản login với BCrypt password |
| authorities | username, authority | Role assignment như `ROLE_ADMIN` |

## audit_log

Mục đích: lưu các thao tác quan trọng để phục vụ audit trong project doanh nghiệp.

| Field | Type | Mandatory | Ý nghĩa |
| --- | --- | --- | --- |
| id | bigint | Yes | Khóa chính |
| username | varchar | Yes | Người thực hiện |
| action | varchar | Yes | Tên hành động |
| module | varchar | Yes | Module chức năng |
| object_id | varchar | No | Record bị tác động |
| old_value | text | No | Giá trị trước thay đổi |
| new_value | text | No | Giá trị sau thay đổi |
| created_at | timestamp | Yes | Thời điểm ghi audit |
