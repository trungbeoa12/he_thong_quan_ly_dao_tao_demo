# TO-BE Process - Quy Trình Tương Lai

## 1. Mục Đích Tài Liệu

Tài liệu này mô tả quy trình quản lý đào tạo sau khi triển khai TMS. BA đọc tài liệu này để hiểu hệ thống sẽ thay đổi cách làm hiện tại như thế nào, actor nào thao tác trên hệ thống, dữ liệu nào được chuẩn hóa và business rule nào cần được kiểm soát.

## 2. Nguyên Tắc Thiết Kế TO-BE

- Dữ liệu đào tạo được quản lý tập trung trong TMS.
- Course và Training Class được tách rõ.
- Mọi registration, approval, attendance, result và cost đều có owner rõ ràng.
- Actual training hours được tính từ Attendance.
- Report được tính từ dữ liệu hệ thống, không tổng hợp thủ công bằng Excel.
- Các thao tác quan trọng phải có audit log.
- Role-based authorization kiểm soát ai được xem và ai được cập nhật dữ liệu.

## 3. Actor Tham Gia

| Actor | Vai trò trong TO-BE | Quyền thao tác chính |
| --- | --- | --- |
| ADMIN | Quản trị hệ thống | Quản lý users, roles, permissions, master data |
| TRAINING_ADMIN | Quản lý đào tạo | Tạo course, mở class, phân công instructor, quản lý registration/result/cost/report |
| INSTRUCTOR | Giảng viên | Xem class được phân công, xem learner list, nhập attendance/result |
| EMPLOYEE | Học viên | Xem course/class, đăng ký học, xem lịch học, xem lịch sử và result |
| MANAGER | Quản lý đơn vị | Xem nhân viên thuộc đơn vị, approve registration, xem report team |
| Finance | Kiểm soát chi phí | Ghi nhận/kiểm tra training cost |
| Ban lãnh đạo | Người xem KPI | Xem dashboard và analytics report |

## 4. Quy Trình Tổng Quan

1. ADMIN cấu hình user, role và master data cần thiết.
2. TRAINING_ADMIN tạo course catalog.
3. TRAINING_ADMIN mở training class từ course.
4. TRAINING_ADMIN phân công instructor và tạo schedule.
5. System mở registration window theo class.
6. EMPLOYEE đăng ký class.
7. MANAGER approve nếu class/course yêu cầu approval.
8. System xác nhận learner list theo capacity và approval status.
9. INSTRUCTOR xem class được phân công.
10. INSTRUCTOR ghi attendance theo từng session.
11. TRAINING_ADMIN hoặc INSTRUCTOR nhập result.
12. TRAINING_ADMIN/Finance nhập training cost.
13. System tổng hợp training hours, completion rate, pass rate và cost.
14. MANAGER và ban lãnh đạo xem dashboard/report theo quyền.

## 5. Quy Trình Chi Tiết Theo Bước

| Bước | Actor | System Action | Dữ liệu tạo/cập nhật | Rule chính |
| --- | --- | --- | --- | --- |
| 1 | ADMIN | Tạo user và gán role | `users`, `authorities` | User phải có role phù hợp |
| 2 | TRAINING_ADMIN | Tạo course | `course` | Course code unique |
| 3 | TRAINING_ADMIN | Mở class từ course | `training_class` | Class phải thuộc một course |
| 4 | TRAINING_ADMIN | Phân công instructor | `training_class.instructor_id` | Instructor phải active |
| 5 | TRAINING_ADMIN | Tạo session schedule | `training_session` | Session date nằm trong class date |
| 6 | EMPLOYEE | Đăng ký class | `training_registration` | Không đăng ký trùng, class phải OPEN |
| 7 | MANAGER | Approve registration | `approval_status`, `approved_by`, `approved_date` | Chỉ manager có quyền mới approve |
| 8 | INSTRUCTOR | Ghi attendance | `attendance` | Attended hours không vượt duration |
| 9 | TRAINING_ADMIN/INSTRUCTOR | Nhập result | `training_result` | Chỉ nhập result cho learner đã đăng ký |
| 10 | TRAINING_ADMIN/Finance | Nhập cost | `training_cost` | Cost amount >= 0, cost type bắt buộc |
| 11 | System | Tổng hợp report | Report query | KPI tính từ dữ liệu gốc |
| 12 | System | Ghi audit | `audit_log` | Action quan trọng phải được log |

## 6. Actor Và System Action

