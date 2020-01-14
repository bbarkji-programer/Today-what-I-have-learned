-- 7장. DDL(Data Definition Language),DML(Data Manipulation Language)
-- DDL(Data Definition Language) : 테이블 생성, 테이블 구조 변경, 테이블 삭제
    -- (1) CREATE TABLE : 테이블 생성
    CREATE TABLE BOOK(
        BOOKID NUMBER(4),
        BOOKNAME VARCHAR2(100),
        PUBLISHER VARCHAR2(20),
        PRICE NUMBER(7),
        PRIMARY KEY(BOOKID) );
    CREATE TABLE BOOK(
        BOOKID NUMBER(4) PRIMARY KEY,
        BOOKNAME VARCHAR2(100),
        PUBLISHER VARCHAR2(20),
        PRICE NUMBER(7) );
    SELECT * FROM BOOK;
    DESC BOOK;
    SELECT * FROM EMP;
    SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- 테이블 출력 시 논리적 순서가 자동으로 매겨짐
    SELECT ROWNUM, BOOKID, BOOKNAME, PRICE FROM BOOK;

    -- EMP01 - EMPNO(NUMBER(4)), ENAME(VARCHAR2(20)), SAL(NUMBER(7,2))
    CREATE TABLE EMP01(
        EMPNO NUMBER(4) PRIMARY KEY,
        ENAME VARCHAR2(20),
        SAL NUMBER(7,2) );
    SELECT * FROM EMP01;
    
    -- DEPT01 - DEPTNO(NUMBER(2)), DNAME(VARCHAR(14)), LOC(VARCHAR2(13))
    CREATE TABLE DEPT01(
        DEPTNO NUMBER(2),
        DNAME VARCHAR2(14),
        LOC VARCHAR2(13) );
        
    -- 서브쿼리를 이용한 CREATE TABLE
    -- EMP테이블과 같은 구조 같은 데이터가 들어있는 EMP02 테이블 생성
    CREATE TABLE EMP02 
        AS 
        SELECT * FROM EMP; --> SELECT문의 수행 결과가 EMP02에 들어감. 구조와 데이터만. 제약조건은 안들어감.
    
    SELECT * FROM EMP02;
    DESC EMP02;
    DESC EMP;
    
    -- EMP 테이블의 사번, 이름, 부서번호 필드만 카피한 EMP03 생성
    CREATE TABLE EMP03 AS SELECT EMPNO, ENAME, DEPTNO FROM EMP;
    SELECT * FROM EMP03;
    DESC EMP03;
    
    -- EMP 테이블의 이름, 급여 만 카피만 EMP04 생성
    CREATE TABLE EMP04 AS SELECT ENAME, SAL FROM EMP;
    SELECT * FROM EMP04;
    
    -- EMP 테이블에서 10번 부서 직원의 모든 데이터를 카피한 EMP05 생성
    CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE DEPTNO=10;
    SELECT * FROM EMP05;
    
    SELECT * FROM EMP WHERE DEPTNO=0;
    
    -- EMP 테이블 구조만 카피한 EMP06 테이블 생성(데이터는 없는 테이블)
    CREATE TABLE EMP06 AS SELECT * FROM EMP WHERE 1=0; --> 항상 거짓이 되는 조건을 WHERE절에
    SELECT * FROM EMP06;
    
    -- DEPT 테이블 구조만 카피한 DEPT02 테이블 생성(데이터는 없는 테이블)
    CREATE TABLE DEPT02 AS SELECT * FROM DEPT WHERE 1=0;
    SELECT * FROM DEPT02;
    
    SELECT * FROM TAB;  

    -- (2) ALTER TABLE : 테이블 구조 변경 (정상적이면 바꾸면 안됨...)
    -- ① ALTER TABLE 테이블이름 ADD(필드이름 그 타입, ...); : 새로운 필드를 추가  
          DESC EMP03; -- 사번, 이름, 부서번호
          ALTER TABLE EMP03
          ADD(
          JOB VARCHAR2(10),
          SAL NUMBER(9,2) ); -- JOB, SAL  추가
          SELECT * FROM EMP03; 
          ALTER TABLE EMP03
          ADD(
          MGR NUMBER(4) );
          SELECT * FROM EMP03;
          
    -- ② ALTER TABLE 테이블이름 MODIFY(필드이름 그 타입, ...); : 현재 필드의 타입 수정
          ALTER TABLE EMP03
          MODIFY(
          EMPNO VARCHAR2(5) ); --이미 다른 타입의 데이터가 있으면 데이터 타입 변경 불가능.
          ALTER TABLE EMP03
          MODIFY(
          JOB VARCHAR2(20)  ); 
          ALTER TABLE EMP03 
          MODIFY(
          ENAME VARCHAR2(5)); -- 이미 들어있는 데이터보다 적은 숫자? 스케일? 로 변경 불가능.
          ALTER TABLE EMP03 
          MODIFY(
          ENAME VARCHAR2(30));
          
    -- ③ ALTER TABLE 테이블이름 DROP COLUMN(필드이름); : 현재 있는 특정 필드 삭제 
          -- 물리적인 삭제 보다는 논리적인 삭제를 먼저 한 후, 접근하지 않는 삭제에 물리적인 삭제 
          -- 물리적 삭제
          ALTER TABLE EMP03 DROP COLUMN JOB;
          ALTER TABLE EMP03 DROP COLUMN DEPTNO;
          SELECT * FROM EMP03; 
          
          -- 논리적 삭제(논리적으로 특정 필드를 접근 못하도록 함)
          ALTER TABLE EMP03 SET UNUSED(SAL);
          SELECT * FROM EMP03; -- SAL이 안보이지만 진짜 지워진건 아님...
          ALTER TABLE EMP03 DROP UNUSED COLUMNS; -- 논리적 접근 불가 필드를 물리적으로 삭제
        
    -- (3) DROP TABLE 테이블이름; : 테이블 삭제
          DROP TABLE EMP01;
          
    -- (4) TRUNCATE TABLE 테이블이름; : 테이블의 모든 데이터를 제거(DDL ; 취소불가)      
          TRUNCATE TABLE EMP02;     
          SELECT * FROM EMP02; -- 데이터잘림
    
    -- (5) RENAME 기존테이블이름 TO 새로운 테이블이름 : 테이블 이름을 변경
         RENAME EMP02 TO EMP2;
    
    -- (6) DDL 명령어를 수정하면, 데이터 사전(시스템 테이블) 수정됨 (오라클이 수정)
        -- 사용자는 데이터 딕셔너리를 수정X, 검색X. 만들수도 없고 수정도 안되고 볼 수도 없음....... 
        -- 데이터 딕셔너리 뷰 만 이용 가능~
        -- 종류 : DBA_XXX, ALL_XXX, USER_XXX
        SELECT * FROM USER_TABLES; -- USER가 만든 테이블 보기
        SELECT * FROM USER_INDEXES; -- USER가 만든 인덱스 보기
        SELECT * FROM USER_CONSTRAINTS; -- USER가 만든 제약조건 보기
         SELECT * FROM USER_VIEWS; -- USER가 만든 뷰 보기
         
        SELECT * FROM DBA_TABLES; -- 시스템이 만든 테이블 보기
        SELECT COUNT(*) FROM DBA_TABLES;
        SELECT TABLE_NAME FROM DBA_TABLES;     
        SELECT * FROM DBA_CONSTRAINTS; -- 시스템이 만든 제약조건 보기       
        SELECT * FROM DBA_VIEWS; -- DBA(시스템)가 만든 뷰 보기
        
        SELECT * FROM ALL_TABLES; -- 권한을 부여 받은 모든 테이블 보기
        SELECT * FROM ALL_INDEXES; -- 권한을 부여 받은 모든 인덱스 보기
        SELECT * FROM ALL_CONSTRAINTS; -- 권한을 부여 받은 모든 제약조건 보기
        SELECT * FROM ALL_VIEWS; -- 권한을 부여 받은 모든 뷰 보기
        
        SHOW USER; 
        
