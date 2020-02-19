DROP TABLE BOARD;

CREATE TABLE BOARD(
    NUM NUMBER(5) PRIMARY KEY, -- �� ��ȣ(���� ��������)
    WRITER VARCHAR2(30) NOT NULL, -- �ۼ���
    SUBJECT VARCHAR2(100) NOT NULL, -- ����
    CONTENT VARCHAR2(1000) NOT NULL, -- ���� *���Ѵ� : CLOB
    EMAIL VARCHAR2(30), -- �ۼ��� �̸��� �ּ�
    HIT NUMBER(5) DEFAULT 0, -- ��ȸ�� 
    PW VARCHAR2(30) NOT NULL, -- ��й�ȣ(�� ���� �� �ʿ�)
    REF NUMBER(5) NOT NULL, -- �� �׷� 
    RE_STEP NUMBER(5) NOT NULL, -- ���� �� �׷쳢�� ��� ����(����:0)
    RE_LEVEL NUMBER(2) NOT NULL, -- �亯 ���� ��� �鿩���� ����
    IP VARCHAR2(20) NOT NULL, -- �ۼ����� IP�ּ�
    RDATE DATE DEFAULT SYSDATE -- �� �� ����(��¥+�ð�)
    );

-- �� ����(�� ����� 0�� �ƴϸ� �ܾ�÷��� ��)
SELECT COUNT(*) FROM BOARD; -- Arraylist�� ���̷� �����ص� �Ǳ� �� 
-- �� ��� (�ֽ� ���� ����)
SELECT * FROM BOARD ORDER BY REF DESC;
-- �۾���
SELECT NVL(MAX(NUM),0)+1 FROM BOARD; -- ���ο� �ۿ� �Ҵ��� �� ��ȣ 
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP)
    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '������', 'ù ��° ���� ����', 'ù ��° ���� ����', 'barkji0@naver.com', '111', (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.20.41');
SELECT * FROM BOARD ORDER BY NUM DESC;
-- �� ��ȣ�� ��(DTO) ��������
SELECT * FROM BOARD WHERE NUM=1;
-- ��ȸ��(HIT) �ø���
UPDATE BOARD SET HIT = HIT+1 WHERE NUM=1;
-- �� �����ϱ�
UPDATE BOARD SET WRITER = '������', SUBJECT = '�ٲ� ����', CONTENT = '�ٲ� ����', EMAIL = '�ٲ۸���@.COM', PW='222', IP = '111.111.11.11' WHERE NUM=1;
-- �� �����ϱ�
DELETE FROM BOARD WHERE NUM=1 AND PW='222' ;

COMMIT;