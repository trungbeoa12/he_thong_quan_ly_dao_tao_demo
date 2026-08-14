# TO-BE Process

1. Training Admin tạo danh mục course trong TMS.
2. Training Admin mở class từ course đã được duyệt.
3. System công bố lịch học và registration window.
4. Employee đăng ký class đang mở.
5. Manager approve nếu class/course yêu cầu approval.
6. Instructor xem class được phân công và danh sách học viên.
7. Instructor ghi nhận attendance theo từng session.
8. Training Admin hoặc Instructor ghi nhận training result.
9. Finance hoặc Training Admin ghi nhận training cost.
10. Ban lãnh đạo xem dashboard và analytics report.

## Actor Và System Action

| Actor | Action | System Response |
| --- | --- | --- |
| Training Admin | Tạo class | Validate course, instructor, schedule, capacity |
| Employee | Đăng ký class | Validate registration window và duplicate registration |
| Manager | Approve request | Cập nhật approval status và audit action |
| Instructor | Ghi attendance | Validate attended hours và registered learners |
| Finance | Ghi cost | Phân loại cost theo cost type |
| Ban lãnh đạo | Xem report | Tổng hợp hours, cost, completion rate, pass rate |
