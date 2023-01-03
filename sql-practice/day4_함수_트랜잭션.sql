-- 숫자함수

-- 숫자형데이터타입
-- 정수 tinyint(1)  smallint(2) int(4) long(8) 상품코드 
-- 실수 float(4) double(8) 
-- 사용자 구성 decimal(10, 0), decimal(8, 2) 
-- round 

-- 평귭급여, 반올림, 소수점이하절삭
select avg(salary), round( avg(salary)) , truncate (avg(salary) , 0)  from employees;
select 123.5678, round( 123.5678 , 0) , round( 123.5678, -1 ), round( 123.5678, -2 ) ;
-- + - * / %(나머지연산자)
-- mod
select 1234, mod(1234, 3) , mod(1234, 7) ;

-- mod 사용하여 employees 짝수사번의 사번, 이름 조회
-- 2로 나누어 나머지 0
select employee_id, first_name from employees
where mod(employee_id, 2) = 0;

# 100 짝수사번
# 101 홀수사번

select employee_id, first_name,
       case
           when mod(employee_id, 2)=0 then '짝수사번'
           else '홀수사번'
           end '사번의 성격'
from employees;
select employee_id, first_name,
       IF(mod(employee_id, 2) = 0, '짝수사번', '홀수사번') '사번의 성격'
from employees;


-- 256 자리 - char / varchar /
-- 65536 - text

create table productfunc(
name char(100),
price decimal(10, 2),
detail text,
imagefile varchar(100));


insert into productfunc values('computer', 1000.99, '........', 'com.jpg');

select ascii('a'), char(65);

-- length()->byte ( 1byte = 8bit )
select 'abcdef', '가나다라마바', char_length('abcdef'),  bit_length('abcdef') ,  length('abcdef'),
 char_length('가나다라마바'), bit_length('가나다라마바'),  length('가나다라마바');

-- 문자 찾기(날짜도 문자열함수 사용)
-- 오라클 + mysql ==> 함수+mariadb

select elt(2, '일이', '둘', '셋'); -- 자바 index번호 0 시작 . db 1
select field('일이','일이', '둘', '셋');
select find_in_set('일이','일이,삼사,오육');
select instr('일이삼사오육', '삼' );
select locate('삼', '일이삼사오육');
select substring('김상형의 sql정복' ,5, 3);
select substr('김상형의 sql정복' ,5, 3);
select now(); -- 날짜시간타입형식 확인

select hire_date 입사시각 , substr(hire_date, 1, 4) 입사년도 , substr(hire_date, 6, 2) 입사월 from employees;


-- 월별 입사자 수를 조회하되, 입사자 수가 10명 이상인 월만 출력하시오.
select substr(hire_date, 6, 2) 입사월 , count(*) 입사자수
from employees
group by substr(hire_date, 6, 2);



select hire_month, count(hire_month)
from  (select
case
when hire_date like '_____01%' then '01'
when hire_date like '_____02%' then '02'
when hire_date like '_____03%' then '03'
when hire_date like '_____04%' then '04'
when hire_date like '_____05%' then '05'
when hire_date like '_____06%' then '06'
when hire_date like '_____07%' then '07'
when hire_date like '_____08%' then '08'
when hire_date like '_____09%' then '09'
when hire_date like '_____10%' then '10'
when hire_date like '_____11%' then '11'
when hire_date like '_____12%' then '12'
end hire_month from employees) imsi
group by hire_month
order by 1;


-- 클라이언트 암호 입력 -->db 테이블 저장
set @pw = 'abc가나다123567575757546sadsa';
select @pw,  insert(@pw, 2, 4, '*');
select repeat('*', char_length(@pw) );

-- @pw 변수의 모든 값을 * 조회

select @pw, insert(@pw, 2, char_length(@pw)-1, repeat('*' ,char_length(@pw) -1)) ;

--
select 'abcdef' , left('abcdef', 3) , right('abcdef', 3);

-- initcap 없음(첫문자대문자)
select 'maria database', upper('maria database'), lower('maria database');
-- 자바 키보드 입력 'maria'.touppercase()  --- db upper('maria')

