-- 1
select first_name, department_id, salary
from employees e
where salary > (select avg(salary) from employees where department_id = 80);

-- 2
select first_name, salary, d.department_name, d.department_id
from employees e
         join departments d on e.department_id = d.department_id
where (salary > (select min(salary)
                 from employees
                 where department_id = (select department_id
                                        from departments
                                        where location_id =
                                              (select location_id from locations where city = 'South San Francisco'))))
  and (salary > (select avg(salary) from employees where department_id = 50));

-- 3-1
select job_title, count(employee_id)
from employees e
         right outer join jobs j on e.job_id = j.job_id
group by job_title;

-- 3-2
select *
from (select job_title, count(employee_id) cnt
      from employees e
               right outer join jobs j on e.job_id = j.job_id
      group by job_title) sub_tbl
where sub_tbl.cnt > 10;

-- 4
select first_name, (select department_name from departments where department_id = e.department_id), salary
from employees e
where (department_id, salary) in (select department_id, max(salary) from employees group by department_id);

-- 5
select first_name, department_id did, salary, (select min(salary) from employees where department_id = did)
from employees e;

-- 6
select *
from (select substring(hire_date, 6, 2) byMonth, count(hire_date) cnt from employees group by byMonth) sub_tbl
where sub_tbl.cnt > 10;

select substring(hire_date, 6, 2) byMonth, count(hire_date) cnt
from employees
group by byMonth
having cnt > 10;

-- 7
select first_name, salary
from (select first_name, salary, (select salary from employees where employee_id = e.manager_id) man_salary
      from employees e) sub_tbl
where salary > sub_tbl.man_salary;

select first_name, salary, (select salary from employees where employee_id = e.manager_id) man_salary
from employees e
having salary > man_salary;

-- 8
select first_name, salary, job_title
from employees e
         join jobs j on e.job_id = j.job_id
         join departments d on e.department_id = d.department_id
         join locations l on d.location_id = l.location_id
where city = 'Southlake';

-- 9
select *
from (select country_name, count(employee_id) cnt
      from employees
               join departments d on employees.department_id = d.department_id
               join locations l on l.location_id = d.location_id
               join countries c on l.country_id = c.country_id
      group by country_name) sub_tbl
where sub_tbl.cnt > 3;

select country_name, count(employee_id) cnt
from employees
         join departments d on employees.department_id = d.department_id
         join locations l on l.location_id = d.location_id
         join countries c on l.country_id = c.country_id
group by country_name
having cnt > 3;

-- 10
select e1.phone_number, e1.email, ifnull(e2.phone_number, '관리자없음'), ifnull(e2.email, '관리자없음')
from employees e1
         left outer join employees e2 on e2.employee_id = e1.manager_id;

-- 11
select *
from (select d.department_id, min(salary) min_salary, max(salary) max_salary
      from employees
               join departments d on employees.department_id = d.department_id
      group by department_name) sub_tbl
where sub_tbl.min_salary != sub_tbl.max_salary;

select d.department_id, min(salary) min_salary, max(salary) max_salary
from employees
         join departments d on employees.department_id = d.department_id
group by department_name
having min_salary != max_salary;

-- 12
select *
from (select e.department_id, e.job_id, avg(salary) avg_salary
      from employees e
               join jobs j on e.job_id = j.job_id
      group by e.department_id, e.job_id) sub_tbl
where sub_tbl.avg_salary > (select avg(salary) from employees where department_id = 50);

select e.department_id, e.job_id, avg(salary) avg_salary
from employees e
         join jobs j on e.job_id = j.job_id
group by e.department_id, e.job_id
having avg_salary > (select avg(salary) from employees where department_id = 50);
