-- SELECT 문 (2019.12.19)
-- 실행 할 때 CTRL ENTER 
-- SELECT + 필드 ~~~~~ FROM + 테이블

SELECT  * FROM TAB; -- scott이 갖고 있는 모든 테이블
SELECT * FROM EMP; -- EMP 테이블의 모든 필드(열), 모든 데이터(행)
DESC EMP; -- DESC+ 테이블의 구조
SELECT * FROM DEPT;
DESC DEPT; -- EX) DEPT 테이블의 구조(필드 별 타입)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP; -- 특정 필드만 순서대로 출력하고 싶을 때
SELECT EMPNO AS "사번", ENAME AS "이름", SAL AS "급여", JOB AS "직책" 
    FROM EMP; -- 필드를 원하는 주석으로~ 두 줄로도 가능
SELECT EMPNO "사번", ENAME "이름", SAL "급여", JOB "작업" FROM EMP; -- 필드 별명을 한글로 쓰고 싶으면 "" 꼭. 근데 한글 거의 안씀
SELECT EMPNO "NO", ENAME "NAME", SAL "SALARY", JOB "j" FROM EMP; -- AS 생략 가능
SELECT EMPNO AS "NO", ENAME AS "NAME", SAL AS SALARY, JOB J FROM EMP; -- (예약어가 아닌 경우)""도 생략가능
SELECT EMPNO NNO, ENAME NNAME, SAL SALARY, JOB J FROM EMP; -- (예약어가 아닌 경우) AS,"" 모두 생략가능
SELECT EMPNO, ENAME, DEPTNO FROM EMP;-- EMP 테이블에서 EMPNO, ENAME, DEPNO 필드의 모든 데이터를 출력해여.

-- WHERE 조건과 비교연산자: 같다(=), 크거나 같다(>=), 작거나 같다(<=), 다르다(<>,^=,!=)
-- 논리 연산자 : AND, OR
SELECT * FROM EMP WHERE SAL =3000; -- SAL이 3000인 직원의 모든 필드를 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL=3000; -- SAL이 3000인 직원의 사번, 이름, 급여만 출력
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL=3000; -- SAL이 3000인 직원의 사번, 이름, 급여만 출력하는데 타이틀을 사번, 이름, 급여로 바꿔서 출력
SELECT EMPNO, ENAME, SAL, COMM FROM EMP WHERE SAL<>3000; -- SAL이 3000이 아닌 직원의 EMPNO, ENAME, SAL, COMM 필드를 LIST
SELECT EMPNO, ENAME, SAL, COMM FROM EMP WHERE SAL^=3000; -- SAL이 3000이 아닌 직원의 EMPNO, ENAME, SAL, COMM 필드를 LIST
SELECT EMPNO, ENAME, SAL, COMM FROM EMP WHERE SAL!=3000; -- SAL이 3000이 아닌 직원의 EMPNO, ENAME, SAL, COMM 필드를 LIST
SELECT * FROM EMP WHERE DEPTNO=10; -- 10번 부서 직원의 모든 필드를 LIST
SELECT * FROM EMP WHERE ENAME='FORD'; -- 이름이 FORD인 직원의 모든 필드를 LIST (*문자는 ''로. ""는 필드의 별명 줄 때만)
SELECT * FROM EMP WHERE ENMAE='ford'; -- 이러면 안나옴. 데이터는 대소문자를 구분해서~ 해야해~
SELECT * FROM EMP WHERE SAL >=2000 AND SAL <=3000;-- SAL이 200 이상 3000 미만인 직원의 모든 필드를 출력해라
SELECT * FROM EMP WHERE ENAME<'EP'; -- 비교연산은 문자도 가능
SELECT * FROM EMP WHERE HIREDATE<'82/01/01'; -- 비교연산은 날짜도 가능
SELECT * FROM EMP WHERE HIREDATE>='82/01/01' AND HIREDATE<='82/12/31';
SELECT ENAME, SAL FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER'; -- 10번 부서이거나 JOB이 매니저인 직원의 이름, 급여 LIST
SELECT * FROM EMP WHERE DEPTNO^=10; -- 10번 부서가 아닌 모든 직원의 모든 필드 LIST
SELECT * FROM EMP WHERE DEPTNO!=10; 
SELECT * FROM EMP WHERE DEPTNO<>10; 

