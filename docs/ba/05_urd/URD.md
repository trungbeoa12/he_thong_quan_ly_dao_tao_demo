# User Requirement Document

## 1. Thông Tin Tài Liệu

Document: TMS URD  
Phase: Foundation draft  
Status: Initial

## 2. Background

Hoạt động đào tạo hiện được quản lý bằng Excel và trao đổi thủ công.

## 3. Business Problem

Doanh nghiệp chưa thể trace đáng tin cậy lịch sử đào tạo, số giờ đào tạo, chi phí, giảng viên và kết quả học tập.

## 4. Mục Tiêu Nghiệp Vụ

Xây dựng hệ thống tập trung để quản lý và báo cáo toàn bộ hoạt động đào tạo doanh nghiệp.

## 5. Scope

- Dữ liệu organization và employee
- Quản lý course và class
- Schedule, registration, approval
- Attendance, result, cost
- Report và analytics
- Audit và security

## 6. Out Of Scope

- Xử lý payroll
- Hệ thống HR core đầy đủ
- Hosting nội dung e-learning
- Tích hợp thanh toán bên ngoài

## 7. Stakeholders

HR, Training Department, Employee, Instructor, Line Manager, Finance, IT, System Admin, Ban lãnh đạo.

## 8. Business Process

TO-BE process được mô tả tại `../04_to_be/to_be_process.md`.

## 9. Business Requirements

| Requirement ID | Yêu cầu |
| --- | --- |
| BR-001 | Hệ thống cho phép Training Admin tạo training course. |
| BR-002 | Hệ thống cho phép mở nhiều class từ một course. |
| BR-003 | Hệ thống cho phép employee đăng ký class đang mở. |
| BR-004 | Hệ thống hỗ trợ manager approval khi cần. |
| BR-005 | Hệ thống ghi nhận attendance theo session. |
| BR-006 | Hệ thống ghi nhận training result và thông tin certificate. |
| BR-007 | Hệ thống ghi nhận training cost theo cost type. |
| BR-008 | Hệ thống cung cấp dashboard và report KPI đào tạo. |
| BR-009 | Hệ thống ghi audit log cho thao tác quan trọng. |
| BR-010 | Hệ thống kiểm soát truy cập theo role. |

## 10. Business Rules

Xem `../07_business_rules/business_rules.md`.

## 11. Reporting Requirements

Training hours, training cost, completion rate, pass rate và average KPI phải filter được theo kỳ báo cáo và thuộc tính tổ chức.

## 12. Data Requirements

Hệ thống phải hỗ trợ demo data cho năm 2025 và 2026.

## 13. Non-functional Requirements

Source code dễ đọc, có role authorization, validation, pagination, audit logging và database migration dễ bảo trì.

## 14. Assumptions

Employee master data có thể lấy từ HR hoặc seed data trong bản demo.

## 15. Constraints

Frontend dùng Thymeleaf và Bootstrap. Không dùng React, Vue hoặc Angular.

## 16. Acceptance Criteria

- User có thể login theo role.
- Sau các phase nghiệp vụ, business data có thể trace từ UI tới database.
- Sau khi sinh demo data, report có thể được kiểm chứng bằng truy vấn SQL.
