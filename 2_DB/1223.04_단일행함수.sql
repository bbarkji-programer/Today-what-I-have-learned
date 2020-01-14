-- 2019.12.20 ~ 12.23 4장 단일행 함수(<->다중행 함수;그룹 함수)
SELECT ENAME, TO_CHAR(HIREDATE, 'YY-MM-DD DY"요일"AM HH:MI:SS') FROM EMP; -- 단일행
SELECT SUM(SAL) FROM EMP; -- 그룹 함수(다중행 함수)
SELECT DEPTNO, SUM(SAL) 
    FROM EMP
    GROUP BY DEPTNO; -- DEPTNO 별로 SUM(SAL) 하겠다. 
-- 단일행 함수의 종류 : 숫자 관련 함수, 문자 처리 함수, 날짜 관련 함수, 형 변환 함수, NVL(,), DECODE, ETC......
-- (1) 숫자 관련 함수
SELECT ABS(-9) FROM EMP;
    -- 아무 의미 없는 1행 짜리 테이블 : DUAL (산술 계산 결과를 한 줄로 보고 싶을 때)
    SELECT * FROM DUAL;
    SELECT ABS(-9) FROM DUAL;
    -- 내림
    SELECT FLOOR(34.5678) FROM DUAL; -- 소수점 아래를 내림
    SELECT FLOOR(34.5678*10)/10 FROM DUAL;
    SELECT FLOOR(10/4) FROM DUAL;
    SELECT TRUNC(34.5678,2) FROM DUAL; -- 소수점 N자리까지 남기고 내림
    SELECT TRUNC(156.54, -2) FROM DUAL; -- 백의 자리까지 남기고 내림
    SELECT TRUNC(156.54, -1) FROM DUAL; -- 십의 자리까지 남기고 내림
    SELECT ENAME, TRUNC(SAL,-3) FROM EMP;-- 이름, SAL(백의자리내림으로) 출력
    -- 반올림
    SELECT ROUND(34.5678) FROM DUAL; -- 소수점에서 반올림
    SELECT ROUND(34.5678,1) FROM DUAL; -- 소수점 아래 한 자리까지 나오게 반올림
    SELECT ROUND(34.5678,-1) FROM DUAL; -- 십의 자리까지 남기고 반올림
    SELECT ROUND(178.111,-2) FROM DUAL; -- 백의 자리까지 남기고 반올림
    SELECT ENAME, ROUND(SAL,-3) FROM EMP; -- 이름, SAL 출력(백의자리에서 반올림)
    -- 올림
    SELECT CEIL(34.5678) FROM DUAL; -- 소수점 올림
    -- 3의 2승
    SELECT POWER(3,2) FROM DUAL;
    -- 나누기
    SELECT MOD(9,2) FROM DUAL;
    SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2)=1; -- 홀수달에 입사한 직원들의 모든 필드 출력
