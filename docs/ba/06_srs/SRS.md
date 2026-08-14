# Software Requirement Specification

## 1. Introduction

SRS này chuyển yêu cầu nghiệp vụ của TMS thành hành vi chức năng và kỹ thuật.

## 2. System Overview

TMS là ứng dụng web Spring Boot dùng Thymeleaf UI, REST API, Spring Security, JPA và Flyway.

## 3. User Roles

ADMIN, TRAINING_ADMIN, INSTRUCTOR, EMPLOYEE, MANAGER.

## 4. Functional Requirements

### FR-COURSE-001

Tên requirement: Tạo Course  
Actor: TRAINING_ADMIN  
Pre-condition: Actor đã login và có quyền.  
Trigger: Actor submit form tạo course.  
Main Flow: Validate input, lưu course, ghi audit action, hiển thị success.  
Alternative Flow: Actor hủy form.  
Exception Flow: Course code bị trùng thì trả validation error.  
Business Rules: Course code là unique.  
Validation Rules: Bắt buộc name, category, training type, training method, duration.  
Post-condition: Course sẵn sàng để mở class.  
Acceptance Criteria: Course hợp lệ có thể được tạo và search.

### FR-CLASS-001

Tên requirement: Mở Training Class  
Actor: TRAINING_ADMIN  
Pre-condition: Course và instructor đã tồn tại.  
Trigger: Actor tạo class từ course.  
Main Flow: Validate date, capacity, registration period, lưu class.  
Exception Flow: End date trước start date thì bị reject.  
Business Rules: Class thuộc đúng một course.  
Validation Rules: Capacity lớn hơn 0.  
Post-condition: Class có thể mở registration.  
Acceptance Criteria: Class trace được tới course và instructor.

### FR-ATTENDANCE-001

Tên requirement: Ghi Attendance  
Actor: INSTRUCTOR  
Pre-condition: Learner đã đăng ký class.  
Trigger: Instructor mở attendance sheet của session.  
Main Flow: Ghi attendance status và attended hours.  
Exception Flow: Attended hours lớn hơn session duration thì bị reject.  
Business Rules: BRULE-003.  
Validation Rules: Attendance status là bắt buộc.  
Post-condition: Training hours sẵn sàng cho report.  
Acceptance Criteria: Attendance đóng góp vào actual training hours.

## 5. Business Rules

Xem `../07_business_rules/business_rules.md`.

## 6. Data Requirements

Xem `../../database/data_dictionary.md`.

## 7. Validation Rules

Validation được áp dụng ở DTO layer và Service layer.

## 8. UI Behaviour

UI dùng sidebar, topbar, list screen, form screen và report filter.

## 9. API Behaviour

REST API trả JSON để hỗ trợ integration và kiểm chứng report bằng dữ liệu.

## 10. Error Handling

Validation error trả về standard API error response.

## 11. Security Requirements

Tất cả module nghiệp vụ cần kiểm soát truy cập theo role.

## 12. Reporting Requirements

Report tổng hợp attendance, result và cost theo filter nghiệp vụ.

## 13. Audit Requirements

Các thao tác create, update, delete, approval, attendance, result và cost phải có audit.