-- 산술연산
SELECT ENAME, SAL*12 "연봉" FROM EMP WHERE SAL>2000;  -- SAL(월급). SAL 2000이상인 직원의 이름과 연봉(COMM 제외) LIST
SELECT ENAME, SAL "기존월급", SAL+300 "인상월급" FROM EMP;  -- 직원들의 월급을 300씩 올리고, '사원명, 원래월급, 올린월급' 필드 모든 직원 LIST
SELECT ENAME, SAL "기존월급", SAL*1.1 "인상월급" FROM EMP; -- 급여를 10프로 인상해서 모든 직원의 사원명, 원래월급, 올린월급
SELECT ENAME, SAL, COMM, (SAL*12)+COMM "연봉" FROM EMP; -- SAL(월급), 연봉(SAL*12+COMM). 모든 직원의 이름, 월급, 상여, 연봉 필드 LIST
-- >>>> 산술연산의 단점. 계산 값에 NULL 이 있으면 결과가 NULL이 되어벌임.... => NVL 함수를 이용해서 해야한당.
SELECT ENAME "이름", SAL "월급", NVL(COMM,0) "상여", (SAL*12)+NVL(COMM,0) "연봉" FROM EMP; -- NVL(COMM,0) : COMM이 NULL 값이면, 대신 0으로 계산. 단, 매개변수 끼리 타입 일치해야. 예) NVL(숫자,숫자)
SELECT ENAME, NVL(HIREDATE,'81/01/01') FROM EMP; -- 날짜는 꼭 DATE 타입이 아니라 문자 타입도 가능
SELECT ENAME, NVL(MGR,'최고경영자') FROM EMP; -- 타입 불일치 하면 안됨. 앞에 함수 써서 타입 일치시텨줘야됭. 

-- 연결 연산자(열이나 문자를 연결) : || 
SELECT ENAME || ' ' || JOB FROM EMP; -- 필드를 하나로 연결
SELECT ENAME || ' IS ' || JOB "EMPLOYEES" FROM EMP;-- "SMITH IS CLERK" (ENAME IS JOB) 출력되고 TITLE 은 EMPLOYEES라고 모든 직원 LIST
SELECT ENAME || 'ANNUAL SALARY IS ' || (SAL*12+NVL(COMM,0)) "ANNUAL SALARY" FROM EMP; -- SMITH'S ANNUAL SALARY IS 000

-- 중복제거 : DISTINCT
SELECT DISTINCT JOB FROM EMP; -- ENP 테이블의 JOB 출력
SELECT DISTINCT DEPTNO FROM EMP; -- 부서 번호의 종류
SELECT DISTINCT JOB, DEPTNO FROM EMP; -- 출력을 먼저 하고, 중복을 제거.

-- >> 연습문제
-- 1.	emp 테이블의 구조 출력
DESC EMP;
-- 2.	emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;
-- 3.	이 계정(scott)에서 사용가능한 테이블 출력
SELECT * FROM TAB;
-- 4.	emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
-- 5.	emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000;
-- 6.	emp 테이블에서 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE>'81/02/28';
-- 7.	emp 테이블에서 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB='SALESMAN';
-- 8.	emp 테이블에서 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB^='CLERK';
-- 9.	emp 테이블에서 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
-- 10.	emp 테이블에서 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30;
-- 11.	emp 테이블에서 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='SALESMAN' OR SAL>=3000;
-- 12.	emp 테이블에서 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=2500 AND JOB='MANAGER';
-- 13.	emp 테이블의 “ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력
SELECT ENAME || '은(는) ' || JOB || ' 업무이고, 연봉은 ' || ((SAL*12)+NVL(COMM,0)) FROM EMP;

-- SQL 연산자
-- BETWEEN A AND B (*항상 A,B가 포함되며, A<B 되어야)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000; -- emp 테이블에서 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력

-- 필드명 IN (LIST1,.....LIST2)
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO IN (10,30); -- emp 테이블에서 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
-- ★ 필드명 LIKE 패턴 ; 와일드카드(%) : 0자 이상의 문자, 와일드카드(_) : 1자 이상의 문자)
SELECT * FROM EMP WHERE ENAME LIKE 'M%';-- 이름이 M으로 시작하는 사람의 모든 필드를 출력해라.
SELECT * FROM EMP WHERE ENAME LIKE '%N%';-- 이름에 N이 들어간 사람 출력
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP
    WHERE HIREDATE LIKE '82%'; -- 82년에 입사한 사람의 ~ 출력
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP
    WHERE HIREDATE LIKE '82/__/__'; -- 82년에 입사한 사람의 ~ 출력
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__'; -- 2월에 입사한 사원의 모든 필드
-- NOT 필드 BETWEEN A AND B
-- NOT 필드 IN (LIST1, ...., LIST2)
-- NOT 필드 LIKE 패턴