-- (2) 문자 관련 함수
    SELECT UPPER('abcABC') FROM DUAL; -- 대문자로
    SELECT LOWER('ABCABC') FROM DUAL; -- 소문자로
    SELECT INITCAP('abcABC') FROM DUAL; -- 첫 번째 문자만 대문자, 나머지는 소문자
    SELECT * FROM EMP WHERE UPPER(JOB)='MANAGER'; -- JOB이 MANAGER인 직원의 모든 필드
    SELECT * FROM EMP WHERE LOWER(JOB)='manager'; 
    SELECT EMPNO, INITCAP(ENAME), INITCAP(JOB) FROM EMP;
    SELECT CONCAT('ABC','DEF') FROM DUAL; -- 문자 두 개 연결(*두 개만 가능)
    SELECT CONCAT(CONCAT('ABC','DEF'),'GHI') FROM DUAL;-- 문자 여러개 연결
    SELECT CONCAT(CONCAT(CONCAT(ENAME,'는 '),JOB),'이다.') TITLE FROM EMP; -- XX는 JOB 이다.
    SELECT SUBSTR('WELCOME TO ORACLE',3,2) FROM DUAL; -- 특정한 문자 뽑기 SUBSTR(STR, 시작할 위치, 추출할 개수) *첫번째 위치는 1
    SELECT SUBSTR('WELCOME TO ORACLE',-3,2) FROM DUAL; -- 시작할 위치가 음수이면 역순으로 순서매겨서 추출 *제일 끝 -1
    SELECT * FROM EMP WHERE MOD(SUBSTR(HIREDATE,-2,2),2)=0; -- SUBSTR 함수를 이용해서 짝수일자에 입사한 직원의 모든 필드 추출해라
    SELECT SUBSTR('데이터베이스',2,2) FROM DUAL; -- 2번째 위치부터 2글자 추출
    SELECT SUBSTRB('데이터베이스',4,6) FROM DUAL; -- B(BYTE) ; 4바이트 자리부터 6바이트추출
     -- 9월에 입사한 사원의 모든 필드 출력
    SELECT * FROM EMP WHERE HIREDATE LIKE '%/09/%';-- LIKE
    SELECT * FROM EMP WHERE SUBSTR(HIREDATE,4,2)='09';-- SUBSTR()
    SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'MM')='09'; -- TO_CHAR()
    SELECT SUBSTR('ABCD',2,3) FROM DUAL; -- 2번째 글자에서 3글자 출력
    SELECT SUBSTRB('ABCD',2,3) FROM DUAL; -- 2번째 바이트에서 3바이트 가져와
    SELECT SUBSTR('오라클디비',2,3)FROM DUAL; -- 2번째 글자에서 3글자 출력
    SELECT SUBSTRB('오라클디비',4,5)FROM DUAL; -- 2번째 바이트 위치부터 3바이트 출력(XE 버전에서는 한글 1글자가 3바이트 차지함..)
    -- LENGTH(문자): 문자의 길이 , LENGTHB(문자): 문자의 BYTE 수
    SELECT LENGTH('ABCD'), LENGTHB('ABCD') FROM DUAL;
    SELECT LENGTH('가나다라'), LENGTHB('가나다라') FROM DUAL;
    -- INSTR(STRING, 찾을 글자) : STRING에서 찾을 글자의 위치 출력
    SELECT INSTR('ABCABCABC','B') FROM DUAL;
    -- INSTR(STRING, 찾을 글자, 시작위치) : 시작위치부터 STRING에서 찾을 글자의 위치 출력
    SELECT INSTR('ABCABCABC','B',3) FROM DUAL;
    -- INSTR(STRING, 찾을 글자, 시작위치, K) : 시작위치부터 K번째 나오는 찾을 글자의 위치 출력
    SELECT INSTR('ABCABCABC', 'B', 3, 2) FROM DUAL;
    -- 9월에 입사한 사원의 모든 필드 출력
    SELECT * FROM EMP WHERE INSTR(HIREDATE,'09')=4; -- INSTR
    -- LPAD(문자, 10, '*')
    SELECT LPAD('ORACLE',20,'*') FROM DUAL; -- **************ORACLE
    -- RPAD(문자, 10, '*')
    SELECT RPAD('ORACLE',20,'*') FROM DUAL; -- ORACLE**************
    SELECT ENAME, LPAD(SAL,6,'*') FROM EMP;
    -- TRIM(양쪽 스페이스 없애기), LTRIM(왼쪽 스페이스 없애기), RTRIM(오른쪽 스페이스 없애기)
    SELECT TRIM('          ORACEL DB             ') TRIM, 
            LTRIM('          ORACEL DB             ') LTRIM, 
            RTRIM('          ORACEL DB             ') RTRIM FROM DUAL;
    -- TRIM('문자' FORM '문자STRING문자') : 좌우에 있는 특정한 문자를 없애고 싶을 때         
    SELECT TRIM('_' FROM '___ORACLE DB___') FROM DUAL; 
    -- REPLACE(문자, 원글자, 바꿀글자)
    SELECT REPLACE('ABCABC','A','999') FROM DUAL;

