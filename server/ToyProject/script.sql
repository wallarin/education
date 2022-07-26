

drop table tblUser;

-- 회원 테이블
create table tblUser (
    id varchar2(30) primary key,                        -- 아이디(PK)
    pw varchar2(30) not null,                           -- 암호
    name varchar2(30) not null,                         -- 이름
    lv char(1) not null,                                -- 등급(1. 일반회원, 2. 관리자)
    pic varchar2(100) default 'pic.png' not null,       -- 회원 사진
    regdate date default sysdate not null,              -- 가입날짜
    active char(1) default 'y' not null                 -- 탈퇴유무(y. 활동중, n. 탈퇴)
);


insert into tblUser (id, pw, name, lv, pic, regdate)
    values ('hong', '1111', '홍길동', '1', default, default);
    
insert into tblUser (id, pw, name, lv, pic, regdate)
    values ('admin', '1111', '관리자', '2', default, default);

select * from tblUser;

commit;


alter table tblUser
    add (active char(1) default 'y' not null);

delete from tblUser where active = 'n';    
commit;



-- 게시판
create table tblBoard (
    seq number primary key,                             -- 번호(PK)
    subject varchar2(300) not null,                     -- 제목
    content varchar2(4000) not null,                    -- 내용
    id varchar2(30) not null references tblUser(id),    -- 아이디(FK)
    regdate date default sysdate not null,              -- 작성시각
    readcount number default 0 not null                 -- 읽음(조회수)
);

create sequence seqBoard;

select * from tblBoard;


create or replace view vwBoard
as
select seq, subject, content, id, (select name from tblUser where id = tblBoard.id) as name, regdate, readcount,
    (select count(*) from tblComment where pseq = tblBoard.seq) as commentcount, depth, (sysdate - regdate) as isnew,
    filename
from tblBoard order by thread desc;

select * from vwBoard;



select * from tblComment;
drop table tblComment;
-- 댓글 테이블
create table tblComment (
    seq number primary key,                             -- 댓글번호(PK)
    content varchar2(1000) not null,                    -- 내용
    id varchar2(30) not null references tblUser(id),    -- 아이디(FK)
    regdate date default sysdate not null,              -- 날짜
    pseq number not null references tblBoard(seq)       -- 부모글 번호(FK)
);

select * from tblComment;

create sequence seqComment;



select * from (select a.*, rownum as rnum from vwBoard a) where rnum between 1 and 10;
select * from (select a.*, rownum as rnum from vwBoard a) where rnum between 11 and 20;
select * from (select a.*, rownum as rnum from vwBoard a) where rnum between 21 and 30;





drop table tblBoard;
drop table tblComment;




create table tblBoard (
    seq number primary key,                             -- 번호(PK)
    subject varchar2(300) not null,                     -- 제목
    content varchar2(4000) not null,                    -- 내용
    id varchar2(30) not null references tblUser(id),    -- 아이디(FK)
    regdate date default sysdate not null,              -- 작성시각
    readcount number default 0 not null,                 -- 읽음(조회수)
    thread number not null,                             -- 답변형 게시판
    depth number not null                               -- 답변형 게시판
);

create table tblComment (
    seq number primary key,                             -- 댓글번호(PK)
    content varchar2(1000) not null,                    -- 내용
    id varchar2(30) not null references tblUser(id),    -- 아이디(FK)
    regdate date default sysdate not null,              -- 날짜
    pseq number not null references tblBoard(seq)       -- 부모글 번호(FK)
);


select nvl(max(thread), 0) as thread from tblBoard;
select * from tblBoard order by seq;



drop table tblBoard;
drop table tblComment;




create table tblBoard (
    seq number primary key,                             -- 번호(PK)
    subject varchar2(300) not null,                     -- 제목
    content varchar2(4000) not null,                    -- 내용
    id varchar2(30) not null references tblUser(id),    -- 아이디(FK)
    regdate date default sysdate not null,              -- 작성시각
    readcount number default 0 not null,                 -- 읽음(조회수)
    thread number not null,                             -- 답변형 게시판
    depth number not null,                              -- 답변형 게시판
    filename varchar2(100) null,                        -- 첨부파일
    orgfilename varchar2(100) null                      -- 첨부파일 원본이름(다운로드용)
);

create table tblComment (
    seq number primary key,                             -- 댓글번호(PK)
    content varchar2(1000) not null,                    -- 내용
    id varchar2(30) not null references tblUser(id),    -- 아이디(FK)
    regdate date default sysdate not null,              -- 날짜
    pseq number not null references tblBoard(seq)       -- 부모글 번호(FK)
);

select * from tblBoard;





