# Change Request CR-001

## Title

Allow employees to evaluate a course after completion.

## Current Behaviour

TMS records attendance and results but does not capture learner feedback.

## New Requirement

After a learner completes a class, the employee can submit course evaluation scores and comments.

## Impact Analysis

- New evaluation entity/table is required.
- Employee UI needs an evaluation form.
- Reports may include satisfaction score.
- APIs need create and search endpoints.
- UAT needs a new scenario.

## Database Impact

Add `course_evaluation` table with class, employee, score, comment, and submitted date.

## API Impact

Add `POST /api/classes/{id}/evaluations`.

## UI Impact

Add evaluation action in employee training history.

## Report Impact

Add average evaluation score by course, instructor, and department.

## Test Impact

Add tests for completed learners, duplicate evaluation prevention, and score validation.

## Implementation Status

Planned for Phase 10. Not implemented in Phase 0.
