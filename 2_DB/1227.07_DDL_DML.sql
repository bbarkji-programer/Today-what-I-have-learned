-- 7��. DDL(Data Definition Language),DML(Data Manipulation Language)
-- DDL(Data Definition Language) : ���̺� ����, ���̺� ���� ����, ���̺� ����
    -- (1) CREATE TABLE : ���̺� ����
    CREATE TABLE BOOK(
        BOOKID NUMBER(4),
        BOOKNAME VARCHAR2(100),
        PUBLISHER VARCHAR2(20),
        PRICE NUMBER(7),
        PRIMARY KEY(BOOKID) );
    CREATE TABLE BOOK(
        BOOKID NUMBER(4) PRIMARY KEY,
        BOOKNAME VARCHAR2(100),
        PUBLISHER VARCHAR2(20),
        PRICE NUMBER(7) );
    SELECT * FROM BOOK;
    DESC BOOK;
    SELECT * FROM EMP;
    SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ���̺� ��� �� ���� ������ �ڵ����� �Ű���
    SELECT ROWNUM, BOOKID, BOOKNAME, PRICE FROM BOOK;

    -- EMP01 - EMPNO(NUMBER(4)), ENAME(VARCHAR2(20)), SAL(NUMBER(7,2))
    CREATE TABLE EMP01(
        EMPNO NUMBER(4) PRIMARY KEY,
        ENAME VARCHAR2(20),
        SAL NUMBER(7,2) );
    SELECT * FROM EMP01;
    
    -- DEPT01 - DEPTNO(NUMBER(2)), DNAME(VARCHAR(14)), LOC(VARCHAR2(13))
    CREATE TABLE DEPT01(
        DEPTNO NUMBER(2),
        DNAME VARCHAR2(14),
        LOC VARCHAR2(13) );
        
    -- ���������� �̿��� CREATE TABLE
    -- EMP���̺�� ���� ���� ���� �����Ͱ� ����ִ� EMP02 ���̺� ����
    CREATE TABLE EMP02 
        AS 
        SELECT * FROM EMP; --> SELECT���� ���� ����� EMP02�� ��. ������ �����͸�. ���������� �ȵ�.
    
    SELECT * FROM EMP02;
    DESC EMP02;
    DESC EMP;
    
    -- EMP ���̺��� ���, �̸�, �μ���ȣ �ʵ常 ī���� EMP03 ����
    CREATE TABLE EMP03 AS SELECT EMPNO, ENAME, DEPTNO FROM EMP;
    SELECT * FROM EMP03;
    DESC EMP03;
    
    -- EMP ���̺��� �̸�, �޿� �� ī�Ǹ� EMP04 ����
    CREATE TABLE EMP04 AS SELECT ENAME, SAL FROM EMP;
    SELECT * FROM EMP04;
    
    -- EMP ���̺��� 10�� �μ� ������ ��� �����͸� ī���� EMP05 ����
    CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE DEPTNO=10;
    SELECT * FROM EMP05;
    
    SELECT * FROM EMP WHERE DEPTNO=0;
    
    -- EMP ���̺� ������ ī���� EMP06 ���̺� ����(�����ʹ� ���� ���̺�)
    CREATE TABLE EMP06 AS SELECT * FROM EMP WHERE 1=0; --> �׻� ������ �Ǵ� ������ WHERE����
    SELECT * FROM EMP06;
    
    -- DEPT ���̺� ������ ī���� DEPT02 ���̺� ����(�����ʹ� ���� ���̺�)
    CREATE TABLE DEPT02 AS SELECT * FROM DEPT WHERE 1=0;
    SELECT * FROM DEPT02;
    
    SELECT * FROM TAB;  

    -- (2) ALTER TABLE : ���̺� ���� ���� (�������̸� �ٲٸ� �ȵ�...)
    -- �� ALTER TABLE ���̺��̸� ADD(�ʵ��̸� �� Ÿ��, ...); : ���ο� �ʵ带 �߰�  
          DESC EMP03; -- ���, �̸�, �μ���ȣ
          ALTER TABLE EMP03
          ADD(
          JOB VARCHAR2(10),
          SAL NUMBER(9,2) ); -- JOB, SAL  �߰�
          SELECT * FROM EMP03; 
          ALTER TABLE EMP03
          ADD(
          MGR NUMBER(4) );
          SELECT * FROM EMP03;
          
    -- �� ALTER TABLE ���̺��̸� MODIFY(�ʵ��̸� �� Ÿ��, ...); : ���� �ʵ��� Ÿ�� ����
          ALTER TABLE EMP03
          MODIFY(
          EMPNO VARCHAR2(5) ); --�̹� �ٸ� Ÿ���� �����Ͱ� ������ ������ Ÿ�� ���� �Ұ���.
          ALTER TABLE EMP03
          MODIFY(
          JOB VARCHAR2(20)  ); 
          ALTER TABLE EMP03 
          MODIFY(
          ENAME VARCHAR2(5)); -- �̹� ����ִ� �����ͺ��� ���� ����? ������? �� ���� �Ұ���.
          ALTER TABLE EMP03 
          MODIFY(
          ENAME VARCHAR2(30));
          
    -- �� ALTER TABLE ���̺��̸� DROP COLUMN(�ʵ��̸�); : ���� �ִ� Ư�� �ʵ� ���� 
          -- �������� ���� ���ٴ� ������ ������ ���� �� ��, �������� �ʴ� ������ �������� ���� 
          -- ������ ����
          ALTER TABLE EMP03 DROP COLUMN JOB;
          ALTER TABLE EMP03 DROP COLUMN DEPTNO;
          SELECT * FROM EMP03; 
          
          -- ���� ����(�������� Ư�� �ʵ带 ���� ���ϵ��� ��)
          ALTER TABLE EMP03 SET UNUSED(SAL);
          SELECT * FROM EMP03; -- SAL�� �Ⱥ������� ��¥ �������� �ƴ�...
          ALTER TABLE EMP03 DROP UNUSED COLUMNS; -- ���� ���� �Ұ� �ʵ带 ���������� ����
        
    -- (3) DROP TABLE ���̺��̸�; : ���̺� ����
          DROP TABLE EMP01;
          
    -- (4) TRUNCATE TABLE ���̺��̸�; : ���̺��� ��� �����͸� ����(DDL ; ��ҺҰ�)      
          TRUNCATE TABLE EMP02;     
          SELECT * FROM EMP02; -- �������߸�
    
    -- (5) RENAME �������̺��̸� TO ���ο� ���̺��̸� : ���̺� �̸��� ����
         RENAME EMP02 TO EMP2;
    
    -- (6) DDL ��ɾ �����ϸ�, ������ ����(�ý��� ���̺�) ������ (����Ŭ�� ����)
        -- ����ڴ� ������ ��ųʸ��� ����X, �˻�X. ������� ���� ������ �ȵǰ� �� ���� ����....... 
        -- ������ ��ųʸ� �� �� �̿� ����~
        -- ���� : DBA_XXX, ALL_XXX, USER_XXX
        SELECT * FROM USER_TABLES; -- USER�� ���� ���̺� ����
        SELECT * FROM USER_INDEXES; -- USER�� ���� �ε��� ����
        SELECT * FROM USER_CONSTRAINTS; -- USER�� ���� �������� ����
         SELECT * FROM USER_VIEWS; -- USER�� ���� �� ����
         
        SELECT * FROM DBA_TABLES; -- �ý����� ���� ���̺� ����
        SELECT COUNT(*) FROM DBA_TABLES;
        SELECT TABLE_NAME FROM DBA_TABLES;     
        SELECT * FROM DBA_CONSTRAINTS; -- �ý����� ���� �������� ����       
        SELECT * FROM DBA_VIEWS; -- DBA(�ý���)�� ���� �� ����
        
        SELECT * FROM ALL_TABLES; -- ������ �ο� ���� ��� ���̺� ����
        SELECT * FROM ALL_INDEXES; -- ������ �ο� ���� ��� �ε��� ����
        SELECT * FROM ALL_CONSTRAINTS; -- ������ �ο� ���� ��� �������� ����
        SELECT * FROM ALL_VIEWS; -- ������ �ο� ���� ��� �� ����
        
        SHOW USER; 
        
