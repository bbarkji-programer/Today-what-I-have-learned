-- [CUSTOMER]
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('ZZZ','111','고객','010-9999-9999', NULL, '서울시','m','1990-01-08');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('XXX','111','고객','010-9999-9999', NULL, '서울시','m','1990-01-08');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('YYY','111','고객','010-9999-9999', NULL, '서울시','m','1990-01-08');

-- [FILEBOARD]
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '제목', '내용', '파일이름', '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '111.111.11.11');
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'BBB', '제목', '내용', '파일이름', '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '111.111.11.11');
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'CCC', '제목', '내용', '파일이름', '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '111.111.11.11');
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'DDD', '제목', '내용', '파일이름', '111', 2, 1, 1, '111.111.11.11'); -- 2번글에 대한 첫 번째 답변 글

