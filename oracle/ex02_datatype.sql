/*

ex02_datatype.sql

ANSI-SQL 자료형
- 오라클 자료형

1. 숫자형
    - 정수, 실수
    a. number
        - (유효자리)38자리 이하의 숫자를 표현하는 자료형
        - 12345678901234567890123456789012345678
        - 5 ~ 22byte
        - 1x10^-130 ~ 9.9999x10^125
        
        - number
        - number(precision) : 전체 자릿수
        - number(precision, scale) : 전체 자릿수 + 소수이하 자릿수
        
        
            
2. 문자형
    - 문자, 문자열
    - char + String > 자바의 String과 유사
    - char vs nchar > n의 의미?
    - char vs varchar > var의 의미?
    
    a. char (2순위 사용!!!!!!!!!!!!!!!!!)
        - 고정 자릿수 문자열 > 공간(컬럼)의 크기가 불변
        - char(n):n자리 문자열, n(바이트)
        - 최소 크기 : 1바이트
        - 최대 크기 : 2000바이트
        - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 스페이스로 채운다.
        
        
    b. nchar (자주 사용 X)
        - n : national > 오라클 인코딩과 상관없이 해당 컬럼을 UTF-16 동작하게
        - 고정 자릿수 문자열
        - nchar(n) : n자리 문자열, n(문자수)
        - 최소 크기 : 1글자(2byte)
        - 최대 크기 : 1000글자(2000byte)
    
    c. varchar2 (1순위로 사용!!!!!!!!!!)
        - 가변 자릿수 문자열 > 공간의 크기가 가변
        - varchar2(n) : n자리 문자열, n(바이트)
        - 최소 크기 : 1바이트
        - 최대 크기 : 4000바이트
        - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 버린다. 즉 데이터의 크기가 공간의 크기가 된다.
        
        
    d. nvarchar2 (자주 사용 X)
        - n : national > 오라클 인코딩과 상관없이 해당 컬럼을 UTF-16 동작하게
        - 가변 자릿수 문자열 > 공간의 크기가 가변
        - varchar2(n) : n자리 문자열, n(문자수)
        - 최소 크기 : 1글자(2byte)
        - 최대 크기 : 2000글자(4000byte)
        - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 버린다. 즉 데이터의 크기가 공간의 크기가 된다.
        
    e. clob(씨롭)
        - 대용량 텍스트
        - 128TB
        - 잘 사용 안함. 참조형
    
    
    
3. 날짜/시간형
    - 자바의 Calendar, Date..
    
    a. date (거의 이것만 사용한다!!!)
        - 년 월 일 시 분 초 까지 저장
        - 7byte
        - 기원전 4712년 1월 1일 ~ 9999년 12월 31일
    
    b. timestamp
        - 년 월 일 시 분 초 + 밀리초 + 나노초
    
    c. interval
        - 시간
        - 틱값 저장용
        - number를 대신 사용

4. 이진 데이터형
    - 비 텍스트 데이터
    - 이미지, 영상, 음악, 파일 등..
    - 잘 사용 안함..
    - ex) 게시판(첨부파일), 회원가입(사진) > 파일명만(문자열) 저장 > hong.jpg
    a. blob
        - 최대 128TB
        
        
        
        
결론 
1. 숫자 > number
2. 문자 > varchar2 + char
3. 날짜 > date

자바
1. 숫자 > int, long, double
2. 문자 > String
3. 날짜 > Calendar




*/


-- 테이블 선언(생성)
/*
create table 테이블명 (
    컬럼 선언
    컬럼명 자료형,
    컬럼명 자료형,
    컬럼명 자료형
);
*/

-- *** 오라클은 사용자가 정의한 모든 식별자를 DB에 저장할 때 항상 대문자로 변환해서 저장한다.(*****)

-- 식별자 : 접두어
create table tblType(
    --num number
    --num number(3)
    --num number(4, 2)
    
    --str1 char(10), -- str1 컬럼에는 최대 10바이트 크기의 문자를 저장
    --str2 varchar2(10)
    
    str1 nchar(10)
    
);

--ORA-00955: name is already used by an existing object

-- 테이블 삭제
-- drop table 테이블명;

drop table tblType;


-- ? 확인

select * from tabs; --tables > 현재 계정이 소유하고 있는 테이블 정보

select * from tabs where table_name = 'TBLTYPE';



-- 데이터 추가하기
insert into tbltype (num) values (100); -- 정수형 리터럴
insert into tbltype (num) values (3.14); -- 실수형 리터럴

insert into tbltype (num) values (1000); -- 안들어가진다.
insert into tbltype (num) values (999);
insert into tbltype (num) values (-999);
insert into tbltype (num) values (-1000); -- 안들어가진다.

insert into tbltype (num) values (3.141592); -- 자릿수를 지정하면 실수는 반올리이 되버린다.
insert into tbltype (num) values (3.956592); -- 자릿수를 지정하면 정수형 자료만 저장된다.


insert into tbltype (num) values (100000000000000); --num number(3) > 3은 자릿수
insert into tbltype (num) values (12345678901234567890123456789012345678);
insert into tbltype (num) values (12345678901234567890123456789012345678901234567890); -- 표현할 수 있는 자릿수가 넘어가면 넘어간 숫자는 0으로 바뀐다.


--num number(4, 2)
insert into tblType (num) values (99.99); --까지만 가능하다..
insert into tblType (num) values (-99.99);


insert into tblType (str1) values ('A');
insert into tblType (str1) values ('ABC');
insert into tblType (str1) values ("ABC"); -- ""사용 불가능
insert into tblType (str1) values ('ABCDEFGHIJ');

