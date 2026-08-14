create table instructor (
    id bigserial primary key,
    instructor_code varchar(50) not null unique,
    instructor_name varchar(255) not null,
    instructor_type varchar(30) not null,
    organization varchar(255),
    expertise varchar(255),
    email varchar(255) not null unique,
    phone varchar(30),
    hourly_rate numeric(18, 2) not null,
    status varchar(20) not null
);

create table course (
    id bigserial primary key,
    course_code varchar(50) not null unique,
    course_name varchar(255) not null,
    category varchar(50) not null,
    description text,
    training_type varchar(30) not null,
    training_method varchar(30) not null,
    default_duration_hours numeric(8, 2) not null,
    target_audience varchar(255),
    status varchar(20) not null
);

create index ix_instructor_name on instructor(instructor_name);
create index ix_course_name on course(course_name);
create index ix_course_category on course(category);

insert into instructor (
    instructor_code, instructor_name, instructor_type, organization, expertise, email, phone, hourly_rate, status
) values
('INS001', 'Nguyễn Minh An', 'INTERNAL', 'Khối Công nghệ thông tin', 'Java, Spring Boot', 'instructor.an@example.com', '0911000001', 450000, 'ACTIVE'),
('INS002', 'Trần Thu Hà', 'INTERNAL', 'Phòng Đào tạo', 'Training Operations, Facilitation', 'instructor.ha@example.com', '0911000002', 350000, 'ACTIVE'),
('INS003', 'Lê Quốc Bình', 'INTERNAL', 'Khối Công nghệ thông tin', 'IT Management, Agile', 'instructor.binh@example.com', '0911000003', 600000, 'ACTIVE'),
('INS004', 'Phạm Ngọc Mai', 'INTERNAL', 'Phòng Dữ liệu', 'Data Analysis, SQL', 'instructor.mai@example.com', '0911000004', 420000, 'ACTIVE'),
('INS005', 'Dr. Michael Tran', 'EXTERNAL', 'TMS Academy Partner', 'Leadership, Management', 'michael.tran@partner.example.com', '0911000005', 1200000, 'ACTIVE'),
('INS006', 'Sarah Le', 'EXTERNAL', 'Compliance Pro Consulting', 'Compliance, Risk Management', 'sarah.le@partner.example.com', '0911000006', 1500000, 'ACTIVE');

insert into course (
    course_code, course_name, category, description, training_type, training_method,
    default_duration_hours, target_audience, status
) values
('C-JAVA-001', 'Java Basic for Enterprise Developers', 'IT', 'Nhập môn Java và coding standard cho hệ thống doanh nghiệp.', 'INTERNAL', 'OFFLINE', 24, 'Developer mới', 'ACTIVE'),
('C-SPRING-001', 'Spring Boot Foundation', 'IT', 'Nền tảng Spring Boot, MVC, JPA và Security.', 'INTERNAL', 'BLENDED', 32, 'Java Developer', 'ACTIVE'),
('C-SQL-001', 'SQL for BA and Reporting', 'DATA', 'SQL phục vụ phân tích dữ liệu và kiểm chứng báo cáo.', 'INTERNAL', 'ONLINE', 16, 'BA, Data Analyst', 'ACTIVE'),
('C-BA-001', 'Business Analysis Foundation', 'MANAGEMENT', 'Tổng quan vòng đời BA từ BRD/URD tới UAT.', 'INTERNAL', 'OFFLINE', 16, 'BA mới', 'ACTIVE'),
('C-COM-001', 'Mandatory Compliance 2025', 'COMPLIANCE', 'Đào tạo compliance bắt buộc cho toàn bộ nhân viên.', 'INTERNAL', 'E_LEARNING', 4, 'All Employees', 'ACTIVE'),
('C-RISK-001', 'Operational Risk Awareness', 'RISK_MANAGEMENT', 'Nhận diện rủi ro vận hành trong hoạt động ngân hàng.', 'EXTERNAL', 'ONLINE', 8, 'Manager, Specialist', 'ACTIVE'),
('C-SALES-001', 'Consultative Sales Skills', 'SALES', 'Kỹ năng bán hàng tư vấn cho đội ngũ kinh doanh.', 'EXTERNAL', 'OFFLINE', 12, 'Sales Team', 'ACTIVE'),
('C-LEAD-001', 'Leadership Essentials', 'LEADERSHIP', 'Năng lực lãnh đạo nền tảng cho manager.', 'EXTERNAL', 'BLENDED', 20, 'Manager', 'ACTIVE');