-- DML(Data Manipulation Language) : 데이터 입력(INSERT문), 데이터 수정(UPDATE문), 데이터 삭제(DELETE문), 데이터 검색(SELECT문)
    -- (1) INSERT INTO 테이블명 (필드명1, 필드명2, ...) VALUES (값1, 값2.....); : 데이터 입력(INSERT문)
    SELECT * FROM DEPT01;
    
    INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
        VALUES (10, 'MARKETING', 'SEOUL');
        
    SELECT * FROM DEPT01;
    
    INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
        VALUES (20, 'SALES', 'SYDNEY');
        
    SELECT * FROM DEPT01;
    
    DESC DEPT01;
    
    INSERT INTO DEPT (DEPTNO, DNAME, LOC)
        VALUES (10, 'IT', 'SANFRAN'); -- PRIMARY KEY는 중복된 값이나 NULL 값은 불가
    
     INSERT INTO DEPT (DEPTNO, DNAME, LOC)
        VALUES (NULL, 'IT', 'SANFRAN'); -- PRIMARY KEY는 중복된 값이나 NULL 값은 불가
    
    -- DEPT01 20,'IT', NULL
    INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
        VALUES (20, 'IT', NULL);
        
    SELECT DEPTNO, DNAME, NVL(LOC, '사무실못얻음') FROM DEPT01;
    
    -- DEPT01 30,'SALES',NULL
    INSERT INTO DEPT01 (DEPTNO, DNAME)
        VALUES (30, 'SALES');
    
    SELECT * FROM DEPT01;
    
    INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (40,'기획','용산'); -- 이렇게 순서 똑같이 할거면 VALUES 앞에 생략 가능
    INSERT INTO DEPT01 VALUES (40,'기획','용산'); -- 이렇게 줄이는 경우 비워놓거나, 순서 바꾸면 안됨.....
    
    SELECT * FROM DEPT01; 
    
    -- DEPT 테이블의 내용(10-30)을 DEPT02 테이블에 추가
    INSERT INTO DEPT02 SELECT * FROM DEPT;
    SELECT * FROM DEPT02;
    INSERT INTO DEPT02 SELECT * FROM DEPT WHERE DEPTNO<30;
    SELECT * FROM DEPT02;
    
    -- ★ DDL 연습문제 ~~~~
    DROP TABLE SAM01;
    
    CREATE TABLE SAM01(
    EMPNO NUMBER(4) CONSTRAINT C_SAM PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2) );
    
    SELECT * FROM USER_CONSTRAINTS;
    SELECT * FROM USER_INDEXES;
    SELECT * FROM SAM01;
    
    INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL) VALUES (1000, 'APPLE', 'POLICE', 10000);    
    INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
    INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
    INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1030, 'VERY', 25000);
    INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1040, 'CAT', 2000);
    INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10;
    
    -- (2) UPDATE 테이블이름 SET 필드명1=값1, 필드명2=값2 WHERE 조건; : 데이터 수정(UPDATE문)
    CREATE TABLE EMP01 AS SELECT * FROM EMP;
    SELECT * FROM EMP01;     
    UPDATE EMP01 SET DEPTNO=30;
    
        -- 모든 직원의 SAL을 10프로 인상
        UPDATE EMP01 SET SAL=SAL*1.1;
        -- 모든 직원의 입사일을 지금으로
        UPDATE EMP01 SET HIREDATE=SYSDATE;
        -- 급여가 3000 이상인 사원만 급여를 10% 인상
        UPDATE EMP01 SET SAL=SAL*1.1 WHERE SAL>=3000;
        -- 근무지가 'DALLAS'인 사람만 SAL을 1000 인상
        DROP TABLE EMP01;
        CREATE TABLE EMP01 AS SELECT * FROM EMP;
        UPDATE EMP01 SET SAL=SAL+10000 WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
        SELECT * FROM EMP01;
        -- SCOTT 사원의 부서번호를 20으로, 직급(JOB)은 MANAGER로 수정
        UPDATE EMP01 SET DEPTNO=20, JOB='MANAGER' WHERE ENAME='SCOTT';
        -- SMITH의 입사일자를 오늘로, 급여(SAL)는 5000으로 COMM은 400으로 수정
        UPDATE EMP01 SET HIREDATE=SYSDATE, SAL=5000, COMM=400 WHERE ENAME='SMITH';
        -- DEPT01 에서 20번 부서의 지역명을 40번 부서의 지역명으로 변경하기
        DROP TABLE DEPT01;
        CREATE TABLE DEPT01 AS SELECT * FROM DEPT;
        UPDATE DEPT01 SET LOC=(SELECT LOC FROM DEPT01 WHERE DEPTNO=40) WHERE DEPTNO=20;
        SELECT * FROM DEPT01;
        -- DEPT01 에서 30번 부서의 지역명과 부서명을 40번 부서의 지역명과 부서명으로 수정
        UPDATE DEPT01 SET (DNAME, LOC)=(SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO=40) WHERE DEPTNO=30;
        -- EMP01 에서 모든 사원의 급여와 입사일을 KING과 같은 값으로 수정하는 UPDATE
        UPDATE EMP01 SET (SAL, HIREDATE)=(SELECT SAL, HIREDATE FROM EMP01 WHERE ENAME='KING');
        SELECT * FROM EMP01;
    
    -- (3) DELETE FROM 테이블명 WHERE 조건 : 데이터 삭제(DELETE문)
    DELETE FROM DEPT01;
    ROLLBACK; --- DML은 ROLLBACK 가능
    TRUNCATE TABLE DEPT01; -- DDL은 ROLLBACK 불가능
    SELECT * FROM DEPT01;
        -- EMP01 테이블에서 30번 부서 직원 삭제
        DELETE FROM EMP01 WHERE DEPTNO=30;
        SELECT * FROM EMP01;
        -- SAM01 테이블에서 JOB이 없는 행 삭제
        DELETE FROM SAM01 WHERE JOB IS NULL;
        SELECT * FROM SAM01;
        -- EMP01 테이블에서 부서명이 SALES 인 부서 직원 삭제
        DELETE FROM EMP01 WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');    

