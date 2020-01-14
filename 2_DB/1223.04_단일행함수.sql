-- 2019.12.20 ~ 12.23 4�� ������ �Լ�(<->������ �Լ�;�׷� �Լ�)
SELECT ENAME, TO_CHAR(HIREDATE, 'YY-MM-DD DY"����"AM HH:MI:SS') FROM EMP; -- ������
SELECT SUM(SAL) FROM EMP; -- �׷� �Լ�(������ �Լ�)
SELECT DEPTNO, SUM(SAL) 
    FROM EMP
    GROUP BY DEPTNO; -- DEPTNO ���� SUM(SAL) �ϰڴ�. 
-- ������ �Լ��� ���� : ���� ���� �Լ�, ���� ó�� �Լ�, ��¥ ���� �Լ�, �� ��ȯ �Լ�, NVL(,), DECODE, ETC......
-- (1) ���� ���� �Լ�
SELECT ABS(-9) FROM EMP;
    -- �ƹ� �ǹ� ���� 1�� ¥�� ���̺� : DUAL (��� ��� ����� �� �ٷ� ���� ���� ��)
    SELECT * FROM DUAL;
    SELECT ABS(-9) FROM DUAL;
    -- ����
    SELECT FLOOR(34.5678) FROM DUAL; -- �Ҽ��� �Ʒ��� ����
    SELECT FLOOR(34.5678*10)/10 FROM DUAL;
    SELECT FLOOR(10/4) FROM DUAL;
    SELECT TRUNC(34.5678,2) FROM DUAL; -- �Ҽ��� N�ڸ����� ����� ����
    SELECT TRUNC(156.54, -2) FROM DUAL; -- ���� �ڸ����� ����� ����
    SELECT TRUNC(156.54, -1) FROM DUAL; -- ���� �ڸ����� ����� ����
    SELECT ENAME, TRUNC(SAL,-3) FROM EMP;-- �̸�, SAL(�����ڸ���������) ���
    -- �ݿø�
    SELECT ROUND(34.5678) FROM DUAL; -- �Ҽ������� �ݿø�
    SELECT ROUND(34.5678,1) FROM DUAL; -- �Ҽ��� �Ʒ� �� �ڸ����� ������ �ݿø�
    SELECT ROUND(34.5678,-1) FROM DUAL; -- ���� �ڸ����� ����� �ݿø�
    SELECT ROUND(178.111,-2) FROM DUAL; -- ���� �ڸ����� ����� �ݿø�
    SELECT ENAME, ROUND(SAL,-3) FROM EMP; -- �̸�, SAL ���(�����ڸ����� �ݿø�)
    -- �ø�
    SELECT CEIL(34.5678) FROM DUAL; -- �Ҽ��� �ø�
    -- 3�� 2��
    SELECT POWER(3,2) FROM DUAL;
    -- ������
    SELECT MOD(9,2) FROM DUAL;
    SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2)=1; -- Ȧ���޿� �Ի��� �������� ��� �ʵ� ���
