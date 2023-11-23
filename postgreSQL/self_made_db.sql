CREATE TABLE emp(empno number(4) PRIMARY KEY,
Ename varchar2(10), job varchar2(9),mgr number(4),
Hiredate DATE,Sal number(7,2),Comm number(7,2),
Deptno number(2));

CREATE TABLE Designation_master(Design_code number(3) PRIMARY KEY,
Design_name varchar2(50));

CREATE TABLE Department_master(Dept_code number(2) PRIMARY KEY, 
Dept_name varchar2(50));

CREATE TABLE Student_master(Student_code number(6) PRIMARY KEY, 
Student_name varchar2(50) NOT NULL,Dept_code number(2),
Student_dob DATE,Student_address varchar2(240));

CREATE TABLE Student_marks(Student_code number(6),
Student_year number NOT NULL,Subject1 number(3),
Student2 number(3),Student3 number(3));

CREATE TABLE Staff_master(Staff_code number(8) PRIMARY KEY, 
Staff_Name varchar2(50) NOT NULL,Design_code number, 
Dept_code number, Hiredate DATE, Staff_dob DATE,
Staff_address varchar2(240), Mgr_code number(8), 
Staff_sal number(10,2));

CREATE TABLE Book_master(Book_Code number(10) PRIMARY KEY, 
Book_Name varchar2(50) NOT NULL, 
Book_pub_year number, Book_pub_author varchar2(50) NOT NULL);

CREATE TABLE Book_transactions(Book_Code number, Student_code number, 
Staff_code number, Book_issue_date DATE NOT NULL, 
Book_expected_return_date DATE NOT NULL,
Book_actual_return_date DATE);


create table previous_products(pid number,name varchar2(40),unit varchar2(40),price number, stock number);

create table current_products(pid number, name varchar2(40),unit varchar2(40), price number, stock number);