create table department (
    id bigserial primary key,
    department_code varchar(50) not null unique,
    department_name varchar(255) not null,
    parent_department_id bigint,
    department_type varchar(30) not null,
    status varchar(20) not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp,
    constraint fk_department_parent foreign key (parent_department_id) references department(id)
);

create table employee (
    id bigserial primary key,
    employee_code varchar(50) not null unique,
    full_name varchar(255) not null,
    date_of_birth date,
    gender varchar(20),
    email varchar(255) not null unique,
    phone varchar(30),
    department_id bigint not null,
    position varchar(255),
    job_title varchar(255),
    hire_date date,
    employee_level varchar(30) not null,
    region varchar(50),
    generation_group varchar(50),
    salary_group varchar(50),
    status varchar(20) not null,
    constraint fk_employee_department foreign key (department_id) references department(id)
);

create index ix_department_parent on department(parent_department_id);
create index ix_employee_department on employee(department_id);
create index ix_employee_name on employee(full_name);

insert into department (department_code, department_name, parent_department_id, department_type, status) values
('HO', 'Head Office', null, 'HEAD_OFFICE', 'ACTIVE'),
('IT', 'Khối Công nghệ thông tin', 1, 'DIVISION', 'ACTIVE'),
('HR', 'Khối Nhân sự', 1, 'DIVISION', 'ACTIVE'),
('FIN', 'Khối Tài chính', 1, 'DIVISION', 'ACTIVE'),
('HN', 'Chi nhánh Hà Nội', 1, 'BRANCH', 'ACTIVE'),
('DN', 'Chi nhánh Đà Nẵng', 1, 'BRANCH', 'ACTIVE'),
('HCM', 'Chi nhánh TP.HCM', 1, 'BRANCH', 'ACTIVE'),
('IT-DEV', 'Phòng Phát triển phần mềm', 2, 'DEPARTMENT', 'ACTIVE'),
('IT-DATA', 'Phòng Dữ liệu', 2, 'DEPARTMENT', 'ACTIVE'),
('HR-TRN', 'Phòng Đào tạo', 3, 'DEPARTMENT', 'ACTIVE'),
('FIN-ACC', 'Phòng Kế toán', 4, 'DEPARTMENT', 'ACTIVE'),
('HCM-SALES', 'Phòng Kinh doanh TP.HCM', 7, 'DEPARTMENT', 'ACTIVE');

insert into employee (
    employee_code, full_name, date_of_birth, gender, email, phone, department_id,
    position, job_title, hire_date, employee_level, region, generation_group, salary_group, status
) values
('E0001', 'Nguyễn Minh An', '1993-04-12', 'MALE', 'an.nguyen@example.com', '0901000001', 8, 'Java Developer', 'Software Engineer', '2020-05-10', 'SPECIALIST', 'North', 'Millennial', 'SG3', 'ACTIVE'),
('E0002', 'Trần Thu Hà', '1990-09-20', 'FEMALE', 'ha.tran@example.com', '0901000002', 10, 'Training Admin', 'Training Specialist', '2019-03-18', 'SPECIALIST', 'North', 'Millennial', 'SG3', 'ACTIVE'),
('E0003', 'Lê Quốc Bình', '1985-01-05', 'MALE', 'binh.le@example.com', '0901000003', 2, 'IT Manager', 'Technology Manager', '2016-11-01', 'MANAGER', 'North', 'Gen X', 'SG5', 'ACTIVE'),
('E0004', 'Phạm Ngọc Mai', '1997-07-23', 'FEMALE', 'mai.pham@example.com', '0901000004', 9, 'Data Analyst', 'Data Analyst', '2022-08-15', 'STAFF', 'North', 'Gen Z', 'SG2', 'ACTIVE'),
('E0005', 'Hoàng Văn Nam', '1988-12-02', 'MALE', 'nam.hoang@example.com', '0901000005', 11, 'Accountant', 'Finance Officer', '2018-06-25', 'SENIOR_STAFF', 'North', 'Millennial', 'SG3', 'ACTIVE'),
('E0006', 'Đỗ Thị Lan', '1995-02-17', 'FEMALE', 'lan.do@example.com', '0901000006', 12, 'Sales Executive', 'Sales Officer', '2021-09-01', 'STAFF', 'South', 'Millennial', 'SG2', 'ACTIVE'),
('E0007', 'Vũ Đức Huy', '1982-10-11', 'MALE', 'huy.vu@example.com', '0901000007', 5, 'Branch Manager', 'Manager', '2015-01-12', 'SENIOR_MANAGER', 'North', 'Gen X', 'SG6', 'ACTIVE'),
('E0008', 'Bùi Khánh Linh', '1999-05-30', 'FEMALE', 'linh.bui@example.com', '0901000008', 6, 'Customer Service', 'Officer', '2023-02-20', 'STAFF', 'Central', 'Gen Z', 'SG1', 'ACTIVE'),
('E0009', 'Đặng Gia Phúc', '1991-03-09', 'MALE', 'phuc.dang@example.com', '0901000009', 8, 'Backend Developer', 'Software Engineer', '2020-10-05', 'SENIOR_STAFF', 'North', 'Millennial', 'SG3', 'ACTIVE'),
('E0010', 'Ngô Bảo Châu', '1994-11-14', 'FEMALE', 'chau.ngo@example.com', '0901000010', 3, 'HR Business Partner', 'HR Specialist', '2021-04-19', 'SPECIALIST', 'North', 'Millennial', 'SG3', 'ACTIVE');
