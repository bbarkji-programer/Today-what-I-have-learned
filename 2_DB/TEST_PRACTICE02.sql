-- <�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;
-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�, �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*1.15-SAL "Increase" FROM EMP;
-- 3. EMP ���̺��� �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,6),'��'),'YY/MM/DD DY') "6���� �� ������" FROM EMP;
-- 4. EMP ���̺��� �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�Ի� N����(�ݿø�)", SAL, TO_CHAR(TRUNC(SAL*MONTHS_BETWEEN(SYSDATE, HIREDATE)),'L9,999,999') "�޿� �� ��(�ݿø�)" FROM EMP;
-- 5. EMP ���̺��� ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, LPAD(SAL,15,'*') FROM EMP;
-- 6. EMP ���̺��� ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"����"') �Ի���� FROM EMP;
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY') �Ի���� FROM EMP;
-- 7. EMP ���̺��� �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, LENGTH(ENAME) "�̸��� ���� ��", JOB 
    FROM EMP
    WHERE LENGTH(ENAME)>=6;
-- 8. EMP ���̺��� ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, SAL, NVL(COMM,0), SAL+NVL(COMM,0) FROM EMP;
-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;
-- 10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
SELECT EMPNO, ENAME, HIREDATE FROM EMP
    WHERE TO_CHAR(HIREDATE,'MM')=12;
-- 11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
--����.
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') �޿� FROM EMP;
-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO	 ENAME 	�Ի���
--7369	  SMITH		1980-12-17
--��.
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE,'YYYY-MM-DD') �Ի��� FROM EMP;
-- 13. ��� ���̺��� �޿��� ���� ���, �̸�, �޿�, ����� �˻��ϴ� SQL ������ �ۼ� �Ͻ� ��. 
--------�޿��� 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME, SAL, CASE WHEN SAL BETWEEN 0 AND 1000 THEN 'E'
                                   WHEN SAL BETWEEN 1001 AND 2000 THEN 'D'
                                   WHEN SAL BETWEEN 2001 AND 3000 THEN 'C'
                                   WHEN SAL BETWEEN 3001 AND 4000 THEN 'B'
                                   ELSE 'A' END AS ��� FROM EMP;
SELECT EMPNO, ENAME, SAL, DECODE(TRUNC((SAL-1)/1000),0,'E', 1, 'D', 2, 'C', 3, 'B', 'A') ��� FROM EMP; 
-- 14. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL,'$999,999') FROM EMP WHERE DEPTNO=20;