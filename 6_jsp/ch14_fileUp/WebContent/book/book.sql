DROP TABLE BOOK;
CREATE TABLE BOOK(
	BOOK_ID VARCHAR2(30)PRIMARY KEY, -- 책ID
	BOOK_KIND NUMBER(3) REFERENCES BOOKKIND(BOOK_KIND), -- 책 분류 
	BOOK_TITLE VARCHAR2(60) NOT NULL, -- 책 제목
	BOOK_PRICE NUMBER(6) NOT NULL, -- 책 가격
	BOOK_COUNT NUMBER(6) NOT NULL, -- 책 재고
	AUTHOR VARCHAR2(30) NOT NULL,  -- 저자
	PUBLISHING_COM VARCHAR2(30) NOT NULL, -- 출판사
	PUBLISHING_DATE DATE NOT NULL, 	-- 출판일
	BOOK_IMAGE1 VARCHAR2(30) DEFAULT 'NOTHING.JPG' NOT NULL, -- 책 이미지 파일 이름(실제 이미지는 서버에 저장)
	BOOK_IMAGE2 VARCHAR2(30) DEFAULT 'NOTHING.JPG' NOT NULL,
	BOOK_CONTENT VARCHAR2(4000), 	-- 책 소개
	BOOK_DISCOUNT NUMBER(3) DEFAULT 0,
	BOOK_RDATE DATE DEFAULT SYSDATE 	-- 등록일
);

DROP TABLE BOOKKIND;
CREATE TABLE BOOKKIND(
	BOOK_KIND NUMBER(3) PRIMARY KEY,
	KIND_NAME VARCHAR2(30),
	LOCATION VARCHAR2(50)
);

DROP TABLE BOOK;
DROP TABLE BOOKKIND;
DROP SEQUENCE BOOK_SEQ;

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

-- 책 등록
INSERT INTO BOOK (BOOK_ID, BOOK_TITLE, BOOK_PRICE, BOOK_IMAGE1, BOOK_IMAGE2, BOOK_CONTENT, BOOK_DISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은자바다', 20000, 'NOTHING.JPG', 'NOTHING.JPG', '좋다', 10);
INSERT INTO BOOK (BOOK_ID, BOOK_TITLE, BOOK_PRICE, BOOK_IMAGE1,BOOK_CONTENT, BOOK_DISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은JSP다', 21000, 'NOTHING.JPG', '좋다', 10);
INSERT INTO BOOK (BOOK_ID, BOOK_TITLE, BOOK_PRICE, BOOK_IMAGE2,BOOK_CONTENT, BOOK_DISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은CSS다', 22000, 'NOTHING.JPG', '좋다', 10);
INSERT INTO BOOK (BOOK_ID, BOOK_TITLE, BOOK_PRICE, BOOK_CONTENT, BOOK_DISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은ORACLE이다', 23000, '좋다', 10);

-- 책 목록(신착 도서 순)
SELECT * FROM BOOK ORDER BY BOOK_RDATE DESC; 

-- 책 목록(TOP-N) : 페이징
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BOOK_RDATE DESC)A) 
    WHERE RN BETWEEN 2 AND 3;

-- 등록된 책 개수
SELECT COUNT(*) FROM BOOK;

-- BOOK_ID로 책 가져오기
SELECT * FROM BOOK WHERE BOOK_ID='3';

COMMIT;

DELETE FROM BOOK WHERE BOOK_ID='33';