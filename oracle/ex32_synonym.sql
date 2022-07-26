-- ex32_synonym.sql

/*

    동의어, Synonym(시노님)
    - 데이터베이스 객체의 별칭(Alias 차이 있음)
    - 다른 사용자 소유의 객체를 접근 > 별칭 사용
    - 
    
    
    테이블 등 자원은 계정 소속이다.

*/


-- hr
show user;

select * from tabs where table_name = 'TBLINSA';

-- system
-- 다른 계정의 자원을 접근할 권한이 있다.
show user;

select * from tabs where table_name = 'TBLINSA';

select * from tblInsa; -- 계정명을 안적으면 본인을 의미한다..
select * from hr.tblInsa; -- 다른 계정의 자원 접근 > 계정명.자원명

select fnSum(10, 20) from dual; -- 안된다.. > hr에서 만들었던 함수
select hr.fnSum(10, 20) from dual; -- hr로 만들었던거라 다른 계정에서 사용하려면 계정명을 적어야한다.

-- scott에게 hr.tblInsa을 접근할 수 있는 권한 부여
grant select, delete on hr.tblInsa to scott;

revoke delete on hr.tblInsa from scott;



-- 일반 다른 계정 > scott
create user scott identified by java1234;

grant connect, resource to scott;

-- 시노님
grant create synonym to scott;



-- scott, hr과 같은 계정이다
select * from tabs;

select * from hr.tblInsa; -- 다른 계정의 자원은 접근 불가능 > 접근할 수 있는 권한이 없다.

-- ORA-01031: insufficient privileges > 불충분한 권한
update hr.tblInsa set basicpay = 3000000 where name = '홍길동'; -- 일반키 > 비인덱스
update hr.tblInsa set basicpay = 3000000 where num = 1001; -- PK > 인덱스

-- ORA-01031: insufficient privileges
delete from hr.tblInsa where num = 1001;



-- 영구적으로 hr의 tblInsa를 scott이 접근해야하는 경우
-- 
select * from hr.tblInsa;

select i.name, i.buseo, i.jikwi from hr.tblInsa i;


-- create synonym 별칭 for 자원;
create public synonym insa for hr.tblInsa;

select * from hr.tblInsa;
select * from insa; -- 소유주 명시X > hr.tblInsa > insa

select * from tabs; -- 여전히 아무것도 없다.

select * from hr.departments; -- 긴 이름도 줄이면 좋다.
select * from dept; -- 줄인 후



-- dual, tabs > public 시노님이였다..
select sysdate from dual;
select * from tabs;






