-- DML(Data Manipulation Language) : ������ �Է�(INSERT��), ������ ����(UPDATE��), ������ ����(DELETE��), ������ �˻�(SELECT��)
    -- (1) INSERT INTO ���̺�� (�ʵ��1, �ʵ��2, ...) VALUES (��1, ��2.....); : ������ �Է�(INSERT��)
    SELECT * FROM DEPT01;
    
    INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
        VALUES (10, 'MARKETING', 'SEOUL');
        
    SELECT * FROM DEPT01;
    
    INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
        VALUES (20, 'SALES', 'SYDNEY');
        
    SELECT * FROM DEPT01;
    
    DESC DEPT01;
    
    INSERT INTO DEPT (DEPTNO, DNAME, LOC)
        VALUES (10, 'IT', 'SANFRAN'); -- PRIMARY KEY�� �ߺ��� ���̳� NULL ���� �Ұ�
    
     INSERT INTO DEPT (DEPTNO, DNAME, LOC)
        VALUES (NULL, 'IT', 'SANFRAN'); -- PRIMARY KEY�� �ߺ��� ���̳� NULL ���� �Ұ�
    
    -- DEPT01 20,'IT', NULL
    INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
        VALUES (20, 'IT', NULL);
        
    SELECT DEPTNO, DNAME, NVL(LOC, '�繫�Ǹ�����') FROM DEPT01;
    
    -- DEPT01 30,'SALES',NULL
    INSERT INTO DEPT01 (DEPTNO, DNAME)
        VALUES (30, 'SALES');
    
    SELECT * FROM DEPT01;
    
    INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (40,'��ȹ','���'); -- �̷��� ���� �Ȱ��� �ҰŸ� VALUES �տ� ���� ����
    INSERT INTO DEPT01 VALUES (40,'��ȹ','���'); -- �̷��� ���̴� ��� ������ų�, ���� �ٲٸ� �ȵ�.....
    
    SELECT * FROM DEPT01; 
    
    -- DEPT ���̺��� ����(10-30)�� DEPT02 ���̺� �߰�
    INSERT INTO DEPT02 SELECT * FROM DEPT;
    SELECT * FROM DEPT02;
    INSERT INTO DEPT02 SELECT * FROM DEPT WHERE DEPTNO<30;
    SELECT * FROM DEPT02;
    
    -- �� DDL �������� ~~~~
    DROP TABLE SAM01;
    
    CREATE TABLE SAM01(
    EMPNO NUMBER(4) CONSTRAINT C_SAM PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2) );
    
    SELECT * FROM USER_CONSTRAINTS;
    SELECT * FROM USER_INDEXES;
    SELECT * FROM SAM01;
    
    INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL) VALUES (1000, 'APPLE', 'POLICE', 10000);    
    INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
    INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
    INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1030, 'VERY', 25000);
    INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1040, 'CAT', 2000);
    INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10;
    
    -- (2) UPDATE ���̺��̸� SET �ʵ��1=��1, �ʵ��2=��2 WHERE ����; : ������ ����(UPDATE��)
    CREATE TABLE EMP01 AS SELECT * FROM EMP;
    SELECT * FROM EMP01;     
    UPDATE EMP01 SET DEPTNO=30;
    
        -- ��� ������ SAL�� 10���� �λ�
        UPDATE EMP01 SET SAL=SAL*1.1;
        -- ��� ������ �Ի����� ��������
        UPDATE EMP01 SET HIREDATE=SYSDATE;
        -- �޿��� 3000 �̻��� ����� �޿��� 10% �λ�
        UPDATE EMP01 SET SAL=SAL*1.1 WHERE SAL>=3000;
        -- �ٹ����� 'DALLAS'�� ����� SAL�� 1000 �λ�
        DROP TABLE EMP01;
        CREATE TABLE EMP01 AS SELECT * FROM EMP;
        UPDATE EMP01 SET SAL=SAL+10000 WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
        SELECT * FROM EMP01;
        -- SCOTT ����� �μ���ȣ�� 20����, ����(JOB)�� MANAGER�� ����
        UPDATE EMP01 SET DEPTNO=20, JOB='MANAGER' WHERE ENAME='SCOTT';
        -- SMITH�� �Ի����ڸ� ���÷�, �޿�(SAL)�� 5000���� COMM�� 400���� ����
        UPDATE EMP01 SET HIREDATE=SYSDATE, SAL=5000, COMM=400 WHERE ENAME='SMITH';
        -- DEPT01 ���� 20�� �μ��� �������� 40�� �μ��� ���������� �����ϱ�
        DROP TABLE DEPT01;
        CREATE TABLE DEPT01 AS SELECT * FROM DEPT;
        UPDATE DEPT01 SET LOC=(SELECT LOC FROM DEPT01 WHERE DEPTNO=40) WHERE DEPTNO=20;
        SELECT * FROM DEPT01;
        -- DEPT01 ���� 30�� �μ��� ������� �μ����� 40�� �μ��� ������� �μ������� ����
        UPDATE DEPT01 SET (DNAME, LOC)=(SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO=40) WHERE DEPTNO=30;
        -- EMP01 ���� ��� ����� �޿��� �Ի����� KING�� ���� ������ �����ϴ� UPDATE
        UPDATE EMP01 SET (SAL, HIREDATE)=(SELECT SAL, HIREDATE FROM EMP01 WHERE ENAME='KING');
        SELECT * FROM EMP01;
    
    -- (3) DELETE FROM ���̺�� WHERE ���� : ������ ����(DELETE��)
    DELETE FROM DEPT01;
    ROLLBACK; --- DML�� ROLLBACK ����
    TRUNCATE TABLE DEPT01; -- DDL�� ROLLBACK �Ұ���
    SELECT * FROM DEPT01;
        -- EMP01 ���̺��� 30�� �μ� ���� ����
        DELETE FROM EMP01 WHERE DEPTNO=30;
        SELECT * FROM EMP01;
        -- SAM01 ���̺��� JOB�� ���� �� ����
        DELETE FROM SAM01 WHERE JOB IS NULL;
        SELECT * FROM SAM01;
        -- EMP01 ���̺��� �μ����� SALES �� �μ� ���� ����
        DELETE FROM EMP01 WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');    

