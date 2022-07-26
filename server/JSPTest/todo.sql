
-- C:\class\server\JSPTest\todo.sql

create table tblTodo (
    seq number primary key,                                 --번호(PK)
    todo varchar2(300) not null,                            --할일
    regdate date default sysdate,                           --날짜
    priority char(1) not null,                              --중요도(A,B,C)
    complete char(1) default 'n' not null                   --완료 유무(y-완료, n-미완료)
);

create sequence seqTodo;

insert into tblTodo (seq, todo, priority) values (seqTodo.nextVal, '할일 숙제 만들기', 'A');

select * from tblTodo order by regdate asc;

update tblTodo set complete = 'y' where seq = 1;



































