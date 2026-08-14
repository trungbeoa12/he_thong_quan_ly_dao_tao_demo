# AS-IS Process - Quy Trình Hiện Tại

## 1. Mục Đích Tài Liệu

Tài liệu này mô tả cách doanh nghiệp đang quản lý hoạt động đào tạo trước khi có hệ thống TMS. BA đọc tài liệu này để hiểu hiện trạng, điểm đau nghiệp vụ, dữ liệu đang phát sinh ở đâu và vì sao cần chuyển sang quy trình TO-BE.

## 2. Phạm Vi Quy Trình

Quy trình AS-IS bao gồm toàn bộ vòng đời đào tạo hiện tại:

- Thu thập nhu cầu đào tạo.
- Tổng hợp kế hoạch đào tạo.
- Mở lớp và gửi thông báo.
- Nhân viên đăng ký học.
- Manager phê duyệt nếu cần.
- Tổ chức lớp học và điểm danh.
- Ghi nhận kết quả học tập.
- Tổng hợp chi phí.
- Lập báo cáo cho HR, Training Department, Finance và ban lãnh đạo.

## 3. Actor Tham Gia

| Actor | Vai trò trong AS-IS | Công cụ đang dùng |
| --- | --- | --- |
| Training Department | Tổng hợp nhu cầu, lập kế hoạch, mở lớp, tổng hợp attendance/result/cost | Excel, email, chat |
| HR | Cung cấp thông tin nhân viên, chính sách đào tạo | HR file, Excel |
| Employee | Đăng ký và tham gia lớp học | Email, form rời, chat |
| Line Manager | Xác nhận hoặc phê duyệt nhân viên đi học | Email, chat |
| Instructor | Giảng dạy, điểm danh, gửi kết quả | Excel, email |
| Finance | Tổng hợp và kiểm tra chi phí đào tạo | Excel, chứng từ |
| Ban lãnh đạo | Xem báo cáo tổng hợp | File báo cáo thủ công |
| IT | Hỗ trợ file, phân quyền folder, xử lý lỗi kỹ thuật rời rạc | File server, email |

## 4. Quy Trình Tổng Quan

1. Training Department nhận nhu cầu đào tạo từ các đơn vị.
2. Nhu cầu được tổng hợp vào file Excel.
3. Training Department rà soát ngân sách, instructor, thời gian và địa điểm.
4. Training Department lập danh sách course/class dự kiến.
5. Thông báo lớp học được gửi qua email hoặc chat.
6. Employee đăng ký bằng email, form rời hoặc phản hồi trực tiếp.
7. Manager phê duyệt qua email/chat nếu lớp yêu cầu approval.
8. Training Department tổng hợp danh sách học viên cuối cùng.
9. Instructor nhận danh sách lớp và tổ chức giảng dạy.
10. Attendance được ghi nhận bằng Excel hoặc giấy rồi gửi lại Training Department.
11. Instructor hoặc Training Department nhập result vào file tổng hợp.
12. Finance và Training Department tổng hợp chi phí.
13. Training Department lập báo cáo thủ công theo tháng/quý/năm.
14. Ban lãnh đạo nhận báo cáo qua file hoặc slide.

## 5. Quy Trình Chi Tiết Theo Bước

| Bước | Người thực hiện | Input | Xử lý hiện tại | Output | Vấn đề chính |
| --- | --- | --- | --- | --- | --- |
| 1 | Đơn vị/Manager | Nhu cầu đào tạo | Gửi email hoặc file nhu cầu | Danh sách nhu cầu rời rạc | Không thống nhất format |
| 2 | Training Department | Nhu cầu từ nhiều đơn vị | Copy vào file Excel tổng | File nhu cầu tổng hợp | Dễ sai khi copy/paste |
| 3 | Training Department | Nhu cầu, ngân sách, instructor | Lập kế hoạch thủ công | Kế hoạch đào tạo | Khó trace quyết định |
| 4 | Training Department | Kế hoạch lớp | Gửi email thông báo | Email mời học | Khó biết ai đã nhận thông tin |
| 5 | Employee | Email thông báo | Reply email/form để đăng ký | Danh sách đăng ký | Dễ đăng ký trùng hoặc thiếu thông tin |
| 6 | Manager | Danh sách đăng ký | Approve qua email/chat | Approval rời rạc | Khó audit ai approve lúc nào |
| 7 | Instructor | Danh sách học viên | Điểm danh bằng Excel/giấy | Attendance file | Dễ sai mã nhân viên, thiếu buổi |
| 8 | Instructor/Training Department | Bài kiểm tra/kết quả | Nhập result vào file | Result file | Khó kiểm tra learner có thật sự tham gia |
| 9 | Finance/Training Department | Hóa đơn, phụ cấp, fee | Tổng hợp cost thủ công | Cost summary | Khó phân loại cost type thống nhất |
| 10 | Training Department | Attendance, result, cost | Làm report thủ công | Báo cáo KPI | Tốn thời gian, khó kiểm chứng |