-- (2) ���� ���� �Լ�
    SELECT UPPER('abcABC') FROM DUAL; -- �빮�ڷ�
    SELECT LOWER('ABCABC') FROM DUAL; -- �ҹ��ڷ�
    SELECT INITCAP('abcABC') FROM DUAL; -- ù ��° ���ڸ� �빮��, �������� �ҹ���
    SELECT * FROM EMP WHERE UPPER(JOB)='MANAGER'; -- JOB�� MANAGER�� ������ ��� �ʵ�
    SELECT * FROM EMP WHERE LOWER(JOB)='manager'; 
    SELECT EMPNO, INITCAP(ENAME), INITCAP(JOB) FROM EMP;
    SELECT CONCAT('ABC','DEF') FROM DUAL; -- ���� �� �� ����(*�� ���� ����)
    SELECT CONCAT(CONCAT('ABC','DEF'),'GHI') FROM DUAL;-- ���� ������ ����
    SELECT CONCAT(CONCAT(CONCAT(ENAME,'�� '),JOB),'�̴�.') TITLE FROM EMP; -- XX�� JOB �̴�.
    SELECT SUBSTR('WELCOME TO ORACLE',3,2) FROM DUAL; -- Ư���� ���� �̱� SUBSTR(STR, ������ ��ġ, ������ ����) *ù��° ��ġ�� 1
    SELECT SUBSTR('WELCOME TO ORACLE',-3,2) FROM DUAL; -- ������ ��ġ�� �����̸� �������� �����Űܼ� ���� *���� �� -1
    SELECT * FROM EMP WHERE MOD(SUBSTR(HIREDATE,-2,2),2)=0; -- SUBSTR �Լ��� �̿��ؼ� ¦�����ڿ� �Ի��� ������ ��� �ʵ� �����ض�
    SELECT SUBSTR('�����ͺ��̽�',2,2) FROM DUAL; -- 2��° ��ġ���� 2���� ����
    SELECT SUBSTRB('�����ͺ��̽�',4,6) FROM DUAL; -- B(BYTE) ; 4����Ʈ �ڸ����� 6����Ʈ����
     -- 9���� �Ի��� ����� ��� �ʵ� ���
    SELECT * FROM EMP WHERE HIREDATE LIKE '%/09/%';-- LIKE
    SELECT * FROM EMP WHERE SUBSTR(HIREDATE,4,2)='09';-- SUBSTR()
    SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'MM')='09'; -- TO_CHAR()
    SELECT SUBSTR('ABCD',2,3) FROM DUAL; -- 2��° ���ڿ��� 3���� ���
    SELECT SUBSTRB('ABCD',2,3) FROM DUAL; -- 2��° ����Ʈ���� 3����Ʈ ������
    SELECT SUBSTR('����Ŭ���',2,3)FROM DUAL; -- 2��° ���ڿ��� 3���� ���
    SELECT SUBSTRB('����Ŭ���',4,5)FROM DUAL; -- 2��° ����Ʈ ��ġ���� 3����Ʈ ���(XE ���������� �ѱ� 1���ڰ� 3����Ʈ ������..)
    -- LENGTH(����): ������ ���� , LENGTHB(����): ������ BYTE ��
    SELECT LENGTH('ABCD'), LENGTHB('ABCD') FROM DUAL;
    SELECT LENGTH('�����ٶ�'), LENGTHB('�����ٶ�') FROM DUAL;
    -- INSTR(STRING, ã�� ����) : STRING���� ã�� ������ ��ġ ���
    SELECT INSTR('ABCABCABC','B') FROM DUAL;
    -- INSTR(STRING, ã�� ����, ������ġ) : ������ġ���� STRING���� ã�� ������ ��ġ ���
    SELECT INSTR('ABCABCABC','B',3) FROM DUAL;
    -- INSTR(STRING, ã�� ����, ������ġ, K) : ������ġ���� K��° ������ ã�� ������ ��ġ ���
    SELECT INSTR('ABCABCABC', 'B', 3, 2) FROM DUAL;
    -- 9���� �Ի��� ����� ��� �ʵ� ���
    SELECT * FROM EMP WHERE INSTR(HIREDATE,'09')=4; -- INSTR
    -- LPAD(����, 10, '*')
    SELECT LPAD('ORACLE',20,'*') FROM DUAL; -- **************ORACLE
    -- RPAD(����, 10, '*')
    SELECT RPAD('ORACLE',20,'*') FROM DUAL; -- ORACLE**************
    SELECT ENAME, LPAD(SAL,6,'*') FROM EMP;
    -- TRIM(���� �����̽� ���ֱ�), LTRIM(���� �����̽� ���ֱ�), RTRIM(������ �����̽� ���ֱ�)
    SELECT TRIM('          ORACEL DB             ') TRIM, 
            LTRIM('          ORACEL DB             ') LTRIM, 
            RTRIM('          ORACEL DB             ') RTRIM FROM DUAL;
    -- TRIM('����' FORM '����STRING����') : �¿쿡 �ִ� Ư���� ���ڸ� ���ְ� ���� ��         
    SELECT TRIM('_' FROM '___ORACLE DB___') FROM DUAL; 
    -- REPLACE(����, ������, �ٲܱ���)
    SELECT REPLACE('ABCABC','A','999') FROM DUAL;

