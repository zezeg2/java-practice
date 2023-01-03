-- empdp 클릭 
USE empdb;

SELECT *
FROM employees;

-- 6장 데이터관리 dml
-- employees 테이블 사번,이름, 성, 급여, 입사일, 부서코드 컬럼 복사 테이블 

DESC employees;

CREATE TABLE emp_copy
    (SELECT employee_id, first_name, last_name, salary, hire_date, department_id
     FROM employees);

DESC emp_copy;

-- 
SELECT COUNT(*)
FROM emp_copy;

-- 1 이사원 15000 2022-12-26 10 삽입
/*insert into 테이블명(컬럼명리스트 ,,,, ) values (값리스트,,,,) */

INSERT INTO emp_copy(employee_id, first_name, last_name, salary, hire_date, department_id)
VALUES (1, '사원', '이', 15000, '2022-12-26', 10);

SELECT *
FROM emp_copy
ORDER BY employee_id;


-- 2  최사원 15000 2022-12-26 80 삽입
INSERT INTO emp_copy
VALUES (2, '사원', '최', 15000, '2022-12-26', 80);


-- 3 홍길동 null null null(emp_copy 이미 입사일 not null 조건설정)
INSERT INTO emp_copy
VALUES (3, '길동', '홍', NULL, '2022-12-26', null);

SELECT *
FROM emp_copy
ORDER BY employee_id;

-- 4 김길동 null null null(emp_copy 이미 입사일 not null 조건설정)-자동null
INSERT INTO emp_copy (employee_id, first_name, last_name, hire_date)
VALUES (4, '길동', '김홍', '2022-12-26');

SELECT *
FROM emp_copy
ORDER BY employee_id;


# - 여러개 INSERT
INSERT INTO emp_copy
VALUES (5, '길동', '홍', 7000, '2012-11-26', NULL),
       (6, '길동', '홍', NULL, '2012-10-26', NULL),
       (7, '길동', '홍', NULL, '2002-09-26', 50);

SELECT *
FROM emp_copy
ORDER BY employee_id;

-- 오류
INSERT INTO emp_copy
VALUES (8, '길동', '홍', 7000, '2012', NULL);

-- 년도4자리-월2-일2 2시:2분:2초 mariadb 기본형식
-- datetime (date , time)

INSERT ignore INTO emp_copy
VALUES (8, '길동', '홍', 7000, '2012', NULL);
SELECT *
FROM emp_copy
ORDER BY employee_id;

-- emp_copy 테이블 생성 + 데이터 복사
CREATE TABLE emp_copy
    (SELECT employee_id, first_name, last_name, salary, hire_date, department_id
     FROM employees);


-- emp_copy 테이블 생성하지 말고  + 데이터 복사
INSERT into emp_copy
SELECT employee_id, first_name, last_name, salary, hire_date, department_id
FROM employees;


DESC emp_copy;


-- 커밋 상태 확인(오라클 - 수동 선택)
SHOW VARIABLES LIKE 'auto%';

-- 마리아디비 autocommit 기본
/*INSERT
UPDATE
-- DELETE-
즉각 결과 반영
*/

-- SET autocimmit = FALSE;

-- DELETE FROM 테이블명 
-- SELECT * FROM 테이블명
# WHERE 조회|삭제조건식문법 유사;

-- DELETE 문장은 AUTOCOMMIT 상태 설정 변경하면 복구 기회 SQL
-- WHERE 절 사용

-- TRUNCATE 문장은 AUTOCOMMIT 상태 설정 변경해도 무시. 복구 기회 없는 SQL
-- WHERE 절 사용불가

TRUNCATE emp_copy;


-- UPDATE

/*UPDATE 테이블명 
set 변경컬럼명=변경값
where 변경조건식 문법 유사 */

-- 1번 사번 사원의 급여 인상. 10% 인상
UPDATE emp_copy
SET salary = salary * 1.1
WHERE employee_id = 1;

SELECT *
FROM emp_copy
ORDER BY employee_id;

-- 입사월이 6월 사원 부서 20번 부서 배정하고 급여 20% 인상-  테이블 변경

