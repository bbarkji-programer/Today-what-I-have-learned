DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID VARCHAR2(20) PRIMARY KEY,
    PW VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    PHONE1 VARCHAR2(10),
    PHONE2 VARCHAR2(10),
    PHONE3 VARCHAR2(10),
    GENDER VARCHAR2(10)
);
-- ȸ������(id, pw, name, phone1, phone2, phone3, gender)
INSERT INTO MEMBER VALUES ('kkk','111','������','010','5091','0108','f');

-- �α���(id,pw)
-- 1. id�� pw�� �´���?
-- 2. id�� ������ �� ���̵��� ����� ����(session�� �߰�)
SELECT * FROM MEMBER WHERE ID='aaa'  AND PW='111';
-- ȸ����������
UPDATE MEMBER SET NAME='������',PW='111',PHONE1='010', PHONE2='5091', PHONE3='0108', GENDER='f'
    WHERE ID='aaa';
COMMIT;
SELECT*FROM MEMBER;

SELECT*FROM MEMBER WHERE ID='AAA';

