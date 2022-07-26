-- C:\class\server\JSPTest

drop table tblAddress;
drop sequence seqAddress;

create table tblAddress (
    seq number primary key,                                 --번호(PK)
    name varchar2(30) not null,                             --이름
    age number(3) not null,                                 --나이
    address varchar2(300) not null,                         --주소
    gender char(1) not null check(gender in ('m', 'f')),    --성별
    tel varchar2(15) not null                               --연락처
);

create sequence seqAddress;

-- 주소록 쓰기
insert into tblAddress (seq, name, age, address, gender, tel) 
    values (seqAddress.nextval, '테스트', 20, '서울시 강남구 역삼동', 'm', '010-1234-5678');
   
-- 주소록 읽기 
select * from tblAddress order by name asc;

-- 주소록 수정하기
-- 한번에 모든 내용을 수정하게 만들어야한다. 각각을 수정하게 만들경우 경우의 수가 너무 많아져서 현실적으로 불가능하다 그래서 모든 컬럼을 수정하게하고 변경하지 않을 값들도 불러온다.
update tblAddress set name = '아무개', age = 22, address= '서울시 강동구 둔촌동', gender = 'f', tel = '010-9822-0048' where seq = 1;

-- 주소록 삭제하기
delete from tblAddress where seq = 11;
