-- UPDATE emp_copy
-- SET department_id =20 , salary= salary*1.2
SELECT hire_date, first_name, department_id, salary
FROM emp_copy
WHERE hire_date LIKE '_____06%';

-- 11시 15분

-- 7장 제약조건
-- 오류 
INSERT INTO emp_copy
VALUES (9, '이름', '성', NULL, NULL, NULL);


SELECT *
FROM information_schema.table_constraints
WHERE TABLE_NAME = 'employees';

-- employee_id, last_name, hire_date not null 조건 이미 설정
-- 테이블 구성 -현실 세계 데이터(사번 존재, 사번 중복x)
DESC emp_copy;


-- 상품코드 상품명 가격 수량 
CREATE TABLE product
(
    p_CODE  INT PRIMARY KEY,
    p_NAME  CHAR(30) NOT NULL,
    price   DECIMAL,
    balance SMALLINT CHECK (balance >= 0)
);

-- primary, not null 정보 
DESC product;

-- not null 제외 제약조건 정보
USE information_schema;

SELECT *
FROM information_schema.table_constraints
WHERE TABLE_NAME = 'product';

INSERT INTO product
VALUES (100, '냉장고', 1000000, 10);
-- INSERT INTO product VALUES(101, '키보드', 10000, -10);-- 오류
INSERT INTO product
VALUES (102, '마우스', 10000, 5);
INSERT INTO product
VALUES (103, '컴퓨터', 1000000, 0);
SELECT *
FROM product;

-- p_code - 정수 , 자동숫자증가 

-- auto increment(컬럼 이미 존재 primary key 설정)
-- p_CODE INT PRIMARY KEY 설정 

ALTER TABLE product
    modify p_code INT NOT NULL AUTO_INCREMENT;

INSERT INTO product(p_name, price, balance)
VALUES ('컴퓨터2', 1000000, 50);
SELECT *
FROM product;

-- users 테이블
/* user_id char(10) 중복x, null허용x
   user_pw 문자 5자리 null허용x
   user_name 문자 30자리
   user_email 문자 30자리 중복x
 user_phone 문자 12자리 '010-'시작
 address 문자 100자리 
 */
-- 제약조건 설정은 테이블 정의시

CREATE TABLE users
(
    user_id    CHAR(10) PRIMARY KEY,
    user_pw    CHAR(5) not NULL,
    USER_name  CHAR(30),
    user_email CHAR(30) UNIQUE,
    user_phone CHAR(12) CHECK (user_phone LIKE '010-%'),
    address    CHAR(100)
);

DESC users;
-- 컬럼명 타입 not null, primary, unique정보

-- check 설정 여부 포함(not null 제외)정보

SELECT*
from information_schema.table_constraints
WHERE TABLE_NAME = 'users';

-- check 내용
SELECT TABLE_NAME, CONSTRAINT_NAME, CHECK_CLAUSE
FROM INFORMATION_SCHEMA.check_CONSTRAINTS;


-- 효력 발생 - DML 

INSERT INTO users
VALUES ('MARIA', 'DB', '홍길동', 'HONG@A.COM', '010-23456789',
        '서울시 용산구 ');
INSERT INTO users
VALUES ('MARIA2', 'DB', '홍길동', 'HONG2@A.COM', '010-34567890',
        '서울시 마포구 ');
-- CHECK X
INSERT INTO users
VALUES ('MARIA3', 'DB3', '홍길동', 'HONG2@A.COM', '01134567890',
        '서울시 마포구 ');
SELECT *
FROM users;

-- 4,5 SELECT 

-- 6 INSERT DELETE UPDATE
-- 7 제약조건 - 2장(오라클설치) CREATE TABLE (64P)  

CREATE TABLE board
(
    seq       INT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TITLE     CHAR(100) NOT NULL,
    CONTENTS  TEXT, -- 65536바이트
    VIEWCOUNT INT DEFAULT 0,
    WRITER    CHAR(10),
    CONSTRAINT FK_board_WRITER FOREIGN KEY (WRITER) REFERENCES users (USER_ID)
);

