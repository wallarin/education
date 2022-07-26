-- 출결 관리 및 조회 내 개설과정
select 
    c.course_seq as "강의번호",
    n.course_neme as "강의 과정명", 
    case 
        when sysdate < c.c_start_date then '강의예정'
        when sysdate between c.c_start_date and c.c_end_date then '강의중'
        when sysdate > c.c_end_date then '강의종료' 
    end as "강의상태"
from tblCourse c inner join tblcoursename n 
    on c.cname_seq = n.cname_seq where c.teacher_seq = 
        (select teacher_seq from tblteacher where t_name = '최경숙' and t_password = 2532102) order by c.c_end_date desc; 





-- 특정 강의 선택 해당 강의 내 교육생 출결현황
-- Case 1.
select 
    su.sugang_seq as "수강생 번호",
    m.m_name as "수강생 이름",
    ad.attend_date as "출석일",
    ad.attendance_type as "상태"
from tblSugang su 
    inner join tblAttendance ad 
        on su.sugang_seq = ad.sugang_seq 
            inner join tblMember m 
                on su.member_seq = m.member_seq 
                    where su.course_seq = 25 
                        order by ad.attend_date;
                        
-- Case 2.
select distinct
    s.sugang_seq as "수강생번호",
    m.m_name "수강생 이름",
    (select count(*) from tblattendance where attendance_type = '정상' and sugang_seq = s.sugang_seq) as 정상,
    (select count(*) from tblattendance where attendance_type = '지각' and sugang_seq = s.sugang_seq) as 지각,
    (select count(*) from tblattendance where attendance_type = '조퇴' and sugang_seq = s.sugang_seq) as 조퇴,
    (select count(*) from tblattendance where attendance_type = '외출' and sugang_seq = s.sugang_seq) as 외출,
    (select count(*) from tblattendance where attendance_type = '병가' and sugang_seq = s.sugang_seq) as 병가,
    (select count(*) from tblattendance where attendance_type = '기타' and sugang_seq = s.sugang_seq) as 기타,
    (select count(*) from tblattendance where attendance_type = '결석' and sugang_seq = s.sugang_seq) as 결석
from tblcourse c
    inner join tblcoursename cn
        on c.cname_seq = cn.cname_seq
            inner join tblsugang s
                on c.course_seq = s.course_seq
                    inner join tblmember m
                        on s.member_seq = m.member_seq
                            inner join tblattendance a
                                on s.sugang_seq = a.sugang_seq
                                    where c.course_seq = 25;
                        
                        
-- 년도별 출력
select 
    su.sugang_seq as "수강생 번호",
    m.m_name as "수강생 이름",
    to_char(ad.attend_date, 'YYYY-MM-DD') as "출석일",
    ad.attendance_type as "상태"
from tblSugang su 
    inner join tblAttendance ad 
        on su.sugang_seq = ad.sugang_seq 
            inner join tblMember m 
                on su.member_seq = m.member_seq 
                    where su.course_seq = 25 and ad.attend_date like '22/04/01'
                        order by ad.attend_date;
                        
                        

-- 월별 출력                        
select 
    su.sugang_seq as "수강생 번호",
    m.m_name as "수강생 이름",
    ad.attend_date as "출석일",
    ad.attendance_type as "상태"
from tblSugang su 
    inner join tblAttendance ad 
        on su.sugang_seq = ad.sugang_seq 
            inner join tblMember m 
                on su.member_seq = m.member_seq 
                    where su.course_seq = 25 and ad.attend_date like '22/03%'
                        order by ad.attend_date;
                        
            
-- 일별 출력                        
select 
    su.sugang_seq as "수강생 번호",
    m.m_name as "수강생 이름",
    ad.attend_date as "출석일",
    ad.attendance_type as "상태"
from tblSugang su 
    inner join tblAttendance ad 
        on su.sugang_seq = ad.sugang_seq 
            inner join tblMember m 
                on su.member_seq = m.member_seq 
                    where su.course_seq = 25 and ad.attend_date like '22/03/01%'
                        order by ad.attend_date;
                        



-- 특정 교육생 출결현황
select attend_date as "출석일", attendance_type as "상태" from tblAttendance where sugang_seq = 184;