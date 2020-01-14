show databases;
create database kimdb; -- kimdb 란 공간을 만듦.
use kimdb; -- kimdb 공간에 들어옴 
use world; -- world 공간에 들어옴
show tables; -- select*from tab;
select*from city;
use kimdb;
select database(); -- 내가 지금 어디에 있는지(현재 위치한 database)
drop table if exists major;
create table major(
	major_code int primary key auto_increment,
	major_name varchar(30));
insert into major (major_name) values ('경영정보');
insert into major (major_name) values ('전자공학');
insert into major (major_name) values ('화학공학');
select*from major;
drop table if exists student;
create table student(
	stu_id int primary key,
	name varchar(15),
    major_code int,
    foreign key(major_code) references major(major_code)); -- foreign key 제약조건은 아래에 써야 적용됨.
insert into student values (1001,'홍길동',1);
insert into student values (1002,'김길동',2);
insert into student values (1003,'신길동',9);
select*from student;
select*from student s left join major m 
	on s.major_code=m.major_code; -- outer join
-- 자바(JDBC) 수업시간에 쓸 테이블
drop table if exists division;
create table division (
	dno int primary key, -- 부서코드
    dname varchar(20) not null, -- 부서명
    phone varchar(20) unique, -- 부서전화
    position varchar(20)); -- 부서위치
desc division;
create table personal(
	pno int primary key, -- 사번
    pname varchar(10) not null, -- 이름
    job varchar(15) not null, -- 직책
    manager int, -- 직속상사사번
    startdate date, -- 입사일check
    pay int, -- 급여
    bonus int, -- 보너스 
    dno int, 
    foreign key(dno) references division(dno)); -- foreign key 조건은 젤 아래에 따로 꼭!
desc personal;
insert into division values (10,'finance','02-777-7777','종로');
insert into division values (20,'research','041-888-7777','대전');
insert into division values (30,'sales','02-999-7777','인천');
insert into division values (40,'marketing','02-555-7777','강남');
select*from division;
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);   
select*from personal;
    
-- 1. 사번, 이름, 급여를 출력
select pno,pname,pay from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select*from personal where pay between 2000 and 5000;
select*from personal where pay>=2000 and pay<=5000;
select*from personal where pay>=2000 && pay<=5000; -- or 는 || 가능
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno,pname,dno from personal where dno=10 || dno=20;
select pno,pname,dno from personal where dno in (10,20);
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno,pname,pay from personal where bonus is null order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정열 같으면 큰 순
select pno, pname, dno, pay from personal order by dno desc;
-- 6. 사번, 이름, 부서명
select pno, pname, dname from personal p, division d where p.dno=d.dno;
-- 7. 사번, 이름, 상사이름
select w.pno, w.pname, m.pname 상사이름 from personal w, personal m where w.manager=m.pno; 
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pno, w.pname, ifnull(m.pname,'없음') 상사이름 from personal w left outer join personal m -- 오른쪽에(+) 하는 거랑 똑같음
	on w.manager=m.pno;
select w.pno, w.pname, if(m.pname is null,'없음',m.pname) 상사이름 from personal w left outer join personal m -- 오른쪽에(+) 하는 거랑 똑같음
	on w.manager=m.pno;
-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal where pname like 's%';
select pname from personal where substr(pname,1,1)='s';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, dname, m.pname 
	from division d, personal w, personal m 
    where d.dno=w.dno and w.manager=m.pno;
-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay) from personal group by dno;
-- 12. 부서명, 급여평균, 인원수
select dname, avg(pay), count(*) from personal p, division d
	where d.dno=p.dno
    group by dname;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select p.dno, sum(pay), count(*) from personal p, division d
	where p.dno=d.dno 
    group by dno
    having count(*)>=4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay from personal where pay=(select max(pay) from personal);
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여
select pname, pay from personal where pay > (select avg(pay) from personal);
-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pname, pay, dname from personal p, division d 
	where p.dno=d.dno
    and pay > (select avg(pay) from personal)
    order by dname, pay desc;
-- 17. 자기부서평균보다 급여를 많이 받는 사람 이름, 급여
select pname, pay from personal p where pay > (select avg(pay) from personal
	where dno=p.dno);
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
 select pname, pay, dname from personal p, division d
	where p.dno=d.dno
    and startdate=(select min(startdate) from personal);
-- 19. 이름, 급여, 해당부서평균
select pname, pay, (select avg(pay) from personal p1 where p1.dno=p2.dno) '해당부서 평균' from personal p2;
-- 20. 이름, 급여, 부서명, 해당부서평균
select pname, pay, dname, (select avg(pay) from personal p1 where p1.dno=p2.dno) '해당부서 평균'
	from personal p2, division d
	where p2.dno=d.dno;

-- ORACLE과 다소 다른 단일행함수(컬럼함수)
select concat(pname,'(',job,')의 급여는',pay) from personal; -- concat 무한정 가능
select round(114.7); -- from 절 생략 가능~
select year(startdate) from personal;
select month(startdate) from personal;
select monthname(startdate) from personal; -- 월이름
select dayname(startdate) from personal; -- 요일
select sysdate();
select now(); -- 날짜와 시간
select current_date(); -- 날짜만
select curdate(); -- 날짜만
select current_time(); -- 시간만
select date_format(startdate,'%y년%m월%e일 %a %p %h시 %i분') from personal;
select date_format(now(),'%Y년%m월%e일 %a %H시 %i분');
-- 이름, 급여, 높다 또는 낮다(3000기준)
select pname, pay, if(pay>=3000,'높다','낮다') from personal;
-- Top-N구문
select pname, pay from personal order by pay desc;
select pname, pay from personal order by pay desc limit 0,3; -- 1(0)등부터 3개 출력 (시작하는 등수, 개수) 시작 숫자가 0부터
select pname, pay from personal order by pay desc limit 3,3; -- 4(3)등부터 3개 출력

select pname, format(pay,0) from personal; -- 세 자리 마다 , 찍기 / 소수 점 아래 0자리까지
select pname, format(pay,1) from personal; -- 세 자리 마다 , 찍기 / 소수 점 아래 1자리까지
    
    
    
    