-- employees. 'Munich' 도시에 위치한 부서에 소속된 직원들 명단?

select * from employees;
select * from departments;
select * from locations;

select city from locations where city = 'Munich';
select department_id from departments where location_id = 2700;
select * from employees where department_id = 70;

select * from employees where department_id = (select department_id from departments where location_id = (select location_id from locations where city = 'Munich'));

-- 서브쿼리 사용하려면 필요한 값을 select 해서 앞에 값에 전달해줘야 한다..


-- tblMan. tblWoman. 서로 짝이 있는 사람 중 남자와 여자의 정보를 모두 가져오시오.
--    [남자]        [남자키]   [남자몸무게]     [여자]    [여자키]   [여자몸무게]
--    홍길동         180       70              장도연     177        65
--    아무개         175       null            이세영     163        null
--    ..

select * from tblMan;
select * from tblWoman;

select 
    m.name as "[남자]",
    m.height as "[남자키]",
    m.weight as "[남자몸무게]",
    w.name as "[여자]",
    w.height as "[여자키]",
    w.weight as "[여자몸무게]"
from tblMan m inner join tblWoman w on m.couple = w.name;


select 
    name as "[남자]", height as "[남자키]" , weight as "[남자몸무게]",
    couple as "[여자]",
    (select height from tblWoman where tblman.couple = name) as "[여자키]",
    (select weight from tblWoman where tblman.couple = name) as "[여자몸무게]"
from tblMan where couple is not null;



-- tblAddressBook. 가장 많은 사람들이 가지고 있는 직업은 주로 어느 지역 태생(hometown)인가?
select * from tblAddressBook;

select distinct hometown from tblAddressBook where job = (select job from tblAddressBook group by job having count(*) = (select max(count(*)) from tblAddressBook group by job));


-- tblAddressBook. 이메일 도메인들 중 평균 아이디 길이가 가장 긴 이메일 사이트의 도메인은 무엇인가? ★★★★★★★★★★★
select 
    substr(email, instr(email, '@') +1),
    avg(length(substr(email,1,instr(email,'@')-1)))
from tblAddressBook 
group by substr(email, instr(email, '@') +1) 
having avg(length(substr(email, 1, instr(email, '@') -1)))
    = 
(select max(avg(length(substr(email, 1, instr(email, '@') -1)))) 
from tbladdressbook group by substr(email, instr(email, '@') +1));



-- tblAddressBook. 평균 나이가 가장 많은 출신(hometown)들이 가지고 있는 직업 중 가장 많은 직업은? ★★★★★★★★★★★
select * from tblAddressBook;

select
    job
from tblAddressBook
    where hometown = (select hometown from tbladdressBook group by hometown 
    having avg(age) = (select max(avg(age)) from tblAddressBook group by hometown)) group by job
        having count(*) = (select max(count(*)) from tblAddressBook where hometown = (select hometown from tblAddressBook group by hometown 
        having avg(age) = (select max(avg(age)) from tblAddressBook group by hometown)) group by job);


-- tblAddressBook. 남자 평균 나이보다 나이가 많은 서울 태생 + 직업을 가지고 있는 사람들을 가져오시오. ★★★★★★★★★★★
select avg(age) from tblAddressBook where gender = 'm';

select * from tblAddressBook where age > (select avg(age) from tblAddressBook where gender = 'm') and hometown = '서울' and job not in('백수', '취업준비생');


-- tblAddressBook. gmail.com을 사용하는 사람들의 성별 > 세대별(10,20,30,40대) 인원수를 가져오시오. ★★★★★★★★★★★
select * from tblAddressBook;
select 
    case
        when gender = 'm' then '남자'
        when gender = 'f' then '여자'
    end as "[성별]",
    count(case
        when age between 10 and 19 then 1
    end) as "10대",
    count(case
        when age between 20 and 29 then 1
    end) as "20대",
    count(case
        when age between 30 and 39 then 1
    end) as "30대",
    count(case
        when age between 40 and 49 then 1
    end) as "40대"
