# ERD

```mermaid
erDiagram
    DEPARTMENT ||--o{ DEPARTMENT : parent_child
    DEPARTMENT ||--o{ EMPLOYEE : has
    EMPLOYEE ||--o| INSTRUCTOR : may_be
    COURSE ||--o{ TRAINING_CLASS : opens
    INSTRUCTOR ||--o{ TRAINING_CLASS : teaches
    TRAINING_CLASS ||--o{ TRAINING_SESSION : contains
    TRAINING_CLASS ||--o{ TRAINING_REGISTRATION : has
    EMPLOYEE ||--o{ TRAINING_REGISTRATION : registers
    TRAINING_SESSION ||--o{ ATTENDANCE : records
    EMPLOYEE ||--o{ ATTENDANCE : attends
    TRAINING_CLASS ||--o{ TRAINING_RESULT : produces
    EMPLOYEE ||--o{ TRAINING_RESULT : receives
    TRAINING_CLASS ||--o{ TRAINING_COST : incurs
    EMPLOYEE ||--o{ TRAINING_COST : employee_cost
    INSTRUCTOR ||--o{ TRAINING_COST : instructor_cost
    USERS ||--o{ AUTHORITIES : has

    DEPARTMENT {
        bigint id PK
        varchar department_code UK
        varchar department_name
        bigint parent_department_id FK
        varchar department_type
        varchar status
        timestamp created_at
        timestamp updated_at
    }

    EMPLOYEE {
        bigint id PK
        varchar employee_code UK
        varchar full_name
        date date_of_birth
        varchar gender
        varchar email
        varchar phone
        bigint department_id FK
        varchar position
        varchar job_title
        date hire_date
        varchar employee_level
        varchar region
        varchar generation_group
        varchar salary_group
        varchar status
    }

    INSTRUCTOR {
        bigint id PK
        varchar instructor_code UK
        varchar instructor_name
        varchar instructor_type
        varchar organization
        varchar expertise
        varchar email
        varchar phone
        numeric hourly_rate
        varchar status
    }

    COURSE {
        bigint id PK
        varchar course_code UK
        varchar course_name
        varchar category
        text description
        varchar training_type
        varchar training_method
        numeric default_duration_hours
        varchar target_audience
        varchar status
    }

    TRAINING_CLASS {
        bigint id PK
        varchar class_code UK
        bigint course_id FK
        bigint instructor_id FK
        date start_date
        date end_date
        varchar location
        integer max_participants
        varchar class_status
        numeric planned_hours
        numeric actual_hours
        date registration_start_date
        date registration_end_date
    }
```

Sơ đồ trên mô tả logical ERD mục tiêu cho toàn bộ hệ thống TMS. Tới Phase 2, MySQL runtime đã có các bảng `users`, `authorities`, `audit_log`, `department`, `employee`, `instructor`, `course`. Các bảng nghiệp vụ như `training_class`, `training_session`, `training_registration`, `attendance`, `training_result`, `training_cost` là thiết kế mục tiêu cho các phase sau.

Mô hình đầy đủ được giải thích thêm trong `data_dictionary.md` và `table_relationship.md`.
