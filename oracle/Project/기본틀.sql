-- ddl

/* 1. 회원 */
create table tblMember (
	member_seq number not null, /* 회원번호 */
	m_name varchar2(15) unique not null, /* 이름 */
	m_password number unique not null, /* 주민번호뒷자리 */
	m_tel varchar2(15) unique not null, /* 전화번호 */
	m_registdate date not null , /* 등록일 */
	m_major varchar2(15) not null, /* 전공여부 */
    
    constraint pk_tblmember primary key (member_seq),

    constraint tblmember_m_major check(m_major in('전공', '유사전공', '비전공')),
    constraint tblmember_member_seq_ck check (member_seq >= 1)
);

select * from tblMember;
drop table tblMember;


/* 2. 교사 */
create table tblteacher (
	teacher_seq number not null, /* 교사번호 */
	t_name varchar2(15) unique not null, /* 교사이름 */
	t_password number not null, /* 주민등록번호뒷자리 */
	t_tel varchar2(15) not null, /* 전화번호 */
    
    constraint pk_tblteacher primary key (teacher_seq)
    
);

select * from tblteacher;
drop table tblteacher;
ALTER TABLE tblteacher DROP CONSTRAINT tblteacher_teacher_seq_ck;

/* 3. 관리자 */
create table tblAdmin (
	admin_seq number not null, /* 관리자번호 */
	id varchar2(20) not null, /* 아이디 */
	password varchar2(20) not null, /* 비밀번호 */
    
    constraint pk_tbladmin primary key (admin_seq),
    
    constraint tbladmin_admin_seq_ck check (admin_seq >= 1)
);


select * from tblAdmin;
drop table tblAdmin;


/* 과목명 */
create table tblSubjectName (
	subname_seq number not null, /* 과목명번호 */
	subname varchar2(30) not null, /* 과목명 */
	subname_subject varchar2(15) not null, /* 과목종류 */
    
    constraint pk_tblsubjectname primary key (subname_seq),
    constraint tblsubname_subname_subject_ck check (subname_subject in ('공통','선택')),
    
    constraint tblsubname_seq_pk check (subname_seq >= 1)
);

select * from tblSubjectName;
drop table tblSubjectName;


/* 강의실 */
create table tblRoom (
	room_seq number not null, /* 강의실번호 */
	room_name varchar2(20) null, /* 강의실 명 */
	room_personel number not null, /* 수용인원 */
    
    constraint pk_tblroom primary key (room_seq),
    
    constraint tblroom_room_seq_ck check(room_seq between 1 and 6),
    constraint tblroom_room_personel_ck check(room_personel <= 30)
    
);

ALTER TABLE tblRoom DROP CONSTRAINT tblroom_room_seq_ck;
select * from tblRoom;
drop table tblRoom;



/* 협력기업테이블 */
create table tblEnterprise (
	enterprise_seq number not null, /* 협력기업번호 */
	ent_name varchar2(60) not null, /* 기업명 */
	ent_people number not null, /* 구인인원 */
	ent_type varchar2(15) not null, /* 구인형태 */
	ent_sector varchar2(15) not null, /* 업종 */
	ent_recuit  varchar2(30)not null, /* 모집부분 */
    
    constraint pk_tblenterprise primary key (enterprise_seq),
    
    constraint tblenter_ent_type_ck check (ent_type in ('정규직','계약직','인턴')),

    constraint tblenter_ent_sector_ck check (ent_sector in ('SI','SM','Solution','SE','OP','SP')),
    constraint tblenter_ent_recuit_ck check (ent_recuit in ('안드로이드 개발', 'IOS개발','백엔드/서버개발','유지보수','웹개발','정보보안','프론트엔드','CPO','CISO', '보안컨설팅' )),
    constraint tblenter_enterprise_seq_ck check (enterprise_seq >= 1)
);
	
select * from tblEnterprise;
drop table tblEnterprise;


/* 출판사 */
create table tblPublisher (
	publisher_seq number not null, /* 출판사번호 */
	name varchar2(60) not null, /* 출판사명 */
    
    constraint pk_publisher primary key (publisher_seq),
  
    constraint tblpublisher_publisher_seq_ck check (publisher_seq >= 1)
);

select * from tblPublisher;
drop table tblPublisher;


/* 과정명 */
create table tblCourseName (
	cname_seq number not null, /* 과정명번호 */
	course_neme varchar2(255) not null, /* 과정명 */
    
    constraint pk_tblcoursename primary key (cname_seq),
    
    constraint tblcoursename_cname_seq_ck check (cname_seq >= 1)
);

select * from tblCourseName;
drop table tblCourseName;


