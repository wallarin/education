-------------------------------------------------------------------------------- 기본 insert

-- tblHome
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

-- tblUser
insert into tblUser values ('admin', 1, '1234', '관리자', '01059892443', '1988-02-01', '여', 'admin@naver.com');
insert into tblUser values ('user', 3, '1234', '사용자', '01031334420', '1995-03-25', '남', 'user@naver.com');
insert into tblUser values ('partner', 2, '1234', '파트너', '01031334420', '1995-03-25', '남', 'user@naver.com');

-- tblBoard
insert into tblBoard values (1, 'admin', '공지사항입니다.', '욕설 금지입니다.', 105, default, '공지', 1000);

insert into tblBoard values (2, 'user', '조용히 휴식을 즐기기에 좋은 곡성', '다들 곡성으로 놀러오세요~.', default, default, '일반', 0);

insert into tblBoard values (3, 'user', '제주도로 떠난 1박 2일', '고요하고 한적한 분위기의 자연 속에서 휴식을 취해보세요. <br>번잡한 도시의 소음과 미세먼지에서 벗어나 자연의 아름다움을 만끽하실 수 있어요.<br>화산 활동으로 만들어진 낯선 지형이 독특한 매력을 풍기는 제주도, 붉은 노을이 매력적인 남해와 차분한 분위기의 카페가 있는 강릉으로 떠나 보시는 건 어떨까요?<br>느긋하면서도 한가로운 휴가를 즐길 수 있는 멋진 여행지를 소개합니다.', default, default, '일반', 0);

insert into tblBoard values (4, 'user', '보물 같은 풍경의 남해', '광주에서는 계절마다 색다른 매력을 선보이는 광동청정습지 생태공원에 방문해 보세요. 주변에서 흔히 보지 못한 식물과 꽃을 둘러보며 보물찾기하듯 산책을 즐기실 수 있어요. 이곳은 산책로가 잘 조성되어 있어 식물을 관찰하기에도 안성맞춤이죠. 율봄식물원에서는 온 가족이 함께하기 좋아요. 아기자기하게 꾸며진 식물원에서 사진으로 추억을 남겨보고, 딸기체험과 동물 먹이 주기 체험을 즐기며 잊지 못할 추억을 만들어 보세요.', default, default, '일반', 0);

insert into tblBoard values (5, 'user', '시원한 풍경이 기분 좋은 강릉', '세종대왕과 쌀로 유명한 여주에서는 강천섬을 잊지 말고 들러보세요. 남한강을 품은 이곳에서는 멸종 위기 식물인 단양쑥부쟁이를 만나보실 수 있어요. 산책로를 따라 걷다 보면 느긋하게 쉴 수 있는 잔디광장과 가로수길이 눈앞에 펼쳐져요.<br><br>걷기 좋은 둘레길을 찾고 계신다면 다양한 코스로 구성된 여강길을 방문해보세요. 여유 있게 남한강 주변을 산책하며 숨겨진 여주의 매력을 발견하실 수 있어요. 세종대왕릉과 효종대왕릉을 잇는 왕의 숲길은 여강길의 보물이라고 할 수 있죠. 여주 시내가 내려다보이는 영월루에 올라 여주의 숨결을 느껴보세요.', default, default, '일반', 0);

insert into tblBoard values (6, 'user', '아름다운 산책로가 매력적인 삼척', '산과 바다가 어우러진 삼척에는 자연과 함께할 수 있는 명소가 곳곳에 숨겨져 있어요. 초곡용굴 촛대바위길에서는 해안 절경을 감상하며 촛대바위, 거북바위, 피라미드바위 등의 다양한 기암괴석을 만나보실 수 있어요. 중간에 있는 출렁다리에서 산책을 즐기고, 전망대에 올라 환상적인 동해의 풍경을 감상해보세요.', default, default, '일반', 0);

