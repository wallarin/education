-- 추천도서 전체 조회하기
select * from vwtblTeachRec;





-- 출판사 조회 프로시저 생성
create or replace procedure procPublisher (
    pname tblPublisher.name%type,
    presult out number,
    pseq out number,
    poutname out tblPublisher.name%type
)
is
begin

    select publisher_seq, name into pseq, poutname from tblPublisher where name = pname;
    presult := 1;
    
exception
    when others then
        presult := 0;
end procPublisher;



-- 출판사 조회하기
declare
    vresult number;
    vseq number;
    vname tblPublisher.name%type;
begin
    procPublisher('테스트',vresult ,vseq, vname);
    if vresult = 1 then
        dbms_output.put_line('출판사번호 : ' || vseq);
        dbms_output.put_line('출판사명 : ' || vname);
    else
        dbms_output.put_line('해당 출판사가 없습니다. 새로 등록해 주세요');
    end if;
end;
/



-- 출판사 등록하기 프로시저
create or replace procedure procnewpub (
    pname tblPublisher.name%type,
    presult out number
)
is
begin

    insert into tblPublisher values ((select max(publisher_seq) +1 from tblPublisher), pname);
    presult := 1;
exception
    when others then
        presult := 0;
end procnewpub;



-- 출판사 등록하기
declare
    vresult number;
begin
    procnewpub('테스트', vresult);
    if vresult = 1 then
        dbms_output.put_line('출판사 등록에 성공하셨습니다.');
    else
        dbms_output.put_line('출판사 등록에 실패하였습니다.');
    end if;
end;





-- 추천도서 등록하기 프로시저
create or replace procedure procTeachRecin (
    p_tname tblteacher.t_name%type,
    p_tpassword tblteacher.t_password%type,
    p_bookname tblTeachRec.rec_name%type,
    p_subname tblSubjectName.subname%type,
    p_pubname tblPublisher.name%type,
    presult out number
)
is
begin
    insert into tblTeachRec 
        values ((select max(book_seq) + 1 from tblTeachRec),
            (select teacher_seq from tblteacher where t_name = p_tname and t_password = p_tpassword), -- 교사번호 입력 '최경하' / 2532102
            p_bookname, -- 책 제목 입력
            sysdate, 
            (select subname_seq from tblsubjectname where subname = p_subname), -- 과목번호 가져오기  'Java'
            (select publisher_seq from tblpublisher where name = p_pubname)); -- 출판사 번호 가져오기  '테스트'
            
            presult := 1;

exception
    when others then
        presult := 0;
end procTeachRecin;




-- 추천도서 등록하기
declare
    vresult number;
begin
    procTeachRecin('최경하', 2532102, '테스트북', 'Java', '테스트', vresult);
    if vresult = 1 then
        dbms_output.put_line('추천도서 등록에 성공하셨습니다.');
    else
        dbms_output.put_line('추천도서 등록에 실패하셨습니다.');
    end if;
end;





-- 추천도서 도서명 수정하기 프로시저
create or replace procedure procprocTeachRecup1 (
    p_rec_name tblTeachRec.rec_name%type,
    p_book_seq tblTeachRec.book_seq%type,
    presult out number
)
is
begin
        update tblTeachRec set rec_name = p_rec_name where book_seq = p_book_seq; -- 도서번호 1의 도서명 수정하기
        presult := 1;
exception
    when others then
        presult := 0;
end procprocTeachRecup1;



-- 추천 도서명 수정하기
declare
    vresult number;
begin
    procprocTeachRecup1('테스트',1 ,vresult);
    
    if vresult = 1 then
        dbms_output.put_line('도서명 수정에 성공하셨습니다.');
    else
        dbms_output.put_line('도서명 수정에 실패하셨습니다.');
    end if;
end;




-- 추천도서 연관과목 수정하기 프로시저
create or replace procedure procprocTeachRecup2 (
    p_subname tblsubjectname.subname%type,
    p_book_seq tblTeachRec.book_seq%type,
    presult out number
)
is
begin
        update tblTeachRec set subname_seq = (select subname_seq from tblsubjectname where subname = p_subname) where book_seq = p_book_seq; -- 연관과목 변경하기
        presult := 1;
exception
    when others then
        presult := 0;
end procprocTeachRecup2;



-- 추천 도서 연관과목 수정하기
declare
    vresult number;
begin
    procprocTeachRecup2('Oracle',1 ,vresult);
    
    if vresult = 1 then
        dbms_output.put_line('과목 수정에 성공하셨습니다.');
    else
        dbms_output.put_line('과목 수정에 실패하셨습니다.');
    end if;
end;



-- 추천도서 출판사 수정하기 프로시저
create or replace procedure procprocTeachRecup3 (
    p_publisher tblpublisher.name%type,
    p_book_seq tblTeachRec.book_seq%type,
    presult out number
)
is
begin
        update tblTeachRec set publisher_seq = (select publisher_seq from tblpublisher where name = p_publisher) where book_seq = p_book_seq; -- 출판사 변경하기
        presult := 1;
exception
    when others then
        presult := 0;
end procprocTeachRecup3;



-- 추천 도서 출판사 수정하기
declare
    vresult number;
begin
    procprocTeachRecup3('비제이퍼블릭',1 ,vresult);
    
    if vresult = 1 then
        dbms_output.put_line('출판사 수정에 성공하셨습니다.');
    else
        dbms_output.put_line('출판사 수정에 실패하셨습니다.');
    end if;
end;




-- 추천 도서 삭제하기 프로시저
create or replace procedure procPublisherde (
    pnum number,
    presult out number
)
is
begin
    delete tblTeachRec where book_seq = pnum;
exception
    when others then
        presult := 0;
end procPublisherde;


-- 추천 도서 삭제하기
declare
    vresult number;
begin
    procPublisherde(51, vresult);
    if vresult = 1 then
        dbms_output.put_line('추천도서 삭제에 성공하셨습니다.');
    else
        dbms_output.put_line('추천도서 삭제에 실패하셨습니다.');
    end if;
end;