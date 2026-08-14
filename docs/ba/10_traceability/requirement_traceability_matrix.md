# Requirement Traceability Matrix

| Business Requirement | URD Requirement | SRS Requirement | API | Database Table | UI Screen | Test Case |
| --- | --- | --- | --- | --- | --- | --- |
| BR-001 | URD-TRAINING-001 | FR-COURSE-001 | POST /api/courses | course | Course Creation Screen | TC-COURSE-001 |
| BR-002 | URD-TRAINING-002 | FR-CLASS-001 | POST /api/classes | training_class | Class Creation Screen | TC-CLASS-001 |
| BR-005 | URD-TRAINING-005 | FR-ATTENDANCE-001 | POST /api/sessions/{id}/attendance | attendance | Attendance Screen | TC-ATT-001 |
| BR-008 | URD-REPORT-001 | FR-REPORT-001 | GET /api/reports/training-hours | attendance | Dashboard | TC-REPORT-001 |