| Actor | Action | System Response |
| --- | --- | --- |
| ADMIN | Tạo user | Validate username, encode password, gán role |
| TRAINING_ADMIN | Tạo course | Validate course code, category, method, duration |
| TRAINING_ADMIN | Mở class | Validate course, instructor, schedule, capacity |
| EMPLOYEE | Đăng ký class | Validate registration window, capacity và duplicate registration |
| MANAGER | Approve registration | Cập nhật approval status và ghi audit action |
| INSTRUCTOR | Ghi attendance | Validate learner đã đăng ký và attended hours |
| TRAINING_ADMIN/INSTRUCTOR | Nhập result | Validate learner, score, result status |
| TRAINING_ADMIN/Finance | Ghi cost | Validate cost type, amount, class reference |
| MANAGER | Xem report team | Filter theo department/team của manager |
| Ban lãnh đạo | Xem dashboard | Tổng hợp hours, cost, completion rate, pass rate |

## 7. Dữ Liệu Được Chuẩn Hóa Trong TO-BE

| Dữ liệu | Cách chuẩn hóa trong TMS | Lợi ích |
| --- | --- | --- |
| Department | Có department code và parent department | Report theo cơ cấu tổ chức |
| Employee | Có employee code, department, level, region | Phân tích theo nhóm nhân viên |
| Instructor | Tách INTERNAL/EXTERNAL, có hourly rate | Tính instructor fee |
| Course | Có course code, category, method, duration | Quản lý chương trình đào tạo |
| Class | Mở từ course, có instructor, date, capacity | Quản lý lớp cụ thể |
| Session | Lưu từng buổi học | Tính attendance theo buổi |
| Registration | Lưu employee đăng ký class | Chống duplicate, trace approval |
| Attendance | Lưu status và attended hours | Tính actual training hours |
| Result | Lưu score/result/certificate | Tính pass rate và completion |
| Cost | Lưu cost type và amount | Tính training cost chính xác |
| Audit Log | Lưu action quan trọng | Hỗ trợ kiểm tra và giải trình |

## 8. Business Rules Cần Hệ Thống Kiểm Soát

- Employee không được đăng ký hai lần cùng một class.
- Class phải còn registration window mới cho đăng ký.
- Class COMPLETED hoặc CANCELLED không nhận registration mới.
- Registration cần approval nếu course/class policy yêu cầu.
- Attendance chỉ nhập cho employee đã đăng ký class.
- Attended hours không được lớn hơn session duration.
- Result chỉ nhập cho employee đã đăng ký và tham gia class.
- Cost phải có cost type và amount hợp lệ.
- Training hours report phải tính từ Attendance.
- Training cost report phải tính từ Training Cost.
- Action quan trọng như create/update/approve/attendance/result/cost phải ghi audit.

## 9. KPI Và Report Trong TO-BE

| KPI/Report | Nguồn dữ liệu chính | Ý nghĩa |
| --- | --- | --- |
| Tổng số course | `course` | Quy mô chương trình đào tạo |
| Tổng số class | `training_class` | Số lớp đã mở |
| Tổng lượt học viên | `training_registration` | Participation |
| Tổng giờ đào tạo | `attendance.attended_hours` | Actual learning hours |
| Tổng chi phí đào tạo | `training_cost.amount` | Tổng cost |
| Chi phí trung bình/employee | `training_cost`, `employee` | Hiệu quả ngân sách |
| Giờ đào tạo trung bình/employee | `attendance`, `employee` | KPI học tập |
| Tỷ lệ hoàn thành | `training_result` | Completion |
| Tỷ lệ pass | `training_result` | Learning outcome |

## 10. Lợi Ích So Với AS-IS

| AS-IS | TO-BE |
| --- | --- |
| Dữ liệu phân tán ở Excel/email | Dữ liệu tập trung trong TMS |
| Registration dễ trùng | Có rule chống duplicate |
| Approval khó audit | Approval có trạng thái, người duyệt, ngày duyệt |
| Attendance rời rạc | Attendance liên kết session và employee |
| Result khó kiểm tra | Result liên kết class và registered employee |
| Cost không thống nhất | Cost tách theo cost type |
| Report thủ công | Report tính từ database |
| Khó trace requirement | Có RTM và mapping UI/API/database/test |

## 11. Điểm BA Cần Chú Ý Khi Đọc TO-BE

BA cần đặc biệt chú ý:

- Mỗi pain point trong AS-IS được giải quyết bằng chức năng hoặc rule nào trong TO-BE.
- Actor nào có quyền tạo, xem, sửa từng loại dữ liệu.
- Dữ liệu nào là master data, dữ liệu nào là transaction data.
- KPI nào được tính từ table nào.
- Rule nào cần validate ở UI, API và service.
- Action nào cần audit.
- TO-BE nào sẽ trở thành URD/SRS requirement ở giai đoạn sau.

## 12. Kết Luận TO-BE

TO-BE chuyển quy trình đào tạo từ mô hình quản lý thủ công sang mô hình dữ liệu tập trung, có rule rõ ràng và có khả năng trace. Đây là nền tảng để các giai đoạn sau viết URD, SRS, API specification, database mapping, SIT, UAT và Change Request impact analysis.
