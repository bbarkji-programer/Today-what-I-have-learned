--<�� ��������> PART1
--1. �̸�, ���ӻ��
SELECT E1.ENAME "�̸�", E2.ENAME "���ӻ��"
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO;
--2. �̸�, �޿�, ����, ���ӻ��
SELECT E1.ENAME "�̸�" , E1.SAL "�޿�" , E1.JOB "����", E2.ENAME "���ӻ��"
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO;
--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���. ��簡 ���� �� ������������ ���)
SELECT E1.ENAME "�̸�" , E1.SAL "�޿�" , E1.JOB "����", NVL(E2.ENAME,'����') "���ӻ��"
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO(+);
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT E1.ENAME "�̸�", E1.SAL "�޿�", DNAME "�μ���", E2.ENAME "���ӻ���"
    FROM EMP E1, EMP E2, DEPT D
    WHERE E1.DEPTNO=D.DEPTNO AND E1.MGR=E2.EMPNO;
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT E1.ENAME "�̸�", E1.SAL "�޿�", E1.DEPTNO "�μ��ڵ�", DNAME "�μ���", NVL(E2.ENAME,'����') "���ӻ���"
    FROM EMP E1, EMP E2, DEPT D
    WHERE E1.DEPTNO=D.DEPTNO AND E1.MGR=E2.EMPNO(+);
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT E1.ENAME "�̸�", E1.SAL "�޿�", GRADE "���", DNAME "�μ���", E2.ENAME "���ӻ���"
    FROM EMP E1, EMP E2, DEPT D, SALGRADE
    WHERE E1.DEPTNO=D.DEPTNO AND E1.MGR=E2.EMPNO(+) AND E1.SAL BETWEEN LOSAL AND HISAL
        AND E1.SAL>=2000;
--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT E1.ENAME "�̸�", E1.SAL "�޿�", GRADE "���", DNAME "�μ���", E2.ENAME "���ӻ���"
    FROM EMP E1, EMP E2, DEPT D, SALGRADE
    WHERE E1.DEPTNO=D.DEPTNO AND E1.MGR=E2.EMPNO(+) AND E1.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME;
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT E1.ENAME "�̸�", E1.SAL "�޿�", GRADE "���", DNAME "�μ���", (E1.SAL+NVL(E1.COMM,0))*12 "����", E2.ENAME "���ӻ���"
    FROM EMP E1, EMP E2, DEPT D, SALGRADE
    WHERE E1.MGR=E2.EMPNO(+) AND E1.DEPTNO=D.DEPTNO AND E1.SAL BETWEEN LOSAL AND HISAL;
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT E1.ENAME "�̸�", E1.SAL "�޿�", GRADE "���", DNAME "�μ���", (E1.SAL+NVL(E1.COMM,0))*12 "����", E2.ENAME "���ӻ���"
    FROM EMP E1, EMP E2, DEPT D, SALGRADE
    WHERE E1.MGR=E2.EMPNO(+) AND E1.DEPTNO=D.DEPTNO AND E1.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, E1.SAL DESC;
    
--<�� ��������> PART2
--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME "�̸�", E.DEPTNO "�μ���ȣ", DNAME "�μ���"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME "�̸�", JOB "����", SAL "�޿�", DNAME "�μ���"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';   
--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME "�̸�", DNAME "�μ���", LOC "��ġ"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL AND COMM^=0;
--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME "�̸�", JOB "����", DNAME "�μ���" , LOC "��ġ"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%L%';
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO "���", ENAME "�����", E.DEPTNO "�μ��ڵ�", DNAME "�μ���"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    ORDER BY ENAME;
--6. ���, �����, �޿�, �μ����� �˻��϶�. �� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO "���", ENAME "�����", E.SAL "�޿�", DNAME "�μ���"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
        AND E.SAL>=2000
    ORDER BY E.SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻��� ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO "���", ENAME "�����", JOB "����", E.SAL "�޿�", DNAME "�μ���"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER' AND E.SAL>=2500
    ORDER BY EMPNO;
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO "���", ENAME "�����", JOB "����", E.SAL "�޿�", GRADE "���"
    FROM EMP E, SALGRADE
    WHERE E.SAL BETWEEN LOSAL AND HISAL
    ORDER BY E.SAL DESC;
--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT E1.ENAME "�����", E2.ENAME "���"
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO(+);
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT E1.ENAME "�����", E2.ENAME "����", E3.ENAME "����� ���"
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR=E2.EMPNO AND E2.MGR=E3.EMPNO;
--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT E1.ENAME "�����", NVL(E2.ENAME,'-') "����", NVL(E3.ENAME,'-') "����� ���"
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR=E2.EMPNO(+) AND E2.MGR=E3.EMPNO(+);