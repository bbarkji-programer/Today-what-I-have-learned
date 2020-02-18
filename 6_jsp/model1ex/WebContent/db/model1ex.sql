DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER(
    cID VARCHAR2(50) PRIMARY KEY,
    cPW VARCHAR2(50) NOT NULL,
    cNAME VARCHAR2(50) NOT NULL,
    cTEL VARCHAR2(50) NOT NULL,
    cEMAIL VARCHAR2(50),
    cADDRESS VARCHAR2(250),
    cGENDER VARCHAR2(10) NOT NULL,
    cBIRTH DATE NOT NULL,
    cRDATE DATE DEFAULT SYSDATE
);

SELECT*FROM CUSTOMER;

-- 1. ȸ������ �� ���̵� �ߺ�üũ
SELECT*FROM CUSTOMER WHERE CID='aaa';
-- 2. ȸ������ SQL
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('aaa','111','ȫ�浿','010-9999-9999', NULL, '����� ���α�','m','1991-01-01');
-- 3. �α����� �� (ID/PW)
SELECT * FROM CUSTOMER WHERE CID='aaa' and CPW='111';
-- 4. ID�� DTO ��������
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- 5. ȸ������ ����
UPDATE CUSTOMER SET CPW='111',
                CNAME='������',
                CTEL = '010-9999-1111',
                CEMAIL='a@a.com',
                CADDRESS='����� ��걸',
                CBIRTH=to_date('1972-01-12','yyyy-mm-dd'),
                CGENDER = 'm'
        WHERE CID='aaa';
commit;