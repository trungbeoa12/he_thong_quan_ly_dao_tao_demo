# Change Request CR-001

## Title

Cho phép employee đánh giá course sau khi hoàn thành.

## Hiện Trạng

TMS ghi nhận attendance và result nhưng chưa thu thập feedback của learner.

## Yêu Cầu Mới

Sau khi learner hoàn thành class, employee có thể submit điểm đánh giá course và comment.

## Phân Tích Impact

- Cần thêm evaluation entity/table.
- Employee UI cần form đánh giá.
- Report có thể bổ sung satisfaction score.
- API cần endpoint create và search evaluation.
- UAT cần thêm scenario mới.

## Impact Database

Thêm bảng `course_evaluation` gồm class, employee, score, comment và submitted date.

## Impact API

Thêm `POST /api/classes/{id}/evaluations`.

## Impact UI

Thêm action đánh giá trong employee training history.

## Impact Report

Thêm average evaluation score theo course, instructor và department.

## Impact Test

Thêm test cho completed learner, chống duplicate evaluation và validate score.

## Trạng Thái Implement

Dự kiến ở Phase 10. Chưa implement trong Phase 0.
