-- VI. SUB QUERY
-- SCOTT �� �ٹ��ϴ� �μ��̸�?
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT'; -- JOIN
SELECT DNAME FROM DEPT WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- ��������
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ��������. *������� : ��������->��������

-- ���������� ���� : ������ ��������, ������ ��������
-- JOB�� MANAGER �� ����� �μ��̸�
SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; -- (������) ��������
SELECT DNAME FROM DEPT WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');

-- (1) ������ ��������
SELECT MAX(SAL) FROM EMP; -- �ְ� �ݾ� SAL
SELECT ENAME, SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP); -- �ְ�ݾ� �޴� ����̸�, �ְ�SAL
SELECT ENAME FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT') AND ENAME<>'SCOTT';-- SCOTT�� ���� �μ��� ����� �ѷ���

INSERT INTO DEPT VALUES (50,'IT','DALLAS');
INSERT INTO EMP VALUES (9999,'ȫ�浿',NULL,NULL,NULL,9000,NULL,50);
ROLLBACK;  -- INSERT ���

 SELECT ENAME FROM EMP E,DEPT D
    WHERE E.DEPTNO=D.DEPTNO
        AND LOC=(SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT')
        AND ENAME<>'SCOTT';-- SCOTT�� ���� �ٹ����� �ٹ��ϴ� ����� �̸�
        
-- SCOTT�� ���� JOB�� ���� ����� ��� ����
SELECT * FROM EMP WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT');     

-- SCOTT�� �޿��� �����ϰų� �� ���� �޴� ����� �̸��� �޿�
SELECT ENAME, SAL FROM EMP WHERE SAL>=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');

-- ���ӻ���� KING�� ����� �̸��� �޿�
SELECT ENAME, SAL FROM EMP WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING'); 

-- ��� �޿� ���ϸ� �޴� ������ ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<=(SELECT AVG(SAL) FROM EMP);

-- �μ� �� �ִ� �޿�, �� �ִ� �޿��� �޴� ����� �̸�, �� ����� �޿�
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
SELECT DEPTNO, SAL, ENAME FROM EMP 
    WHERE (DEPTNO,SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO); -- ���߿�, ������

-- ������ ������ �������� : SCOTT�� JOB�� ����, �μ� ��ȣ�� ���� ����� ��� �ʵ带 ���
SELECT * FROM EMP 
    WHERE (JOB,DEPTNO)=(SELECT JOB, DEPTNO FROM EMP 
                            WHERE ENAME='SCOTT') AND ENAME<>'SCOTT';
                            
-- (2) ������ �������� : ���������� �������� ������ IN, ALL, ANY=SOME, EXISTS
-- DEPTNO, DEPTNO �� �ִ� �޿�, �ִ� �޿� �޴� ��� �̸� ���
SELECT DEPTNO, SAL, ENAME FROM EMP 
    WHERE(DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
    
-- �Ի�⵵, �Ի�� �� �ּұ޿�, �޴� ��� �̸�
SELECT TO_CHAR(HIREDATE, 'YY') YEAR, SAL, ENAME FROM EMP
    WHERE(TO_CHAR(HIREDATE, 'YY'),SAL)
    IN (SELECT TO_CHAR(HIREDATE, 'YY'), MIN(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE, 'YY'))
    ORDER BY YEAR;

-- �޿��� 3000 �̻� �޴� ����� �Ҽӵ� �μ��� ������ �μ����� �ٹ��ϴ� ������� ��� �ʵ�
SELECT DEPTNO FROM EMP WHERE SAL>=3000;
SELECT * FROM EMP 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>=3000);

-- �μ� ���� �Ի����� ���� ���� ����� �μ���ȣ, �̸�, �Ի����� ���
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, ENAME, HIREDATE FROM EMP WHERE(DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);

-- JOB �� ���� ���� ������ �޴� ����� �̸�, JOB, ����
SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB;
SELECT ENAME, JOB, SAL FROM EMP
    WHERE (JOB,SAL) IN (SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB);

-- 30�� �μ� ��� �� �޿��� ���� ���� ������� �� ���� �޿��� �޴� ����� �̸�, �޿�
-- > ���������� Ǯ���,
SELECT SAL FROM EMP WHERE DEPTNO=30; -- ������ ��������
SELECT ENAME, SAL FROM EMP 
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO=30);
-- �Ǵ�
SELECT ENAME, SAL FROM EMP 
    WHERE SAL>(SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);
    
