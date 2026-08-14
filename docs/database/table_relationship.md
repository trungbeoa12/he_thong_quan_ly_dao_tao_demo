# Table Relationship

| Relationship | Cardinality | Business Meaning |
| --- | --- | --- |
| department -> department | 1 to many | A department may have child departments. |
| department -> employee | 1 to many | Each employee belongs to one department. |
| employee -> instructor | 1 to 0..1 | An internal instructor may also be an employee. |
| course -> training_class | 1 to many | One course can be opened as many classes. |
| instructor -> training_class | 1 to many | One instructor can teach many classes. |
| training_class -> training_session | 1 to many | A class has multiple sessions. |
| training_class -> training_registration | 1 to many | A class has many employee registrations. |
| employee -> training_registration | 1 to many | An employee can register for many classes. |
| training_session -> attendance | 1 to many | Each session records attendance per employee. |
| training_class -> training_result | 1 to many | A class has final results for learners. |
| training_class -> training_cost | 1 to many | A class has cost lines by cost type. |

## Referential Rules

- Attendance can only be recorded for employees registered in the related class.
- Training Result can only be created for registered employees.
- Training Cost must reference a class and may reference an employee or instructor depending on cost type.
- Training Session dates must be inside the class start and end dates.
- A completed or cancelled class cannot accept new registrations.