-- źź������ 
-- 83�⵵�� �Ի��� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE INSTR(HIREDATE,'83')=1;
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE),1,2)=83;
-- �̸��� E�� ������ ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE SUBSTR(ENAME,-1,1)='E'; 
SELECT * FROM EMP WHERE ENAME LIKE '%E';
-- �̸��� E�� ������ ����� �̸���(***E) ���
SELECT LPAD(SUBSTR(ENAME,-1,1),LENGTH(ENAME),'*') FROM EMP WHERE SUBSTR(ENAME,-1,1)='E';
-- ���, �̸�(S****), ��å, �Ի���(81/01/**) ���
SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*') "�̸�", JOB, TO_CHAR(HIREDATE,'YY/MM/**') "�Ի���" FROM EMP;
-- ���, �̸�, ��å�� ���(��å�� �̸��� ���ڿ� ����ŭ�� ǥ��)
SELECT EMPNO, ENAME, SUBSTR(JOB, 1, LENGTH(ENAME)) FROM EMP;
-- 82�⵵ 12���� �Ի��� �������� ��� �ʵ带 ���
SELECT * FROM EMP WHERE SUBSTR(HIREDATE,1,5)='82/12';
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/12/01' AND '82/12/31';
SELECT * FROM EMP WHERE INSTR(HIREDATE, '82/12')=1;
SELECT * FROM EMP WHERE HIREDATE LIKE '82/12%';
-- �̸��� �� ��° ���ڰ� R�� ���
SELECT ENAME FROM EMP WHERE SUBSTR(ENAME,3,1)='R';
SELECT ENAME FROM EMP WHERE ENAME LIKE '__R%';
SELECT ENAME FROM EMP WHERE INSTR(ENAME, 'R', 3)=3;

-- (3) ��¥ ���� ������ �Լ�
    -- ���� ���� �ý��� �ð� ���
    SELECT SYSDATE "��������" FROM DUAL;
    SELECT TO_CHAR(SYSDATE,'YY/MM/DD DY"����" HH24:MI:SS') FROM DUAL;
    -- ��¥ ����
    SELECT SYSDATE-1 "����", SYSDATE "����", SYSDATE+1 "����" FROM DUAL;
    SELECT TO_CHAR(SYSDATE+14, 'YY-MM-DD HH24:MI;SS') FROM DUAL;
    -- �̸�, �Ի���, �ٹ��ϼ�
    SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE+1) "�ٹ��ϼ�" FROM EMP;
    SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE+1)/365) "�ٹ�����" FROM EMP;
    SELECT ENAME, HIREDATE, TRUNC(((SYSDATE-HIREDATE+1)/365)*12) "�ٹ�����" FROM EMP;
    -- ��¥ �Լ�
    -- MONTHS_BETWEEN(�ֱٳ�¥, ������¥) : �� ��¥ ������ ���� �� ���ϱ�
    SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�ٹ�����" FROM EMP;
    -- ADD_MONTHS(Ư����¥,N) : Ư�� ��¥���� N ���� ��
    SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE,6) FROM EMP; -- �����Ⱓ ������ ��(�Ի� �� 6������ ��¥)
    -- NEXT_DAY(Ư����¥,'��') : Ư�� ��¥���� ó�� �����ϴ� ������
    SELECT SYSDATE, NEXT_DAY(SYSDATE,'��') FROM DUAL;
    SELECT ENAME, HIREDATE, NEXT_DAY(HIREDATE,'��') FROM EMP; -- ������, �Ի���, �Ի� �� �´� ù �ָ�
    -- LAST_DAY(Ư����¥) : Ư�� ��¥�� ���� ������ ��(����)
    SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL; -- �̹� �� ����
    SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP; -- ù ���޳�(����) ����ϱ�
    -- ROUND(�ݿø�), TRUNC(����) - YEAR, MONTH, DAY, ����(default)
    SELECT SYSDATE, ROUND(SYSDATE,'YEAR') FROM DUAL; -- YEAR �ݿø� ; ����� �ݵ�� 1��
    SELECT SYSDATE, TRUNC(SYSDATE,'YEAR') FROM DUAL; -- YEAR ���� ; ����� �ݵ�� 1��
    SELECT SYSDATE, ROUND(SYSDATE, 'MONTH') FROM DUAL; -- MONTH �ݿø� ; ����� �ݵ�� 1��
    SELECT SYSDATE, TRUNC(SYSDATE, 'MONTH') FROM DUAL; -- MONTH ���� ; ����� �ݵ�� 1��
    SELECT SYSDATE, ROUND(TO_DATE('191226','YYMMDD'), 'DAY') FROM DUAL; -- DAY �ݿø� ; ����� �ݵ�� �Ͽ���
    SELECT SYSDATE, TRUNC(TO_DATE('191226','YYMMDD'), 'DAY') FROM DUAL; -- DAY ���� ; ����� �ݵ�� �Ͽ���
    SELECT TO_CHAR((SYSDATE),'YY/MM/DD DY"����" HH24:MI:SS') FROM DUAL;
    SELECT TO_CHAR(ROUND(SYSDATE),'YY/MM/DD DY"����" HH24:MI:SS') FROM DUAL; -- DEFAULT ; �ݵ�� 00:00:00 
    SELECT TO_CHAR(TRUNC(SYSDATE),'YY/MM/DD DY"����" HH24:MI:SS') FROM DUAL; -- DEFAULT ; �ݵ�� 00:00:00 
    
-- źź������
-- ENAME, �Ի���, �Ի��� ���� 1��
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP;
-- ENAME, �Ի���, ���޳�(����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;
-- ENAME, �Ի���, ���޳�(25��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9,'MONTH')+24 FROM EMP; -- 24���� 15�� ����, 24���̸� ������, 25���̸� �ڷ� �ٵ��� �ݿø�
-- ENAME, �Ի���, ���޳�(17��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-1,'MONTH')+16 FROM EMP; -- 16���� 15�� ����, 17���̸� ������, 17���̸� �ڷ� �ٵ��� �ݿø�
-- ENAME, �Ի���, SAL(����), �̶����� ���� ������
SELECT ENAME, HIREDATE, SAL, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)) FROM EMP;
-- ENAME, �Ի���, SAL, COMM, �̶����� ȸ�翡�� ���� ��
SELECT ENAME, HIREDATE, SAL, COMM, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))
    +NVL(COMM,0)*TRUNC((SYSDATE-HIREDATE)/365) "�̶����� ���� ��" FROM EMP;
    
-- (4) ����ȯ �Լ�
-- TO_CHAR(��¥, ����) : ��¥�� ���ڷ�
    -- YY(�⵵) MM(��) MON(���̸�) DD(��) DY(����) AM(����/����) HH(12�ð� ���� �ð�) HH24(24�ð� ���� �ð�) MI(��) SS(��)
    -- ���� ���� ���ĺ��̳� Ư������ ��� ����. �ܷ����� ��� ""�ȿ�
    SELECT ENAME, SAL, TO_CHAR(HIREDATE,'YY/MM/DD DY AM HH:MI:SS') FROM EMP;
    SELECT ENAME, SAL, TO_CHAR(HIREDATE,'YYYY/MON/DD DY AM HH:MI:SS') FROM EMP;
    SELECT TO_CHAR(SYSDATE, 'YY"��" MM"��" DD"��" DY"����" AM HH"��" MI"��" SS"��"') FROM DUAL;
    SELECT TO_CHAR(SYSDATE, 'MM-DD') FROM DUAL;
-- TO_CHAR(����, ����) : ���ڸ� ���ڷ�
    -- ���� �� L : ���� ��ȭ������ ����
    -- ���� �� , : õ �������� ,�� ���̰� ���� ��
    -- ���� �� 0 : �ڸ���. �ڸ����� ���� ������ 0���� ä���.
    SELECT ENAME, SAL, TO_CHAR(SAL,'L000,000') FROM EMP;
    SELECT ENAME, SAL, TO_CHAR(SAL,'L000,000.0') FROM EMP;
    -- ���� �� 9 : �ڸ���. �ڸ����� ���� ������ ä���� �ʴ´�.
    SELECT ENAME, SAL, TO_CHAR(SAL,'L999,999') FROM EMP;   
    SELECT ENAME, SAL, TO_CHAR(SAL,'L999,999.9') FROM EMP;  
    -- ���� �� $ : $ ��ȭ������ ����
    SELECT ENAME, SAL, TO_CHAR(SAL,'$000,000') FROM EMP;
-- TO_DATE(����, ����) : ���ڸ� ��¥������
    -- DATE_FORMET�� �𸣴� ���¿��� 81�� 5�� 1�Ϻ��� 83�� 5�� 1�� ���̿� �Ի��� �������� ��� �ʵ带 ���
    SELECT * FROM EMP WHERE 
        HIREDATE BETWEEN TO_DATE('19810501','YYYYMMDD') AND TO_DATE('19830501','YYYYMMDD');
    -- ÷ ���� �� ���� ���� �Ƴ�
    SELECT TRUNC(SYSDATE-TO_DATE('20190115','YYYYMMDD'))+1 FROM DUAL;
-- TO_NUMBER(����, ����) : ���ڸ� ���ڷ� '9,876' -> 9876
    SELECT TO_NUMBER('1,000','9,999')+1000 FROM DUAL; 

-- (5) NULL ���� �Լ� = NVL(MULL �� ���� �ִ� ������, NULL ��� ���� ��) *��, ���� ��ġ�ؾ� ��
-- ����̸�, ����� �̸�(������ 'CEO'��� ���)
SELECT E1.ENAME, NVL(E2.ENAME,'CEO')
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO(+);
-- ����̸�, MGR(MGR�� NULL �̸�, 'CEO' ��� ���)
SELECT ENAME, NVL(TO_CHAR(MGR,'9999'),'CEO') MGR FROM EMP;

-- (6) DECODE(������, ��1, ���1, ��2, ���2, ��3, ���3,......., ��N, ���N, �� �� ���)
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATIONS', 'ETC')
    AS DNAME FROM EMP;
    -- ������ SAL�� �̿��ؼ� ������ SAL�� JOB�� ���� ���� ����. JOB�� ANALYST�� 10% �λ�, JOB�� SALESMAN�̸� 20%�λ�, 
    -- JOB�� MANAGER 30%�λ�, CLERK 40%�λ�. �� �� ����X
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

-- (8) EXTRACT : ����
SELECT ENAME,TO_CHAR(HIREDATE,'YYYY') FROM EMP; -- '1980' ���ڷ� �ٲ�
SELECT ENAME, EXTRACT(YEAR FROM HIREDATE) FROM EMP; -- �⵵�� ����(���°� �״�� DATE��)
SELECT ENAME, EXTRACT(MONTH FROM HIREDATE) FROM EMP;
SELECT ENAME FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE)=9;

-- (9) �� ��
-- LEVEL ~ START WITH ~ CONNECT BY PRIOR
SELECT LEVEL, LPAD(' ', LEVEL*2)||'����'|| ENAME, MGR FROM EMP
    WHERE ENAME<>'SCOTT'
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR; -- �� ������ �Ʒ� ������ ���� ����


