-- 30�� �μ� ��� �޿� �� ���� ���� �� ���� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30);
SELECT ENAME, SAL FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);

-- ���� ���ϰ� �ִ� ������ �����ȣ, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);
-- > EXISTS�� ���ٸ�~
SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
    WHERE EXISTS (SELECT EMPNO FROM EMP WORKER WHERE WORKER.MGR=MANAGER.EMPNO);
SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
    WHERE EXISTS (SELECT EMPNO FROM EMP WHERE MGR=MANAGER.EMPNO);
    
-- ���, �̸�, �μ���ȣ, SAL, ���� �� �μ��� SAL ���(SELECT ���� SUBQUERY)
SELECT EMPNO, ENAME, DEPTNO, SAL, (SELECT ROUND(AVG(SAL)) FROM EMP WHERE DEPTNO=E.DEPTNO) "�޿����" FROM EMP E 
    ORDER BY DEPTNO, SAL DESC;
    
-- ���� ���ϰ� ���� ������ ��� ������ ���
-- EXISTS ������ �̿�
SELECT * FROM EMP MANAGER
    WHERE NOT EXISTS(SELECT EMPNO FROM EMP WORKER WHERE WORKER.MGR=MANAGER.EMPNO);
-- IN ������ �̿�
SELECT * FROM EMP WHERE EMPNO NOT IN (SELECT MGR FROM EMP WHERE MGR IS NOT NULL);
-- SELF JOIN, OUTER JOIN
SELECT M.* FROM EMP W, EMP M WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL;

-- <źź������>
--�μ����� ���� �޿��� ���� �޴� ����� ����(��� ��ȣ, ����̸�, �޿�, �μ���ȣ)�� ���(IN ������ �̿�)
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP
    WHERE (DEPTNO,SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
    
--����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT E.DEPTNO, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    AND ENAME IN (SELECT ENAME FROM EMP WHERE JOB='MANAGER');
    
SELECT DEPTNO, DNAME, LOC FROM DEPT
    WHERE DEPTNO
    IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');

--������ 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND (GRADE,SAL) IN (SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=3000 GROUP BY GRADE);
    
--�����ȭ : �Ի��� �б⺰�� ���� ���� ������ �޴� ������� �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���

SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) QUARTER FROM EMP; -- �б�
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) �б�, MAX(SAL) FROM EMP GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3); -- ��������(�б� �� ���� ���� ����)

SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) �б�, EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM��
    FROM EMP
    WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3),SAL)
    IN (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) �б�, MAX(SAL) FROM EMP GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3))
    ORDER BY �б�;

--SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME, SAL, JOB FROM EMP WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB='SALESMAN');

--SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ��� �����ؼ� ���(ANY)
SELECT ENAME, SAL, JOB FROM EMP WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN');

--������ 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, ����, �Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP WHERE HIREDATE=(SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);

--������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� �̸�, �޿�, ����, �μ���ȣ�� ����ϵ� �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT ENAME, SAL, JOB, DEPTNO FROM EMP WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN') AND DEPTNO<>20;
SELECT ENAME, SAL, JOB, DEPTNO FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN') AND DEPTNO<>20;
    
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
SELECT EMPNO, ENAME, SAL FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');

-- 15.	��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME IN (SELECT ENAME FROM EMP WHERE ENAME LIKE '__N%');






