-- ORA-12899: value too large for column "HR"."TBLTYPE"."STR1" (actual: 11, maximum: 10)
insert into tblType (str1) values ('ABCDEFGHIJK'); -- 범위 초과

insert into tblType (str1) values ('가나다');
insert into tblType (str1) values ('가나다라'); -- 12byte

insert into tblType (str1, str2) values ('ABC','ABC');
insert into tblType (str1, str2) values ('ABCABCABCA','ABCABCABCA');
insert into tblType (str1, str2) values ('ABCABCABCA','ABCABCABCAB');

-- @ABC       @ : char > 최대 크기중 모자란 길이만큼 스페이스(공백문자)를 채워넣는다. > 10바이트
-- @ABC@        : varchar1 > 최대 크기와 상관없이 공간에 데이터만 들어가고.. 나머지 공간은 삭제 > 3바이트



insert into tblType (str1) values ('가나다');
insert into tblType (str1) values ('가나다라마바');
insert into tblType (str1) values ('가나다라마바사아자차');
insert into tblType (str1) values ('가나다라마바사아자차카');

insert into tblType (str1) values ('ABCDEFGHIJ');
insert into tblType (str1) values ('ABCDEFGHIJK'); -- 오류발생

-- 데이터 가져오기
select * from tbltype;












----------------------------------------------------------------------------------------------------------------------------------------------------------------



--정수 / 실수 최대 38자리의 숫자넣기
create table tblType( -- number(숫자)를 받는 num(컬럼)의 테이블 생성
    --num number
);

-- 정수 / 실수 값 넣기 > 두개 다 가능하다.
-- 데이터 추가하기
insert into tbltype (num) values (100); -- 정수형 리터럴
insert into tbltype (num) values (3.14); -- 실수형 리터럴

select * from tbltype; -- 테이블 조회하기

drop table tblType; -- 테이블 삭제하기




----------------------------------------------------------------------------------------------------------------------------------------------------------------


-- 자릿수 제한 number 만들기
create table tblType( -- number(숫자)를 받는 num(컬럼)의 테이블 생성
    --num number(3)
);

-- 데이터 추가하기
insert into tbltype (num) values (100); -- 정수형 리터럴
insert into tbltype (num) values (3.14); -- 실수형 리터럴

insert into tbltype (num) values (1000); -- 안들어가진다.
insert into tbltype (num) values (999);
insert into tbltype (num) values (-999);
insert into tbltype (num) values (-1000); -- 안들어가진다.

insert into tbltype (num) values (3.141592); -- 자릿수를 지정하면 실수는 반올리이 되버린다.
insert into tbltype (num) values (3.956592); -- 자릿수를 지정하면 정수형 자료만 저장된다.


insert into tbltype (num) values (100000000000000); --num number(3) > 3은 자릿수
insert into tbltype (num) values (12345678901234567890123456789012345678);
insert into tbltype (num) values (12345678901234567890123456789012345678901234567890); -- 표현할 수 있는 자릿수가 넘어가면 넘어간 숫자는 0으로 바뀐다.

select * from tbltype; -- 테이블 조회하기

drop table tblType; -- 테이블 삭제하기





----------------------------------------------------------------------------------------------------------------------------------------------------------------



-- 앞의 4는 정수 자릿수 + 실수 자릿수, 뒤의 2는 실수의 자릿수
create table tblType(
    --num number(4, 2)
);

insert into tbltype (num) values (100); -- 정수형 리터럴
insert into tbltype (num) values (3.14); -- 실수형 리터럴
insert into tblType (num) values (99.99); --까지만 가능하다..
insert into tblType (num) values (-99.99);

select * from tbltype; -- 테이블 조회하기

drop table tblType; -- 테이블 삭제하기



----------------------------------------------------------------------------------------------------------------------------------------------------------------



-- 불변 문자열 받기
create table tblType(
    str1 char(10), -- str1 컬럼에는 최대 10바이트 크기의 문자를 저장
);

-- 데이터 추가하기
insert into tblType (str1) values ('A');
insert into tblType (str1) values ('ABC');
insert into tblType (str1) values ("ABC"); -- ""사용 불가능
insert into tblType (str1) values ('ABCDEFGHIJ');

-- ORA-12899: value too large for column "HR"."TBLTYPE"."STR1" (actual: 11, maximum: 10)
insert into tblType (str1) values ('ABCDEFGHIJK'); -- 범위 초과

insert into tblType (str1) values ('가나다');
insert into tblType (str1) values ('가나다라'); -- 12byte


select * from tbltype; -- 테이블 조회하기

drop table tblType; -- 테이블 삭제하기



----------------------------------------------------------------------------------------------------------------------------------------------------------------


create table tblType(
    str1 char(10), -- str1 컬럼에는 최대 10바이트 크기의 문자를 저장
    str2 varchar2(10)
);

-- 데이터 추가하기
insert into tblType (str1, str2) values ('ABC','ABC');
insert into tblType (str1, str2) values ('ABCABCABCA','ABCABCABCA');
insert into tblType (str1, str2) values ('ABCABCABCA','ABCABCABCAB');


select * from tbltype; -- 테이블 조회하기

drop table tblType; -- 테이블 삭제하기

-- @ABC       @ : char > 최대 크기중 모자란 길이만큼 스페이스(공백문자)를 채워넣는다. > 10바이트
-- @ABC@        : varchar1 > 최대 크기와 상관없이 공간에 데이터만 들어가고.. 나머지 공간은 삭제 > 3바이트















