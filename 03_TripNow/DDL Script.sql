CREATE TABLE tblHome (
	seq	number	primary key,
	pid	varchar2(15)	NOT NULL,
	tseq	number	NOT NULL,
	name	varchar2(60)	NOT NULL,
	location	varchar2(150)	NOT NULL,
	enterhome	varchar2(100)	NOT NULL,
	outerhome	varchar2(100)	NOT NULL
);

CREATE TABLE tblUser (
	id	varchar2(15)	primary key,
	gseq	number	NOT NULL,
	pw	varchar2(20)	NOT NULL,
	name	varchar2(15)	NOT NULL,
	tel	varchar2(11)	NOT NULL,
	birth	date	NOT NULL,
	gender	varchar2(3)	NOT NULL,
	email	varchar2(50)	NOT NULL
);

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
--

CREATE TABLE tblCar (
	seq	number primary key,
	fseq	number	NOT NULL,
	hseq	number	NOT NULL,
	ctseq	number	NOT NULL,
	pid	varchar2(15)	NOT NULL,
	rseq	number	NOT NULL,
	location	varchar2(150)	NOT NULL,
	mileage	number	NOT NULL,
	geartype	varchar2(1)	NOT NULL,
	price	number	NOT NULL,
	rentstart	varchar2(100)	NOT NULL,
	rentend	varchar2(100)	NOT NULL,
	show	varchar2(1) DEFAULT 'n'	NOT NULL,
    carname varchar2(60) not null
);

CREATE TABLE tblUserCoupon (
	seq	number	primary key,
	id	varchar2(15)	NOT NULL,
	eseq	number	NOT NULL,
	used	varchar2(1)	DEFAULT 'n' Not NULL	
);


CREATE TABLE tblActivity (
	seq	number	primary key,
	pid	varchar2(15)	NOT NULL,
	rseq	number	NOT NULL,
	name	varchar2(100)	NULL,
	location	varchar2(150)	NOT NULL,
	period	date	NOT NULL,
	price	number	NOT NULL,
	path	varchar2(1000)	NOT NULL,
	fpath	varchar2(1000)	NOT NULL,
	show	varchar2(1)	DEFAULT 'n' Not NULL,
    content varchar2(1000) NOT NULL
);

CREATE TABLE tblActPhoto (
    seq number primary key,
    aseq number NOT NULL,
    path varchar(1000) NOT NULL
);
---

CREATE TABLE tblPayment (
	seq	number	primary key,
	blseq	number	NOT NULL,
	payment	varchar2(1)	NOT NULL,
    finalprice number NOT NULL
);


CREATE TABLE tblQuestion (
	seq	number	primary key,
	id	varchar2(15)	NOT NULL,
	cseq	number	NOT NULL,
	title	varchar2(120)	NOT NULL,
	content	varchar2(1000)	NOT NULL,
	regdate	date default sysdate	NOT NULL
);


CREATE TABLE tbltnAnswer (
	seq	number	primary key,
	qseq	number	NOT NULL,
	id	varchar2(15)	NOT NULL,
	content	varchar2(300)	NOT NULL,
	regdate	date default sysdate	NOT NULL
);



CREATE TABLE tblHomeBook (
	seq	number	primary key,
	rseq	number	NOT NULL,
	pseq	number	NOT NULL,
	id	varchar2(15)	NOT NULL,
	bseq	number	NOT NULL,
	bsseq	number	NOT NULL,
	startdate	date	NOT NULL,
	enddate	date	NOT NULL
);

CREATE TABLE tblRoom (
	seq	number	NOT NULL,
	hseq	number	NOT NULL,
	rseq	number	NOT NULL,
	name	varchar2(50)	NOT NULL,
	price	number	NOT NULL,
	path	varchar2(1000)	NOT NULL,
	show	varchar2(1)	DEFAULT 'n' NOT NULL	
);

--ALTER TABLE tblRoom RENAME TO tblDBRoom;
--

create table tblroompic (
    seq number primary key,
    rseq number not null, -- references tblRoom(seq)
    fpath varchar2(1000) not null
);

CREATE TABLE tblComment (
	seq	number	primary key,
	bseq	number	NOT NULL,
	content	varchar2(300)	NOT NULL,
	regdate	date default sysdate	NOT NULL,
    id varchar2(20) NOT NULL
);


CREATE TABLE tblActivityBook (
	seq	number	primary key,
	pseq	number	NOT NULL,
	aseq	number	NOT NULL,
	id	varchar2(15)	NOT NULL,
	blseq	number	NOT NULL,
	bsseq	number	NOT NULL,
	regdate	date	default sysdate NOT NULL,
	count	number DEFAULT 1 NOT NULL	
);


CREATE TABLE tblCarBook (
	seq	number	primary key,
	sseq	number	NOT NULL,
	id	varchar2(15)	NOT NULL,
	cseq	number	NOT NULL,
	bseq	number	NOT NULL,
	bsseq	number	NOT NULL,
	startdate	date	NOT NULL,
	enddate	date	NOT NULL
);

