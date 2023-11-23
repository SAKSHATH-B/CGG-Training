insert into emp values(1,'Ajay','Trainee',1562,'15-09-2023',25000,15620,15);
insert into emp values(2,'Sakshath','TSD',1563,'09-08-2005',30000,15621,12);
insert into emp values(3,'Madhav','Freelance',1564,'1-05-2000',20000,15623,06);
insert into emp values(4,'Arvind','ASD',1565,'13-03-2003',35000,15624,12);
insert into emp values(5,'Dinakar','TSD',1566,'06-05-2005',27000,15625,06);
insert into emp values(6,'Aditya','TSD',1567,'14-11-2009',29000,15626,15);
insert into emp values(7,'Shankar','TSD',1568,'04-10-2003',28000,15627,05);
insert into emp values(8,'Charan','Part-Time',1569,'16-06-2001',15000,15628,13);



insert into Department_master values(10,'Computer Science');
insert into Department_master values(20,'Mechanics');
insert into Department_master values(30,'Electrical');
insert into Department_master values(40,'Information Technology');
insert into Department_master values(50,'Automobile');


insert into Student_master values(1,'abc',10,'1-2-1990','Hyd');
insert into Student_master values(10,'abc-def',20,'12-12-1985','Delhi');
insert into Student_master values(2,'xyz',10,'10-04-1992','Hyd');
insert into Student_master values(3,'pqr',30,'18-11-2000','Mumbai');
insert into Student_master values(4,'uvw',40,'20-05-1995','Chennai');
insert into Student_master values(5,'abc',20,'15-08-1991','Delhi');
insert into Student_master values(6,'xyz',50,'08-07-1990','Secd');
insert into Student_master values(7,'uvw',30,'14-09-2000','Kolkata');
insert into Student_master values(8,'lmn',40,'22-06-1992','Hyd');
insert into Student_master values(9,'pqr',50,'19-2-1990','Hyd');
insert into Student_master values(11,'Sunil',20,'10-09-1990','Hyd');
insert into Student_master values(12,'Sunil',NULL,'10-09-1990','Hyd');

insert into Designation_master values(12,'Asst Professor');
insert into Designation_master values(14,'Assoc Professor');
insert into Designation_master values(16,'Professor');
insert into Designation_master values(18,'Staff');

insert into Staff_master values(100,'Chetan',12,10,'12-12-2000','10-08-1975','Hyd',102,20000);
insert into Staff_master values(101,'Rehman',12,10,'05-04-1990','1-01-1980','Hyd',102,25000);
insert into Staff_master values(102,'Sheetal',16,10,'21-01-1980','05-06-1965','Delhi',2,80000);
insert into Staff_master values(103,'Rohit',18,10,'12-05-2000','30-11-1990','Hyd',102,15000);
insert into Staff_master values(104,'Syed',14,10,'10-07-2005','09-06-1970','Hyd',102,50000);
insert into Staff_master values(105,'Ahmed',12,30,'10-07-2005','09-06-1995','Hyd',106,20000);
insert into Staff_master values(106,'Abdul',16,30,'10-03-1980','19-06-1970','Hyd',107,90000);
insert into Staff_master values(108,'Virat',16,20,'20-06-1980','15-02-1978','Hyd',107,90000);
insert into Staff_master values(109,'Sushma',12,20,'22-07-1985','12-08-1984','Hyd',108,20000);


insert into Book_master values (1234,'C Pointers',2000,'Yeshwant Kanetkar');
insert into Book_master values (1233,'Let us C',2000,'Yeshwant Kanetkar');
insert into Book_master values (1235,'Mama marifiya',2001,'Dinakar karengula');


insert into Student_marks values(1,2000,80,50,60);
insert into Student_marks values(2,2000,70,70,65);
insert into Student_marks values(1,2001,70,60,60);
insert into Student_marks values(2,2001,70,65,80);



insert into Book_transactions values(1234,1,100,'06-09-2023','22-09-2023','10-09-2023');
insert into Book_transactions values(1233,2,101,'07-09-2023','13-09-2023','11-09-2023');
insert into Book_transactions values(1235,1,102,'08-09-2023','14-09-2023','12-09-2023');
insert into Book_transactions values(1234,2,103,'09-09-2023','22-09-2023','11-09-2023');


insert into previous_products values(7,'Uncle Bob''s Organic Dried Pears','12 - 1 lbpkgs',30.00,15);
insert into previous_products values(8,'Northwoods Cranberry Sauce','12 - 12 ozjars',40.00,6);
insert into previous_products values(1,'Chang','24 - 12 oz bottles',19.00,17);
insert into previous_products values(3,'Aniseed Syrup','12 - 550 mlbottles',10.00,13);
insert into previous_products values(4,'Chef Anton''s Cajun Seasoning','48 - 6 ozjars',22.00,53);
insert into previous_products values(5,'Chef Anton''s Gumbo Mix','36boxes',21.35,0);
insert into previous_products values(6,'Grandma''s Boysenberry Spread','12 - 8 ozjars',25.00,120);


insert into current_products values(7,'Uncle Bob''s Organic Dried Pears','12 - 1 lbpkgs',30.00,15);
insert into current_products values(8,'Northwoods Cranberry Sauce','12 - 12 ozjars',40.00,6);
insert into current_products values(9,'Mishi Kobe Niku','18 - 500 g pkgs.',97.00,29);
insert into current_products values(10,'Ikura','12 - 200 ml jars',31.00,31);
insert into current_products values(11,'Queso Cabrales','1 kg pkg.',21.00,22);
insert into current_products values(5,'Chef Anton''s Gumbo Mix','36boxes',21.35,0);
insert into current_products values(6,'Grandma''s Boysenberry Spread','12 - 8 ozjars',25.00,120);