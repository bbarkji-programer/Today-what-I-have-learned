-- DCL : CREATE USER~, ALTER USER~, GRANT, REVOKE, DROP USER~
    -- DCL ��ɾ�� DBA ������ �ִ� ������ ����(�Ϲ�����X)
CREATE USER PARK IDENTIFIED BY JIYEONG; -- ����� ����(���� �ο��� ���� ���ؼ� �α����� �ȵȴ�.)
ALTER USER PARK IDENTIFIED BY tiger; -- ��й�ȣ ����(��й�ȣ�� ��ҹ��ڸ� �����Ѵ�.)
SELECT*FROM EMPV1;
GRANT CREATE SESSION TO PARK; -- �α��� ����(SESSION) �ο�
-- ������ GRANT(���Ѻο�) ���� �ʰ� '���Ѱ�ü'�� ���� �� ���� ������ �ִ� ���
CREATE ROLE ROLLEX1; -- ROLLEX1���� ��ü ����
-- ROLLEX1=�α���,���̺����,�� ���� ������ �ο��� '���Ѱ�ü'
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW TO ROLLEX1;
GRANT ROLLEX1 TO PARK; -- PARK�� ROLLEX1����(�α���,���̺����,��) ���� �ο�
GRANT SELECT ON EMPV1 TO PARK; -- PARK�� SCOTT�� ���� �ִ� EMPV1 ���̺��� SELECT �� �� �ִ� ���� �ο�
GRANT ALL ON EMPV1 TO PARK; -- PARK���� EMPV1 �� ���̺� ��� ���� �ο�

SELECT*FROM EMPV1;
SELECT*FROM EMP;
SHOW USER;
GRANT ALL ON SALGRADE TO PARK;
REVOKE ALL ON SALGRADE FROM PARK; -- ���� ����
GRANT SELECT ON SALGRADE TO PARK; -- SELECT ���Ѹ� ��

-- ���� ���ַ��� ���ַ��� ������ ���� ���� ���¿��� ��.
DROP USER PARK CASCADE; -- ����� ����