-- IS NULL / IS NOT NULL
SELECT * FROM EMP WHERE COMM IS NULL; -- 상여가 NULL인 직원을 모두 뿌려
SELECT * FROM EMP WHERE COMM IS NOT NULL;

-- 정렬 ORDER BY 필드(/별명) (오름차순)
-- 정렬 ORDER BY 필드 DESC (내림차순)
SELECT * FROM EMP ORDER BY SAL DESC; -- 급여가 많은 사람부터 
SELECT * FROM EMP ORDER BY SAL; -- 급여가 낮은 사람부터
SELECT * FROM EMP ORDER BY HIREDATE; -- 입사 순서대로
SELECT * FROM EMP ORDER BY HIREDATE DESC;-- 최근 입사 순서대로
SELECT * FROM EMP ORDER BY ENAME; -- 이름을 알파벳 순으로
SELECT ENAME, SAL, SAL*12+NVL(COMM,0) "연봉" FROM EMP ORDER BY "연봉";-- 연봉 순서대로
SELECT ENAME, SAL*12+NVL(COMM,0) "연봉"
    FROM EMP
    WHERE SAL*12+NVL(COMM,0)>=2000
    ORDER BY "연봉"; -- 연봉이 2000 이상인 직원의 이름 연봉
    -- FROM절 -> WHERE절 -> SELECT절 -> ORDER BY절 순서로 해석. 때문에 WHERE 뒤에는 ELIAS X
    
-- ★ 셤 연습문제
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD'; -- DATE형 포맷팅
-- TO_CHAR(날짜형필드, 'YYYY/MM/DD') -> YYYY/MM/DD 스타일의 문자형으로 전환
-- TO_DATE('1981/01/01', 'YYYY/MM/DD') -> 문자를 날짜형으로 전환 함수

-- 1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000;
-- 2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO=7788;
-- 3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL*12+NVL(COMM,0)>=24000 ORDER BY SAL;
-- 4.	EMP 테이블에서 hiredate가 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 ename,job,hiredate을 출력하는 SELECT 문장을 작성 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE FROM EMP HIREDATE WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' ORDER BY HIREDATE;
--SELECT ENAME, JOB, HIREDATE FROM EMP HIREDATE WHERE HIREDATE BETWEEN TO_DATE('1981/02/20','YYYY/MM/DD') AND TO_DATE('1981/05/01','YYYY/MM/DD') ORDER BY HIREDATE;
-- 5.	EMP 테이블에서 deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN(10,20) ORDER BY ENAME;
-- 6.	EMP 테이블에서 sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력(단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME "EMPLOYEE", SAL "MONTHLY SALARY" FROM EMP WHERE SAL>=1500 AND DEPTNO IN(10,30);
-- 7.	EMP 테이블에서 hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE HIREDATE LIKE '82%';
-- SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY/MM/DD') LIKE '1982%';
-- 8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT * FROM EMP WHERE (ENAME BETWEEN 'C' AND 'Q') AND ENAME^='Q' ORDER BY SAL, ENAME;
-- 9.	EMP 테이블에서 comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 출력하는 SELECT 문을 작성
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM>(SAL*1.1);
-- 10.	EMP 테이블에서 job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT * FROM EMP WHERE JOB IN('CLERK','ANALYST') AND NOT (SAL IN(1000,3000,5000));
SELECT * FROM EMP WHERE JOB IN('CLERK','ANALYST') AND SAL NOT IN(1000,3000,5000);
-- 11.	EMP 테이블에서 ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND (DEPTNO=30 OR MGR=7782);
-- 12.	사원 테이블에서 입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, SAL FROM EMP WHERE HIREDATE LIKE '81%';
-- 13.	사원 테이블에서 입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81%' AND JOB^='SALESMAN';
-- 14.	사원 테이블의 사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;
-- 15.	사원 테이블에서 사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';
-- 16.	사원 테이블에서연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME, SAL*12 "연봉" FROM EMP WHERE SAL*12>=35000;