from tblAddressBook where email like ('%gmail.com') group by gender;



-- tblAddressBook. 가장 나이가 많으면서 가장 몸무게가 많이 나가는 사람과 같은 직업을 가지는 사람들을 가져오시오.  ★★★★★★★★★★★

select max(age), max(weight) from tblAddressBook;
select * from tblAddressBook where job = '구급대원';

-- 내풀이
select * from tblAddressBook where job = (select job from tblAddressBook
where age = (select max(age) from tblAddressBook) and weight = (select max(weight) from tblAddressBook));

-- T.풀이
SELECT * FROM tbladdressbook where job = (SELECT job FROM tbladdressbook
where weight = (SELECT max(weight) FROM tbladdressbook where age = (SELECT max(age) FROM tbladdressbook)) and age = (SELECT max(age) FROM tbladdressbook));


-- tblAddressBook.  동명이인이 여러명 있습니다. 이 중 가장 인원수가 많은 동명이인(모든 이도윤)의 명단을 가져오시오.
select * from tblAddressBook where name = (select name from tblAddressBook group by name having count(*) = (select max(count(*)) from tblAddressBook group by name));



-- tblAddressBook. 가장 사람이 많은 직업의(332명) 세대별 비율을 구하시오.
--    [10대]       [20대]       [30대]       [40대]
--    8.7%        30.7%        28.3%        32.2%

select job,
    round(count(case
        when age between 10 and 19 then 1
    end) / count(*) * 100, 1) || '%' as "[10대]",
    round(count(case
        when age between 20 and 29 then 1
    end) / count(*) * 100, 1) || '%' as "[20대]",
    round(count(case
        when age between 30 and 39 then 1
    end) / count(*) * 100, 1) || '%' as "[30대]",
    round(count(case
        when age between 40 and 49 then 1
    end) / count(*) * 100, 1) || '%' as "[40대]"
from tblAddressBook group by job having count(job) = (select max(count(job)) from tblAddressBook group by job);




-- tblStaff, tblProject. 현재 재직중인 모든 직원의 이름, 주소, 월급, 담당프로젝트명을 가져오시오.
select * from tblStaff;
select * from tblProject;

select * from tblStaff s
    left outer join tblProject p
        on s.seq = p.staff_seq;

       
       
-- tblVideo, tblRent, tblMember. '뽀뽀할까요' 라는 비디오를 빌려간 회원의 이름은?
select * from tblVideo;
select * from tblRent;
select * from tblMember;


select 
    m.name
from tblVideo v 
    inner join tblRent r 
        on v.seq = r.video 
            inner join tblMember m 
                on r.member = m.seq
     where v.name = '뽀뽀할까요';
     
    
-- tblStaff, tblProejct. 'TV 광고'을 담당한 직원의 월급은 얼마인가?

select s.name, s.salary from tblStaff s inner join tblProject p on s.seq = p.staff_seq where p.project = 'TV 광고';

    
-- tblVideo, tblRent, tblMember. '털미네이터' 비디오를 한번이라도 빌려갔던 회원들의 이름은?
select * from tblVideo;
select * from tblRent;
select * from tblMember;

select m.name from tblMember m inner join tblRent r on m.seq = r.member inner join tblVideo v on r.video = v.seq where v.name = '털미네이터';
-- 중복이 존재한다면 distinct m.name을 하면 된다.
-- rent 데이터가 없는 사람들은 안가져오는게 좋을지도?? and r.rentdate is not null;

                
-- tblStaff, tblProject. 서울시에 사는 직원을 제외한 나머지 직원들의 이름, 월급, 담당프로젝트명을 가져오시오.

