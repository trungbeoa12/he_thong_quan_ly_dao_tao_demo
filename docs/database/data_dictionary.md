# Data Dictionary

## department

Purpose: stores organization hierarchy.

| Field | Type | Mandatory | Meaning | Validation |
| --- | --- | --- | --- | --- |
| id | bigint | Yes | Primary key | Generated |
| department_code | varchar | Yes | Business code | Unique |
| department_name | varchar | Yes | Display name | 2-255 chars |
| parent_department_id | bigint | No | Parent department | Must reference department.id |
| department_type | varchar | Yes | HO, DIVISION, BRANCH, TEAM | Controlled values |
| status | varchar | Yes | ACTIVE/INACTIVE | Controlled values |
| created_at | timestamp | Yes | Creation time | System generated |
| updated_at | timestamp | Yes | Last update time | System generated |

## employee

Purpose: stores employees and learners.

| Field | Type | Mandatory | Meaning | Validation |
| --- | --- | --- | --- | --- |
| id | bigint | Yes | Primary key | Generated |
| employee_code | varchar | Yes | HR employee code | Unique |
| full_name | varchar | Yes | Employee full name | 2-255 chars |
| email | varchar | Yes | Work email | Email format, unique |
| department_id | bigint | Yes | Owning department | FK to department |
| employee_level | varchar | Yes | Staff, specialist, manager | Controlled values |
| status | varchar | Yes | Employment status | ACTIVE/INACTIVE |

## instructor

Purpose: stores internal and external instructors.

| Field | Type | Mandatory | Meaning | Validation |
| --- | --- | --- | --- | --- |
| id | bigint | Yes | Primary key | Generated |
| instructor_code | varchar | Yes | Instructor code | Unique |
| instructor_type | varchar | Yes | INTERNAL/EXTERNAL | Controlled values |
| hourly_rate | numeric | Yes | Cost rate | Greater than or equal to 0 |
| status | varchar | Yes | Availability | ACTIVE/INACTIVE |

## course

Purpose: stores reusable training programs.

| Field | Type | Mandatory | Meaning | Validation |
| --- | --- | --- | --- | --- |
| id | bigint | Yes | Primary key | Generated |
| course_code | varchar | Yes | Course code | Unique |
| course_name | varchar | Yes | Course name | 2-255 chars |
| category | varchar | Yes | Training domain | Controlled values |
| training_type | varchar | Yes | INTERNAL/EXTERNAL | Controlled values |
| training_method | varchar | Yes | OFFLINE/ONLINE/E_LEARNING/BLENDED | Controlled values |
| default_duration_hours | numeric | Yes | Standard duration | Greater than 0 |
| status | varchar | Yes | ACTIVE/INACTIVE | Controlled values |

## training_class

Purpose: stores actual opened classes for a course.

| Field | Type | Mandatory | Meaning | Validation |
| --- | --- | --- | --- | --- |
| id | bigint | Yes | Primary key | Generated |
| class_code | varchar | Yes | Class code | Unique |
| course_id | bigint | Yes | Source course | FK to course |
| instructor_id | bigint | Yes | Main instructor | FK to instructor |
| start_date | date | Yes | Class start | Not after end_date |
| end_date | date | Yes | Class end | Not before start_date |
| max_participants | integer | Yes | Capacity | Greater than 0 |
| class_status | varchar | Yes | Lifecycle state | PLANNED/OPEN/IN_PROGRESS/COMPLETED/CANCELLED |

## users, authorities

Purpose: Spring Security authentication and authorization skeleton.

| Table | Primary Key | Meaning |
| --- | --- | --- |
| users | username | Login account with BCrypt password |
| authorities | username, authority | Role assignments such as ROLE_ADMIN |

## audit_log

Purpose: stores important user actions for enterprise audit.

| Field | Type | Mandatory | Meaning |
| --- | --- | --- | --- |
| id | bigint | Yes | Primary key |
| username | varchar | Yes | Actor |
| action | varchar | Yes | Action name |
| module | varchar | Yes | Functional module |
| object_id | varchar | No | Target record |
| old_value | text | No | Before value |
| new_value | text | No | After value |
| created_at | timestamp | Yes | Audit time |
