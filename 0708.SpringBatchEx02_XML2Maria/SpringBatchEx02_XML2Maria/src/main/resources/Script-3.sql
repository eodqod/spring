drop table EXAM_RESULT;
create table EXAM_RESULT(
	idx int primary key auto_increment,
	STUDENT_NAME varchar(20) not null, 
	DOB date not null, 
	PERCENTAGE FLOAT(7,2) not null
);

select * from EXAM_RESULT;