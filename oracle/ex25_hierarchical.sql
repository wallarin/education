-- ex25_hierarchical.sql
-- ANSI-SQL 마지막

/*

    계층형 쿼리, Hierarchical Query
    - 레코드의 관계가 서로간에 상하 수직 구조일 경우에 사용
    - 자기 참조를 하는 테이블에서 사용 > Self Join
    - 오라클 전용 쿼리
    - 주로, 카테고리, 답변형 게시판, 조직도 등.. 트리 구조에 사용
    
    
    컴퓨터
        - 본체
            - 메인보드
            - 그래픽카드
            - 랜카드
            - 메모리
            - CPU
        - 모니터
            - 보호필름
            - 모니터암
        - 프린터
            - A4
            - 잉크 카트리지
        
    카테고리
        - 컴퓨터용품
            - 하드웨어
            - 소프트웨어
            - 소모품
        - 운동용품
            - 테니스
            - 골프
            - 달리기
        - 먹거리
            - 밀키트
            - 베이커리
            - 도시락

*/

-- Case 1.
create table tblComputer (
    seq number primary key,                         -- 식별자(PK)
    name varchar2(50) not null,                     -- 부품명
    qty number not null,                            -- 수량
    pseq number null references tblComputer(seq)    -- 부모부품(FK)
);

insert into tblComputer values (1, '컴퓨터', 1, null);

insert into tblComputer values (2, '본체', 1, 1);
insert into tblComputer values (3, '메인보드', 1, 2);
insert into tblComputer values (4, '그래픽카드', 1, 2);
insert into tblComputer values (5, '랜카드', 1, 2);
insert into tblComputer values (6, 'CPU', 1, 2);
insert into tblComputer values (7, '메모리', 2, 2);

insert into tblComputer values (8, '모니터', 1, 1);
insert into tblComputer values (9, '보호필름', 1, 8);
insert into tblComputer values (10, '모니터암', 1, 8);

insert into tblComputer values (11, '프린터', 1, 1);
insert into tblComputer values (12, 'A4용지', 100, 11);
insert into tblComputer values (13, '잉크카트리지', 3, 11);

select * from tblComputer;


-- Case 2.
create table tblCategoryBig (
    seq number primary key,                     -- 식별자(PK)
    name varchar2(100) not null                 -- 카테고리명
);

create table tblCategoryMedium (
    seq number primary key,                             -- 식별자(PK)
    name varchar2(100) not null,                        -- 카테고리명
    pseq number not null references tblCategoryBig(seq) -- 부모카테고리(FK)
);

create table tblCategorySmall (
    seq number primary key,                                 -- 식별자(PK)
    name varchar2(100) not null,                            -- 카테고리명
    pseq number not null references tblCategoryMedium(seq)  -- 부모카테고리(FK)
);

insert into tblCategoryBig values (1, '카테고리');

insert into tblCategoryMedium values (1, '컴퓨터용품', 1);
insert into tblCategoryMedium values (2, '운동용품', 1);
insert into tblCategoryMedium values (3, '먹거리', 1);

insert into tblCategorySmall values (1, '하드웨어', 1);
insert into tblCategorySmall values (2, '소프트웨어', 1);
insert into tblCategorySmall values (3, '소모품', 1);

insert into tblCategorySmall values (4, '테니스', 2);
insert into tblCategorySmall values (5, '골프', 2);
insert into tblCategorySmall values (6, '달리기', 2);

insert into tblCategorySmall values (7, '밀키트', 3);
insert into tblCategorySmall values (8, '베이커리', 3);
insert into tblCategorySmall values (9, '도시락', 3);


-- Case 1. 사용
-- 셀프 조인
select 
    c1.name as "부품명",
    c2.name as "부모부품명"
from tblComputer c1             -- 부품
    inner join tblComputer c2   -- 부모부품
        on c2.seq = c1.pseq;
        

-- 계층형 쿼리
-- start with 절 + connect by 절
-- 계층형 쿼리에서만 사용 가능한 의사 컬럼
--      a. prior > 자기와 연관된 부모 레코드를 참조
--      b. level > depth(세대)

select
    seq as "번호",
    lpad(' ', (level - 1) * 5) || name as "부품명",
    prior name "부모부품명",
    level       -- 세대 번호                 -- 시각적인 효과를 주기 위해서 사용한다.
from tblComputer
    --start with seq = 1               -- 결과셋의 루트 레코드 지정 > 최상위 노드를 지정한다. (1 - 컴퓨터 관련, 2 - 본체 관련)
    --start with seq = (select seq from tblComputer where name = '모니터')
    start with pseq is null
        connect by prior seq = pseq; -- 현재 레코드와 부모 레코드를 연결하는 조건(셀프 조인과 비슷하다.)




select
    lpad(' ', (level - 1) * 2) || name as "직원명",
    prior name as "상사명"
from tblSelf
    start with super is null
        connect by super = prior seq;



select * from tblCategoryBig;
select * from tblCategoryMedium;
select * from tblCategorySmall;

select 
    b.name as "상",
    m.name as "중",
    s.name as "하"
from tblCategoryBig b
    inner join tblCategoryMedium m
        on b.seq = m.pseq
            inner join tblCategorySmall s
                on m.seq = s.pseq;


-- 1. ANSI-SQL > complete
-- 2. 설계 > 금요일
-- 3. PL/SQL > 다음주 ~ 다다음주