insert into tblBoard values (7, 'user', '천천히 걸으며 매력을 만끽할 수 있는 여주', '자라섬 남도에서는 핑크뮬리, 구절초와 백일홍이 가득한 꽃 정원을 마주하실 수 있어요. 반짝반짝 빛이 나는 강물과 알록달록한 꽃을 구경하며 힐링해 보세요. 남이섬 근처에서는 튤립나무길, 자작나무길과 같이 한적한 산책을 즐기기 좋은 숨은 명소에 들러보세요.', default, default, '일반', 0);

insert into tblBoard values (8, 'user', '모든 순간이 소중해지는 울릉도', '소돌해변과 아들바위 공원에서의 산책을 첫 번째 일정으로 추가하면 강릉 여행을 무리 없이 시작하실 수 있어요. 코끼리 바위, 죽도바위 또는 소원바위라는 별명을 가진 기암괴석과 바다가 조화를 이루는 풍경을 직접 확인해 보세요.', default, default, '일반', 0);

insert into tblBoard values (9, 'user', '서해 여행이나 인천의 섬으로 떠나고 싶다면 소야도', '늦은 가을에는 붉게 물든 메타세콰이아 나무 사이를 거닐며 힐링 타임을 즐기셔도 좋아요. 겨울에는 잔잔한 수면 위에 수묵화를 그린 듯 펼쳐지는 섶다리마을도 구경해 보세요.', default, default, '일반', 0);

insert into tblBoard values (10, 'user', '통영에서 조용한 섬을 찾는다면 한산도', '경남의 보물섬이라 불리는 남해에서는 남파랑길과 해파랑길로 구성된 둘레길을 거닐어 보세요. <br>각각의 코스가 지닌 매력과 자연의 경이로움을 감상하며 남해 여행을 만끽하실 수 있으실 거예요. <br>오솔길을 따라 걷다 보면 편백숲에 둘러싸인 힐링 스팟, 남해 토피아랜드가 기다리고 있어요', default, default, '일반', 0);

insert into tblBoard values (11, 'user', '국내 1박 2일 여행을 알차게 채울 수 있는 고창', '핫한 배경에서 사진을 맘껏 찍고 싶으신 분에게는 100개의 콘셉트가 함께하는 사진놀이터와 미디어아트 전시관인 아르떼뮤지엄을 추천해 드려요. 한적한 분위기의 바다에서 용천수 노천탕을 즐길 수 있는 곽지해수욕장도 잊지 말고 일정에 추가해 보세요.', default, default, '일반', 0);

-- tblCar
insert into tblCar values (1, 1, 2, 4, 'partner', 1, '서울시', 10, 'y', 50000, '08:00', '20:00', 'y', '아반떼');
insert into tblCar values (2, 1, 2, 1, 'partner', 1, '강릉시', 14, 'y', 30000, '08:00', '20:00', 'y', '레이');
insert into tblCar values (3, 2, 2, 1, 'partner', 1, '강릉시', 16, 'y', 35000, '08:00', '20:00', 'y', '레이');
insert into tblCar values (4, 4, 2, 4, 'partner', 1, '서울시', 16, 'y', 55000, '08:00', '20:00', 'y', '아반떼');
insert into tblCar values (5, 2, 2, 1, 'partner', 1, '서울시', 16, 'y', 35000, '08:00', '20:00', 'y', '레이');
insert into tblCar values (6, 2, 2, 1, 'partner', 1, '서울시', 16, 'y', 34000, '08:00', '20:00', 'y', '스파크');

-- tblUserCoupon
insert into tblUserCoupon values (1, 'user', 1, 'n');

