create table emp(empno numeric(4) primary key,
ename varchar(10),job varchar(9),
mgr numeric(4),hiredate date,
sal numeric(7,2),
comm numeric(7,2),
deptno numeric(2));


create table designation_master(design_code numeric(3) primary key,
design_name varchar(50));

create table department_master(dept_code numeric(2) primary key,dept_name varchar(50));

create table student_master(student_code numeric(6) primary key,student_name varchar(50) not null,dept_code numeric(2),studen5_dob date,student_address varchar(240));

create table student_marks(student_code numeric(6),student_year numeric not null,
subject1 numeric(3),subject2 numeric(3),
subject3 numeric(3));

create table staff_master(staff_code numeric(6) primary key,staff_name varchar(50) not null,
design_code numeric,dept_code numeric,
hiredate date,staff_dob date,staff_address varchar(240), mgr_code numeric(8), staff_sal numeric(10,2));

create table book_master(book_code numeric(10) primary key,book_name varchar(50) not null,
book_publish_year numeric,book_pub_author varchar(50) not null);

create table book_transaction(book_code numeric,student_code numeric,staff_code numeric,
book_issue_date date not null,book_expected_return_date date not null,
book_actual_return_date date);





