select *
from employees
where mod(employee_id, 2) = 0;

select employee_id, first_name, case when mod(employee_id, 2) = 0 then 'E' else 'O' end 'eo'
from employees;

select employee_id, first_name, IF(mod(employee_id, 2) = 0, 'E', 'O') 'eo'
from employees;

create table productFunc
(
    name   char(100),
    price  decimal(10, 2),
    detail text,
    image  varchar(100)
);

select ascii('a'), char('a');

select elt(3, '1', '2', '3');
select field('4', '1', '2', '3', '4');
select find_in_set('11', '11,2,3,4');
select instr('12345', '3');
select locate('3', '12345');


select hire_date, substr(hire_date, 1, 4) 입사년도, substr(hire_date, 6, 2) 입사월
from employees;


set @pw = 'abc##123';
select @pw, insert(@pw, 2, 4, '*');
select repeat('*', char_length(@pw));

select @pw, insert(@pw, 2, char_length(@pw) - 1, repeat('*', char_length(@pw) - 1));


select first_name 이름,
       salary     급여,
       case
           when salary >= 20000 then salary + 5000
           when salary >= 15000 then salary + 10000
           when salary >= 10000 then salary + 20000
           else salary + 30000
           end    연말보나스
from employees;

select first_name 이름,
       salary     급여,
       hire_date 입사일,
       case
           when year(hire_date) < 2002 then 30000
           when year(hire_date) < 2005 then 20000
           else 10000
           end    연말보나스
from employees;


select now(), date_format(now(), '%Y년 %m월 %d일 %H시');

