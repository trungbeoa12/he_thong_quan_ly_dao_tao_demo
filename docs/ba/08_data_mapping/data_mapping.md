# Data Mapping

| Target Table | Target Field | Business Name | Description | Source | Source Field | Data Type | Transformation Rule | Mandatory | Validation | Example |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| employee | department_id | Department | Employee owning department | HR file | department_code | bigint | Map department_code to department.id | Yes | Must exist | IT-HO |
| training_registration | employee_id | Learner | Registered employee | UI/API | employee_code | bigint | Map employee_code to employee.id | Yes | Must exist | E0001 |
| training_registration | class_id | Class | Selected class | UI/API | class_code | bigint | Map class_code to training_class.id | Yes | Must exist | CLS-2025-001 |
| attendance | attended_hours | Attended Hours | Actual hours attended | UI/API | attendedHours | numeric | Direct value | Yes | <= session.duration_hours | 4 |
| training_cost | amount | Cost Amount | Cost line amount | Finance file/UI | amount | numeric | Direct value | Yes | >= 0 | 1500000 |
