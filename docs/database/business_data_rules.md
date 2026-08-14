# Business Data Rules

| Rule ID | Rule |
| --- | --- |
| BRULE-001 | Một nhân viên không được đăng ký hai lần cùng một lớp. |
| BRULE-002 | Training Result chỉ được nhập cho nhân viên đã đăng ký lớp. |
| BRULE-003 | Attended Hours không được lớn hơn Session Duration. |
| BRULE-004 | Session Date phải nằm trong thời gian start/end của Training Class. |
| BRULE-005 | Class ở trạng thái COMPLETED hoặc CANCELLED không được nhận đăng ký mới. |
| BRULE-006 | Instructor Fee được tính từ hourly rate của instructor nhân với teaching hours, trừ khi có điều chỉnh thủ công kèm audit. |
| BRULE-007 | Average Training Hours per Employee = tổng attended hours / số employee trong phạm vi báo cáo. |
| BRULE-008 | Training Cost per Employee = tổng training cost / số employee tham gia đào tạo. |
| BRULE-009 | PASS rate = số kết quả PASSED / số kết quả hoàn tất trong phạm vi báo cáo. |
| BRULE-010 | Training Registration cần manager approval khi chính sách course/class yêu cầu approval. |
