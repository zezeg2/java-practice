select first_name, salary
from employees e
where salary > (select salary from employees where first_name = 'kelly');

-- 모든 william 보다 급여를 더 많이 받는 사원의 이름 급여 조회
select first_name, salary
from employees e
where salary > any (select salary from employees where first_name = 'william');
-- william 중 1명 보다 급여를 더 많이 받는 사원의 이름 급여 조회
select first_name, salary
from employees e
where salary > all (select salary from employees where first_name = 'william');
-- william 급여와 같은 급여를 받는 사원의 이름 급여 조회
select first_name, salary
from employees e
where salary = any (select salary from employees where first_name = 'william');
select first_name, salary
from employees e
where salary in (select salary from employees where first_name = 'william');

-- 변수 사용
set @name = 'kelly';

select first_name, salary
from employees e
where salary > (select salary from employees where first_name = @name);



select first_name, salary, department_id
from employees e
where (department_id, salary) in (select department_id, max(salary) from employees group by department_id);



select location_id
from locations l
where city = 'london';

select department_id
from departments d
where location_id = 2400;

select first_name, department_id
from employees e
where department_id = 40;

select first_name, department_id
from employees e
where department_id = (select department_id
                       from departments d
                       where location_id = (select location_id from locations l where city = 'south san francisco'));


select first_name, salary, department_id, (select avg(salary) from employees where department_id = e.department_id)
from employees e
where salary > any (select avg(salary)
                    from employees
                    where department_id = e.department_id);


select avg(salary)
from employees e
where salary >= 10000;

select sal_tbl.sal_avg 고액월급평균
from (select avg(salary) sal_avg from employees where salary >= 10000) sal_tbl;



select first_name,
       salary,
       case
           when salary + salary * ifnull(commission_pct, 0) >= 20000 then '임원'
           when salary + salary * ifnull(commission_pct, 0) >= 15000 then '부장'
           when salary + salary * ifnull(commission_pct, 0) >= 10000 then '과장'
           when salary + salary * ifnull(commission_pct, 0) >= 5000 then '대리'
           else '사원'
           end 직급
from employees e;

select first_name,
       case
           when total_sal >= 20000 then '임원'
           when total_sal >= 15000 then '부장'
           when total_sal >= 10000 then '과장'
           when total_sal >= 5000 then '대리'
           else '사원'
           end 직급
from (select first_name, salary + salary * ifnull(commission_pct, 0) total_sal from employees) i;

select first_name, salary, (select min(salary) from employees)
from employees e;

select first_name, department_id
from emp_copy ec
where department_id = 100;


create table dp_50 (select *
                    from employees
                    where department_id = 50);

create table emp_man (select *
                      from employees
                      where job_id like '%man%');


-- 집합 연산자
select employee_id, first_name, department_id, job_id
from dp_50
union
-- all
select employee_id, first_name, department_id, job_id
from emp_man
order by 1;

select employee_id, first_name, department_id, job_id from dp_50
    intersect
    select employee_id, first_name, department_id, job_id from emp_man
    order by 1;


select employee_id, first_name, department_id, job_id
from dp_50
except
select employee_id, first_name, department_id, job_id
from emp_man
order by 1;

select employee_id, first_name, department_id, job_id
from emp_man
except
select employee_id, first_name, department_id, job_id
from dp_50
order by 1;


-- join

select first_name, department_id
from employees e;
select department_id
from departments d;



select e.first_name, e.department_id, d.department_name
from employees e
         inner join departments d on e.department_id = d.department_id;
select *
from employees e
         cross join departments d;

select e.first_name, j.job_title, d.department_name
from employees e
         inner join jobs j on e.job_id = j.job_id
         inner join departments d on e.department_id = d.department_id;


select first_name, department_name, city, salary
from employees e
         join departments d on e.department_id = d.department_id
         join locations l on d.location_id = l.location_id
where l.city = 'seattle';


select first_name, department_name
from employees e
         left outer join departments d on e.department_id = d.department_id;
select first_name, department_name
from employees e
         right outer join departments d on e.department_id = d.department_id;

select first_name, department_name
from employees e
         left outer join departments d on e.department_id = d.department_id
union
select first_name, department_name
from employees e
         right outer join departments d on e.department_id = d.department_id;



select inform.emp
from (select first_name emp, department_name dep, country_name country, region_name region, city
      from (employees e
          join departments d on e.department_id = d.department_id
          join locations l on d.location_id = l.location_id
          join countries c on l.country_id = c.country_id
          join regions r on c.region_id = r.region_id
               )
      where l.city = 'seattle') inform;

select first_name emp, department_name dep, country_name country, region_name region, city
from (employees e
    join departments d on e.department_id = d.department_id
    join locations l on d.location_id = l.location_id
    join countries c on l.country_id = c.country_id
    join regions r on c.region_id = r.region_id
         )
where l.city = 'seattle';

desc employees;
select first_name, salary, employee_id
from employees e
where employee_id in (select manager_id from employees);



select e.first_name employee, e2.first_name manager
from employees e
         left outer join employees e2 on e.manager_id = e2.employee_id;



select *
from employees e
         right outer join jobs j on e.job_id = j.job_id;



