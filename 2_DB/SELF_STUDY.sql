--1. ��� ���̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի����� ���
SELECT ENAME, SAL, HIREDATE FROM EMP WHERE HIREDATE = (SELECT MIN(HIREDATE)FROM EMP);

--2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿��� ���
SELECT ENAME, SAL FROM EMP WHERE SAL = (SELECT MIN(SAL) FROM EMP);

--3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ带 ���
SELECT ENAME, SAL, DEPTNO FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ����� ���
SELECT ENAME, SAL, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND SAL <= (SELECT AVG(SAL) FROM EMP);

--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ����� ���
SELECT ENAME, SAL, HIREDATE, GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');

--6. 5���� �μ��� �߰��ϰ� �޿��� ū �� ������ ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME 
    FROM EMP E, SALGRADE, DEPT D 
    WHERE SAL BETWEEN LOSAL AND HISAL 
    AND E.DEPTNO=D.DEPTNO
    AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')
    ORDER BY SAL DESC;

--7. ������̺��� BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿��� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME='BLAKE');

--8. ������̺��� MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի����� ���
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME='MILLER');

--9. ������̺��� �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿��� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--10. ������̺��� CLARK�� ���� �μ���, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿�  ���
SELECT DEPTNO FROM EMP WHERE ENAME='CLARK';
SELECT SAL FROM EMP WHERE EMPNO=7698;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='CLARK') AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);

--11. �����ȭ. ������̺��� CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT E.EMPNO, E.ENAME, E.SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO 
    AND E.DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='CLARK')
    AND E.SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);

--12. ��� ���̺��� BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի����� ���
SELECT ENAME, HIREDATE FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE');

--13. ��� ���̺��� ��� �޿� �̻��� �޴� ��� �������� ���ؼ� ������ ��ȣ�� �̸��� ���
SELECT EMPNO, ENAME FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--14. ��� ���̺��� �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� �������� ���� ��� ��ȣ,�̸�,�޿��� ���(��, �����ȣ ������ ���)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%') ORDER BY EMPNO;

--15. ��� ���̺��� �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿��� ���
SELECT ENAME, JOB, SAL FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC='DALLAS';
SELECT ENAME, JOB, SAL FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');

--16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿��� ���
SELECT ENAME, SAL FROM EMP WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING');

--17. ��� ���̺��� SALES�μ� ����� �̸�,������ ���
SELECT ENAME, JOB FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');

--18. ��� ���̺��� ������ �μ� 30�� ���� ���޺��� ���� ����� ���
SELECT ENAME FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);

--19. ��� ���̺��� �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ������ ���
SELECT ENAME, JOB FROM EMP WHERE DEPTNO=10 AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30);

--20. ��� ���̺��� FORD�� ������ ���޵� ���� ����� ��� ������ ���
SELECT * FROM EMP WHERE (JOB,SAL) = (SELECT JOB, SAL FROM EMP WHERE ENAME='FORD');

--21. ��� ���̺��� ������ JONES�� ���ų� ������ FORD�̻��� ����� ������ �̸�,����,�μ���ȣ,�޿��� ���. (��, ������ ���ĺ� ��, ������ ���� ������ ���)
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
    WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='JONES')
    OR SAL=(SELECT SAL FROM EMP WHERE ENAME='FORD')
    ORDER BY JOB, SAL DESC;

--22. ��� ���̺��� SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿��� ���
SELECT ENAME, JOB, SAL FROM EMP WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME IN ('SCOTT','WARD'));

--23. ��� ���̺��� CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ����� �̸�,������ ���
SELECT ENAME, JOB FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO');

--24. ��� ���̺��� �μ����� ������ ��� ���޺��� ���� ����� �����ȣ,�̸�,�޿��� ���
SELECT EMPNO, ENAME, SAL FROM EMP E WHERE SAL >(SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);

--25. ��� ���̺��� �������� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ���
SELECT DEPTNO, ENAME, SAL FROM EMP E WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB=E.JOB);

--26. ��� ���̺��� ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����,�̸�,�����ȣ,�μ���ȣ�� ���
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP MANAGER WHERE EXISTS (SELECT * FROM EMP WORKER WHERE WORKER.MGR=MANAGER.EMPNO);

--27. ��� ���̺��� ���� ����� �����ȣ,�̸�,����,�μ���ȣ�� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP MANAGER WHERE NOT EXISTS (SELECT * FROM EMP WORKER WHERE WORKER.MGR=MANAGER.EMPNO);