-- 해시 태그 테이블
create table tblHashTag(

    seq number primary key,             -- 번호(PK
    tag varchar2(100) unique not null   -- 해시 태그(UQ)
    
);

create sequence seqHashTag;


-- 게시판 <- 연결 -> 해시태그

create table tblTagging (
    seq number primary key,                             --번호(PK)
    bseq number not null references tblBoard(seq),      --게시물(FK)
    hseq number not null references tblHashTag(seq)     --해시 태그(FK)
);

create sequence seqTagging;

select * from tblBoard order by seq desc;

select * from tblHashTag;

select * from tblTagging;



select tag from tblHashTag h inner join tblTagging t on h.seq = t.hseq where bseq = 330;



select b.* from vwBoard b
    inner join tblTagging t
        on b.seq = t.bseq
            inner join tblHashTag h
                on h.seq = t.hseq
                    where h.tag = '수업';





create table tblGoodBad (
    seq number primary key,                             -- 번호(PK)
    id varchar2(30) not null references tblUser(id),    -- 아이디(FK)
    bseq number not null references tblBoard(seq),      -- 게시판 글번호
    good number default 0 not null,                     -- 좋아요
    bad number default 0 not null                       -- 싫어요
);

create sequence seqGoodBad;

select * from tblGoodBad;



select 
    tblBoard.*, 
    (select name from tblUser where id = tblBoard.id) as name,
    (select sum(good) from tblGoodBad where bseq = tblBoard.seq) as good,
    (select sum(bad) from tblGoodBad where bseq = tblBoard.seq) as bad,
    (select 
        case 
            when good = 1 then 1
            when bad = 1 then 2
            else 3
        end 
    from tblGoodBad where bseq = tblBoard.seq and id = 'hong') as goodbad
from tblBoard where seq = 333;




select * from tblTagging;

select * from tblBoard;     -- 회원별 글 작성 횟수 차트화
select * from tblComment;   -- 회원별 댓글 횟수 차트화
select * from tblHashTag;   -- 태그별 카운트 차트화
select * from tblGoodBad;   -- X


select u.id, (select name from tblUser where id = u.id) as name, (select count(*) from tblBoard where id = u.id) as cnt 
from tblBoard b right outer 
    join tblUser u 
        on u.id = b.id 
            group by u.id;
            

select u.id, (select name from tblUser where id = u.id) as name, (select count(*) from tblComment where id = u.id) as cnt 
from tblComment b right outer 
    join tblUser u 
        on u.id = b.id 
            group by u.id;
            
            
select h.tag, (select count(*) from tblTagging where hseq = h.seq) as cnt from tblHashTag h left outer join tblTagging t on h.seq = t.hseq group by h.tag, h.seq;






-- 맛집 즐겨찾기
create table tblFood (
    seq number primary key,                                 -- 번호(PK)
    name varchar2(100) not null,                            -- 상호명
    lat number not null,                                    -- 위도(Latitude)
    lng number not null,                                    -- 경도(Longitude)
    star number(3) not null,                                -- 별점(1~5)
    category number not null references tblCategory(seq)    -- 업종
);

create sequence seqFood;

alter table tblFood
    modify (star number(3));
    
desc tblFood;

create table tblCategory (
    seq number primary key,
    name varchar2(100) not null,
    marker varchar2(100) not null,
    icon varchar2(100) not null
);

insert into tblCategory values (1, '한식', 'm1', 'fa-solid fa-bowl-food');
insert into tblCategory values (2, '양식', 'm2', 'fa-solid fa-pizza-slice');
insert into tblCategory values (3, '카페', 'm3', 'fa-solid fa-mug-hot');
commit;

select * from tblFood;














------------------------------------------------ Ajax

-- 설문 테이블(질문) <-> 설문 항목
-- ^
-- |
-- 선택
-- > 지금 내용처럼 만드는게 X 단순화한 버전

-- 설문조사
create table tblResearch (
    seq number primary key,                             -- 번호(PK)
    question varchar2(500) not null,                    -- 질문
    item1 varchar2(300) not null,                       -- 항목 1
    item2 varchar2(300) not null,                       -- 항목 2
    item3 varchar2(300) not null,                       -- 항목 3
    item4 varchar2(300) not null,                       -- 항목 4
    cnt1 number default 0 not null,                     -- 선택 1
    cnt2 number default 0 not null,                     -- 선택 2
    cnt3 number default 0 not null,                     -- 선택 3
    cnt4 number default 0 not null                      -- 선택 4
);

insert into tblResearch values (1, '가장 잘 사용하는 프로그래밍 언어는?', 'Java', 'Python', 'Visual C++', 'Node.js', default, default, default, default);

select * from tblResearch;

update tblResearch set
    cnt1 = 10,
    cnt2 = 17,
    cnt3 = 5,
    cnt4 = 10
where seq = 1;

commit;






select * from tblInsa;

desc tblInsa;

select * from tblAddress;









select tblComment.*, (select name from tblUser where id = tblComment.id) as name from tblComment where seq = (select max(seq) from tblComment);







create table tblDraggable (
    id varchar2(30) primary key,           -- 태그id(PK)
    left number not null,                  -- x좌표
    top number not null                    -- y좌표
);


insert into tblDraggable (id, left, top) values ('cat01', 0, 0);
insert into tblDraggable (id, left, top) values ('cat02', 0, 0);
insert into tblDraggable (id, left, top) values ('cat03', 0, 0);


commit;


select * from tblDraggable;




select * from tblMovie;
-- 크롤링. 네이버 영화
create table tblMovie (
    seq number primary key,             --번호(PK)
    title varchar2(200) not null,       --영화제목
    category varchar2(200) not null,    --개요
    time number not null,               --상영시간
    rdate varchar2(10) not null,        --개봉일
    director varchar2(100) not null,    --감독
    actor varchar2(200) null,           --배우
    poster varchar2(300) not null       --포스터
);

create sequence seqMovie;

insert into tblMovie (seq, title, category, time, rdate, director, actor, poster) values (seqMovie.nextVal, ?, ?, ?, ?, ?, ?, ?);

select * from tblMovie order by seq asc;


    
    
    
    
    
    
    
    
create table tbl_userid (
    id varchar2(20) primary key
);
    
create table tbl_userinfo (
    seq number primary key,
    name varchar2(15) not null,
    id varchar2(20)
); 

drop table tbl_userinfo;

insert into tbl_userid values ('toto');
insert into tbl_userinfo values (1, '토토', null);
insert into tbl_userinfo values (2, '토토', 'toto');

select * from tbl_userid;
select * from tbl_userinfo;
    
ALTER TABLE tbl_userinfo
ADD FOREIGN KEY (id) REFERENCES tbl_userid(id);

select * from tbl_userid tu inner join tbl_userinfo ui on tu.id = ui.id;
    
    
    
    
    