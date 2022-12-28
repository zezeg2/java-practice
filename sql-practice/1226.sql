SET GLOBAL time_zone='+09:00';
SET time_zone = '+09:00';
SELECT @@GLOBAL.time_zone, @@SESSION.time_zone, @@system_time_zone;
set autocommit = false;
show variables like '%auto%';

create table emp_copy
    (select employee_id, first_name, last_name, salary, hire_date, department_id
     from employees);

select *
from emp_copy;

insert into emp_copy (employee_id, first_name, last_name, salary, hire_date, department_id)
values (1, 'jonghyeon', 'park', 100000, '2022-12-26', 10);
select * from emp_copy where employee_id = 1;
insert into emp_copy (employee_id, first_name, last_name, salary, hire_date, department_id)
values (3, 'jonghyeon', 'park', null, now(), null),
       (4, 'jonghyeon', 'park', null, now(), null),
       (5, 'jonghyeon', 'park', null, now(), null);
insert ignore into emp_copy
values (6, 'jonghyeon', 'park', 210000, 2022, null);

select *
from emp_copy ec
where first_name = 'jonghyeon';

desc emp_copy;

select department_id, salary, hire_date
from emp_copy ec
where hire_date like '_____06%';

drop table product;
create table product
(
    code    int primary key,
    name    char(30) not null,
    price   decimal,
    balance smallint default 1 check (balance >= 0)
);
desc product;
select *
from information_schema.table_constraints tc
where table_name = 'product';
insert into product
values (100, '냉장고', 10000000, 10);
insert into product
values (101, '냉장고2', 10000000, -1);
insert into product
values (102, '냉장고3', 10000000, 10);
insert into product
values (103, '냉장고4', 10000000, 0);
select *
from product p;


alter table product
    modify code int not null auto_increment;

create table user
(
    user_id     char(10) primary key,
    user_pw     char(5) not null,
    use_name    char(30),
    use_email   char(30) unique,
    user_phone  char(12) check (user_phone like '010-%'),
    use_address char(100)
);

insert into user (user_id, user_pw, use_name, user_phone, use_address)
values ('root', '0000', 'hello world', '010-2086-932', '31-7');


-- 컬럼 레벨로만 가능 - not null
-- 테이블 레벨로만 가능 * maria db only => foreign key
-- 컬럼레벨 + 테이블 레벨도 가능
create table board
(
    seq        int(10) primary key auto_increment,
    title      char(50) not null,
    contents   text     not null,
    view_count int(10),
    writer     char(10) not null,
    foreign key (writer) references user (user_id) on delete set null
);



create table board2
(
    seq        int      not null auto_increment,
    title      char(50) not null,
    contents   text     not null,
    view_count int(10),
    writer     char(10) not null,
    constraint primary key (seq),
    constraint fk_board_writer foreign key (writer) references user (user_id)
);

alter table board2
    add writing_time datetime default now();
alter table board2
    modify writing_time datetime default now() not null;

alter table board2
    drop constraint fk_writer;

alter table board2
    add constraint fk_writer foreign key (writer) references user (user_id) on delete cascade on update cascade;

-- alter table board2 modify constraint fk_writer on delete set null;

insert into board2 (title, contents, writer) value ('title6', 'contents6', 'root');


alter table user
    modify user_id char(10) primary key;

insert into user
values ('assd', '123', 'hello', 'zezeg22@gmail.com ', '010-12341212', 'helelelel');

select *
from user;
select *
from information_schema.check_constraints cc
where table_name = 'board2';

select *
from information_schema.key_column_usage
where table_name = 'board2';
select *
from board2;

select department_id, salary, first_name
from employees
where department_id = (select department_id from employees where first_name = 'kelly');

select first_name, max(salary)
from employees e
order by department_id;


select *
from employees e
where salary = (select max(salary) from employees e2);

select max(salary)
from employees e
group by department_id;
select department_id, salary, first_name
from employees e
where department_id in (select department_id from employees where first_name = 'peter')
  and hire_date in (select hire_date from employees where first_name = 'peter');

select department_id, salary, first_name
from employees e
where (department_id, hire_date)
          in (select department_id, hire_date
              from employees
              where first_name = 'peter');

select job_id, department_id, salary, first_name
from employees e
where (job_id, department_id)
          in (select job_id, department_id
              from employees
              where first_name = 'kelly');

show databases;