/* 교재 */
create table tblTextBook (
	txtbook_seq number not null, /* 교재번호 */
	name varchar2(255) not null, /* 교재명 */
	author varchar2(60) not null, /* 지은이(낭궁성 외 2명) */
	publisher_seq number not null, /* 출판사번호 */
    
    constraint pk_tbltextbook primary key (txtbook_seq),
    
    constraint tbltextbook_txtbook_seq_ck check (txtbook_seq >= 1),
    
    constraint tbltextbook_publisher_seq_fk foreign key (publisher_seq) references tblpublisher (publisher_seq)
);

select * from tblTextBook;
drop table tblTextBook;


/* 과목에 쓰이는 교재 */
create table tblSubjectTxt (
	subtxt_seq number not null, /* 과목교재번호 */
	subname_seq number not null, /* 과목명번호 */
	txtbook_seq number not null, /* 교재번호 */
    
    constraint pk_tblsubjecttxt primary key (subtxt_seq),
    
    constraint tblsubjecttxt_subtxt_seq_ck check (subtxt_seq >= 1),
    
 	constraint tblsubjecttxt_subname_seq_fk foreign key (subname_seq) references tblsubjectname (subname_seq),
	constraint tblsubjecttxt_txtbook_seq_fk	foreign key (txtbook_seq) references tbltextbook (txtbook_seq)
);

select * from tblSubjectTxt;
drop table tblSubjectTxt;


/* 교사 강의 목록 */
create table tblTeacherSub (
	tsubject_seq number not null, /* 교사강의목록번호 */
	teacher_seq number not null, /* 교사번호 */
	subname_seq number not null, /* 과목명번호 */
    
    constraint pk_tblteachersub primary key (tsubject_seq),
    
    constraint tblteachersub_tsubject_seq_ck check (tsubject_seq >= 1),
    
	constraint tblteachersub_teacher_seq_fk foreign key (teacher_seq) references tblteacher (teacher_seq),
    constraint tblteachersub_subname_seq_fk foreign key (subname_seq) references tblsubjectname (subname_seq)
);

select * from tblTeacherSub;
drop table tblTeacherSub;


/* 과정 내 과목들(정적) */
create table tblCSubStop (
	csubstop_seq number not null, /* 과정내과목들(정적)번호 */
	cname_seq number not null, /* 과정명번호 */
	subname_seq number not null, /* 과목명번호 */
    
    constraint pk_tblcsubstop primary key (csubstop_seq),
    
    constraint tblcsubstop_csubstop_seq_ck check (csubstop_seq >= 1),
    
	constraint tblcsubstop_cname_seq_fk	foreign key (cname_seq)	references tblcoursename (cname_seq),
	constraint tblcsubstop_subname_seq_fk foreign key (subname_seq)	references tblsubjectname (subname_seq)
);

select * from tblCSubStop;
drop table tblCSubStop;


/* 교사 추천 도서 */
create table tblTeachRec (
	book_seq number not null, /* 도서번호 */
	teacher_seq number not null, /* 교사번호 */
	rec_name varchar2(255) not null, /* 도서명 */
	book_date date not null, /* 등록일 */
	subname_seq number not null, /* 과목명번호 */
	publisher_seq number not null, /* 출판사번호 */
    
    constraint pk_tblteachrec primary key (book_seq),
    
    constraint tblteachrec_book_seq_ck check (book_seq >= 1),
    
    constraint tblteachrec_teacher_seq_fk foreign key (teacher_seq)	references tblteacher (teacher_seq),
    constraint tblteachrec_subname_seq_fk foreign key (subname_seq) references tblsubjectname (subname_seq),
	constraint tblteachrec_publisher_seq_fk foreign key (publisher_seq) references tblpublisher (publisher_seq)
);

select * from tblTeachRec;
drop table tblTeachRec;


/* 시험문제 */
create table tblTestName (
	testname_seq number not null, /* 시험문제번호 */
	test varchar2(255) not null, /* 시험문제 */
	test_type varchar2(10) not null, /* 유형 */
	subname_seq number not null, /* 과목명번호 */
    
    constraint pk_tbltestname primary key (testname_seq),
    
    constraint tbltestname_testname_seq_ck check (testname_seq >= 1),
    constraint tbltestname_test_type_ck check (test_type in ('필기', '실기')),
    constraint tbltestname_subname_seq_fk foreign key (subname_seq)	references tblsubjectname (subname_seq)
);

select * from tblTestName;
drop table tblTestName;


/* 교사가 정한 시험문제 */
create table tblTest (
	testnum_seq number not null, /* 교사가정한시험문제번호 */
	teacher_seq number not null, /* 교사번호 */
	testname_seq number not null, /* 시험문제번호 */
    
    constraint pk_tbltest primary key (testnum_seq),
    
    constraint tbltest_testnum_seq_ck check (testnum_seq >= 1),
    
    constraint tbltest_teacher_seq_fk foreign key (teacher_seq) references tblteacher (teacher_seq),
    constraint tbltest_testname_seq_fk foreign key (testname_seq) references tbltestname (testname_seq)
);