-- ★ 제약조건
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999,'홍',50);
    
-- 제약조건에 따른 테이블 생성
DROP TABLE DEPT1;

CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14) UNIQUE NOT NULL,
    LOC VARCHAR2(13) NOT NULL );
    
SELECT * FROM DEPT1;

DROP TABLE EMP1;

CREATE TABLE EMP1(
    EMPNO NUMBER(4) PRIMARY KEY, -- PRIMARY KEY 제약조건
    ENAME VARCHAR2(10) UNIQUE, -- UNIQUE 제약조건
    JOB VARCHAR2(9) NOT NULL, -- NOT NULL 제약조건
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE, -- 비워두면 자동으로 지금 날짜가 들어가게 설정(기본값 부여)
    SAL NUMBER(7,2) CHECK (SAL>=0), -- 0보다 큰 값만 들어가게 설정
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) REFERENCES DEPT1(DEPTNO)   );-- 외래키(FOREIGH KEY) 제약조건 : DEPT1의 DEPTNO를 그대로 가져오게  

-- MYSQL 에서는 최대한 제약키를 아래쪽으로 몰아야...    
CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9) NOT NULL, -- NOT NULL 제약조건
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE, -- 비워두면 자동으로 지금 날짜가 들어가게 설정(기본값 부여)
    SAL NUMBER(7,2) CHECK (SAL>=0), -- 0보다 큰 값만 들어가게 설정
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    PRIMARY KEY(EMPNO),-- PRIMARY KEY 제약조건
    UNIQUE(ENAME), -- UNIQUE 제약조건
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO)    );-- 외래키(FOREIGH KEY) 제약조건 : DEPT1의 DEPTNO를 그대로 가져오게      

-- DEPT1 
INSERT INTO DEPT1 VALUES (10,'회계','종로');
INSERT INTO DEPT1 VALUES (20,'기획','용산');
INSERT INTO DEPT1 VALUES (30,'전산','중구');

--EMP1
INSERT INTO EMP1 VALUES (1000,'SMITH','MANAGER',2000,'81/01/01',800,NULL,10);
INSERT INTO EMP1 (EMPNO, ENAME, JOB, SAL, DEPTNO) VALUES
    (2000,'SCOTT','SALESMAN',2000,30);
INSERT INTO EMP1 (EMPNO, ENAME, JOB, HIREDATE, SAL, DEPTNO) VALUES
    (3000,'WARD','SALESMAN',NULL,3000,20);
SELECT * FROM EMP1; 

DROP TABLE EMP1;
DROP TABLE DEPT1;

-- DML 쿼리를 데이터 베이스에 등록 (ROLLBACK 안됨)
COMMIT;







    