-- �� ��������
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999,'ȫ',50);
    
-- �������ǿ� ���� ���̺� ����
DROP TABLE DEPT1;

CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14) UNIQUE NOT NULL,
    LOC VARCHAR2(13) NOT NULL );
    
SELECT * FROM DEPT1;

DROP TABLE EMP1;

CREATE TABLE EMP1(
    EMPNO NUMBER(4) PRIMARY KEY, -- PRIMARY KEY ��������
    ENAME VARCHAR2(10) UNIQUE, -- UNIQUE ��������
    JOB VARCHAR2(9) NOT NULL, -- NOT NULL ��������
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE, -- ����θ� �ڵ����� ���� ��¥�� ���� ����(�⺻�� �ο�)
    SAL NUMBER(7,2) CHECK (SAL>=0), -- 0���� ū ���� ���� ����
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) REFERENCES DEPT1(DEPTNO)   );-- �ܷ�Ű(FOREIGH KEY) �������� : DEPT1�� DEPTNO�� �״�� ��������  

-- MYSQL ������ �ִ��� ����Ű�� �Ʒ������� ���ƾ�...    
CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9) NOT NULL, -- NOT NULL ��������
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE, -- ����θ� �ڵ����� ���� ��¥�� ���� ����(�⺻�� �ο�)
    SAL NUMBER(7,2) CHECK (SAL>=0), -- 0���� ū ���� ���� ����
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    PRIMARY KEY(EMPNO),-- PRIMARY KEY ��������
    UNIQUE(ENAME), -- UNIQUE ��������
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO)    );-- �ܷ�Ű(FOREIGH KEY) �������� : DEPT1�� DEPTNO�� �״�� ��������      

-- DEPT1 
INSERT INTO DEPT1 VALUES (10,'ȸ��','����');
INSERT INTO DEPT1 VALUES (20,'��ȹ','���');
INSERT INTO DEPT1 VALUES (30,'����','�߱�');

--EMP1
INSERT INTO EMP1 VALUES (1000,'SMITH','MANAGER',2000,'81/01/01',800,NULL,10);
INSERT INTO EMP1 (EMPNO, ENAME, JOB, SAL, DEPTNO) VALUES
    (2000,'SCOTT','SALESMAN',2000,30);
INSERT INTO EMP1 (EMPNO, ENAME, JOB, HIREDATE, SAL, DEPTNO) VALUES
    (3000,'WARD','SALESMAN',NULL,3000,20);
SELECT * FROM EMP1; 

DROP TABLE EMP1;
DROP TABLE DEPT1;

-- DML ������ ������ ���̽��� ��� (ROLLBACK �ȵ�)
COMMIT;







    