-- 셤 연습문제 테이블 생성
DROP TABLE MY_DATA;

CREATE TABLE MY_DATA (
    ID NUMBER(4),
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10,2),
    PRIMARY KEY(ID));

INSERT INTO MY_DATA (ID, NAME, USERID, SALARY) VALUES
    (1,'Scott','sscott',TO_NUMBER('10,000.00','99,999.99'));
INSERT INTO MY_DATA VALUES (2,'Ford','fford',TO_NUMBER('13,000.00','99,999.99'));
INSERT INTO MY_DATA VALUES (3,'Patel','ppatel',33000);
INSERT INTO MY_DATA VALUES (4,'Report','rreport',23500);
INSERT INTO MY_DATA VALUES (5,'Good','ggood',44450.00);

SELECT * FROM MY_DATA;

COMMIT;

UPDATE MY_DATA SET SALARY=65000 WHERE ID=3;
COMMIT;

DELETE FROM MY_DATA WHERE ID=3;
COMMIT;

DELETE FROM MY_DATA WHERE INICAP(NAME)='Ford';

UPDATE MY_DATA SET SALARY=15000 WHERE NAME IN (SELECT NAME FROM MY_DATA WHERE SALARY<=15000);

DROP TABLE MY_DATA;