-- list 출력용 뷰
create or replace view vwhomeinfo as
select distinct h.seq, h.name, h.location, (select min(price) from tblRoom where hseq = h.seq) as price, (select path from tblRoom where seq = (select min(seq) from tblroom where hseq = h.seq)) as path, r.show, ht.value,
(select avg(star) from tblHomeReview where hseq in (select seq from tblHomeBook where rseq in (select seq from tblRoom where hseq in (select seq from tblHome where seq = h.seq)))) as star,
(select count(seq) from tblHomeReview where hseq in (select seq from tblHomeBook where rseq in (select seq from tblRoom where hseq in (select seq from tblHome where seq = h.seq)))) as reviewcount,
(select maxpeople from tblOptionList where rseq = (select seq from tblRoom where seq = h.seq)) as maxpeople
from tblHome h 
    left outer join tblRoom r on h.seq = r.hseq
    left outer join tblHomeType ht on h.tseq = ht.seq;

select * from tblHome h inner join tblroom r on h.seq = r.hseq;
    
select h.seq, h.name, h.location, (select min(price) from tblRoom where hseq = h.seq) as price, r.path from tblHome h left outer join tblRoom r on h.seq = r.hseq group by h.seq, h.name, h.location, r.path;
    
    
select * from vwhomeinfo;


select h.*, r.*, ht.*, (select min(price) from tblRoom where hseq = h.seq) as price,
(select avg(star) from tblHomeReview where hseq in (select seq from tblHomeBook where rseq in (select seq from tblRoom where hseq in (select seq from tblHome where seq = h.seq)))) as star,
(select count(seq) from tblHomeReview where hseq in (select seq from tblHomeBook where rseq in (select seq from tblRoom where hseq in (select seq from tblHome where seq = h.seq)))) as reviewcount,
(select maxpeople from tblOptionList where rseq = (select seq from tblRoom where seq = h.seq)) as maxpeople
from tblHome h 
    left outer join tblRoom r on h.seq = r.hseq
    left outer join tblHomeType ht on h.tseq = ht.seq;
    
    
-- 게시판 페이징
create or replace view vwCommu as
select tblBoard.*, (select count(bseq) from tblComment where bseq = tblBoard.seq) as commentcount from tblBoard order by thread desc, regdate desc ;

-- 방 상세보기 사진 따로 추출
CREATE TABLE tblRoom (
	seq	number	NOT NULL,
	hseq	number	NOT NULL,
	rseq	number	NOT NULL,
	name	varchar2(50)	NOT NULL,
	price	number	NOT NULL,
	path	varchar2(1000)	NOT NULL,
	show	varchar2(1)	DEFAULT 'n' NOT NULL	
);

-- 방 상세보기 후 방 사진 출력을 위한 테이블 새로 생성
create table tblroompic (
    seq number primary key,
    rseq number not null, -- references tblRoom(seq)
    fpath varchar2(1000) not null
);

-- 게시판 테이블 수정
CREATE TABLE tblBoard (
	seq	number	NOT NULL,
	id	varchar2(15)	NOT NULL,
	subject	varchar2(120)	NOT NULL,
	content	varchar2(1000)	NOT NULL,
	readcount	number DEFAULT 0 Not NULL	,
	regdate	date default sysdate	NOT NULL,
    commutype varchar2(20) default '일반' not null,
    thread number default 0 not null
);


-- 숙소 추가
insert into tblHome values (1, 'partner', 1, '신라호텔', '서울특별시 중구 동호로 249', '15:00', '11:00');
insert into tblHome values (2, 'partner', 1, '자바호텔', '서울특별시 중구 동호로 249', '15:00', '11:00');
insert into tblHome values (3, 'partner', 1, '오라클모텔', '서울특별시 강남구 역삼동 249', '15:00', '11:00');
insert into tblHome values (4, 'partner', 2, '오라클호텔', '서울특별시 강남구 역삼동 249', '15:00', '11:00');
insert into tblHome values (5, 'partner', 3, '오라클팬션', '서울특별시 강남구 삼성동 249', '15:00', '11:00');
insert into tblHome values (6, 'partner', 1, 'SQL모텔', '서울특별시 강남구 논현동 249', '15:00', '11:00');


insert into tblHome values (7, 'partner', 1, '밀리오레모텔', '서울특별시 중구 세종대로 81-5', '19:00', '12:00');
insert into tblHome values (8, 'partner', 1, '스카이모텔', '서울특별시 중구 을지로동 2-63', '20:30', '13:00');
insert into tblHome values (9, 'partner', 1, '아마레', '서울특별시 중구 명동 334', '17:30', '12:00');
insert into tblHome values (10, 'partner', 1, 'The May', '서울특별시 중구 신당동 282', '22:00', '14:00');
insert into tblHome values (11, 'partner', 1, 'New Stay inn', '서울특별시 중구 청구동 112', '21:30', '11:00');
insert into tblHome values (12, 'partner', 1, 'H-AVENUE', '서울특별시 중구 광희동 861', '18:00', '12:00');

