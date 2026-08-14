# TO-BE Process

1. Training Admin creates course catalog in TMS.
2. Training Admin opens classes from approved courses.
3. System publishes class schedule and registration window.
4. Employee registers for an open class.
5. Manager approves when approval is required.
6. Instructor views assigned class and learner list.
7. Instructor records attendance per session.
8. Training Admin or Instructor records training results.
9. Finance or Training Admin records training costs.
10. Management views dashboard and analytics reports.

## Actor and System Actions

| Actor | Action | System Response |
| --- | --- | --- |
| Training Admin | Create class | Validate course, instructor, schedule, capacity |
| Employee | Register class | Validate registration window and duplicate registration |
| Manager | Approve request | Update approval status and audit action |
| Instructor | Record attendance | Validate attended hours and registered learners |
| Finance | Record cost | Classify cost by cost type |
| Management | View report | Aggregate hours, cost, completion rate, pass rate |
