

create table tblGallery (
    seq number primary key,             -- 번호(PK) > 삭제할 떄 이용될 것이다.
    filename varchar2(100) not null,    -- 이미지 파일명(하드 디스크에 저장된 이름)
    subject varchar2(100) not null,     -- 제목(이미지 설명)
    regdate date default sysdate        -- 작성된 시간
);

create sequence seqGallery;

insert into tblGallery (seq, filename, subject) values (seqGallery.nextval, '테스트.jpg', '테스트입니다.');

select * from tblGallery;

delete from tblGallery where seq = 19;
commit;