insert into tblRoom values (1, 1, 1, '봄방', 80000, 'images/jeju.jpg', 'y');
insert into tblRoom values (2, 2, 1, '여름방', 55000, 'images/room1.jpg', 'y');
insert into tblRoom values (3, 1, 1, '가을방', 50000, 'images/hotel1.jpg', 'y');
insert into tblRoom values (4, 3, 1, '겨울방', 70000, 'images/hotel2.jpg', 'y');
insert into tblRoom values (5, 4, 1, '1월방', 60000, 'images/hotel3.jpg', 'y');
insert into tblRoom values (6, 5, 1, '2월방', 35000, 'images/hotel1.jpg', 'y');
insert into tblRoom values (7, 6, 1, '3월방', 40000, 'images/jeju.jpg', 'y');
insert into tblRoom values (8, 1, 1, '4월방', 88000, 'images/hotel2.jpg', 'y');
insert into tblRoom values (9, 7, 1, '빨간방', 66000, 'images/imgimg.jpg', 'y');
insert into tblRoom values (10, 8, 1, '주황방', 70000, 'images/imgimg1.jpg', 'y');
insert into tblRoom values (11, 9, 1, '노랑방', 55000, 'images/imgimg2.jpg', 'y');
insert into tblRoom values (12, 10, 1, '초록방', 50000, 'images/imgimg3.jpg', 'y');
insert into tblRoom values (13, 11, 1, '파랑방', 68000, 'images/imgimg4.jpg', 'y');
insert into tblRoom values (14, 12, 1, '남색방', 100000, 'images/imgimg5.jpg', 'y');
commit;
delete from tblRoom;
--
select * from tblHome;

commit;
-- 숙소 > 방 추가
insert into tblRoom values (1, 1, 1, '봄방', 80000, 'images/jeju.jpg', 'y');
insert into tblRoom values (2, 2, 1, '여름방', 55000, 'images/room1.jpg', 'y');
insert into tblRoom values (3, 1, 1, '가을방', 50000, 'images/hotel1.jpg', 'y');
insert into tblRoom values (4, 3, 1, '겨울방', 70000, 'images/hotel2.jpg', 'y');
insert into tblRoom values (5, 4, 1, '1월방', 60000, 'images/hotel3.jpg', 'y');
insert into tblRoom values (6, 5, 1, '2월방', 35000, 'images/hotel1.jpg', 'y');
insert into tblRoom values (7, 6, 1, '3월방', 40000, 'images/jeju.jpg', 'y');
insert into tblRoom values (8, 1, 1, '4월방', 88000, 'images/hotel2.jpg', 'y');
select * from tblRoom order by seq;

select * from tblHome h inner join tblRoom r on h.seq = r.hseq order by h.seq;

-- 방 > 옵션 추가
insert into tblOptionList values(1,	1, 1, 'n', 'y', 5, 'y', 'y', 'y', 'y', 'y');
insert into tblOptionList values(2,	2, 2, 'n', 'n', 5, 'y', 'y', 'n', 'y', 'y');
insert into tblOptionList values(3,	3, 2, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(4,	4, 2, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(5,	5, 2, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(6,	6, 2, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(7,	7, 2, 'y', 'y', 3, 'y', 'y', 'y', 'y', 'y');
insert into tblOptionList values(8,	8, 3, 'y', 'y', 3, 'y', 'y', 'y', 'y', 'y');

insert into tblOptionList values(9,	9, 1, 'n', 'y', 5, 'y', 'y', 'y', 'y', 'y');
insert into tblOptionList values(10,10, 3, 'n', 'n', 5, 'y', 'y', 'n', 'y', 'y');
insert into tblOptionList values(11,11, 2, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(12,12, 3, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(13,13, 1, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(14,14, 4, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
select * from tblOptionList order by seq;

select * from tblBoard;


-- 방 상세 사진 추가
insert into tblRoomPic values (1, 1, 'pic/hotel1.jpg');
insert into tblRoomPic values (2, 1, 'pic/imgimg2.jpg');
insert into tblRoomPic values (3, 2, 'pic/room1.jpg');
select * from tblRoomPic;



-- 숙소 예약 추가
insert into tblHomeBook values (1, 1, 1, 'user', 1, 1, '22/07/12', '22/07/13');
insert into tblHomeBook values (2, 2, 1, 'user', 1, 1, '22/07/14', '22/07/15');
insert into tblHomeBook values (3, 1, 1, 'user', 1, 1, '22/07/19', '22/07/21');
select * from tblHomeBook;



-- 숙소 리뷰 추가
insert into tblHomeReview values (1, 'user', 1, 5, '깨끗하고 친절하고 위치도 만족했습니다', '22/07/15');
insert into tblHomeReview values (2, 'user', 2, 4, '깨끗하고 친절하고 위치도 만족했습니다', '22/07/18');
insert into tblHomeReview values (3, 'user', 3, 3, '방이 너무 지저분했습니다.. 실망이예요', '22/07/21');
select * from tblHomeReview order by seq;


-- 판매 회원 추가
insert into tblUser values ('partner', 2, '1234', '김판매', '01029390012', '66/01/23', '남', 'partner@naver.com');








insert into tblBoard values (14, 'user', '춘천으로 떠난 1박 2일', '고요하고 한적한 분위기의 자연 속에서 휴식을 취해보세요. 
<br>
번잡한 도시의 소음과 미세먼지에서 벗어나 자연의 아름다움을 만끽하실 수 있어요. 
<br>
화산 활동으로 만들어진 낯선 지형이 독특한 매력을 풍기는 제주도, 붉은 노을이 매력적인 남해와 차분한 분위기의 카페가 있는 강릉으로 떠나 보시는 건 어떨까요?
<br>
느긋하면서도 한가로운 휴가를 즐길 수 있는 멋진 여행지를 소개합니다.', default, default, '일반', 0);

commit;