-- pad- 다른문자열 채운다
select 'abc', lpad('abc', 10, '#') , rpad('abc', 10, '#');

select 'abc', lpad('abc', 10, ' ') , rpad('abc', 10, ' ');

select first_name, lpad(first_name, 20, '-')  from employees;
desc emp_copy;

-- trim- 문자열 잘라낸다
set @pw = '    김상형의 sql 정복    ';
select char_length(@pw) , char_length(ltrim(@pw)), char_length(rtrim(@pw)), char_length(rtrim(ltrim(@pw)));

set @pw = 'ㅋㅋㅋㅋ웃겨요ㅋㅋㅋ';
select trim(leading 'ㅋ' from @pw), trim(trailing 'ㅋ' from @pw), trim(both 'ㅋ' from @pw);


-- create table / alter table
-- 문자 char / varchar / text
-- 숫자 int double decimal(10, 0)
-- 날짜 date , time, datetime


-- 날짜 문자 숫자 입력
-- 날짜<--> 문자자동형변환<--->숫자
-- emp_copy  복사 - 제약조건복사안됨(not null 제외)

select min(employee_id), max(employee_id) from employees;

-- hire_date - datetime 타입

insert into emp_copy values(300, '길동', '최',  10000, now(), 200);
insert into emp_copy values('301', '길동', '최',  10000, now(), 200);
insert into emp_copy values(302, '신입', '최',  10000, current_date, 200);
insert into emp_copy values(303, '대리', '김',  10000, '2019-12-28 00:00:00', 200);
insert into emp_copy values(304, '과장', '김',  10000, date_sub(now() , interval 4 month), 200);
insert into emp_copy values(305, '대리', '김',  10000, '20221212', 200);
insert into emp_copy values(306, '대리', '박',  10000, 20221212, 200);

select * from emp_copy order by employee_id desc;

select now();
select date_format(date_sub(now() , interval 1 year ), '%Y');

select 100 + 200;
select '100' + '200';-- concat다름

select concat('100' ,'200');

-- 명시적 형변환
-- 실수를 정수로 변환
select round(123.444);
select truncate(123.444, 1);


-- cast ,convert, format
select avg(salary) , cast(avg(salary) as signed integer ) ,
convert(avg(salary) , signed integer) ,
format(avg(salary) , 0)  from employees;

--
# ifnull(컬럼명, 컬럼null대체값) -- null 연산식 null o
# where nullif(값1, 값2) is null

select if(20 > 10, '크다', '작거나 같다');

-- 사원들 commission_pct null 사원들, 그렇지 않은 사원들
# 이름   보너스유무
# kelly   못받는다

select first_name 이름 , if(commission_pct is null , '못받는다', '받는다') 보너스유무
from employees;

-- 급여정보 연말보너스 지급
# 20000 이상이면 5000 증가
# 15000 이상 20000 미만 10000 증가
# 10000 이상 15000 미만 20000 증가
# 나머지 30000 증가


select first_name 이름, salary 급여,
case
 when salary >= 20000 then salary+5000
when salary >= 15000  then salary+10000
when salary >= 10000  then salary+20000
else salary+30000
 end 연말보너스
from employees;

-- 입사년도 조회
select hire_date from employees order by 1;

-- 2002년 이전까지 입사자 30000
-- 2005년 이전까지 입사자 20000
-- 나머지 10000
select first_name 이름, salary 급여, hire_date 입사일,
case  substr(hire_date, 1, 4)
 when '2001' then salary+30000
 when '2002' then salary+30000
 when '2003' then salary+20000
 when '2004' then salary+20000
 when '2005' then salary+20000
 else salary+10000
 end 연말보너스
from employees;

select first_name 이름, salary 급여, hire_date 입사일,
case
 when substr(hire_date, 1, 4) in('2001', '2002') then salary+30000
 when substr(hire_date, 1, 4) in('2003', '2004', '2005') then salary+20000
 else salary+10000
 end 연말보너스
from employees;

-- maria db decode 없다

-- 날짜함수

-- 현재 시각 날짜
select curdate(), current_date,  curtime(), now(), sysdate();