/* 
1>users USER_ID - PK 설정되어야만 한다
2> WRITER 컬럼은 users USER_ID  타입 길이 일치해야 한다
*/

DESC board;

# --외래키 제약조건 확인
SELECT *
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'board';



-- 컬럼레벨로만 가능 - NOT NULL
-- 테이블레벨로만 가능 (MARIA DB만  ) - FOREIGN KEY
-- 컬럼레벨+테이블레벨도 가능 - PRIMARY KEY, UNIUE, CHECK 

CREATE TABLE board
(
    seq       INT       NOT NULL AUTO_INCREMENT PRIMARY KEY,                  -- 컬럼레벨 정의
    TITLE     CHAR(100) NOT NULL,                                             -- 컬럼레벨 정의
    CONTENTS  TEXT,                                                           -- 65536바이트
    VIEWCOUNT INT DEFAULT 0,                                                  -- 컬럼레벨 정의
    WRITER    CHAR(10),
    CONSTRAINT FK_board_WRITER FOREIGN KEY (WRITER) REFERENCES users (USER_ID)-- 테이블레벨 정의
);


CREATE TABLE board2
(
    seq       INT       NOT NULL AUTO_INCREMENT,
    TITLE     CHAR(100) NOT NULL,              -- 컬럼레벨 정의
    CONTENTS  TEXT,                            -- 65536바이트
    VIEWCOUNT INT DEFAULT 0,                   -- 컬럼레벨 정의
    WRITER    CHAR(10),
    CONSTRAINT PK_board_SEQ PRIMARY KEY (SEQ), -- 경고무시
    CONSTRAINT FK_board_WRITER2 FOREIGN KEY (WRITER) REFERENCES users(USER_ID)
#     CHECK (컬럼 조건
)
SELECT *
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'board2';

-- 
INSERT INTO board(TITLE, CONTENTS, WRITER)
VALUES ('제목', '내용', 'maria');
INSERT INTO board(TITLE, CONTENTS, WRITER)
VALUES ('제목2', '내용2', 'MAria2');

SELECT *
FROM users;

SELECT *
FROM board;

-- 2.자식테이블이 참조중인 데이터 삭제시-자식도 같이 삭제 / null
-- 오류
DELETE
from users
-- select * FROM users
WHERE user_id = 'maria';

-- 2.자식테이블이 참조중인 데이터 삭제시-자식도 같이 삭제 / null
-- 오류 해결
-- 테이블 내 조건 변경

-- CREATE TABLE - 2장(없는 테이블 정의)  / 
-- ALTER TABLE (있는 테이블의 컬럼추가, 컬럼삭제, 컬럼타입수정, 컬럼제약조건 수정)-14장

# ALTER TABLE 테이블명
#     ADD A INT;
# -- 없던 컬럼 추가
#
# ALTER TABLE 테이블명
#     MODIFY A CHAR(10);
# -- 있던 컬럼 타입이나 길이 수정
#
# ALTER TABLE 테이블명
#     DROP XXXX; -- 있던 컬럼 삭제
#
# ALTER TABLE 테이블명
#     ADD CONSTRAINT,,,; -- 존재하는 컬럼의 없던 제약조건 추가
#
# ALTER TABLE 테이블명
#     MODIFY CONSTRAINT....;
# --있던 컬럼 제약조건  수정
#
# ALTER TABLE 테이블명
#     DROP CONSTRAINT;
# -- 제약조건  삭제

-- 외래키 제약조건 있는 상태에서 
-- 외래키 제약조건 삭제후 - 추가 ON DELETE CASCADE 추가
ALTER TABLE board
    DROP CONSTRAINT FK_board_WRITER;

ALTER TABLE board
    ADD CONSTRAINT FK_board_WRITER
        FOREIGN KEY (WRITER) REFERENCES users (USER_ID)
            ON DELETE CASCADE ON UPDATE CASCADE;
-- ON DELETE SET NULL ON UPDATE CASCADE;

-- 오류발생 SQL 다시 실행
DELETE
from users
-- select * FROM users
WHERE user_id = 'maria';

SELECT *
FROM users;

SELECT *
FROM board;

#######################################