select s.name, s.salary, p.project from tblStaff s inner join tblProject p on s.seq = p.staff_seq where s.address not like '서울%';
    
    
-- tblCustomer, tblSales. 상품을 2개(단일상품) 이상 구매한 회원의 연락처, 이름, 구매상품명, 수량을 가져오시오.

select * from tblCustomer;
select * from tblSales;

select c.tel, c.name, s.item, s.qty from tblCustomer c inner join tblSales s on c.seq = s.cseq where s.qty > 1;
                
-- tblVideo, tblRent, tblGenre. 모든 비디오 제목, 보유수량, 대여가격을 가져오시오.
          
                
-- tblVideo, tblRent, tblMember, tblGenre. 2007년 2월에 대여된 구매내역을 가져오시오. 회원명, 비디오명, 언제, 대여가격
select * from tblGenre;
select 
    m.name as "회원명",
    v.name as "비디오명",
    r.rentdate as "대여일",
    g.price as "대여가격"
from tblVideo v 
    inner join tblRent r 
        on v.seq = r.video 
            inner join tblMember m 
                on r.member = m.seq
                    inner join tblGenre g
                        on v.genre = g.seq
                            where rentdate like('07/02/%');
        
-- tblVideo, tblRent, tblMember. 현재 반납을 안한 회원명과 비디오명, 대여날짜를 가져오시오.
select 
    m.name as "회원명",
    v.name as "비디오명",
    r.rentdate as "대여날짜"
from tblVideo v 
    inner join tblRent r 
        on v.seq = r.video 
            inner join tblMember m 
                on r.member = m.seq
                    where r.retdate is null;

    
    
-- employees, departments. 사원들의 이름, 부서번호, 부서명을 가져오시오.

select * from employees;
select * from departments;

select 
    e.first_name || ' ' || e.last_name as name,
    d.department_id as "부서번호",
    d.department_name as "부서명"
from employees e
    inner join departments d
        on e.department_id = d.department_id;

        
        
-- employees, jobs. 사원들의 정보와 직업명을 가져오시오.
select * from employees;
select * from jobs;

select e.*, j.job_title from employees e
    inner join jobs j
        on e.job_id = j.job_id;
        
        
-- employees, jobs. 직무(job_id)별 최고급여(max_salary) 받는 사원 정보를 가져오시오.
select * from employees e
    inner join jobs j
        on e.job_id = j.job_id;

       
    
    
-- departments, locations. 모든 부서와 각 부서가 위치하고 있는 도시의 이름을 가져오시오.
select * from departments;
select * from locations;

select d.department_name, l.city from departments d
    inner join locations l
        on d.location_id = l.location_id;
        
        
-- locations, countries. location_id 가 2900인 도시가 속한 국가 이름을 가져오시오.
select * from locations;
select * from countries;

select c.country_name from locations l
    inner join countries c
        on l.country_id = c.country_id
            where l.location_id = 2900;

            
            
-- employees. 급여를 12000 이상 받는 사원과 같은 부서에서 근무하는 사원들의 이름, 급여, 부서번호를 가져오시오.
select distinct job_id from employees where salary >= 12000;

select 
    e.first_name || ' ' || e.last_name as name, e.salary, e.department_id 
    from employees e inner join (select distinct job_id from employees where salary >= 12000) f on e.job_id = f.job_id;

        
        
-- employees, departments. locations.  'Seattle'에서(LOC) 근무하는 사원의 이름, 직위, 부서번호, 부서이름을 가져오시오.
select first_name || ' ' || last_name, department_id, department_name from employees;
select * from employees;
select * from departments;
select * from locations;

select 
    e.first_name || ' ' || e.last_name,
    e.job_id,
    e.department_id,
    d.department_name
from employees e
    inner join departments d
        on e.department_id = d.department_id
            inner join locations l
                on d.location_id = l.location_id
            where l.city = 'Seattle';

    
-- employees, departments. first_name이 'Jonathon'인 직원과 같은 부서에 근무하는 직원들 정보를 가져오시오.

