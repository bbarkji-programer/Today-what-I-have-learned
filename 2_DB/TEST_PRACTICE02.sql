-- <셤 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;
-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여, 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장을 기술하시오.
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*1.15-SAL "Increase" FROM EMP;
-- 3. EMP 테이블에서 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,6),'월'),'YY/MM/DD DY') "6개월 후 월요일" FROM EMP;
-- 4. EMP 테이블에서 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "입사 N개월(반올림)", SAL, TO_CHAR(TRUNC(SAL*MONTHS_BETWEEN(SYSDATE, HIREDATE)),'L9,999,999') "급여 총 계(반올림)" FROM EMP;
-- 5. EMP 테이블에서 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, LPAD(SAL,15,'*') FROM EMP;
-- 6. EMP 테이블에서 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"요일"') 입사요일 FROM EMP;
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY') 입사요일 FROM EMP;
-- 7. EMP 테이블에서 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, LENGTH(ENAME) "이름의 글자 수", JOB 
    FROM EMP
    WHERE LENGTH(ENAME)>=6;
-- 8. EMP 테이블에서 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, SAL, NVL(COMM,0), SAL+NVL(COMM,0) FROM EMP;
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;
-- 10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
SELECT EMPNO, ENAME, HIREDATE FROM EMP
    WHERE TO_CHAR(HIREDATE,'MM')=12;
-- 11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
--…….
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') 급여 FROM EMP;
-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO	 ENAME 	입사일
--7369	  SMITH		1980-12-17
--….
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE,'YYYY-MM-DD') 입사일 FROM EMP;
-- 13. 사원 테이블에서 급여에 따라 사번, 이름, 급여, 등급을 검색하는 SQL 문장을 작성 하시 오. 
--------급여가 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME, SAL, CASE WHEN SAL BETWEEN 0 AND 1000 THEN 'E'
                                   WHEN SAL BETWEEN 1001 AND 2000 THEN 'D'
                                   WHEN SAL BETWEEN 2001 AND 3000 THEN 'C'
                                   WHEN SAL BETWEEN 3001 AND 4000 THEN 'B'
                                   ELSE 'A' END AS 등급 FROM EMP;
SELECT EMPNO, ENAME, SAL, DECODE(TRUNC((SAL-1)/1000),0,'E', 1, 'D', 2, 'C', 3, 'B', 'A') 등급 FROM EMP; 
-- 14. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL,'$999,999') FROM EMP WHERE DEPTNO=20;