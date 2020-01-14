-- 1. 사번, 이름, 급여를 출력
select pno,pname,pay from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select*from personal where pay between 2000 and 5000;
select*from personal where pay>=2000 and pay<=5000;
select*from personal where pay>=2000 && pay<=5000; -- or 는 || 가능
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno,pname,dno from personal where dno=10 || dno=20;
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno,pname,pay from personal where bonus is null order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정열 같으면 큰 순
select pno, pname, dno, pay from personal order by dno desc;
-- 6. 사번, 이름, 부서명
select pno, pname, dname from personal p, division d where p.dno=d.dno;
-- 7. 사번, 이름, 상사이름
select w.pno, w.pname, m.pname 상사이름 from personal w, personal m where w.manager=m.pno; 
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pno, w.pname, m.pname from personal w left join personal m
	on w.manager=m.pno;
-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal where pname like 's%';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, dname, m.pname 
	from division d, personal w, personal m 
    where d.dno=w.dno and w.manager=m.pno;
-- 11. 부서코드, 급여합계, 최대급여
select p.dno, sum(pay), max(pay) from personal p, division d
	where d.dno=p.dno
    group by dno;
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