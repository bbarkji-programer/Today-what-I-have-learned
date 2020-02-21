-- 초기화
DROP TABLE FILEBOARD;
DROP TABLE CUSTOMER;
DROP TABLE BOOK;
DROP SEQUENCE BOOK_SEQ;

-- CUSTOMER
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

-- BOOK
CREATE SEQUENCE BOOK_SEQ 
    MAXVALUE 9999999 
    NOCACHE
    NOCYCLE;

CREATE TABLE BOOK(
    BOOK_ID NUMBER(7) PRIMARY KEY,
    BOOK_TITLE VARCHAR2(30) NOT NULL, 
    BOOK_PRICE NUMBER(7) NOT NULL,
    BOOK_IMAGE1 VARCHAR2(30) DEFAULT 'NOTHING.JPG' NOT NULL,
    BOOK_IMAGE2 VARCHAR2(30) DEFAULT 'NOTHING.JPG' NOT NULL,
    BOOK_CONTENT VARCHAR2(4000),
    BOOK_DISCOUNT NUMBER(3) NOT NULL, -- 할인율
    BOOK_RDATE DATE DEFAULT SYSDATE -- 책 등록일
);

-- FILEBOARD
CREATE SEQUENCE FILEBOARD_SEQ
    MAXVALUE 9999999
    NOCACHE
    NOCYCLE;

CREATE TABLE FILEBOARD(
    fNUM NUMBER(7) PRIMARY KEY,
    cID VARCHAR2(50) REFERENCES CUSTOMER(cID),
    fSUBJECT VARCHAR2(250) NOT NULL,
    fCONTENT VARCHAR2(4000),
    fFILENAME VARCHAR2(50),
    fPW VARCHAR2(50) NOT NULL,
    fHIT NUMBER(7) DEFAULT 0,
    fREF NUMBER(7) NOT NULL,
    fRE_STEP NUMBER(7) NOT NULL,
    fRE_LEVEL NUMBER(7) NOT NULL,
    fIP VARCHAR2(50) NOT NULL,
    fRDATE DATE DEFAULT SYSDATE
);    

SELECT*FROM CUSTOMER;
SELECT*FROM BOOK;
SELECT*FROM FILEBOARD;

COMMIT;