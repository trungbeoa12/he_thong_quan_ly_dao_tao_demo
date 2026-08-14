# Software Requirement Specification

## 1. Introduction

This SRS translates TMS business requirements into functional and technical behavior.

## 2. System Overview

TMS is a Spring Boot web application with Thymeleaf UI, REST APIs, Spring Security, JPA, and Flyway.

## 3. User Roles

ADMIN, TRAINING_ADMIN, INSTRUCTOR, EMPLOYEE, MANAGER.

## 4. Functional Requirements

### FR-COURSE-001

Requirement Name: Create Course  
Actor: TRAINING_ADMIN  
Pre-condition: Actor is authenticated and authorized.  
Trigger: Actor submits course creation form.  
Main Flow: Validate input, save course, audit action, show success.  
Alternative Flow: Actor cancels form.  
Exception Flow: Duplicate course code returns validation error.  
Business Rules: Course code is unique.  
Validation Rules: Mandatory name, category, training type, training method, duration.  
Post-condition: Course is available for class opening.  
Acceptance Criteria: A valid course can be created and searched.

### FR-CLASS-001

Requirement Name: Open Training Class  
Actor: TRAINING_ADMIN  
Pre-condition: Course and instructor exist.  
Trigger: Actor creates a class from a course.  
Main Flow: Validate date, capacity, registration period, save class.  
Exception Flow: End date before start date is rejected.  
Business Rules: Class belongs to exactly one course.  
Validation Rules: Capacity greater than zero.  
Post-condition: Class can be opened for registration.  
Acceptance Criteria: A class can be traced to its course and instructor.

### FR-ATTENDANCE-001

Requirement Name: Record Attendance  
Actor: INSTRUCTOR  
Pre-condition: Learner is registered in class.  
Trigger: Instructor opens a session attendance sheet.  
Main Flow: Record attendance status and attended hours.  
Exception Flow: Attended hours greater than session duration is rejected.  
Business Rules: BRULE-003.  
Validation Rules: Attendance status is mandatory.  
Post-condition: Training hours are available for reports.  
Acceptance Criteria: Attendance contributes to actual training hours.

## 5. Business Rules

See `../07_business_rules/business_rules.md`.

## 6. Data Requirements

See `../../database/data_dictionary.md`.

## 7. Validation Rules

Validation is applied at DTO and service levels.

## 8. UI Behaviour

The UI uses a sidebar, topbar, list screens, form screens, and report filters.

## 9. API Behaviour

REST APIs return JSON for integration and reporting exercises.

## 10. Error Handling

Validation errors return a standard API error response.

## 11. Security Requirements

Role-based endpoint access is required for all business modules.

## 12. Reporting Requirements

Reports aggregate attendance, results, and costs by business filters.

## 13. Audit Requirements

Create, update, delete, approval, attendance, result, and cost actions must be auditable.
