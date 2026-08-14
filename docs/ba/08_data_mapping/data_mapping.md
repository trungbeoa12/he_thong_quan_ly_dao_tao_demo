# Data Mapping

| Target Table | Target Field | Business Name | Description | Source | Source Field | Data Type | Transformation Rule | Mandatory | Validation | Example |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| employee | department_id | Department | Đơn vị trực thuộc của employee | HR file | department_code | bigint | Map `department_code` sang `department.id` | Yes | Phải tồn tại | IT-HO |
| training_registration | employee_id | Learner | Employee đăng ký học | UI/API | employee_code | bigint | Map `employee_code` sang `employee.id` | Yes | Phải tồn tại | E0001 |
| training_registration | class_id | Class | Class được chọn | UI/API | class_code | bigint | Map `class_code` sang `training_class.id` | Yes | Phải tồn tại | CLS-2025-001 |
| attendance | attended_hours | Attended Hours | Số giờ học thực tế | UI/API | attendedHours | numeric | Lấy trực tiếp từ input | Yes | <= `session.duration_hours` | 4 |
| training_cost | amount | Cost Amount | Số tiền của cost line | Finance file/UI | amount | numeric | Lấy trực tiếp từ input | Yes | >= 0 | 1500000 |
