# 커넥션 풀
<Resource auth="Container"
                  driverClassName="oracle.jdbc.OracleDriver" maxIdle="10"
                  maxTotal="20" maxWaitMillis="-1" name="jdbc/myoracle"
                  password="test" type="javax.sql.DataSource"
                  url="jdbc:oracle:thin:@192.168.0.26:1521:xe" username="test" />
  
 create table member(
userNum number(10) NOT NULL PRIMARY KEY,
admin number(1) NOT NULL,
name varchar2(10) NOT NULL,
userId varchar2(20) NOT NULL UNIQUE,
pwd varchar(30) NOT NULL,
email varchar(30) NOT NULL,
phone varchar(14) NOT NULL,
address varchar(100) NOT NULL);

create table content(
contentNum number(5) not null primary key,
contentName varchar2(50) not null,
genre varchar2(30) not null,
actor varchar2(100) not null,
year number(4) not null,
story varchar2(1000) not null,
poster varchar2(30) not null
);

create table contentWishList(
contentNum number(5) not null,
userNum number(5) not null,
CONSTRAINT FK_contentNum FOREIGN KEY (contentNum) REFERENCES content(contentNum),
CONSTRAINT FK_contentuserNum FOREIGN KEY (userNum) REFERENCES member(userNum));

create table QnA(
qnaNum number(5) not null primary key,
userNum number(5) not null,
qnaTitle varchar2(100) not null,
qnaContent varchar2(2000) not null,
qnaRegidate date not null default systimestamp,
qnaPwd varchar2(20) not null,
qnaCategory varchar2(20) null,
CONSTRAINT FK_qnaUserNum FOREIGN KEY (userNum) REFERENCES member(userNum));

create table bulletin(
bulletinNum number(10) NOT NULL primary key,
usernum number(10) NOT NULL ,
bulletinTitle varchar2(30) NOT NULL,
bulletinDate TIMESTAMP DEFAULT SYSTIMESTAMP,
constraint FK_USERNUM foreign key (userNum) references member1(usernum)
);

CREATE TABLE BULLETINBOARDWISHLIST(
BULLETINNUM NUMBER(10) NOT NULL,
BULLETINUSERNUM NUMBER(10) NOT NULL,
CONSTRAINT FK_BULLETINNUM FOREIGN KEY(BULLETINNUM)REFERENCES BULLETIN(BULLETINNUM),
CONSTRAINT FK_BULLETINUSERNUM FOREIGN KEY (BULLETINUSERNUM) REFERENCES MEMBER1(USERNUM)
);

create table comments(
commentNum number(5) not null primary key,
commentContent varchar2(500) not null,
commentDate date not null default systimestamp,
bulletinNum number(10) not null,
CONSTRAINT FK_commentNum FOREIGN KEY (bulletinNum) REFERENCES bulletin(bulletinNum));


create table QnAReply(
replyNum number(5) not null,
replyContent varchar2(1000) not null,
replyRegidate date default systimestamp,
qnaNum number(5) not null,
 CONSTRAINT FK_qnaReply FOREIGN KEY (qnaNum) REFERENCES QnA(qnaNum));

create table comment(
commentNum number(5) not null primary key,
commentContent varchar2(500) not null,
commentDate date not null default systimestamp,
bulletinNum number(10) not null,
CONSTRAINT FK_commentNum FOREIGN KEY (bulletinNum) REFERENCES bulletin(bulletinNum));


member - member_seq
content - content_seq
QnA - QnA_seq
bulletin - bulletin_seq
comments - comments_seq
QnAReply - QnAReply_seq