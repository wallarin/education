-- 문제05.sql

-- employees
-- 1. 전체 이름(first_name + last_name)이 가장 긴 -> 짧은 사람 순으로 정렬해서 가져오기
--    > 컬럼 리스트 > fullname(first_name + last_name), length(fullname)

select 
    first_name || ' ' || last_name as "full name",
    length(first_name || ' ' || last_name) as "len"
from employees
    order by "len" desc;
    
-- 2. 전체 이름(first_name + last_name)이 가장 긴 사람은 몇글자? 가장 짧은 사람은 몇글자? 평균 몇글자?
--    > 컬럼 리스트 > 숫자 3개 컬럼

select 
    max(length(first_name || ' ' || last_name)) as "maxlen",
    min(length(first_name || ' ' || last_name)) as "minlen",
    round(avg(length(first_name || ' ' || last_name))) as "avglen"
from employees;

-- 3. last_name이 4자인 사람들의 first_name을 가져오기
--    > 컬럼 리스트 > first_name, last_name
--    > 정렬(first_name, 오름차순)

select first_name, last_name from employees where length(last_name) = 4 order by first_name asc;

-- decode
-- 4. tblInsa. 부장 몇명? 과장 몇명? 대리 몇명? 사원 몇명?

select 
    count(decode(jikwi, '부장', 1)) as "부장",
    count(decode(jikwi, '과장', 1)) as "과장",
    count(decode(jikwi, '대리', 1)) as "대리",
    count(decode(jikwi, '사원', 1)) as "사원"
from tblInsa;

-- 5. tblInsa. 간부(부장, 과장) 몇명? 사원(대리, 사원) 몇명?

select 
    count(decode(jikwi, '부장', 1)) + count(decode(jikwi, '과장', 1)) as "간부수",
    count(decode(jikwi, '대리', 1)) + count(decode(jikwi, '사원', 1)) as "사원수"
from tblInsa;

-- 6. tblInsa. 기획부, 영업부, 총무부, 개발부의 각각 평균 급여?

select
    round(avg(decode(buseo, '기획부', basicpay))) as "기획부",
    round(avg(decode(buseo, '영업부', basicpay))) as "영업부",
    round(avg(decode(buseo, '총무부', basicpay))) as "총무부",
    round(avg(decode(buseo, '개발부', basicpay))) as "개발부"
from tblInsa;

-- 7. tblInsa. 남자 직원 가장 나이가 많은 사람이 몇년도 태생? 여자 직원 가장 나이가 어린 사람이 몇년도 태생?

select
    19 || min(decode(substr(ssn,8, 1), 1, substr(ssn, 1, 2))) as "남자 최고령",
    19 || max(decode(substr(ssn,8, 1), 2, substr(ssn, 1, 2))) as "여자 막내"
from tblInsa;
