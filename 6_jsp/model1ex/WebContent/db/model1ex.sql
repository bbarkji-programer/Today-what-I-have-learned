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

-- 1. 회원가입 시 아이디 중복체크
SELECT*FROM CUSTOMER WHERE CID='aaa';
-- 2. 회원가입 SQL
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('aaa','111','홍길동','010-9999-9999', NULL, '서울시 종로구','m','1991-01-01');
-- 3. 로그인할 때 (ID/PW)
SELECT * FROM CUSTOMER WHERE CID='aaa' and CPW='111';
-- 4. ID로 DTO 가져오기
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- 5. 회원정보 수정
UPDATE CUSTOMER SET CPW='111',
                CNAME='엑스맨',
                CTEL = '010-9999-1111',
                CEMAIL='a@a.com',
                CADDRESS='서울시 용산구',
                CBIRTH=to_date('1972-01-12','yyyy-mm-dd'),
                CGENDER = 'm'
        WHERE CID='aaa';
commit;