-- tblActivity
insert into tblActivity values (1, 'partner', 2, '수상레저 가평군 체험~!', '경기도 가평군', '2022-08-30', 8000, '/tripnow/images/jeju.jpg', '/tripnow/images/hotel3.jpg', 'y','가나다라 마바사');
insert into tblActivity values (2, 'partner', 2, '오션월드', '서울특별시 서초구', '2022-08-30', 8000, '/tripnow/images/jeju.jpg', '/tripnow/images/jeju.jpg', 'y','가나다라 ㄴㄹㄴㄹㄴ마바사');
insert into tblActivity values (3, 'partner', 1, '수상양레저', '경기도 안양시', '2022-08-30', 8000, '/tripnow/images/jeju.jpg', '/tripnow/images/hotel3.jpg', 'y','가나다라 마바사');
insert into tblactivity values(4,'partner','2','오션월드 마지막 세일!','강원도 홍천시','2022-08-22',23000,'/tripnow/images/ocean.png','/tripnow/images/ocean.png','y','오션월드 세일 기간 7/20일부터 8/1일까지 23000원입니다!');
insert into tblactivity values(5,'partner','2','캠프통아일랜드 종일권','강원도 철원시','2022-08-22',42400,'/tripnow/images/wslide.png','/tripnow/images/wslide.png','y','오션월드 세일 기간 7/20일부터 8/1일까지 23000원입니다!');
insert into tblactivity values(7,'partner','2','캠프통포레스트 반종일권','강원도 인제시','2022-08-22',39990,'/tripnow/images/wslide2.png','/tripnow/images/wslide.png2','y','오션월드 세일 기간 7/20일부터 8/1일까지 23000원입니다!');
insert into tblactivity values(8,'partner','2','케리비안베이','강원도 인제시','2022-08-22',59990,'/tripnow/images/k.png','/tripnow/images/k.png','y','오션월드 세일 기간 7/20일부터 8/1일까지 23000원입니다!');
insert into tblactivity values(9,'partner','2','에버랜드 자유이용권','강원도 홍천시','2022-08-22',59990,'/tripnow/images/ever.png','/tripnow/images/ever.png','y','오션월드 세일 기간 7/20일부터 8/1일까지 23000원입니다!');
insert into tblactivity values(11,'partner','2','케리비안베이 특가!','강원도 홍천시','2022-08-22',32190,'/tripnow/images/k2.png','/tripnow/images/k2.png','y','오션월드 세일 기간 7/20일부터 8/1일까지 23000원입니다!');
insert into tblactivity values(12,'partner','2','강원랜드 1박 호텔','강원도 홍천시','2022-08-22',123044,'/tripnow/images/k3.png','/tripnow/images/k3.png','y','오션월드 세일 기간 7/20일부터 8/1일까지 23000원입니다!');
insert into tblactivity values(13,'partner','2','에버랜드 야간이용권','강원도 홍천시','2022-08-22',123044,'/tripnow/images/k4.png','/tripnow/images/k4.png','y','오션월드 세일 기간 7/20일부터 8/1일까지 23000원입니다!');


-- tblActPhoto
insert into tblActPhoto values (1,1,'/tripnow/images/jeju.jpg');
insert into tblActPhoto values (2,1,'/tripnow/images/hotel3.jpg');
insert into tblActPhoto values (3,1,'/tripnow/images/bridge.jpg');
insert into tblActPhoto values (4,2,'/tripnow/images/jeju.jpg');
insert into tblActPhoto values (5,2,'/tripnow/images/bridge.jpg');
insert into tblActPhoto values (6,2,'/tripnow/images/hotel3.jpg');
insert into tblactphoto values (7,4,'/tripnow/images/ocean1.png');
insert into tblactphoto values (8,4,'/tripnow/images/ocean2.png');
insert into tblactphoto values (9,4,'/tripnow/images/ocean3.png');

-- tblPayment
insert into tblPayment values (1, 1, 'y',23232);

-- tblQuestion
insert into tblQuestion values (1, 'user', 1, '유저를 신고합니다', 'abcde 유저가 저의 개인 정보를 커뮤니티에 유출시켰습니다. 조치 부탁드려요.', sysdate);

-- tblAnswer
insert into tblAnswer values (1, 1, 'admin', '불편을 드려 죄송합니다. 해당 회원 블랙리스트 조치 완료되었습니다.', sysdate);

-- tblHomeBook
insert into tblHomeBook values (1, 1, 1, 'user', 1, 1, '22/07/12', '22/07/13');
insert into tblHomeBook values (2, 2, 1, 'user', 1, 1, '22/07/14', '22/07/15');
insert into tblHomeBook values (3, 1, 1, 'user', 1, 1, '22/07/19', '22/07/21');

-- tblRoom
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

