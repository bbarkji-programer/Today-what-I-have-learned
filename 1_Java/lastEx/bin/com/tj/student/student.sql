DROP TABLE STUDENT;
DROP TABLE MAJOR;
DROP SEQUENCE STUDENT_SQ;

CREATE TABLE MAJOR (
    mNO NUMBER(1,0) PRIMARY KEY,
    mNAME VARCHAR2(50) NOT NULL UNIQUE);

CREATE SEQUENCE STUDENT_SQ
    MAXVALUE 999
    NOCACHE;

CREATE TABLE STUDENT (
    sNO VARCHAR2(10) PRIMARY KEY,
    sNAME VARCHAR2(50),
    mNO NUMBER(1,0) REFERENCES MAJOR(mNO),
    SCORE NUMBER(3,0) DEFAULT 0 CHECK(SCORE>=0 AND SCORE<=100),
    sEXPEL NUMBER(1,0) DEFAULT 0 CHECK(sEXPEL=0 OR sEXPEL=1));

INSERT INTO MAJOR VALUES(1,'컴퓨터공학');
INSERT INTO MAJOR VALUES(2,'경영정보학');
INSERT INTO MAJOR VALUES(3,'산업디자인');
INSERT INTO MAJOR VALUES(4,'정보전자학');
INSERT INTO MAJOR VALUES(5,'연극영화학');

SELECT*FROM STUDENT;
SELECT*FROM MAJOR;

--1
INSERT INTO STUDENT (sNO,sNAME,mNO,SCORE) VALUES 
    (TO_CHAR(SYSDATE,'YYYY')||(SELECT mNO FROM MAJOR WHERE mNAME='컴퓨터공학')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL,'000')),
        '정우성',(SELECT mNO FROM MAJOR WHERE mNAME='컴퓨터공학'),90);

--2
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE
    FROM (SELECT*FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND mNAME='컴퓨터공학' 
    ORDER BY SCORE DESC);

--3
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE
    FROM (SELECT*FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sEXPEL=0 ORDER BY SCORE DESC);


-- 첫 화면에 전공이름들 콤보박스에 추가
SELECT mNAME FROM MAJOR;

-- 학번으로 검색(SNO, SNAME, MNAME, SCORE)
SELECT sNO, sNAME, mNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.mNO=M.mNO AND sNO=20204004;
    
-- 이름으로 검색(SNO, SNAME, MNAME, SCORE)
SELECT sNO, sNAME, mNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.mNO=M.mNO AND sNO='20204004';
SELECT sNO, sNAME, mNAME, SCORE, sEXPEL FROM STUDENT S, MAJOR M 
    WHERE S.mNO=M.mNO AND sNAME='홍길동';
    
-- 전공검색(RANK, sNAME_NO, mNAME_NO,SCORE,sEXPEL)
SELECT ROWNUM RANK, sNAME||'('||sNO||')' sNAME_NO, mNAME||'('||mNO||')' mNAME_NO, SCORE,sEXPEL 
    FROM (SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND mNAME='컴퓨터공학' ORDER BY SCORE DESC);
    
-- 학생입력
INSERT INTO STUDENT (sNO,sNAME,mNO,SCORE) VALUES 
    (TO_CHAR(SYSDATE,'YYYY')||(SELECT mNO FROM MAJOR WHERE mNAME='컴퓨터공학')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL,'000')),
        '정우성',(SELECT mNO FROM MAJOR WHERE mNAME='컴퓨터공학'),90);       
SELECT*FROM STUDENT;
ROLLBACK;

-- 학생수정
UPDATE STUDENT SET sName='신길동', mNO=(SELECT mNO FROM MAJOR WHERE mNAME='컴퓨터공학'), SCORE=100 WHERE sNO='20204004';
SELECT*FROM STUDENT;
ROLLBACK;

-- 학생출력(RANK,NAME_NO,NNAME,SCORE)
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||mNO||')' mNAME_NO, SCORE
    FROM (SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sEXPEL=0 ORDER BY SCORE DESC);
    
-- 제적처리
UPDATE STUDENT SET sEXPEL=1 WHERE SNO=20204004;
ROLLBACK;

-- 제적자출력(RANK,NAME_NO,MNAME,SCORE)
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||mNO||')' mNAME_NO, SCORE
    FROM (SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sEXPEL=1 ORDER BY SCORE DESC);

COMMIT;