-- 탄탄다지기 
-- 83년도에 입사한 직원의 모든 필드 출력
SELECT * FROM EMP WHERE INSTR(HIREDATE,'83')=1;
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE),1,2)=83;
-- 이름이 E로 끝나는 사원의 모든 필드 출력
SELECT * FROM EMP WHERE SUBSTR(ENAME,-1,1)='E'; 
SELECT * FROM EMP WHERE ENAME LIKE '%E';
-- 이름이 E로 끝나는 사원의 이름을(***E) 출력
SELECT LPAD(SUBSTR(ENAME,-1,1),LENGTH(ENAME),'*') FROM EMP WHERE SUBSTR(ENAME,-1,1)='E';
-- 사번, 이름(S****), 직책, 입사일(81/01/**) 출력
SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*') "이름", JOB, TO_CHAR(HIREDATE,'YY/MM/**') "입사일" FROM EMP;
-- 사번, 이름, 직책을 출력(직책은 이름의 문자열 수만큼만 표시)
SELECT EMPNO, ENAME, SUBSTR(JOB, 1, LENGTH(ENAME)) FROM EMP;
-- 82년도 12월에 입사한 직원들의 모든 필드를 출력
SELECT * FROM EMP WHERE SUBSTR(HIREDATE,1,5)='82/12';
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/12/01' AND '82/12/31';
SELECT * FROM EMP WHERE INSTR(HIREDATE, '82/12')=1;
SELECT * FROM EMP WHERE HIREDATE LIKE '82/12%';
-- 이름의 세 번째 글자가 R인 사람
SELECT ENAME FROM EMP WHERE SUBSTR(ENAME,3,1)='R';
SELECT ENAME FROM EMP WHERE ENAME LIKE '__R%';
SELECT ENAME FROM EMP WHERE INSTR(ENAME, 'R', 3)=3;

-- (3) 날짜 관련 예약어와 함수
    -- 지금 현재 시스템 시간 출력
    SELECT SYSDATE "지금현재" FROM DUAL;
    SELECT TO_CHAR(SYSDATE,'YY/MM/DD DY"요일" HH24:MI:SS') FROM DUAL;
    -- 날짜 연산
    SELECT SYSDATE-1 "어제", SYSDATE "오늘", SYSDATE+1 "내일" FROM DUAL;
    SELECT TO_CHAR(SYSDATE+14, 'YY-MM-DD HH24:MI;SS') FROM DUAL;
    -- 이름, 입사일, 근무일수
    SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE+1) "근무일수" FROM EMP;
    SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE+1)/365) "근무연수" FROM EMP;
    SELECT ENAME, HIREDATE, TRUNC(((SYSDATE-HIREDATE+1)/365)*12) "근무월수" FROM EMP;
    -- 날짜 함수
    -- MONTHS_BETWEEN(최근날짜, 이전날짜) : 두 날짜 사이의 개월 수 구하기
    SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "근무월수" FROM EMP;
    -- ADD_MONTHS(특정날짜,N) : 특정 날짜에서 N 개월 후
    SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE,6) FROM EMP; -- 수숩기간 마지막 날(입사 후 6개월인 날짜)
    -- NEXT_DAY(특정날짜,'수') : 특정 날짜에서 처음 도래하는 수요일
    SELECT SYSDATE, NEXT_DAY(SYSDATE,'수') FROM DUAL;
    SELECT ENAME, HIREDATE, NEXT_DAY(HIREDATE,'토') FROM EMP; -- 직원명, 입사일, 입사 후 맞는 첫 주말
    -- LAST_DAY(특정날짜) : 특정 날짜인 달의 마지막 날(말일)
    SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL; -- 이번 달 말일
    SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP; -- 첫 월급날(말일) 출력하기
    -- ROUND(반올림), TRUNC(버림) - YEAR, MONTH, DAY, 생략(default)
    SELECT SYSDATE, ROUND(SYSDATE,'YEAR') FROM DUAL; -- YEAR 반올림 ; 결과는 반드시 1일
    SELECT SYSDATE, TRUNC(SYSDATE,'YEAR') FROM DUAL; -- YEAR 버림 ; 결과는 반드시 1일
    SELECT SYSDATE, ROUND(SYSDATE, 'MONTH') FROM DUAL; -- MONTH 반올림 ; 결과는 반드시 1일
    SELECT SYSDATE, TRUNC(SYSDATE, 'MONTH') FROM DUAL; -- MONTH 버림 ; 결과는 반드시 1일
    SELECT SYSDATE, ROUND(TO_DATE('191226','YYMMDD'), 'DAY') FROM DUAL; -- DAY 반올림 ; 결과는 반드시 일요일
    SELECT SYSDATE, TRUNC(TO_DATE('191226','YYMMDD'), 'DAY') FROM DUAL; -- DAY 버림 ; 결과는 반드시 일요일
    SELECT TO_CHAR((SYSDATE),'YY/MM/DD DY"요일" HH24:MI:SS') FROM DUAL;
    SELECT TO_CHAR(ROUND(SYSDATE),'YY/MM/DD DY"요일" HH24:MI:SS') FROM DUAL; -- DEFAULT ; 반드시 00:00:00 
    SELECT TO_CHAR(TRUNC(SYSDATE),'YY/MM/DD DY"요일" HH24:MI:SS') FROM DUAL; -- DEFAULT ; 반드시 00:00:00 
    
-- 탄탄다지기
-- ENAME, 입사일, 입사일 달의 1일
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP;
-- ENAME, 입사일, 월급날(말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;
-- ENAME, 입사일, 월급날(25일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9,'MONTH')+24 FROM EMP; -- 24일을 15로 만들어서, 24일이면 앞으로, 25일이면 뒤로 붙도록 반올림
-- ENAME, 입사일, 월급날(17일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-1,'MONTH')+16 FROM EMP; -- 16일을 15로 만들어서, 17일이면 앞으로, 17일이면 뒤로 붙도록 반올림
-- ENAME, 입사일, SAL(월급), 이때까지 받은 월급합
SELECT ENAME, HIREDATE, SAL, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)) FROM EMP;
-- ENAME, 입사일, SAL, COMM, 이때까지 회사에서 받은 돈
SELECT ENAME, HIREDATE, SAL, COMM, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))
    +NVL(COMM,0)*TRUNC((SYSDATE-HIREDATE)/365) "이때까지 받은 돈" FROM EMP;
    
-- (4) 형변환 함수
-- TO_CHAR(날짜, 패턴) : 날짜를 문자로
    -- YY(년도) MM(월) MON(월이름) DD(일) DY(요일) AM(오전/오후) HH(12시간 단위 시간) HH24(24시간 단위 시간) MI(분) SS(초)
    -- 패턴 내에 알파벳이나 특수문자 사용 가능. 외래어일 경우 ""안에
    SELECT ENAME, SAL, TO_CHAR(HIREDATE,'YY/MM/DD DY AM HH:MI:SS') FROM EMP;
    SELECT ENAME, SAL, TO_CHAR(HIREDATE,'YYYY/MON/DD DY AM HH:MI:SS') FROM EMP;
    SELECT TO_CHAR(SYSDATE, 'YY"년" MM"월" DD"일" DY"요일" AM HH"시" MI"분" SS"초"') FROM DUAL;
    SELECT TO_CHAR(SYSDATE, 'MM-DD') FROM DUAL;
-- TO_CHAR(숫자, 패턴) : 숫자를 문자로
    -- 패턴 내 L : 지역 통화단위가 붙음
    -- 패턴 내 , : 천 단위마다 ,를 붙이고 싶을 때
    -- 패턴 내 0 : 자리수. 자리수가 맞지 않으면 0으로 채운다.
    SELECT ENAME, SAL, TO_CHAR(SAL,'L000,000') FROM EMP;
    SELECT ENAME, SAL, TO_CHAR(SAL,'L000,000.0') FROM EMP;
    -- 패턴 내 9 : 자리수. 자리수가 맞지 않으면 채우지 않는다.
    SELECT ENAME, SAL, TO_CHAR(SAL,'L999,999') FROM EMP;   
    SELECT ENAME, SAL, TO_CHAR(SAL,'L999,999.9') FROM EMP;  
    -- 패턴 내 $ : $ 통화단위가 붙음
    SELECT ENAME, SAL, TO_CHAR(SAL,'$000,000') FROM EMP;
-- TO_DATE(문자, 패턴) : 문자를 날짜형으로
    -- DATE_FORMET을 모르는 상태에서 81년 5월 1일부터 83년 5월 1일 사이에 입사한 직원들의 모든 필드를 출력
    SELECT * FROM EMP WHERE 
        HIREDATE BETWEEN TO_DATE('19810501','YYYYMMDD') AND TO_DATE('19830501','YYYYMMDD');
    -- 첨 만난 날 부터 몇일 됐나
    SELECT TRUNC(SYSDATE-TO_DATE('20190115','YYYYMMDD'))+1 FROM DUAL;
-- TO_NUMBER(문자, 패턴) : 문자를 숫자로 '9,876' -> 9876
    SELECT TO_NUMBER('1,000','9,999')+1000 FROM DUAL; 

-- (5) NULL 관련 함수 = NVL(MULL 일 수도 있는 데이터, NULL 대신 넣을 값) *단, 형이 일치해야 함
-- 사원이름, 상사의 이름(없으면 'CEO'라고 출력)
SELECT E1.ENAME, NVL(E2.ENAME,'CEO')
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO(+);
-- 사원이름, MGR(MGR이 NULL 이면, 'CEO' 라고 출력)
SELECT ENAME, NVL(TO_CHAR(MGR,'9999'),'CEO') MGR FROM EMP;

-- (6) DECODE(데이터, 값1, 결과1, 값2, 결과2, 값3, 결과3,......., 값N, 결과N, 그 외 결과)
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATIONS', 'ETC')
    AS DNAME FROM EMP;
    -- 기존의 SAL을 이용해서 조정될 SAL은 JOB에 따라 조정 예정. JOB이 ANALYST면 10% 인상, JOB이 SALESMAN이면 20%인상, 
    -- JOB이 MANAGER 30%인상, CLERK 40%인상. 그 외 조정X
    SELECT EMPNO, ENAME, SAL, ROUND(DECODE(JOB, 'ANALYST', SAL*1.1, 'SALESMAN', SAL*1.2, 'MANAGER', SAL*1.3, 'CLERK', SAL*1.4, SAL))
    AS "NEW SAL" FROM EMP;

-- (7) CASE
SELECT ENAME, DEPTNO, CASE WHEN DEPTNO=10 THEN 'ACCOUNTING'
                           WHEN DEPTNO=20 THEN 'RESEARCH'
                           WHEN DEPTNO=30 THEN 'SALES'
                           WHEN DEPTNO=40 THEN 'OPERATIONS'
                           ELSE 'ETC' END AS DNAME FROM EMP;
SELECT ENAME, DEPTNO, CASE DEPTNO WHEN 10 THEN 'ACCOUNTING'
                                  WHEN 20 THEN 'RESEARCH'
                                  WHEN 30 THEN 'SALES'
                                  WHEN 40 THEN 'OPERATIONS' END DNAME FROM EMP;

-- (8) EXTRACT : 추출
SELECT ENAME,TO_CHAR(HIREDATE,'YYYY') FROM EMP; -- '1980' 문자로 바꿈
SELECT ENAME, EXTRACT(YEAR FROM HIREDATE) FROM EMP; -- 년도만 추출(형태가 그대로 DATE형)
SELECT ENAME, EXTRACT(MONTH FROM HIREDATE) FROM EMP;
SELECT ENAME FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE)=9;

-- (9) 그 외
-- LEVEL ~ START WITH ~ CONNECT BY PRIOR
SELECT LEVEL, LPAD(' ', LEVEL*2)||'└─'|| ENAME, MGR FROM EMP
    WHERE ENAME<>'SCOTT'
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR; -- 윗 레벨과 아래 레벨의 연결 조건


