-- tblroompic
insert into tblRoomPic values (1, 1, 'pic/hotel1.jpg');
insert into tblRoomPic values (2, 1, 'pic/imgimg2.jpg');
insert into tblRoomPic values (3, 2, 'pic/room1.jpg');

-- tblComment
insert into tblComment values (1,1,'댓글입니다','2022-07-15','user');

-- tblActivityBook
insert into tblActivityBook values (1, 3, 1, 'user', 1, 2, '2022-08-01', 2);

-- tblCarBook
insert into tblCarBook values (1, 3, 'user', 1, 2, 2, '2022-08-01', '2022-08-02');

-- tblPayState
insert into tblPayState values (1, '입금전');
insert into tblPayState values (2, '입금후');
insert into tblPayState values (3, '진행중');

-- tblFuel
insert into tblFuel values (1, '가솔린');
insert into tblFuel values (2, '디젤');
insert into tblFuel values (3, 'LPG');
insert into tblFuel values (4, '전기');

-- tblHeadcount
insert into tblHeadCount values (1, 2);
insert into tblHeadCount values (2, 4);
insert into tblHeadCount values (3, 6);
insert into tblHeadCount values (4, 8);
insert into tblHeadCount values (5, 10);
insert into tblHeadCount values (6, 12);

-- tblCarType
insert	into 	tblcartype	values	(	0	, '모두보기');
insert	into 	tblcartype	values	(	1	, '경차');
insert	into 	tblcartype	values	(	2	, '소형');
insert	into 	tblcartype	values	(	3	, '준중형');
insert	into 	tblcartype	values	(	4	, '중형');
insert	into 	tblcartype	values	(	5	, '고급');
insert	into 	tblcartype	values	(	6	, 'SUV');
insert	into 	tblcartype	values	(	7	, '승합');

-- tblGrade
insert into tblGrade values (1, '관리자');
insert into tblGrade values (2, '파트너');
insert into tblGrade values (3, '회원');
insert into tblGrade values (4, '이용불가');
insert into tblGrade values (5, '블랙리스트');

-- tblBookList
insert into tblBookList values (1, 'user');
insert into tblBookList values (2, 'user');

-- tblCarReview
insert into tblCarReview values (1, 'user', 1, 5, '렌트 차량도 깨끗하고 응대가 친절해서 좋았습니다~', sysdate);
insert into tblCarReview values (2, 'wjdqudwlr', 1, 4, '렌트 차량이 살짝 더러웠지만 응대가 친절해서 좋았습니다~', sysdate);

-- tblHomeReview
insert into tblHomeReview values (1, 'user', 1, 5, '깨끗하고 친절하고 위치도 만족했습니다', '22/07/15');
insert into tblHomeReview values (2, 'user', 2, 4, '깨끗하고 친절하고 위치도 만족했습니다', '22/07/18');
insert into tblHomeReview values (3, 'user', 3, 3, '방이 너무 지저분했습니다.. 실망이예요', '22/07/21');

-- tblBookState
insert into tblBookState values (1, '예약중');
insert into tblBookState values (2, '예약완료');
insert into tblBookState values (3, '사용완료');
insert into tblBookState values (4, '취소');

-- tblHomeReply
insert into tblHomeReply values (1, 1, 'partner', '다음에 또 방문해 주세요~ ^^', sysdate);

-- tblActivityReview
insert into TBLACTIVITYREVIEW values(1,1,'user',5,'정말 재미있어요!','2022-07-11' );

-- tblCarReply
insert into TBLCARREPLY   values(1,1,'partner','후기 감사합니다!','2022-07-11' );

