--D_08_3 과목상담내역조회

create or replace procedure procSubConsult(
    psugang_num number,
    psubname tblSubjectName.subname%type
)
is
    vsubname         tblSubjectName.subname%type;
    vcourse          tblCourseName.course_neme%type;
    vconsult         tblConsult.consult_txt%type;
    vanswer          tblAnswer.answer_txt%type;
    vteacher         tblTeacher.t_name%type;
    
    cursor vcursor 
    is
    select 
        sj.subname,
        cn.course_neme,
        c.consult_txt,
        a.answer_txt,
        t.t_name 
    from tblConsult c
        left outer join tblAnswer a 
            on c.consult_seq = a.consult_seq 
                left outer join tblCSub cs 
                    on c.csub_seq = cs.csub_seq 
                        left outer join tblSubjectName sj 
                            on cs.subname_seq = sj.subname_seq
                                left outer join tblTeacher t 
                                    on a.teacher_seq = t.teacher_seq
                                        left outer join tblAnswer a 
                                             on c.consult_seq = a.consult_seq 
                                                left outer join tblCourse cr 
                                                    on cs.course_seq = cr.course_seq
                                                        left outer join tblcoursename cn 
                                                            on cr.cname_seq = cn.cname_seq
                 
    where sj.subname = psubname and c.sugang_seq = psugang_num ; -- 번호 입력

begin 

    dbms_output.put_line(rpad('과목명', 10, ' ') || '| ' || 
                                rpad('과정명', 20, ' ') || '| ' || 
                                rpad('상담내용', 40, ' ') || '    | ' || 
                                rpad('답변', 40, ' ') || '    | ' || '강사명');
    dbms_output.put_line('=============================================================================================================');
    dbms_output.put_line(' ');
    
    open vcursor;
    loop
             
        fetch vcursor into vsubname, vcourse, vconsult, vanswer, vteacher;
        exit when vcursor%notFound;
        
         if
            length(vteacher) > 0 
        then vanswer := vanswer;        
        else
            vanswer := 'null';
            vteacher := 'null';
                
        end if;
            
        dbms_output.put_line(rpad(vsubname, 10, ' ') || '| ' || 
                                rpad(vcourse, 20, ' ') || '| ' || 
                                rpad(vconsult, 40, ' ') || '... | ' || 
                                rpad(vanswer, 40, ' ') || '... | ' || vteacher); 
        dbms_output.put_line(' ');
    
    end loop;
    close vcursor;

end procSubConsult;
/


--실행
begin
    procSubConsult(197, 'Java');
end;
/

--------------------------------------------------------------------------------
-- D-06. 과목상담 내용 수정 프로시저
create or replace procedure procUpdateCtxt (
    psugang_num tblSugang.sugang_seq%type,      -- 수강번호
    pcsub_seq tblCsub.csub_seq%type,            -- 개설과목번호
    pconsult_seq tblConsult.consult_seq%type,   -- 과목상담번호
    pconsult_txt tblConsult.consult_txt%type,   -- 상담 내용
    presult out number
)
is
begin
        update tblConsult
        set consult_txt = pconsult_txt
        where sugang_seq = psugang_num and csub_seq = csub_seq and consult_seq = pconsult_seq;
        presult := 1;
exception
    when others then
        presult := 0;
end procUpdateCtxt;
/

-- 상담 내용 수정하기
declare
    vresult number;
begin
    procUpdateCtxt(197, 128, 24, '안녕하세요.선생님',vresult);
    
    if vresult = 1 then
        dbms_output.put_line('상담 내용 수정이 완료되었습니다.');
    else
        dbms_output.put_line('상담 내용 수정이 실패하였습니다.');
    end if;
end;
/
-- 결과보기
select * from tblConsult where(sugang_seq = 197);
rollback;

--------------------------------------------------------------------------------
-- D-06 과목상담 내용 삭제 프로시저
create or replace procedure procDeleteCtxt (
    psugang_num tblSugang.sugang_seq%type,      -- 수강번호
    pcsub_seq tblCsub.csub_seq%type,            -- 개설과목번호
    pconsult_seq tblConsult.consult_seq%type,   -- 과목상담번호
    presult out number
)
is
begin
    delete tblConsult
    where sugang_seq = psugang_num and csub_seq = csub_seq and consult_seq = pconsult_seq;
        presult := 1;
exception
    when others then
        presult := 0;
end procDeleteCtxt;
/

-- 상담내용 삭제하기
declare
    vresult number;
begin
    procDeleteCtxt(197, 136, 101, vresult);
    if vresult = 1 then
        dbms_output.put_line('상담 내용 삭제를 완료하였습니다.');
    else
        dbms_output.put_line('상담 내용 삭제를 실패하였습니다.');
    end if;
end;
/
-- 결과보기
select * from tblConsult where(sugang_seq = 197);
rollback;