CREATE TABLE tblPayState (
	seq	number	primary key,
	value	varchar2(10)	NOT NULL
);
--

CREATE TABLE tblFuel (
	seq	number	primary key,
	value	varchar2(9)	NOT NULL
);

CREATE TABLE tblHeadcount (
	seq	number	primary key,
	value	number	NOT NULL
);
--

CREATE TABLE tblCarType (
	seq	number	primary key,
	value	varchar2(90)	NOT NULL
);

CREATE TABLE tblGrade (
	seq	number	primary key,
	value	varchar2(15)	NOT NULL
);

CREATE TABLE tblBookList (
	seq	number	primary key,
	id	varchar2(15)	NOT NULL
);

CREATE TABLE tblCarReview (
	seq	number	primary key,
	id	varchar2(15)	NOT NULL,
	rseq	number	NOT NULL,
	rating	number	NOT NULL,
	content	varchar2(300)	NOT NULL,
	regdate	date default sysdate	NOT NULL
);

CREATE TABLE tblHomeReview (
	seq	number	primary key,
	id	varchar2(15)	NOT NULL,
	hseq	number	NOT NULL,
	star	number	NOT NULL,
	content	varchar2(300)	NOT NULL,
	regdate	date	default sysdate NOT NULL
);

CREATE TABLE tblBookState (
	seq	number	primary key,
	value	varchar2(15)	NOT NULL
);

CREATE TABLE tblHomeReply (
	seq	number	primary key,
	rseq	number	NOT NULL,
	id	varchar2(15)	NOT NULL,
	content	varchar2(300)	NOT NULL,
	regdate	date	default sysdate NOT NULL
);

CREATE TABLE tblActivityReview (
	seq	number	primary key,
	rseq	number	NOT NULL,
	id	varchar2(15)	NOT NULL,
	star	number	NOT NULL,
	content	varchar2(300)	NOT NULL,
	regdate	date	default sysdate NOT NULL
);

CREATE TABLE tblCarReply (
	seq	number	primary key,
	replyseq	number	NOT NULL,
	partnerid	varchar2(15)	NOT NULL,
	content	varchar2(300)	NOT NULL,
	regdate	date	default sysdate NOT NULL
);

CREATE TABLE tblOptionList (
	seq	number	primary key,
	rseq	number	NOT NULL,
	bseq	number	NOT NULL,
	bath	varchar2(1) DEFAULT 'n'	NOT NULL	,
	pet	varchar2(1)	DEFAULT 'n' NOT NULL	,
	maxpeople	number	NOT NULL,
	smoke	varchar2(1)	DEFAULT 'n' NOT NULL	,
	pool	varchar2(1)	DEFAULT 'n' NOT NULL	,
	parking	varchar2(1)	DEFAULT 'n' NOT NULL	,
	cook	varchar2(1)	 DEFAULT 'n' NOT NULL	,
	wifi	varchar2(1)	DEFAULT 'n' NOT NULL	
);

CREATE TABLE tblHomeType (
	seq	number	primary key,
	value	varchar2(10)	NOT NULL
);

CREATE TABLE tblBedOption (
	seq	number	primary key,
	value	varchar2(10)	NOT NULL
);

CREATE TABLE tblActivityReply (
	seq	number	primary key,
	rseq	number	NOT NULL,
	id	varchar2(15)	NOT NULL,
	content	varchar2(300)	NOT NULL,
	regdate	date	default sysdate NOT NULL
);

CREATE TABLE tblCity (
	seq	number	primary key,
	value	varchar2(100)	NOT NULL
);

CREATE TABLE tblDistrict (
	seq	number	primary key,
	cseq	number	NOT NULL,
	value	varchar2(100)	NOT NULL
);

CREATE TABLE tblSlang (
	seq	number	primary key,
	value	varchar2(100)	NOT NULL
);

create table tblcarName (
    seq varchar2(60) PRIMARY key,
    tseq number not null,
    path varchar2(1000)
);

CREATE TABLE tblRegState (
	seq	number	primary key,
	value	varchar2(15)	NOT NULL
);

CREATE TABLE tblQuestionCategory (
	seq	number	primary key,
	value	varchar2(30)	NOT NULL
);

CREATE TABLE tblEvent (
	seq	number	primary key,
	name	varchar2(100)	NOT NULL,
	enddate	date	NOT NULL,
	eventname	varchar2(90) NOT	NULL,
	content	varchar2(3000)	NOT NULL,
	bennerpicture	varchar2(1000)	NOT NULL,
	detailpicture	varchar2(1000)	NOT NULL,
	rate	number	NOT NULL,
	value	varchar2(12)	NOT NULL,
	finished	varchar2(1)	DEFAULT 'n' NOT NULL	
);

CREATE TABLE tblAccount (
	seq	number	primary key,
	id	varchar2(15)	NOT NULL,
	bank	varchar2(50)	NOT NULL,
	acnumber	number	NOT NULL
);

