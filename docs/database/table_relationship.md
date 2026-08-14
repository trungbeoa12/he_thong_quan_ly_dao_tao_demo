# Table Relationship

| Relationship | Cardinality | Ý nghĩa nghiệp vụ |
| --- | --- | --- |
| department -> department | 1 to many | Một phòng ban có thể có nhiều phòng ban con. |
| department -> employee | 1 to many | Mỗi nhân viên thuộc một phòng ban. |
| employee -> instructor | 1 to 0..1 | Giảng viên nội bộ có thể đồng thời là nhân viên. |
| course -> training_class | 1 to many | Một course có thể mở nhiều lớp. |
| instructor -> training_class | 1 to many | Một giảng viên có thể dạy nhiều lớp. |
| training_class -> training_session | 1 to many | Một lớp có nhiều buổi học. |
| training_class -> training_registration | 1 to many | Một lớp có nhiều lượt đăng ký. |
| employee -> training_registration | 1 to many | Một nhân viên có thể đăng ký nhiều lớp. |
| training_session -> attendance | 1 to many | Mỗi buổi học ghi nhận điểm danh theo từng học viên. |
| training_class -> training_result | 1 to many | Một lớp có kết quả cuối cùng cho từng học viên. |
| training_class -> training_cost | 1 to many | Một lớp có nhiều dòng chi phí theo cost type. |

## Referential Rules

- Chỉ được ghi attendance cho employee đã đăng ký lớp liên quan.
- Chỉ được tạo Training Result cho employee đã đăng ký lớp.
- Training Cost bắt buộc tham chiếu class và có thể tham chiếu employee hoặc instructor tùy cost type.
- Training Session date phải nằm trong khoảng start date và end date của class.
- Class đã COMPLETED hoặc CANCELLED không được nhận đăng ký mới.
