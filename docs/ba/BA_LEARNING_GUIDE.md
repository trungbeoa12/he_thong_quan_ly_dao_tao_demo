# Lộ Trình Đọc Tài Liệu BA Cho Project TMS

Tài liệu này dành cho BA đọc theo từng giai đoạn của project. Nội dung tập trung vào hiểu nghiệp vụ, yêu cầu, dữ liệu, API, kiểm thử và change request. Không bao gồm bài tập thực hành.

## Giai Đoạn 1 - Hiểu Bối Cảnh Nghiệp Vụ

BA cần đọc:

- `01_business_request/business_request.md`
- `02_stakeholder_analysis/stakeholder_analysis.md`

Mục tiêu đọc:

- Hiểu vì sao doanh nghiệp cần TMS.
- Hiểu vấn đề khi quản lý đào tạo bằng Excel.
- Biết các nhóm stakeholder chính và nhu cầu của từng nhóm.

## Giai Đoạn 2 - Hiểu Quy Trình Hiện Tại Và Quy Trình Tương Lai

BA cần đọc:

- `03_as_is/as_is_process.md`
- `04_to_be/to_be_process.md`

Mục tiêu đọc:

- Nắm quy trình AS-IS trước khi có hệ thống.
- Nắm quy trình TO-BE sau khi triển khai TMS.
- Thấy actor nào thao tác gì và hệ thống phản hồi ra sao.

## Giai Đoạn 3 - Đọc URD

BA cần đọc:

- `05_urd/URD.md`

Mục tiêu đọc:

- Hiểu business problem, business objective, scope và out of scope.
- Nắm danh sách business requirements được đánh mã `BR-xxx`.
- Biết acceptance criteria ở mức nghiệp vụ.

## Giai Đoạn 4 - Đọc SRS

BA cần đọc:

- `06_srs/SRS.md`

Mục tiêu đọc:

- Hiểu business requirement được chuyển thành functional requirement như thế nào.
- Nắm cấu trúc một requirement chi tiết gồm actor, pre-condition, trigger, main flow, exception flow, validation rule và acceptance criteria.
- Nhìn được logic nghiệp vụ trước khi developer implement.

## Giai Đoạn 5 - Đọc Business Rules

BA cần đọc:

- `07_business_rules/business_rules.md`
- `../database/business_data_rules.md`

Mục tiêu đọc:

- Hiểu các rule quan trọng như chống đăng ký trùng, điều kiện nhập result, điều kiện tính attended hours.
- Biết rule nào ảnh hưởng tới UI, API, service, database và test.

## Giai Đoạn 6 - Đọc Thiết Kế Dữ Liệu

BA cần đọc:

- `../database/ERD.md`
- `../database/data_dictionary.md`
- `../database/table_relationship.md`

Mục tiêu đọc:

- Hiểu các entity chính của hệ thống.
- Biết ý nghĩa nghiệp vụ của từng table và field.
- Hiểu quan hệ giữa department, employee, course, class, session, registration, attendance, result và cost.

## Giai Đoạn 7 - Đọc Data Mapping

BA cần đọc:

- `08_data_mapping/data_mapping.md`

Mục tiêu đọc:

- Hiểu dữ liệu nguồn đi vào field đích như thế nào.
- Biết rule mapping từ business code sang database id.
- Nắm validation cơ bản cho dữ liệu đầu vào.

## Giai Đoạn 8 - Đọc API Specification

BA cần đọc:

- `09_api_specification/api_specification.md`

Mục tiêu đọc:

- Biết UI action sẽ gọi API nào.
- Hiểu method, URL, purpose và authorization của từng API.
- Chuẩn bị nền để trace từ UI tới service và database ở các phase sau.

## Giai Đoạn 9 - Đọc Traceability Matrix

BA cần đọc:

- `10_traceability/requirement_traceability_matrix.md`

Mục tiêu đọc:

- Thấy mỗi requirement được trace qua URD, SRS, API, database table, UI screen và test case.
- Hiểu cách kiểm soát scope và impact khi requirement thay đổi.

## Giai Đoạn 10 - Đọc SIT Và UAT

BA cần đọc:

- `11_sit/SIT_TestCases.md`
- `12_uat/UAT_TestCases.md`

Mục tiêu đọc:

- Hiểu SIT kiểm tra hệ thống theo requirement như thế nào.
- Hiểu UAT kiểm chứng scenario nghiệp vụ end-to-end như thế nào.
- Biết expected result của từng scenario.

## Giai Đoạn 11 - Đọc Change Request

BA cần đọc:

- `13_change_request/change_request_CR001.md`

Mục tiêu đọc:

- Hiểu cách mô tả current behaviour và new requirement.
- Biết cách phân tích impact tới database, API, UI, report và test.

## Giai Đoạn 12 - Đọc Go-Live Checklist

BA cần đọc:

- `14_go_live/go_live_checklist.md`

Mục tiêu đọc:

- Hiểu các nhóm việc cần kiểm tra trước go-live.
- Biết mối liên hệ giữa data, security, migration, SIT, UAT, training và operation.