-- tblOptionList
insert into tblOptionList values(1, 1, 1, 'n', 'y', 5, 'y', 'y', 'y', 'y', 'y');
insert into tblOptionList values(2, 2, 2, 'n', 'n', 5, 'y', 'y', 'n', 'y', 'y');
insert into tblOptionList values(3, 3, 2, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(4, 4, 2, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(5, 5, 2, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(6, 6, 2, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(7, 7, 2, 'y', 'y', 3, 'y', 'y', 'y', 'y', 'y');
insert into tblOptionList values(8, 8, 3, 'y', 'y', 3, 'y', 'y', 'y', 'y', 'y');
insert into tblOptionList values(9, 9, 1, 'n', 'y', 5, 'y', 'y', 'y', 'y', 'y');
insert into tblOptionList values(10, 10, 3, 'n', 'n', 5, 'y', 'y', 'n', 'y', 'y');
insert into tblOptionList values(11, 11, 2, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(12, 12, 3, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(13, 13, 1, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
insert into tblOptionList values(14, 14, 4, 'y', 'y', 3, 'n', 'n', 'n', 'y', 'y');
-- tblHomeType
insert into TBLHOMETYPE values(1,'모텔');
insert into TBLHOMETYPE values(2,'호텔');
insert into TBLHOMETYPE values(3,'팬션');

-- tblBedOption
insert into TBLBEDOPTION values(1,'일반' );
insert into TBLBEDOPTION values(2,'트윈' );
insert into TBLBEDOPTION values(3,'퀸' );
insert into TBLBEDOPTION values(4,'온돌' );

-- tblActivityReply
insert into TBLACTIVITYREPLY values(1,1,'partner','후기 감사합니다!','2022-07-11' );

-- tblCity
insert into TBLCITY values(1,'서울' );

-- tblDistrict
insert into TBLDISTRICT values(1,1,'강남구' );

-- tblSlang
insert into TBLSLANG values(1,'바보' );

-- tblcarName
insert into TBLCARNAME values('아반떼',4,'/tripnow/images/avante.jpg' );
insert into TBLCARNAME values('레이',1,'/tripnow/images/ray.png' );
insert into TBLCARNAME values('스파크',1,'/tripnow/images/spark.jpg' );

-- tblRegState
insert into TBLREGSTATE values(1,'진행중' );
insert into TBLREGSTATE values(2,'등록완료' );
insert into TBLREGSTATE values(3,'거절' );

-- tblQuestionCategory
insert into TBLQUESTIONCATEGORY values( 1,'신고');
insert into TBLQUESTIONCATEGORY values( 2,'파트너등록');
insert into TBLQUESTIONCATEGORY values( 3,'홈페이지문의');
insert into TBLQUESTIONCATEGORY values( 4,'상품제휴문의');
insert into TBLQUESTIONCATEGORY values( 5,'기타');
insert into TBLQUESTIONCATEGORY values (6, '공지사항');

-- tblEvent
insert	into	tblEvent	values 	(1,'여름 맞이 숙소 10% 할인 쿠폰',	'2022-08-01',	'쿠폰받고 호캉스가자!',	'이벤트 내용',	'/tripnow/images/hotel1.jpg',	'detail.jpg',	10,	'숙소', 'y');
insert	into	tblEvent	values 	(2,'여름 맞이 렌터카 5% 할인 쿠폰',	'2022-08-02',	'차? 렌터카가 더 싸다!',	'이벤트 내용',	'/tripnow/images/car.jpg',	'detail.jpg',	5,	'렌터카', 'y');
insert	into	tblEvent	values 	(3,'여름 맞이 액티비티 10% 할인 쿠폰',	'2022-08-03',	'액티비티 온종일을 싸게?',	'이벤트 내용',	'/tripnow/images/jeju.jpg',	'detail.jpg',	10,	'액티비티', 'y');
insert	into	tblEvent	values 	(4,'여름 맞이 숙소 15% 할인 쿠폰',	'2022-08-04',	'쿠폰받고 호캉스가자!',	'이벤트 내용',	'/tripnow/images/hotel2.jpg',	'detail.jpg',	15,	'숙소', 'y');
insert	into	tblEvent	values 	(5,'여름 맞이 렌터카 10% 할인 쿠폰',	'2022-08-05',	'제주도 싸게 놀래?',	'이벤트 내용',	'/tripnow/images/jeju.jpg',	'detail.jpg',	10,	'렌터카', 'y');
insert	into	tblEvent	values 	(6,'여름 맞이 액티비티 5% 할인 쿠폰',	'2022-08-06',	'액티비티 온종일을 싸게?',	'이벤트 내용',	'/tripnow/images/car.jpg',	'detail.jpg',	5,	'액티비티', 'y');
insert	into	tblEvent	values 	(7,'여름 맞이 숙소 10% 할인 쿠폰',	'2022-08-07',	'쿠폰받고 호캉스가자!',	'이벤트 내용',	'/tripnow/images/hotel3.jpg',	'detail.jpg',	10,	'숙소', 'y');
insert	into	tblEvent	values 	(8,'여름 맞이 렌터카 10% 할인 쿠폰',	'2022-08-08',	'제주도 싸게 놀래?',	'이벤트 내용',	'/tripnow/images/jeju.jpg',	'detail.jpg',	10,	'렌터카', 'y');
insert	into	tblEvent	values 	(9,'여름 맞이 액티비티 15% 할인 쿠폰',	'2022-08-09',	'액티비티 온종일을 싸게?',	'이벤트 내용',	'/tripnow/images/car.jpg',	'detail.jpg',	15,	'액티비티', 'y');

-- tblAccount
insert into tblAccount values (1, 'partner', '국민은행', 110110110110);



-------------------------------------------------------------------------------- 렌터카


-- reviewcount / rating avg view
create or replace view vwReviewcount
as 
select count(cr.rating) as count, avg(cr.rating) as rating, c.seq from tblCar c 
left outer join tblCarBook cb on c.seq = cb.cseq 
left join tblCarReview cr on cr.rseq = cb.seq group by c.seq order by seq asc;

-- carlist view
create or replace view vwCarlist
as
select distinct c.seq as mainseq, 
hc.value as hval, 
ct.value as ctvalue, c.location as location, c.price as price, c.geartype as geartype, c.mileage as mileage, c.show as show,
c.rentstart as rentstart, c.rentend as rentend, c.carname as carname, f.seq as fseq,
f.value as fvalue, cb.startdate as startbook, 
cb.enddate as endbook, cn.path as path
from tblCarType ct 
inner join tblCar c on c.ctseq = ct.seq 
inner join tblFuel f on c.fseq = f.seq 
inner join tblHeadcount hc on hc.seq = c.hseq 
left outer join tblCarBook cb on cb.cseq = c.seq
left outer join tblCarReview cr on cr.rseq = cb.seq
inner join TBLCARNAME cn on cn.seq = c.carname;


-- review view
create or replace view vwReview
as
select cr.regdate as regdate, c.seq as seq, rating, cre.regdate as pregdate, cr.content as content, cr.id as id, cseq, rseq, replyseq, cre.content as pcontent from tblcar c 
inner join tblCarBook cb on cb.cseq = c.seq
inner join tblCarReview cr on cb.seq = cr.rseq
left outer join tblCarReply cre on cre.replyseq = cr.seq
inner join tblCar c on c.seq = cb.cseq;





-------------------------------------------------------------------------------- 숙소

create or replace view vwhomeinfo as
select distinct h.seq, h.name, h.location, (select min(price) from tblRoom where hseq = h.seq) as price, (select path from tblRoom where seq = (select min(seq) from tblroom where hseq = h.seq)) as path, r.show, ht.value,
(select avg(star) from tblHomeReview where hseq in (select seq from tblHomeBook where rseq in (select seq from tblRoom where hseq in (select seq from tblHome where seq = h.seq)))) as star,
(select count(seq) from tblHomeReview where hseq in (select seq from tblHomeBook where rseq in (select seq from tblRoom where hseq in (select seq from tblHome where seq = h.seq)))) as reviewcount,
(select maxpeople from tblOptionList where rseq = (select seq from tblRoom where seq = h.seq)) as maxpeople
from tblHome h 
    left outer join tblRoom r on h.seq = r.hseq
    left outer join tblHomeType ht on h.tseq = ht.seq;



create or replace view vwCommu as
select tblBoard.*, (select count(bseq) from tblComment where bseq = tblBoard.seq) as commentcount from tblBoard order by thread desc, regdate desc ;










