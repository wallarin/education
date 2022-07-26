-- 수경님
select
        cn.course_neme as "개설 과정명",
        c.c_start_date as "개설과정 시작날짜",
        c.c_end_date as "개설과정 종료날짜",
        r.room_name as "강의실명",
        t.t_name as "교사명",
        case when c.course_seq in (select distinct course_seq from tblCSub) then 'Y'
             else 'N' 
        end as "개설과목 등록여부",
        (select count(*) from tblSugang where course_seq = c.course_seq) as "수강 인원"
    from tblCourse c
        inner join tblCourseName cn
            on c.cname_seq = cn.cname_seq
                inner join tblRoom r
                    on c.room_seq = r.room_seq
                        inner join tblteacher t
                            on c.teacher_seq = t.teacher_seq
                                order by c.c_start_date desc, cn.course_neme desc;













select 
    sj.subname,
    cs.csstart_date,
    cs.csend_date
from tblCSub cs
    inner join tblSubjectname sj 
        on cs.subname_seq = sj.subname_seq
            inner join tblCourse c 
                on cs.course_seq = c.course_seq
                            where c.teacher_seq = 1;

















