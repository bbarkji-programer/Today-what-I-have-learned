-- SELECT �� (2019.12.19)
-- ���� �� �� CTRL ENTER 
-- SELECT + �ʵ� ~~~~~ FROM + ���̺�

SELECT  * FROM TAB; -- scott�� ���� �ִ� ��� ���̺�
SELECT * FROM EMP; -- EMP ���̺��� ��� �ʵ�(��), ��� ������(��)
DESC EMP; -- DESC+ ���̺��� ����
SELECT * FROM DEPT;
DESC DEPT; -- EX) DEPT ���̺��� ����(�ʵ� �� Ÿ��)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP; -- Ư�� �ʵ常 ������� ����ϰ� ���� ��
SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�", JOB AS "��å" 
    FROM EMP; -- �ʵ带 ���ϴ� �ּ�����~ �� �ٷε� ����
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�", JOB "�۾�" FROM EMP; -- �ʵ� ������ �ѱ۷� ���� ������ "" ��. �ٵ� �ѱ� ���� �Ⱦ�
SELECT EMPNO "NO", ENAME "NAME", SAL "SALARY", JOB "j" FROM EMP; -- AS ���� ����
SELECT EMPNO AS "NO", ENAME AS "NAME", SAL AS SALARY, JOB J FROM EMP; -- (���� �ƴ� ���)""�� ��������
SELECT EMPNO NNO, ENAME NNAME, SAL SALARY, JOB J FROM EMP; -- (���� �ƴ� ���) AS,"" ��� ��������
SELECT EMPNO, ENAME, DEPTNO FROM EMP;-- EMP ���̺��� EMPNO, ENAME, DEPNO �ʵ��� ��� �����͸� ����ؿ�.

-- WHERE ���ǰ� �񱳿�����: ����(=), ũ�ų� ����(>=), �۰ų� ����(<=), �ٸ���(<>,^=,!=)
-- �� ������ : AND, OR
SELECT * FROM EMP WHERE SAL =3000; -- SAL�� 3000�� ������ ��� �ʵ带 ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL=3000; -- SAL�� 3000�� ������ ���, �̸�, �޿��� ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL=3000; -- SAL�� 3000�� ������ ���, �̸�, �޿��� ����ϴµ� Ÿ��Ʋ�� ���, �̸�, �޿��� �ٲ㼭 ���
SELECT EMPNO, ENAME, SAL, COMM FROM EMP WHERE SAL<>3000; -- SAL�� 3000�� �ƴ� ������ EMPNO, ENAME, SAL, COMM �ʵ带 LIST
SELECT EMPNO, ENAME, SAL, COMM FROM EMP WHERE SAL^=3000; -- SAL�� 3000�� �ƴ� ������ EMPNO, ENAME, SAL, COMM �ʵ带 LIST
SELECT EMPNO, ENAME, SAL, COMM FROM EMP WHERE SAL!=3000; -- SAL�� 3000�� �ƴ� ������ EMPNO, ENAME, SAL, COMM �ʵ带 LIST
SELECT * FROM EMP WHERE DEPTNO=10; -- 10�� �μ� ������ ��� �ʵ带 LIST
SELECT * FROM EMP WHERE ENAME='FORD'; -- �̸��� FORD�� ������ ��� �ʵ带 LIST (*���ڴ� ''��. ""�� �ʵ��� ���� �� ����)
SELECT * FROM EMP WHERE ENMAE='ford'; -- �̷��� �ȳ���. �����ʹ� ��ҹ��ڸ� �����ؼ�~ �ؾ���~
SELECT * FROM EMP WHERE SAL >=2000 AND SAL <=3000;-- SAL�� 200 �̻� 3000 �̸��� ������ ��� �ʵ带 ����ض�
SELECT * FROM EMP WHERE ENAME<'EP'; -- �񱳿����� ���ڵ� ����
SELECT * FROM EMP WHERE HIREDATE<'82/01/01'; -- �񱳿����� ��¥�� ����
SELECT * FROM EMP WHERE HIREDATE>='82/01/01' AND HIREDATE<='82/12/31';
SELECT ENAME, SAL FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER'; -- 10�� �μ��̰ų� JOB�� �Ŵ����� ������ �̸�, �޿� LIST
SELECT * FROM EMP WHERE DEPTNO^=10; -- 10�� �μ��� �ƴ� ��� ������ ��� �ʵ� LIST
SELECT * FROM EMP WHERE DEPTNO!=10; 
SELECT * FROM EMP WHERE DEPTNO<>10; 

