-- ex17_group_by.sql

/*
    
    GROUP BY
    - GROUP BY 컬럼명
    - GROUP BY 컬럼명, 컬럼명
    - 레코드들을 특정 컬럼값(1~N)으로 그룹을 나누는 역할
    - 그룹을 왜 나누는지? > 각각의 나눠진 그룹을 대상 > 집계 함수를 적용하기 위해서(********************)
    
    
    SELECT 컬럼리스트
    FROM 테이블
    WHERE 조건
    GROUP BY 기준
    ORDER BY 기준
    
    실행 순서*****
    1. FROM 테이블
    2. WHERE 조건
    3. GROUP BY 기준
    4. SELECT 컬럼리스트
    5. ORDER BY 기준

*/



-- tblInsa. 부서별 평균 급여?
select * from tblInsa;

select round(avg(basicpay)) from tblInsa; -- 1,556,527만원. 60명

select distinct buseo from tblInsa; -- 7개 부서

select round(avg(basicpay)) from tblInsa where buseo = '총무부'; -- 1,714,857만원
select round(avg(basicpay)) from tblInsa where buseo = '개발부'; -- 1,387,857만원
select round(avg(basicpay)) from tblInsa where buseo = '영업부'; -- 1,601,513만원
select round(avg(basicpay)) from tblInsa where buseo = '기획부'; -- 1,855,714만원
select round(avg(basicpay)) from tblInsa where buseo = '인사부'; -- 1,533,000만원
select round(avg(basicpay)) from tblInsa where buseo = '자재부'; -- 1,416,733만원
select round(avg(basicpay)) from tblInsa where buseo = '홍보부'; -- 1,451,833만원



-- group by를 사용하면 컬럼리스트
-- 1. 집계 함수
-- 2. group by 기준 > 컬럼
select
    round(avg(basicpay)) as 평균급여, -- 집합값(여러명의 값을 가지고 결과)
    buseo --집합값(여러명의 값을 가지고 결과)
    --, name 개별값(개인의 데이터)
from tblInsa
    group by buseo;
    
    
    
    
select
    buseo,
    count(*) as "부서별 인원수",
    sum(basicpay) as "부서별 지급액",
    round(avg(basicpay)) as "부서별 평균급여",
    max(ibsadate) as "부서별 막내 입사일",
    min(ibsadate) as "부서별 최고참 입사일"
from tblInsa
    group by buseo;
    
    
select
    count(*) as "전체 인원수",
    sum(basicpay) as "전체 지급액",
    round(avg(basicpay)) as "전체 평균급여",
    max(ibsadate) as "전체 막내 입사일",
    min(ibsadate) as "전체 최고참 입사일"
from tblInsa;




-- 남자? 여자?
select * from tblComedian;



--  8   	2
select
    count(decode(gender, 'm', 1)) as "남자수",
    count(decode(gender, 'f', 1)) as "여자수"
from tblComedian;


-- m	    8
-- f	    2

select
    gender,
    count(*)
from tblComedian
    group by gender;



-- 지역별 인원수?
select
    city,
    count(*) as cnt
from tblInsa
    group by city
        order by cnt desc;



select
    continent,
    count(*),
    sum(population)
from tblCountry
    group by continent;
    
    

select
    gender,
    max(height),
    min(height),
    max(weight),
    min(weight)
from tblComedian
    group by gender;
    
    
select
    buseo,
    jikwi,
    city,
    count(*)
from tblInsa
    group by buseo, jikwi, city
        order by buseo asc, jikwi asc;




-- 급여별 그룹
-- 100만원 이하
-- 100만원 ~ 200만원
-- 200만원 이상

select
    basicpay,
    floor(basicpay / 1000000)
from tblInsa
    group by basicpay;
    
    
select
    (floor(basicpay / 1000000) + 1) * 100 || '만원 이하' as 급여,
    count(*)
from tblInsa
    group by floor(basicpay / 1000000)
        order by floor(basicpay / 1000000) asc;
        

-- tblTodo. 한일의 개수? 안한일의 개수 > 그룹 기준? 일의 완료 유무?

-- 12  8
select
    count(case
        when completedate is not null then 'O'
    end),
    count(case
        when completedate is null then 'X'
    end)

from tblTodo;


-- O    12
-- X     8

select
    case
        when completedate is not null then 'O'
        else 'X'
    end as iscompleted,
    count(*)
from tbltodo
    group by 
    case
        when completedate is not null then 'O'
        else 'X'
    end;




-- 지역별 인원수?
select distinct city from tblInsa;


-- 모든 지역을 수동으로 작성!!! x 11번 작성;;;;;
-- 신입 사원 입사 > "강릉" 거주
-- 새로운 데이터 / 수정도니 데이터에 아주 취약한 방식!!!!!! > 정적인 데이터에는 무난~
select
    count(decode(city, '서울', 1)) as "서울",
    count(decode(city, '인천', 1)) as "인천",
    count(decode(city, '경기', 1)) as "경기"
from tblInsa;

-- pivot