## 6. Dữ Liệu Đang Được Quản Lý Rời Rạc

| Nhóm dữ liệu | Nơi lưu hiện tại | Rủi ro |
| --- | --- | --- |
| Department | HR file, Excel | Tên đơn vị không thống nhất |
| Employee | HR file, danh sách lớp | Sai mã nhân viên, sai department |
| Course | File kế hoạch đào tạo | Không có mã course chuẩn |
| Class | Excel kế hoạch lớp | Không trace rõ course-class |
| Registration | Email, form, Excel | Trùng đăng ký, thiếu approval |
| Attendance | Excel/giấy | Khó tính actual training hours |
| Result | Excel instructor gửi | Khó kiểm tra điều kiện nhập result |
| Cost | Excel Finance/Training | Cost type không thống nhất |
| Report | Excel/slide | Khó drill-down và kiểm chứng số liệu |

## 7. Pain Points Chính

- Không có single source of truth cho dữ liệu đào tạo.
- Dữ liệu nằm ở nhiều file, nhiều owner, nhiều version.
- Không có mã chuẩn cho course, class, session, registration.
- Không kiểm soát tốt duplicate registration.
- Approval qua email/chat nên khó audit.
- Attendance không liên kết chặt với registration.
- Result có thể được nhập cho người chưa đủ điều kiện.
- Training hours phải tính thủ công từ attendance file.
- Training cost khó tách theo instructor fee, travel, hotel, material, room và other cost.
- Report theo department, region, employee level, generation group hoặc salary group mất nhiều thời gian.
- Khi có thay đổi requirement, BA khó xác định impact vì dữ liệu và quy trình không tập trung.

## 8. Rủi Ro Nghiệp Vụ

| Rủi ro | Mô tả | Ảnh hưởng |
| --- | --- | --- |
| Sai số liệu training hours | Attendance file thiếu hoặc sai giờ học | KPI đào tạo không đáng tin |
| Sai chi phí đào tạo | Cost không phân loại đúng | Finance khó kiểm soát ngân sách |
| Thiếu lịch sử học tập | Dữ liệu phân tán theo từng lớp | HR không đánh giá được năng lực nhân viên |
| Không audit approval | Approval nằm trong email/chat | Khó giải trình khi có tranh chấp |
| Báo cáo chậm | Cần tổng hợp thủ công | Ban lãnh đạo không có dữ liệu kịp thời |
| Không trace requirement | File nghiệp vụ và dữ liệu rời rạc | SIT/UAT khó kiểm chứng |

## 9. Business Rules Đang Ngầm Tồn Tại

Các rule sau đang tồn tại trong thực tế nhưng chưa được hệ thống hóa:

- Một nhân viên chỉ nên đăng ký một lần cho cùng một lớp.
- Lớp có giới hạn số lượng học viên.
- Một số lớp cần manager approval trước khi tham gia.
- Attendance phải được ghi theo từng buổi học.
- Actual training hours phải tính từ attended hours.
- Result chỉ nên có cho người đã tham gia lớp.
- Cost cần tách theo loại chi phí để phục vụ Finance và report.

## 10. Điểm BA Cần Chú Ý Khi Đọc AS-IS

BA cần đặc biệt chú ý:

- Bước nào đang làm thủ công và dễ sai.
- Dữ liệu nào được nhập nhiều lần ở nhiều nơi.
- Actor nào là owner của từng loại dữ liệu.
- Quyết định nào cần audit nhưng hiện chưa audit được.
- Report nào đang phụ thuộc vào Excel thủ công.
- Pain point nào sẽ trở thành requirement trong URD/SRS.

## 11. Kết Luận AS-IS

Quy trình hiện tại có thể vận hành khi số lượng lớp ít, nhưng không phù hợp với doanh nghiệp có hàng nghìn nhân viên, nhiều đơn vị và nhiều loại hình đào tạo. Vấn đề lớn nhất không chỉ là thiếu phần mềm, mà là thiếu dữ liệu tập trung, thiếu rule rõ ràng, thiếu traceability và thiếu khả năng kiểm chứng báo cáo.