-- �������
SELECT ENAME, SAL*12 "����" FROM EMP WHERE SAL>2000;  -- SAL(����). SAL 2000�̻��� ������ �̸��� ����(COMM ����) LIST
SELECT ENAME, SAL "��������", SAL+300 "�λ����" FROM EMP;  -- �������� ������ 300�� �ø���, '�����, ��������, �ø�����' �ʵ� ��� ���� LIST
SELECT ENAME, SAL "��������", SAL*1.1 "�λ����" FROM EMP; -- �޿��� 10���� �λ��ؼ� ��� ������ �����, ��������, �ø�����
SELECT ENAME, SAL, COMM, (SAL*12)+COMM "����" FROM EMP; -- SAL(����), ����(SAL*12+COMM). ��� ������ �̸�, ����, ��, ���� �ʵ� LIST
-- >>>> ��������� ����. ��� ���� NULL �� ������ ����� NULL�� �Ǿ����.... => NVL �Լ��� �̿��ؼ� �ؾ��Ѵ�.
SELECT ENAME "�̸�", SAL "����", NVL(COMM,0) "��", (SAL*12)+NVL(COMM,0) "����" FROM EMP; -- NVL(COMM,0) : COMM�� NULL ���̸�, ��� 0���� ���. ��, �Ű����� ���� Ÿ�� ��ġ�ؾ�. ��) NVL(����,����)
SELECT ENAME, NVL(HIREDATE,'81/01/01') FROM EMP; -- ��¥�� �� DATE Ÿ���� �ƴ϶� ���� Ÿ�Ե� ����
SELECT ENAME, NVL(MGR,'�ְ�濵��') FROM EMP; -- Ÿ�� ����ġ �ϸ� �ȵ�. �տ� �Լ� �Ἥ Ÿ�� ��ġ������߉�. 

-- ���� ������(���̳� ���ڸ� ����) : || 
SELECT ENAME || ' ' || JOB FROM EMP; -- �ʵ带 �ϳ��� ����
SELECT ENAME || ' IS ' || JOB "EMPLOYEES" FROM EMP;-- "SMITH IS CLERK" (ENAME IS JOB) ��µǰ� TITLE �� EMPLOYEES��� ��� ���� LIST
SELECT ENAME || 'ANNUAL SALARY IS ' || (SAL*12+NVL(COMM,0)) "ANNUAL SALARY" FROM EMP; -- SMITH'S ANNUAL SALARY IS 000

-- �ߺ����� : DISTINCT
SELECT DISTINCT JOB FROM EMP; -- ENP ���̺��� JOB ���
SELECT DISTINCT DEPTNO FROM EMP; -- �μ� ��ȣ�� ����
SELECT DISTINCT JOB, DEPTNO FROM EMP; -- ����� ���� �ϰ�, �ߺ��� ����.

-- >> ��������
-- 1.	emp ���̺��� ���� ���
DESC EMP;
-- 2.	emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;
-- 3.	�� ����(scott)���� ��밡���� ���̺� ���
SELECT * FROM TAB;
-- 4.	emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
-- 5.	emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000;
-- 6.	emp ���̺��� �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE>'81/02/28';
-- 7.	emp ���̺��� ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB='SALESMAN';
-- 8.	emp ���̺��� ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB^='CLERK';
-- 9.	emp ���̺��� �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
-- 10.	emp ���̺��� �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30;
-- 11.	emp ���̺��� ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='SALESMAN' OR SAL>=3000;
-- 12.	emp ���̺��� �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=2500 AND JOB='MANAGER';
-- 13.	emp ���̺��� ��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���
SELECT ENAME || '��(��) ' || JOB || ' �����̰�, ������ ' || ((SAL*12)+NVL(COMM,0)) FROM EMP;

-- SQL ������
-- BETWEEN A AND B (*�׻� A,B�� ���ԵǸ�, A<B �Ǿ��)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000; -- emp ���̺��� �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���

-- �ʵ�� IN (LIST1,.....LIST2)
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO IN (10,30); -- emp ���̺��� �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
-- �� �ʵ�� LIKE ���� ; ���ϵ�ī��(%) : 0�� �̻��� ����, ���ϵ�ī��(_) : 1�� �̻��� ����)
SELECT * FROM EMP WHERE ENAME LIKE 'M%';-- �̸��� M���� �����ϴ� ����� ��� �ʵ带 ����ض�.
SELECT * FROM EMP WHERE ENAME LIKE '%N%';-- �̸��� N�� �� ��� ���
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP
    WHERE HIREDATE LIKE '82%'; -- 82�⿡ �Ի��� ����� ~ ���
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP
    WHERE HIREDATE LIKE '82/__/__'; -- 82�⿡ �Ի��� ����� ~ ���
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__'; -- 2���� �Ի��� ����� ��� �ʵ�
-- NOT �ʵ� BETWEEN A AND B
-- NOT �ʵ� IN (LIST1, ...., LIST2)
-- NOT �ʵ� LIKE ����

-- IS NULL / IS NOT NULL
SELECT * FROM EMP WHERE COMM IS NULL; -- �󿩰� NULL�� ������ ��� �ѷ�
SELECT * FROM EMP WHERE COMM IS NOT NULL;

-- ���� ORDER BY �ʵ�(/����) (��������)
-- ���� ORDER BY �ʵ� DESC (��������)
SELECT * FROM EMP ORDER BY SAL DESC; -- �޿��� ���� ������� 
SELECT * FROM EMP ORDER BY SAL; -- �޿��� ���� �������
SELECT * FROM EMP ORDER BY HIREDATE; -- �Ի� �������
SELECT * FROM EMP ORDER BY HIREDATE DESC;-- �ֱ� �Ի� �������
SELECT * FROM EMP ORDER BY ENAME; -- �̸��� ���ĺ� ������
SELECT ENAME, SAL, SAL*12+NVL(COMM,0) "����" FROM EMP ORDER BY "����";-- ���� �������
SELECT ENAME, SAL*12+NVL(COMM,0) "����"
    FROM EMP
    WHERE SAL*12+NVL(COMM,0)>=2000
    ORDER BY "����"; -- ������ 2000 �̻��� ������ �̸� ����
    -- FROM�� -> WHERE�� -> SELECT�� -> ORDER BY�� ������ �ؼ�. ������ WHERE �ڿ��� ELIAS X
    
-- �� �� ��������
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD'; -- DATE�� ������
-- TO_CHAR(��¥���ʵ�, 'YYYY/MM/DD') -> YYYY/MM/DD ��Ÿ���� ���������� ��ȯ
-- TO_DATE('1981/01/01', 'YYYY/MM/DD') -> ���ڸ� ��¥������ ��ȯ �Լ�

-- 1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000;
-- 2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO=7788;
-- 3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL*12+NVL(COMM,0)>=24000 ORDER BY SAL;
-- 4.	EMP ���̺��� hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� ename,job,hiredate�� ����ϴ� SELECT ������ �ۼ� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP HIREDATE WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' ORDER BY HIREDATE;
--SELECT ENAME, JOB, HIREDATE FROM EMP HIREDATE WHERE HIREDATE BETWEEN TO_DATE('1981/02/20','YYYY/MM/DD') AND TO_DATE('1981/05/01','YYYY/MM/DD') ORDER BY HIREDATE;
-- 5.	EMP ���̺��� deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN(10,20) ORDER BY ENAME;
-- 6.	EMP ���̺��� sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���(�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME "EMPLOYEE", SAL "MONTHLY SALARY" FROM EMP WHERE SAL>=1500 AND DEPTNO IN(10,30);
-- 7.	EMP ���̺��� hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE HIREDATE LIKE '82%';
-- SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY/MM/DD') LIKE '1982%';
-- 8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT * FROM EMP WHERE (ENAME BETWEEN 'C' AND 'Q') AND ENAME^='Q' ORDER BY SAL, ENAME;
-- 9.	EMP ���̺��� comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� ����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM>(SAL*1.1);
-- 10.	EMP ���̺��� job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP WHERE JOB IN('CLERK','ANALYST') AND NOT (SAL IN(1000,3000,5000));
SELECT * FROM EMP WHERE JOB IN('CLERK','ANALYST') AND SAL NOT IN(1000,3000,5000);
-- 11.	EMP ���̺��� ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND (DEPTNO=30 OR MGR=7782);
-- 12.	��� ���̺��� �Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, SAL FROM EMP WHERE HIREDATE LIKE '81%';
-- 13.	��� ���̺��� �Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81%' AND JOB^='SALESMAN';
-- 14.	��� ���̺��� ���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;
-- 15.	��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';
-- 16.	��� ���̺�������(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL*12 "����" FROM EMP WHERE SAL*12>=35000;



