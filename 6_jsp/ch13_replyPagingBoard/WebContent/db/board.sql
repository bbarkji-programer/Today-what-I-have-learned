DROP TABLE BOARD;

CREATE TABLE BOARD(
    NUM NUMBER(5) PRIMARY KEY, -- 글 번호(추후 시퀀스로)
    WRITER VARCHAR2(30) NOT NULL, -- 작성자
    SUBJECT VARCHAR2(100) NOT NULL, -- 제목
    CONTENT VARCHAR2(1000) NOT NULL, -- 본문 *무한대 : CLOB
    EMAIL VARCHAR2(30), -- 작성자 이메일 주소
    HIT NUMBER(5) DEFAULT 0, -- 조회수 
    PW VARCHAR2(30) NOT NULL, -- 비밀번호(글 삭제 시 필요)
    REF NUMBER(5) NOT NULL, -- 글 그룹 
    RE_STEP NUMBER(5) NOT NULL, -- 같은 글 그룹끼리 출력 순서(원글:0)
    RE_LEVEL NUMBER(2) NOT NULL, -- 답변 글일 경우 들여쓰기 정도
    IP VARCHAR2(20) NOT NULL, -- 작성자의 IP주소
    RDATE DATE DEFAULT SYSDATE -- 글 쓴 시점(날짜+시간)
    );

-- 글 개수(글 목록이 0이 아니면 긁어올려구 함)
SELECT COUNT(*) FROM BOARD; -- Arraylist의 길이로 유추해도 되긴 됨 
-- 글 목록 (최신 글이 위로)
SELECT * FROM BOARD ORDER BY REF DESC;
-- 글쓰기
SELECT NVL(MAX(NUM),0)+1 FROM BOARD; -- 새로운 글에 할당할 글 번호 
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP)
    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '박지영', '첫 번째 글의 제목', '첫 번째 글의 본문', 'barkji0@naver.com', '111', (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.20.41');
SELECT * FROM BOARD ORDER BY NUM DESC;
-- 글 번호로 글(DTO) 가져오기
SELECT * FROM BOARD WHERE NUM=1;
-- 조회수(HIT) 올리기
UPDATE BOARD SET HIT = HIT+1 WHERE NUM=1;
-- 글 수정하기
UPDATE BOARD SET WRITER = '김지영', SUBJECT = '바꾼 제목', CONTENT = '바꾼 내용', EMAIL = '바꾼메일@.COM', PW='222', IP = '111.111.11.11' WHERE NUM=1;
-- 글 삭제하기
DELETE FROM BOARD WHERE NUM=1 AND PW='222' ;

COMMIT;