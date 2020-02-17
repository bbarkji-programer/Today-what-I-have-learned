DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY NOT NULL,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    EMAIL VARCHAR2(30),
    BIRTH DATE NOT NULL,
    RDATE DATE NOT NULL,
    ADDRESS VARCHAR2(200));
    
SELECT * FROM MEMBER;

-- 1. ȸ�� ���� �� ���̵� ���� Ȯ��(�ߺ�üũ)
SELECT * FROM MEMBER WHERE ID='AAA'; -- �׳� ���̵� �ִ��� �������� Ȯ��

-- 2. ȸ�� ���� �� INSERT
INSERT INTO MEMBER (ID,PW,NAME,EMAIL,BIRTH,RDATE,ADDRESS) VALUES ('AAA','111','������','AAA@BB.CC','1990-01-01',SYSDATE,'���� ����');

-- 3. �α��� �� �� (ID/PW)
SELECT * FROM MEMBER WHERE ID='AAA'; -- ���̵�� �˻��� ������ �� PW�� PARAM PW�� üũ

-- 4. ID�� DTO ��������
SELECT * FROM MEMBER WHERE ID='AAA'; -- DTO �����ͼ� SET SESSION

-- 5. ȸ�� ���� ����(UPDATE)
UPDATE MEMBER SET PW='222',NAME='������',EMAIL='DDD@EE.FF',BIRTH='1990-02-02',ADDRESS='���� ����' WHERE ID='AAA';

COMMIT;