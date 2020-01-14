-- �� �� ��������
-- 1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE FROM EMP WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP);

-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL FROM EMP WHERE SAL=(SELECT MIN(SAL) FROM EMP);

-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO FROM EMP WHERE SAL>(SELECT AVG(SAL) FROM EMP);

-- 4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO 
    AND SAL<=(SELECT AVG(SAL) FROM EMP);
    
-- 5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE, GRADE FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');
    
-- 6. 5���� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME FROM EMP E, SALGRADE, DEPT D 
    WHERE (SAL BETWEEN LOSAL AND HISAL)
    AND E.DEPTNO=D.DEPTNO
    AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')
    ORDER BY SAL DESC;

-- 7. ������̺��� BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='BLAKE');

-- 8. ������̺��� MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի����� �˻��Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE HIREDATE>(SELECT HIREDATE FROM EMP WHERE ENAME='MILLER');

-- 9. ������̺��� �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>(SELECT AVG(SAL) FROM EMP);

-- 10. ������̺��� CLARK�� ���� �μ���, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='CLARK') AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);

-- 11. �����ȭ. ������̺��� CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    AND DNAME=(SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK')
    AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);
    
--12. ��� ���̺��� BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի����ڸ� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, HIREDATE FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE') AND ENAME<>'BLAKE';

-- 13. ��� ���̺��� ��� �޿� �̻��� �޴� ��� �������� ���ؼ� ������ ��ȣ�� �̸��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. (�� �޿��� ���� ������ ����Ͽ���.)
SELECT EMPNO, ENAME FROM EMP WHERE SAL>=(SELECT AVG(SAL) FROM EMP) ORDER BY SAL DESC;

-- 14. ��� ���̺��� �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� �������� ���� 
-- ��� ��ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� �����ȣ ������ ����Ͽ���.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%') ORDER BY EMPNO;

-- 15. ��� ���̺��� �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB, SAL FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'); 

-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, SAL FROM EMP WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING');

SELECT ENAME, SAL FROM EMP W
    WHERE EXISTS(SELECT * FROM EMP WHERE EMPNO=W.MGR AND ENAME='KING');
    
-- 17. ��� ���̺��� SALES�μ� ����� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='SALES';
        
-- 18. ��� ���̺��� ������ �μ� 30�� ���� ���޺��� ���� ����� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);

SELECT ENAME FROM EMP WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30);

-- 19. ��� ���̺��� �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP WHERE DEPTNO=10 AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30);

-- 20. ��� ���̺��� FORD�� ������ ���޵� ���� ����� ��� ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP WHERE (JOB, SAL)=(SELECT JOB, SAL FROM EMP WHERE ENAME='FORD') AND ENAME<>'FORD';

-- 21. ��� ���̺��� �̸��� JONES�� ������ JOB�� ���ų� ������ FORD�̻��� ����� ������ �̸�,����,�μ���ȣ,�޿��� ����ϴ� SELECT���� �ۼ�.
--     ��, ������ ���ĺ� ��, ������ ���� ������ ����Ͽ���.
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP 
     WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='JONES')
     OR SAL >= (SELECT SAL FROM EMP WHERE ENAME='FORD')
     ORDER BY JOB, SAL DESC;

-- 22. ��� ���̺��� SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB, SAL FROM EMP WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME IN ('SCOTT','WARD')) 
    AND ENAME NOT IN('SCOTT','WARD');

-- 23. ��� ���̺��� CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO');

-- 24. ��� ���̺��� �μ����� ������ ��� ���޺��� ���� ����� �����ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
-- �μ� �� ��� ����
SELECT EMPNO, ENAME, SAL FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE E.DEPTNO=DEPTNO);

-- 25. ��� ���̺��� �������� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT DEPTNO, ENAME, SAL FROM EMP E
    WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE E.JOB=JOB);

-- 26 ��� ���̺��� ��� �Ѹ� �̻����κ��� ���� ���� �� �ִ� ����� ����,�̸�,�����ȣ,�μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP MANAGER
    WHERE EXISTS(SELECT EMPNO FROM EMP WORKER WHERE WORKER.MGR=MANAGER.EMPNO)
    ORDER BY DEPTNO; 

-- 27. ��� ���̺��� ���� ����� �����ȣ,�̸�,����,�μ���ȣ�� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP MANAGER
    WHERE NOT EXISTS(SELECT EMPNO FROM EMP WORKER WHERE WORKER.MGR=MANAGER.EMPNO); 









