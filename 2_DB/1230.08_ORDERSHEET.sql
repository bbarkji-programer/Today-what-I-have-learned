DROP TABLE CART;
DROP TABLE ORDERDETAIL;
DROP TABLE ORDERS;
DROP TABLE MEMBERS;
DROP TABLE PRODUCTS;

CREATE TABLE PRODUCTS(
    pCODE VARCHAR2(5),
    pNAME VARCHAR2(50),
    pPRICE NUMBER(9),
    pSTOCK NUMBER(3),
    PRIMARY KEY(pCODE));
    
CREATE TABLE MEMBERS(
    mNO VARCHAR2(10),
    mNAME VARCHAR2(50),
    mADDR VARCHAR2(255),
    mTEL VARCHAR2(30),
    mMAIL VARCHAR2(40),
    PRIMARY KEY(mNO));

CREATE TABLE ORDERS(
    oNO NUMBER(30),
    mNO VARCHAR2(10),
    oADDR VARCHAR2(255),
    oTEL VARCHAR2(30),
    oDATE DATE,
    PRIMARY KEY(oNO),
    FOREIGN KEY(mNO) REFERENCES MEMBERS(mNO));
    
CREATE TABLE ORDERDETAIL(
    odNO NUMBER(4),
    oNO NUMBER(30) REFERENCES ORDERS(oNO),
    pCODE VARCHAR2(5) REFERENCES PRODUCTS(pCODE),
    QTY NUMBER(3),
    COST NUMBER(9),
    PRIMARY KEY(odNO));
    
CREATE TABLE CART(
    cNO NUMBER(4) PRIMARY KEY,
    mNO VARCHAR2(10) REFERENCES MEMBERS(mNO),
    pCODE VARCHAR2(5) REFERENCES PRODUCTS(pCODE),
    QTY NUMBER(3),
    COST NUMBER(9));