select department_id from employees where first_name = 'Jonathon';

select * from employees where department_id = (select department_id from employees where first_name = 'Jonathon');

    
    
-- employees, departments. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을 출력하는데 월급이 3000이상인 사원을 가져오시오.

select 
    e.first_name || ' ' || e.last_name as name,
    d.department_name,
    e.salary
from employees e
    inner join departments d
        on e.department_id = d.department_id
            where e.salary >= 3000
                order by e.salary asc;

            
            
-- employees, departments. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름, 월급을 가져오시오.
select * from employees;
select * from departments;

select 
    e.department_id,
    d.department_name,
    e.first_name || ' ' || e.last_name as name,
    e.salary
from employees e 
    inner join departments d
        on e.department_id = d.department_id
    where e.department_id = 10;
            
            
-- departments, job_history. 퇴사한 사원의 입사일, 퇴사일, 근무했던 부서 이름을 가져오시오.
select * from departments;
select * from job_history; 

select 
    h.start_date,
    h.end_date,
    d.department_name
from departments d
    inner join job_history h
        on d.department_id = h.department_id;

-- employees. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호', '사원이름', '관리자번호', '관리자이름'으로 하여 가져오시오.
select 
    a.employee_id as "사원번호",
    a.first_name || ' ' || a.last_name as "사원이름",
    a.manager_id as "관리자번호",
    b.first_name || ' ' || b.last_name as "관리자이름"
from employees a
    inner join employees b
        on a.manager_id = b.employee_id;
        
        
-- employees, jobs. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 입사년도(hire_date)별 평균 급여를 가져오시오. 년도를 기준으로 오름차순 정렬.
select * from employees;
select * from jobs;

select 
    to_char(e.hire_date, 'yyyy') as "입사년도",
    avg(e.salary) as "평균 급여"
from employees e
    inner join jobs j
        on e.job_id = j.job_id
    where j.job_title = 'Sales Manager'
        group by to_char(e.hire_date, 'yyyy')
            order by to_char(e.hire_date, 'yyyy') asc;





-- employees, departments. locations. 각 도시(city)에 있는 모든 부서 사원들의 평균급여가 가장 낮은 도시부터 
-- 도시명(city)과 평균연봉, 해당 도시의 사원수를 가져오시오. 단, 도시에 근 무하는 사원이 10명 이상인 곳은 제외하고 가져오시오.
select * from employees;
select * from departments;
select * from locations;

select l.city, round(avg(e.salary)), count(*) from employees e
    inner join departments d
        on e.department_id = d.department_id
            inner join locations l
                on d.location_id = l.location_id
                    group by l.city
                        having count(*) < 10
                            order by round(avg(e.salary)) asc;
            
            
-- employees, jobs, job_history. ‘Public  Accountant’의 직책(job_title)으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 가져오시오. 현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사원은 고려 하지 말것.
select * from employees;
select * from jobs;
select * from job_history;

select 
    h.department_id,
    e.first_name || ' ' || e.last_name as "name"
from jobs j 
    inner join job_history h
        on j.job_id = h.job_id
            inner join employees e
                on h.department_id = e.department_id
            where j.job_title = 'Public Accountant';
    
    
-- employees, departments, locations. 커미션을 받는 모든 사람들의 first_name, last_name, 부서명, 지역 id, 도시명을 가져오시오.
select e.first_name, e.last_name, d.department_name, l.location_id, l.city from employees e 
    inner join departments d
        on e.department_id = d.department_id
            inner join locations l
                on d.location_id = l.location_id
where e.commission_pct is not null;
    
    
-- employees. 자신의 매니저보다 먼저 고용된 사원들의 first_name, last_name, 고용일을 가져오시오.
select 
    a.first_name, a.last_name, a.hire_date, b.hire_date as "매니저 고용일"
from employees a
    inner join employees b
        on a.manager_id = b.employee_id
            where b.hire_date > a.hire_date;


