-- B-11 관리자 - 수료 교육생 취업활동 관리 pl-sql
-- 수료 교육생 취업활동 관리 특정 학생 조회
-- 개설과정, 협력기업조회가능일, 수료생이름으로 검색할 수 있다.
create or replace procedure procViewTblEmploye(
    pcourse_neme in varchar2,
    pm_name in varchar2
)
is
    mm_name tblmember.m_name%type;
    scomplete_date tblsugang.complete_date%type;
    cncourse_name tblcoursename.course_neme%type;
    elnsurance_have tblemploye.lnsurance_have%type;
    eent_viewdate tblemploye.ent_viewdate%type;
    jjobact_date tbljobact.jobact_date%type;
    cursor vcursor is
select 
    m.m_name as 수료생이름,
    s.complete_date as 수료일,
    cn.course_neme as 개설과정명,
    e.lnsurance_have as 고용보험등록,
    e.ent_viewdate as 협력기업조회가능일,
    j.jobact_date as 취업활동내역
from tblMember m
    inner join tblSugang s
    on m.member_seq = s.member_seq
    inner join tblEmploye e
    on s.sugang_seq = e.sugang_seq
    inner join tblJobAct j
    on s.sugang_seq = j.sugang_seq
    inner join tblCourse c
    on s.course_seq = c.course_seq
    inner join tblCourseName cn
    on c.cname_seq = cn.cname_seq
where upper(cn.course_neme) like upper('%'||pcourse_neme||'%') and m.m_name like '%'||pm_name||'%';
    
begin
    open vcursor; 
        dbms_output.put_line('==================================================================================================================================================================================='); 
        dbms_output.put_line(rpad('수료생이름', 12, ' ') || ' | ' ||  rpad('수료일', 12, ' ') || ' | ' ||  rpad('고용보험', 10, ' ') || ' | ' || rpad(' 조회가능일 ', 12, ' ') || ' | ' || rpad('취업활동내역', 25, ' ')|| ' | ' ||rpad('개설과정명 ', 10, ' '));
        dbms_output.put_line('==================================================================================================================================================================================='); 
        loop
            fetch vcursor into mm_name, scomplete_date, cncourse_name, elnsurance_have, eent_viewdate, jjobact_date;
            exit when vcursor%notfound;

                dbms_output.put_line(rpad(mm_name, 12, ' ') || ' | ' || rpad(scomplete_date, 12, ' ') || ' | ' || rpad(elnsurance_have, 10, ' ') || ' | ' || rpad(eent_viewdate, 12, ' ') || ' | ' || rpad(jjobact_date, 25, ' ') || ' | ' ||cncourse_name);     

        end loop;
        dbms_output.put_line('==================================================================================================================================================================================='); 
    close vcursor;

end;
/
set serverout on;

begin
    --procViewTblEmploye('aws', '박은채');
    procViewTblEmploye('aws', null);
end;
/
-- 수강생 번호로 조회
create or replace procedure procViewTblEmploye(
    psugang_seq in varchar2
)
is
    mm_name tblmember.m_name%type;
    scomplete_date tblsugang.complete_date%type;
    cncourse_name tblcoursename.course_neme%type;
    elnsurance_have tblemploye.lnsurance_have%type;
    eent_viewdate tblemploye.ent_viewdate%type;
    jjobact_date tbljobact.jobact_date%type;
    cursor vcursor is
select 
    m.m_name as 수료생이름,
    s.complete_date as 수료일,
    cn.course_neme as 개설과정명,
    e.lnsurance_have as 고용보험등록,
    e.ent_viewdate as 협력기업조회가능일,
    j.jobact_date as 취업활동내역
from tblMember m
    inner join tblSugang s
    on m.member_seq = s.member_seq
    inner join tblEmploye e
    on s.sugang_seq = e.sugang_seq
    inner join tblJobAct j
    on s.sugang_seq = j.sugang_seq
    inner join tblCourse c
    on s.course_seq = c.course_seq
    inner join tblCourseName cn
    on c.cname_seq = cn.cname_seq
where s.sugang_seq = psugang_seq;  
begin
    dbms_output.put_line('===================================================================================================================================================================================');    
    dbms_output.put_line(rpad('수료생이름', 12, ' ') || ' | ' ||  rpad('수료일', 12, ' ') || ' | ' ||  rpad('고용보험', 10, ' ') || ' | ' || rpad(' 조회가능일 ', 12, ' ') || ' | ' || rpad('취업활동내역', 25, ' ')|| ' | ' ||rpad('개설과정명 ', 10, ' '));
    dbms_output.put_line('==================================================================================================================================================================================='); 
    open vcursor; 
        loop
            fetch vcursor into mm_name, scomplete_date, cncourse_name, elnsurance_have, eent_viewdate, jjobact_date;
            exit when vcursor%notfound;

               dbms_output.put_line(rpad(mm_name, 12, ' ') || ' | ' || rpad(scomplete_date, 12, ' ') || ' | ' || rpad(elnsurance_have, 10, ' ') || ' | ' || rpad(eent_viewdate, 12, ' ') || ' | ' || rpad(jjobact_date, 25, ' ') || ' | ' ||cncourse_name);     

        end loop;
    close vcursor;
    dbms_output.put_line('==================================================================================================================================================================================='); 
end;

set serverout on;

