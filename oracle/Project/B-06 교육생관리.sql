-- 회원 등록하기
insert into tblmember (member_seq, m_name, m_password, m_tel, m_registdate, m_major) 
    values ((select max(member_seq) from tblMember) + 1, '아무개', 1847223, '010-8156-8192', sysdate, '전공');

-- 회원 이름 수정하기    
update tblMember set m_name = '김무개' where member_seq = 281;

-- 회원 주민번호 뒷자리(비밀번호) 수정하기
update tblMember set m_password = 1874223 where member_seq = 281;

-- 회원 전화번호 수정하기
update tblMember set m_tel = '010-8516-8192' where member_seq = 281;

-- 회원 전공여부 수정하기
update tblMember set m_major = '비전공' where member_seq = 281;

delete tblMember where member_seq = 281;


-- 수강생 등록하기
insert into tblsugang (sugang_seq, complete_date, progress, member_seq, course_seq) values

select * from tblMember where member_seq=281;