-- cast convert format + date_format(쉽다)

-- 'yyyy-mm-dd hh:mm;ss'==자바

select now(), date_format(now(),'%y/%m/%d'),
date_format(now(),'%y/%m/%d'),
date_format('2022-01-01 00:00:00','%y/%c/%e') ;

select now(), date_format(now(),'%y/%m/%d %w %h:%i:%s') ;


/*
%y , %y - 4/2자리년도
%m, %m, %c - 2자리 /영문월이름/1,2자리   월
%d , % e - 2/1,2자리 일
%w - 영문요일
%a - 영문3글자요일

%h , %h - 24/12 시간
%i - 분
%s - 초
*/

-- 연도 추출 함수
select year(now()), month(now()), day(now()), hour(now()),  minute(now()),  second(now());


-- 2006년도 입사자 급여조회
select hire_date, salary from employees
where hire_date >= '2006-01-01 00:00:00'
and hire_date < '2007-01-01 00:00:00';
select hire_date, salary from employees where hire_date like '2006%';
select hire_date, salary from employees where substr(hire_date, 1, 4) = '2006';
select hire_date, salary from employees where instr(hire_date, '2006') = 1;
select hire_date, salary from employees where date_format(hire_date, '%y') = '2006';
select hire_date, salary from employees where year(hire_date) = '2006';


select substr(hire_date, 1, 4), date_format(hire_date, '%y'), year(hire_date), salary from employees ;

-- 6월 입사자
select hire_date, salary from employees where hire_date like '_____06%';-- 11
select hire_date, salary from employees where substr(hire_date, 6, 2) = '06';

-- 2006-06
select hire_date, salary from employees
where instr(right(hire_date, char_length(hire_date)-5), '06') = 1;
select hire_date, salary from employees where date_format(hire_date, '%m') = '06';
select hire_date, salary from employees where month(hire_date) = '06';



 -- 2006년 이후 입사자 - 2006, 2007, 2008
select hire_date, salary from employees where hire_date >= '2006-01-01 00:00:00'
order by hire_date; -- 54
select hire_date, salary from employees where substr(hire_date, 1, 4) >= '2006'
order by hire_date;
select hire_date, salary from employees where date_format(hire_date, '%y') >= '2006'
order by hire_date;
select hire_date, salary from employees where year(hire_date) >= '2006'
order by hire_date;

 -- 0-월... 2-수 .. 6- 일
 select weekday(now()) ;

#  사원이름             입사요일
#   kelly(대문자변경)   일요일


 select upper(first_name) 사원이름 ,
 concat(
 case weekday(hire_date)
 when 0 then '월'
 when 1 then '화'
 when 2 then '수'
 when 3 then '목'
 when 4 then '금'
 else '주말'
 end , '요일') 입사요일
 from employees;

 -- 두 날짜 사이의 계산
 select curdate() 오늘날짜,
 subdate( curdate(), interval 1 day) 어제날짜,
 adddate(curdate(), interval 1 day) 내일날짜,
 adddate(curdate(), interval 1 month ) 한달후날짜,
 adddate(curdate(), interval 1 year ) 1년후날짜;

 -- now()  hire_date --> 입사한지 얼마나 경과주수 계산

 select datediff(now(), hire_date) 경과일수,
 truncate( datediff(now(), hire_date) /7, 0) 경과주수,
 truncate(datediff(now(), hire_date)/365, 0) 경과년수,
 period_diff(date_format(now(), '%y%m') , date_format(hire_date, '%y%m')) 경과개월수
 from employees;

 -- 트랜잭션 - 여러개 작업 논리 결합
 -- 여러개 sql 실행 (1개 덩어리) - 계좌이체 1개 작업
 -- a-b 이체도중
 -- a 출금(ok)-(x)-> b 입금(x)--> 이미 처리 sql 취소 (rollback)
 -- a 출금(ok)--> b 입금(ok)--> 2개 sql db 영구 반영(commit)
 -- all or nothing
 -- tcl -transaction control lang.
 -- commit / rollback

 -- 마리아db  변수
show variables like '%auto%';
set autocommit = false;
show variables like '%auto%';