begin
    procViewTblEmploye(3);
end;

-- 수료 교육생 취업활동 관리 전체 조회 view 생성

create or replace view vwTblEmploye
as
select 
    m.m_name as 수료생이름,
    s.complete_date as 수료일,
    cn.course_neme as 개설과정명,
    e.lnsurance_have as 고용보험등록,
    e.ent_viewdate as 협력기업조회가능일,
    j.jobact_date as 취업활동내역
from tblMember m
    inner join tblSugang s
        on m.member_seq = s.member_seq
            inner join tblEmploye e
                on s.sugang_seq = e.sugang_seq
                    inner join tblJobAct j
                        on s.sugang_seq = j.sugang_seq
                            inner join tblCourse c
                                on s.course_seq = c.course_seq
                                    inner join tblCourseName cn
                                        on c.cname_seq = cn.cname_seq;


-- 수료 교육생 취업활동 관리 전체 조회(view)
select * from vwtblemploye;

-- 수료 교육생 취업활동 관리 전체 조회(view) 개설과정명 일부 생략
select 
    "수료생이름", 
    "수료일", 
    case
        when length("개설과정명") > 10 then substr("개설과정명", 0, 10) || '...'
        else "개설과정명"
    end as "개설과정명"
    , "고용보험등록"
    , "협력기업조회가능일"
    , "취업활동내역" 
from vwtblemploye;


-- 수료 교육생 취업활동 관리 등록
create or replace procedure proctblemploye(
    pcourse_seq in number
)
is
    ssugang_seq tblsugang.sugang_seq%type;
    scomplete_date tblsugang.complete_date%type;
    ccourse_seq tblcourse.course_seq%type;
    cursor vcursor is
select 
    s.sugang_seq, 
    s.complete_date, 
    c.course_seq 
from tblsugang s
    inner join tblcourse c
        on s.course_seq = c.course_seq
    where sugang_seq in (select sugang_seq from tblsugang where progress = '수강종료') and c.course_seq = pcourse_seq;
begin
    open vcursor; 
        loop
            fetch vcursor into ssugang_seq, scomplete_date, ccourse_seq;
            exit when vcursor%notfound;

                insert into tblemploye (employe_seq, ent_viewdate, sugang_seq) values ((select max(employe_seq)+1 from tblemploye), add_months(to_date(scomplete_date), 6),ssugang_seq);
                insert into tblJobAct (jobact_seq, sugang_seq) values((select max(jobact_seq)+1 from tblJobAct), ssugang_seq);
                
        end loop;
    close vcursor;
end;


-- 25번의 개설과정번호로 해당되는 교육생 번호는 (181 ~ 197) tblemploye, tbljobact에 등록된다 
begin
    proctblemploye(25);
end;


-- 수료 교육생 취업관리 수정

-- 수료 교육생 취업관리(고용보험(tblemploye), 취업활동내역)
create or replace procedure procUpdateJobact(
    pinput in varchar2,
    pseq in tblJobact.sugang_seq%type,
    presult out number
)
is
begin

    if pinput = 'Y' then
        update tblEmploye set lnsurance_have = 'Y' where sugang_seq = pseq;
        presult := 1;
    elsif pinput = 'N' then
        update tblEmploye set lnsurance_have = 'N' where sugang_seq = pseq;
        presult := 1;
    elsif pinput is not null then
        update tblJobAct set jobact_date = pinput where sugang_seq = pseq;
        presult := 1;
    end if;
    
exception
    when others then
        presult := 0;
end;


declare
    vresult number;
begin
    
     --procUpdateJobact('N', 32, vresult);
     --procUpdateJobact('Y', 32, vresult);
     procUpdateJobact('자기소개서_임인세', 32, vresult);
     if(vresult = 1) then
        dbms_output.put_line('취업관리 정보 수정에 성공했습니다.');
    else 
        dbms_output.put_line('취업관리 정보 수정에 실패했습니다.');
    end if;
    
end;



-- 수료생 정보 삭제

-- 특정 날짜 학생 삭제
create or replace procedure procDelDateJobAct(

    pdate in tblemploye.ent_viewdate%type,
    presult out number

)
is
begin
    delete tbljobact where sugang_seq in (select sugang_seq from tblemploye where ent_viewdate < pdate);
    delete tblemploye where ent_viewdate < pdate;
    presult := 1;
exception
    when others then
        presult := 0;
end;

declare
    vresult number;
begin
    
    procDelDateJobAct(to_date('21-03-02', 'yy-mm-dd'), vresult);
     if(vresult = 1) then
        dbms_output.put_line('수료생 삭제 성공했습니다.');
    else 
        dbms_output.put_line('수료생 삭제 실패했습니다.');
    end if;
    
end;


-- 특정 학생 삭제
create or replace procedure procDelStuJobAct(

    pseq in tblemploye.sugang_seq%type,
    presult out number

)
is
begin
    delete tbljobact where sugang_seq = pseq;
    delete tblemploye where sugang_seq = pseq;
    presult := 1;
exception
    when others then
        presult := 0;
end;

declare
    vresult number;
begin
    
    procDelStuJobAct(31, vresult);
     if(vresult = 1) then
        dbms_output.put_line('수료생 삭제 성공했습니다.');
    else 
        dbms_output.put_line('수료생 삭제 실패했습니다.');
    end if;
    
end;