-- 추천도서 전체 조회하기
select * from vwtblTeachRec;



-- 특정 교사가 추천한 도서보기 프로시저
create or replace procedure procPublisherse (
    pname tblTeacher.t_name%type,
    presult out number
)
is
    p_book_seq tblTeachRec.book_seq%type;
    p_rec_name tblTeachRec.rec_name%type;
    p_name tblPublisher.name%type;
    p_book_date tblTeachRec.book_date%type;
    p_t_name tblTeacher.t_name%type;
    p_subname tblSubjectName.subname%type;
    
    cursor vcursor is select 
    tr.book_seq as "추천도서번호",
    tr.rec_name as "추천도서명", 
    p.name as "출판사", 
    tr.book_date as "등록일", 
    t.t_name as "등록 교사", 
    sn.subname as "연관 과목명" 
    
    from tblTeachRec tr 
        inner join tblTeacher t 
            on tr.teacher_seq = t.teacher_seq 
                inner join tblSubjectName sn 
                    on tr.subname_seq = sn.subname_seq
                        inner join tblPublisher p 
                            on tr.publisher_seq = p.publisher_seq
                                where t.t_name = pname
                                    order by tr.book_seq;
begin
    open vcursor;
        dbms_output.put_line('===========================================');
        loop
            fetch vcursor into p_book_seq, p_rec_name, p_name, p_book_date, p_t_name, p_subname;
            exit when vcursor%notfound;
            dbms_output.put_line('추천도서번호 : ' || p_book_seq || '     추천도서명 : ' 
            || p_rec_name || '                출판사 : ' || p_name || '  등록일 : ' || p_book_date || '   등록 교사 : ' || p_t_name || '  연관 과목명 : ' || p_subname);
        end loop;
        dbms_output.put_line('===========================================');
    close vcursor;
    presult := 1;
exception
    when others then
        presult := 0;
end procPublisherse;




declare
    vresult number;
begin
    procPublisherse('최경하', vresult);
    if vresult = 1 then
        dbms_output.put_line('조회 종료');
    else
        dbms_output.put_line('예상치 못한 오류가 발생했습니다.');
    end if;
end;