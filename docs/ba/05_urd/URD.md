# User Requirement Document

## 1. Document Information

Document: TMS URD  
Phase: Foundation draft  
Status: Initial

## 2. Background

Training is currently managed using Excel and manual communication.

## 3. Business Problem

The organization cannot reliably trace training history, hours, costs, instructors, and results.

## 4. Business Objective

Create a centralized system for managing and reporting enterprise training activities.

## 5. Scope

- Organization and employee data
- Course and class management
- Schedule, registration, approval
- Attendance, result, cost
- Reports and analytics
- Audit and security

## 6. Out of Scope

- Payroll processing
- Full HR core system
- Learning content hosting
- External payment integration

## 7. Stakeholders

HR, Training Department, Employee, Instructor, Line Manager, Finance, IT, System Admin, Management.

## 8. Business Process

The TO-BE process is documented in `../04_to_be/to_be_process.md`.

## 9. Business Requirements

| Requirement ID | Requirement |
| --- | --- |
| BR-001 | The system allows Training Admin to create training courses. |
| BR-002 | The system allows multiple classes to be opened from one course. |
| BR-003 | The system allows employees to register for open classes. |
| BR-004 | The system supports manager approval when required. |
| BR-005 | The system records attendance by session. |
| BR-006 | The system records training results and certificate information. |
| BR-007 | The system records training costs by cost type. |
| BR-008 | The system provides training KPI dashboards and reports. |
| BR-009 | The system logs important user actions for audit. |
| BR-010 | The system controls access by role. |

## 10. Business Rules

See `../07_business_rules/business_rules.md`.

## 11. Reporting Requirements

Training hours, training cost, completion rate, pass rate, and average KPIs must be filterable by period and organization attributes.

## 12. Data Requirements

The system must support demo data for 2025 and 2026.

## 13. Non-functional Requirements

Readable source code, role authorization, validation, pagination, audit logging, and maintainable database migrations.

## 14. Assumptions

Employee master data is available from HR or seed data in this demo.

## 15. Constraints

The frontend uses Thymeleaf and Bootstrap. No React, Vue, or Angular.

## 16. Acceptance Criteria

- Users can log in by role.
- Business data can be traced from UI to database after later phases.
- Reports can be validated by SQL exercises after demo data generation.