select * from tblTest;
drop table tblTest;


/* 개설 과정 */
create table tblCourse (
	course_seq number not null, /* 개설과정번호 */
	c_start_date date not null, /* 개설과정시작날짜 */
	c_end_date date not null, /* 개설과정끝날짜 */
	cname_seq number not null, /* 과정명번호 */
	teacher_seq number not null, /* 교사번호 */
	room_seq number not null, /* 강의실번호 */
    
    constraint pk_tblcourse primary key (course_seq),
    
    constraint tblcourse_course_seq_ck check (course_seq >= 1),
    
    constraint tblcourse_teacher_seq_fk foreign key (teacher_seq) references tblteacher (teacher_seq),
	constraint tblcourse_room_seq_fk foreign key (room_seq) references tblroom (room_seq),
	constraint tblcourse_cname_seq_fk foreign key (cname_seq) references tblcoursename (cname_seq)

);

select * from tblCourse;
drop table tblCourse;


/* 개설 과정 내 과목명(동적) */
create table tblCSub (
	csub_seq number not null, /* 개설과정내과목번호 */
	subname_seq number not null, /* 과목명번호 */
	course_seq number not null, /* 개설과정번호 */
	csstart_date date not null, /* 과목시작일 */
	csend_date date not null, /* 과목종료일 */
    
    constraint pk_tblcsub primary key (csub_seq),
    
    constraint tblcsub_csub_seq_ck check (csub_seq >= 1),
    
    constraint tblcsub_subname_seq_fk foreign key (subname_seq)	references tblsubjectname (subname_seq),
    constraint tblcsub_course_seq_fk foreign key (course_seq) references tblcourse (course_seq)
);

select * from tblCSub;
drop table tblCSub;


/* 시험 날짜 */
create table tblTestDate (
	testdate_seq number not null, /* 시험날짜번호 */
	test_date date, /* 시험날짜 */
	testnum_seq number not null, /* 교사가정한시험문제번호 */
	csub_seq number not null, /* 개설과정내과목번호 */
    
    constraint pk_tbltestdate primary key (testdate_seq),
    
    constraint tbltestdate_testdate_seq_ck check (testdate_seq >= 1),
    
	constraint tbltestdate_testnum_seq_fk foreign key (testnum_seq) references tbltest (testnum_seq),
	constraint tbltestdate_csub_seq_fk foreign key (csub_seq) references tblcsub (csub_seq)
);

select * from tblTestDate;
drop table tblTestDate;


/* 과목 배점 설정 */
create table tblSubtPoint (
	subpoint_seq number not null, /* 과목배점번호 */
	attend_point number null, /* 출결배점 */
	pilgi_point number null, /* 필기배점 */
	silgi_point number null, /* 실기배점 */
	teacher_seq number not null, /* 교사번호 */
	csub_seq number, /* 개설과정내과목번호 */
    
    constraint pk_tblsubtpoint primary key (subpoint_seq),
    
    constraint tblsubtpoint_subponit_seq_ck check (subpoint_seq >= 1),
    constraint tblsubtpoint_attend_point_ck check (attend_point >= 20),
    constraint tblsubtpoint_sum_ck check (attend_point + pilgi_point + silgi_point = 100),
    constraint tblsubtpoint_teacher_seq_fk foreign key (teacher_seq) references tblteacher (teacher_seq),
    constraint tblsubtpoint_csub_seq_fk foreign key (csub_seq) references tblcsub (csub_seq)
);

select * from tblSubtPoint;
drop table tblSubtPoint;


/* 수강 */
create table tblSugang (
	sugang_seq number not null, /* 수강번호 */
	complete_date date, /* 수료일 */
	progress varchar2(20) not null, /* 진행상태 */
	member_seq number not null, /* 회원번호 */
	course_seq number, /* 개설과정번호 */
    
    constraint pk_tblsugang	primary key (sugang_seq),
    
    constraint tblsugang_sugang_seq_ck check (sugang_seq >= 1),
    
    constraint tblsugang_member_seq_fk foreign key (member_seq)	references tblmember (member_seq),
    constraint tblsugang_progress_ck check (progress in('수강예정', '수강중', '수강종료', '중도탈락')),
    constraint tblsugang_course_seq_fk foreign key (course_seq)	references tblcourse (course_seq)
);

select * from tblSugang;
drop table tblSugang;


/* 교육생 중도 탈락 */
create table tblStustop (
	stustop_seq number not null, /* 중도탈락번호 */
	stop_date date not null, /* 중도탈락날짜 */
	sugang_seq number not null, /* 수강번호 */
    
    constraint pk_tblstustop primary key (stustop_seq),
    
    constraint tblstustop_stustop_seq_ck check (stustop_seq >= 1),
    
    constraint tblstustop_sugang_seq_fk foreign key (sugang_seq) references tblsugang (sugang_seq)
);

