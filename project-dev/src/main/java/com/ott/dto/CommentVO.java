package com.ott.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
create table comments(
commentNum number(5) not null primary key,
commentContent varchar2(500) not null,
commentDate date default systimestamp not null,
bulletinNum number(10) not null,
commentCount number(10),
CONSTRAINT FK_commentNum FOREIGN KEY (bulletinNum) REFERENCES bulletin(bulletinNum)ON DELETE CASCADE);
 */
@Setter
@Getter
@ToString
public class CommentVO {
	private int commentNum;
	private String commentContent;
	private Timestamp commentDate;
	private int bulletinNum;
	private String userId;
	
}
