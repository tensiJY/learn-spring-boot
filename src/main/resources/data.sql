insert into course(id, name, created_date, last_updated_date) 
values(10001,'JPA in 50 Steps', now(), now());
insert into course(id, name, created_date, last_updated_date) 
values(10002,'Spring in 50 Steps', now(), now());
insert into course(id, name, created_date, last_updated_date) 
values(10003,'Spring Boot in 100 Steps', now(), now());
values(10004,'Dummy1', now(), now());
insert into course(id, name, created_date, last_updated_date) 
values(10005,'Dummy2', now(), now());
insert into course(id, name, created_date, last_updated_date) 
values(10006,'Dummy3', now(), now());
insert into course(id, name, created_date, last_updated_date) 
values(10007,'Dummy4', now(), now());
insert into course(id, name, created_date, last_updated_date) 
values(10008,'Dummy5', now(), now());


insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L123890');

insert into student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);

insert into review(id,rating,description, course_id)
values(50001,'5', 'Great Course', 10001);
insert into review(id,rating,description, course_id)
values(50002,'4', 'Wonderful Course', 10002);
insert into review(id,rating,description, course_id)
values(50003,'5', 'Awesome Course', 10003);

insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,10003);