-- 새로운 데이터 / 수정된 데이터에 아주 강함~ > 정적/동적인 데이터 모두에 무난~
select
    city,
    count(*)
from tblInsa
    group by city;








/*

    WHERE절
    - 조건절
    - FROM의 조건
    
    HAVING
    - 조건절
    - GROUP BY와 같이 사용
    - GROUP BY의 조건
    
    
    SELECT 컬럼리스트
    FROM 테이블
    WHERE 조건
    GROUP BY 기준
    HAVING 조건
    ORDER BY 기준
    
    실행 순서*****
    1. FROM 테이블
    2. WHERE 조건
    3. GROUP BY 기준
    4. HAVING 조건
    5. SELECT 컬럼리스트
    6. ORDER BY 기준

*/


-- 부서별 평균 급여 150만원 넘는 결과
select                              --4. 평균 급여 < 사전조건(150만원 이상인 사람들)
    buseo,
    round(avg(basicpay))
from tblInsa                        --1. 60명의 데이터를 가져온다.
    where basicpay >= 1500000       --2. 60명을 대상으로 조건 검사
        group by buseo;             --3. 2번을 통과한 사람들을(27명) 대상으로 그룹 형성.
        
-- 급여가 150만원 이상인 사람을 그룹으로 묶어서
        
        
--총무부	2431333
--개발부	2303750
--영업부	2164275
--기획부	2174000
--인사부	2200000
--자재부	2410000
--홍보부	1967000
    
    
    
select                                      --4. 출력
    buseo,
    round(avg(basicpay))
from tblInsa                                --1. 60명의 데이터를 가져온다.
    group by buseo                          --2. 60명을 대상으로 그룹 형성.
        having avg(basicpay) >= 1500000;    --3. 그룹을 대상으로 조건(집계값) > 그룹을 탈락!!!
        

--총무부	1714857
--영업부	1601513
--기획부	1855714
--인사부	1533000



select                                          --5. 컬럼 구성
    buseo,
    round(avg(basicpay))
from tblInsa                                    --1. 60명 데이터를 가져온다.
    where basicpay >= 1500000                   --2. 27명만 남긴다.(개인 탈락)
        group by buseo                          --3. 27명을 가지고 그룹 형성
            having avg(basicpay) >= 2200000     --4. 4부서만 남긴다.(부서 탈락)
                order by 2;
                
                

-- 서울 직원 > 남/녀 그룹 > 그룹별 평균 급여 155만원 > 각 그룹의 인원 수?

select                                          --5.
    substr(ssn, 8, 1),
    count(*),
    round(avg(basicpay))
from tblInsa                                    --1.
    where city = '서울'                         --2.
        group by substr(ssn, 8, 1)              --3.
            having avg(basicpay) >= 1550000;    --4.




-- tblCountry
-- 대륙별로 최대인구수, 최소인구수, 평균인구수를 가져오시오.
select
    continent as "대륙",
    max(population) as "최대인구수",
    min(population) as "최소인구수",
    round(avg(population)) as "평균인구수"
from tblCountry
    group by continent;




-- employees
-- 직업별(job_id) 직원수를 가져오시오.
select
    job_id,
    count(*)
from employees
    group by job_id;



-- tblInsa
-- 부서별 부서인원수, 최고급여, 최저급여, 평균 급여
select
    buseo,
    count(*) as "부서 인원수",
    max(basicpay + sudang) as "최고 급여",
    min(basicpay + sudang) as "최저 급여",
    round(avg(basicpay + sudang)) as "평균 급여"
from tblInsa
    group by buseo;




-- tblInsa
-- 부서별 직급의 인원수를 가져오시오.
-- [부서명]    [총인원]   [부장]    [과장]    [대리]    [사원]
-- 기획부          X명       X         X         X         X
-- 영업부          X명       X         X         X         X

select
    buseo, jikwi,
    count(*)
from tblInsa
    group by buseo, jikwi;


select
    buseo as "[부서명]",
    count(*) as "[총인원]",
    count(decode(jikwi, '부장', 1)) as "[부장]",
    count(decode(jikwi, '과장', 1)) as "[과장]",
    count(decode(jikwi, '대리', 1)) as "[대리]",
    count(decode(jikwi, '사원', 1)) as "[사원]"
from tblInsa
    group by buseo;




/*

    group by + having + rollup + cube
    
    
    rollup()
    - group by의 결과에서 집계 결과를 좀 더 자세하게 반환
    - 그룹별 중간 통계를 내고자 할 때 사용

*/

select
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup(buseo)
        order by buseo asc;
        
        
        
select
    buseo,
    jikwi,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup(buseo, jikwi);
    
    
    
    
select
    jikwi,
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup(jikwi, buseo);




/*

    cube()
    - group by의 결과에서 집계 결과를 더 자세하게 반환
    - 그룹별 중간 통계를 내고 싶을 때 사용

*/


select
    jikwi,
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by cube(jikwi, buseo); --A + B 그룹이 1개일때는 cube와 rollup의 차이가 없음
















