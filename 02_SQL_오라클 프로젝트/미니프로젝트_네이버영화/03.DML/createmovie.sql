create table z_genrelist (      -- 장르목차 -- 완료
    seq number primary key,
    genre varchar2(200) not null
);

create table z_grade (      -- 관람 등급 -- 완료
    seq number primary key,
    viewGrade varchar2(50) not null
);

create table z_actor (      -- 배우명 -- 완료
    seq number primary key,
    name varchar2(100) not null
);

create table z_actorfillmore (      -- 배우 필모그래피
    seq number primary key,
    moviename varchar2(200),
    actorSeq number not null references z_actor(seq)
);

create table z_countrylist (        -- 나라목록 -- 완료
    seq number primary key,
    name varchar2(200) not null
);

create table z_member (             -- 회원 id
    id varchar2(30) primary key
);

create table z_tblMovie (       -- 영화 -- 완료
    seq number primary key,
    kor_title varchar2(200) not null,
    eng_title varchar2(200),
    state varchar2(20) not null,
    runningtime varchar2(20),
    good_num number,
    open_date date,
    grade_num number not null references z_grade(seq),
    summary varchar2(300)
);

create table z_genre (      -- 영화의 장르O -- 완료
    seq number primary key,
    genreSeq number not null references z_genrelist(seq),
    movieSeq number not null references z_tblmovie(seq)
);

create table z_country (        -- 제작국가 -- 완료
    seq number primary key,
    countrySeq number not null references z_countrylist(seq),
    movieSeq number not null references z_tblmovie(seq)
);

create table z_pd (     -- 감독
    seq number primary key,
    movieSeq number not null references z_tblmovie(seq),
    name varchar2(100) not null
);

create table z_pdfillmore (     -- 감독 필모그래피
    seq number primary key,
    moviename varchar2(200),
    pdSeq number not null references z_pd(seq)
);

create table z_totalview (      -- 누적 관객수
    movieseq number primary key references z_tblMovie(seq),
    viewNum number
);

create table z_cast (       -- 출연진 / 배역
    seq number primary key,
    movieSeq number not null references z_tblMovie(seq),
    role varchar2(10) not null,
    character varchar2(200),
    actorSeq number not null references z_actor(seq)
);

create table z_blog (               -- 블로그 리뷰
    seq number primary key,
    movieSeq number not null references z_tblMovie(seq),
    id varchar2(30) not null references z_member(id),
    title varchar2(300) not null,
    r_date date not null,
    content varchar2(500)
);

create table z_review (             -- 관객 리뷰
    seq number primary key,
    movieSeq number not null references z_tblMovie(seq),
    id varchar2(30) not null references z_member(id),
    c_view varchar2(5) not null check (c_view in('Y', 'N')),
    rate number not null,
    likenum number not null,
    content varchar2(400) not null
);

create table z_allrate (        -- 네티즌 / 기자 / 관람객 평점 -- 완료
    movieseq primary key references z_tblMovie(seq),
    netrate number,
    gijarate number,
    viewrate number
);

create table z_enjoypoint (     -- 감상포인트 -- 완료
    movieseq primary key references z_tblMovie(seq),
    prod number not null,
    story number not null,
    act number not null,
    visual number not null,
    ost number not null
);

create table z_gender (     -- 성별 관람 추이 -- 완료
    movieseq primary key references z_tblMovie(seq),
    man number not null,
    woman number not null
);

create table z_age (        -- 나이별 관람 추이 -- 완료
    movieseq primary key references z_tblMovie(seq),
    age10 number not null,
    age20 number not null,
    age30 number not null,
    age40 number not null,
    age50 number not null
);


/*
drop table z_genrelist;
drop table z_grade;
drop table z_actor;
drop table z_actorfillmore;
drop table z_countrylist;
drop table z_tblMovie;
drop table z_genre;
drop table z_country;
drop table z_pd;
drop table z_pdfillmore;
drop table z_totalview;
drop table z_cast;
drop table z_member;
drop table z_blog;
drop table z_review;
drop table z_allrate;
drop table z_enjoypoint;
drop table z_gender;
drop table z_age;
*/






