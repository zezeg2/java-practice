# 주석
-- 주석
/*  

여러줄 주석
*/

-- EMPLOYEES 테이블 데이터 조회
SELECT * FROM employees;
SELECT * FROM departments;
SELECT employee_id , first_name FROM employees;
SELECT employee_id  "사 번" , first_name AS 이름  FROM employees;


DESCRIBE employees;

-- salary (8,2)

SELECT first_name, salary FROM employees;

-- 연봉 , salary*12

SELECT first_name, salary '월봉' , salary*12 AS '연봉' FROM employees;

-- 사원 속한 부서코드 종류 조회 = 중복말고 1번
SELECT DISTINCT  department_id FROM employees;

select last_name, department_id
from employees
where department_id = 80;

select employee_id, salary, first_name
from employees
where salary >= 10000 and employee_id < 200;

-- 동일
select salary, first_name
from employees
where salary >= 10000 and salary <= 15000;


select salary, first_name
from employees
where salary between 10000 and 15000;


select employee_id, salary*1.1 as 인상급여
from employees
where employee_id=10 or employee_id=30 or employee_id=200 or employee_id=150;

select employee_id, salary*1.1 as 인상급여
from employees
where employee_id in(100, 200, 150, 222);

-- db(maria db - 대소문자구분없다, '', "")

SELECT first_name FROM employees WHERE first_name = 'steven';

-- s로 시작하는 사원 first_name 조회
SELECT first_name
FROM employees
WHERE first_name like 's%';

-- er 끝나는 사원의 first_name 조회

SELECT first_name
FROM employees
WHERE first_name like '%er';


-- 이름이 5글자이면서 er 끝나는 사원의 first_name 조회

SELECT first_name
FROM employees
WHERE first_name LIKE '___er';


-- 입사일 조회-datetime-형태

select first_name, hire_date from employees;

DESC employees;

-- 2002년 입사자의 이름, 입사일 조회- 문자열, 날짜형 - '' , ""
SELECT first_name, hire_date
FROM employees
WHERE hire_date like '2002%';

-- 6월 입사자의 이름, 입사일 조회-

# '2002-06-11 11:22:33'

SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '_____06%';



SELECT first_name, commission_pct
FROM employees;


-- 커미션 받는 사원 
SELECT first_name, commission_pct
FROM employees
WHERE commission_pct IS not NULL;


SELECT employee_id FROM employees  ORDER BY employee_id LIMIT 10, 10;

-- null우선
SELECT employee_id, commission_pct FROM employees  ORDER BY commission_pct;

-- null 나중
SELECT employee_id, commission_pct FROM employees  ORDER BY commission_pct DESC;

-- null 먼저.역순(오라클만)
SELECT employee_id, commission_pct FROM employees  ORDER BY commission_pct DESC nulls first;


-- 부서코드 오름차순. 동일 부서코드인 경우 급여 많은 사원부터 조회.
SELECT first_name, salary, department_id FROM employees ORDER BY department_id , salary DESC;

-- 급여 총합, 평균, 사원수, 최대월급, 최저월급 

SELECT SUM(salary) , avg(salary), COUNT(salary) , MAX(salary), MIN(salary)  FROM employees;


-- 입사일

SELECT COUNT(hire_date) , MAX(hire_date), MIN(hire_date)  FROM employees;

-- 커미션(null 많다)

SELECT COUNT(commission_pct)  FROM employees;

-- null 포함 테이블 레코드수
SELECT COUNT(*)  FROM employees;

-- 소속 부서 없는 사원 이름 조회 
SELECT first_name, department_id FROM employees
WHERE department_id IS NULL;

-- 소속 	부서명 사원수 조회
SELECT COUNT(department_id)  FROM employees;




-- 사원이름 , 전체 사원 급여 총합 조회
-- 집계함수 외 select 다른 컬럼 조회 불가

SELECT first_name, SUM(salary) FROM employees;


--  부서코드 종류 갯수 
SELECT count(DISTINCT department_id) FROM employees;

--  50번 부서 사원 급여총합 조회
SELECT SUM(salary) 
FROM employees 
WHERE department_id = 50;


--  각 부서별 부서 사원 급여총합 조회
-- 집계함수 외 select 다른 컬럼 조회 불가
-- 단 group by 컬럼 제외
SELECT department_id, SUM(salary) 
FROM employees 
GROUP BY department_id;


--  각 부서별 부서 사원 급여총합 조회. 단 부서코드 없는 사원 제외
SELECT department_id, SUM(salary) 
FROM employees 
WHERE department_id IS not null
GROUP BY department_id;


--  각 부서별, 직종별  부서 사원 급여총합 조회. 단 부서코드 없는 사원 제외
SELECT department_id, job_id, SUM(salary) 
FROM employees 
WHERE department_id IS not NULL AND job_id IS NOT null
GROUP BY department_id, job_id ;



--  각 부서별 부서 사원 급여총합 조회. 
-- 단 부서코드 없는 사원 제외하고 급여총합 10만 이상인 부서만 조회.
SELECT department_id, SUM(salary) 
FROM employees 
WHERE department_id IS not NULL
GROUP BY department_id
HAVING SUM(salary) >= 100000
ORDER BY 2 DESC;
-- ORDER BY SUM(salary) DESC;