select * from tblStustop;
drop table tblStustop;


/* 교육생취업활동 */
create table tblJobAct (
	jobact_seq number not null, /* 교육생취업활동번호 */
	jobact_date varchar2(255), /* 교육생취업활동내역(깃허브주소,url주소,pdf파일,작성하는글자체 ) */
	sugang_seq number not null, /* 수강번호 */
    
    constraint pk_tbljobact primary key (jobact_seq),
    
    constraint tbljobact_jobact_seq_ck check (jobact_seq >= 1),
    
	constraint tbljobact_sugang_seq_fk foreign key (sugang_seq) references tblsugang (sugang_seq)

);

select * from tblJobAct;
drop table tblJobAct;


/* 교육생취업관리 */
create table tblemploye (
	employe_seq number not null, /* 교육생취업관리번호 */
	lnsurance_have varchar2(5) default 'N', /* 고용보험파일여부 */
	ent_viewdate date not null, /* 협력기업테이블조회가능일 */
	sugang_seq number not null, /* 수강번호 */
    
    constraint pk_tblemploye primary key (employe_seq),
    
    constraint tblemploye_employe_seq_ck check (employe_seq >= 1),
    constraint tblemploye_lnsurance_have_ck check (lnsurance_have in ('Y','N')),
    
    constraint tblemploye_sugang_seq_fk foreign key (sugang_seq) references tblsugang (sugang_seq)
);

select * from tblemploye;
drop table tblemploye;


/* 출결상황 */
create table tblAttendance (
	attendance_seq number not null, /* 출결번호 */
	attend_date date not null, /* 출결날짜 */
	in_time date null, /* 입실시간 */
	out_time date null, /* 퇴실시간 */
	attendance_type varchar2(10) not null, /* 근태상황 */
	sugang_seq number not null, /* 수강번호 */
    
    constraint pk_tblattendance primary key (attendance_seq),
    
    constraint tblatten_attendance_seq_ck check (attendance_seq >= 1),
    constraint tblatten_attendance_type_ck check (attendance_type in ('정상','지각','조퇴','병가','기타','결석')),
    constraint tblatten_sugang_seq_fk foreign key (sugang_seq) references tblsugang (sugang_seq)
);

select * from tblAttendance;
drop table tblAttendance;


/* 성적 */
create table tblScore (
	score_seq number not null, /* 성적번호 */
	attend_score number, /* 출결점수 */
	pilgi_score number, /* 필기점수 */
	silgi_score number, /* 실기점수 */
	csub_seq number not null, /* 개설과정내과목번호 */
	sugang_seq number not null, /* 수강번호 */
    
    constraint pk_tblscore primary key (score_seq),
    
    constraint tblscore_score_seq_ck check (score_seq >= 1),
    
	constraint tblscore_csub_seq_fk foreign key (csub_seq) references tblcsub (csub_seq),
	constraint tblscore_sugang_seq_fk foreign key (sugang_seq) references tblsugang (sugang_seq)
);

select * from tblScore;
drop table tblScore;


/* 과목상담 */
create table tblConsult (
	consult_seq number not null, /* 과목상담목록번호 */
	consult_txt varchar2(255) not null, /* 상담내용 */
	csub_seq number not null, /* 개설과정내과목번호 */
	sugang_seq number not null, /* 수강번호 */
    
    constraint pk_tblconsult primary key (consult_seq),
    
    constraint tblconsult_consult_seq_ck check (consult_seq >= 1),
    
    constraint tblconsult_csub_seq_fk foreign key (csub_seq) references tblcsub (csub_seq),
    constraint tblconsult_sugang_seq_fk foreign key (sugang_seq) references tblsugang (sugang_seq)
);

select * from tblConsult;
drop table tblConsult;


/* 과목답변 */
create table tblAnswer (
	answer_seq number not null, /* 과목상담답변번호 */
	answer_txt varchar2(255) not null, /* 상담답변 */
	teacher_seq number not null, /* 교사번호 */
	-- csub_seq number not null, /* 개설과정내과목번호 */
	consult_seq number not null, /* 과목상담목록번호 */
    
    constraint pk_tblanswer	primary key (answer_seq),
    
    constraint tbltblanswer_answer_seq_ck check (answer_seq >= 1),
    
    constraint tblanswer_teacher_seq_fk foreign key (teacher_seq) references tblteacher (teacher_seq),
	-- constraint tblanswer_csub_seq_fk foreign key (csub_seq) references tblcsub (csub_seq),
	constraint tblanswer_consult_seq_fk foreign key (consult_seq) references tblconsult (consult_seq)

);

select * from tblAnswer;
drop table tblAnswer;