package com.ott.dto;



import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 *  create table bulletin(
	   bulletinNum number(10) NOT NULL primary key,
	   Userid VARCHAR2(20) NOT NULL,
	   name VARCHAR2(30) NOT NULL,
	   bulletinTitle varchar2(30) NOT NULL,
	   bulletinDate TIMESTAMP DEFAULT SYSTIMESTAMP,
	   bulletincontent NOT NULL VARCHAR2(1000),
	   readCount number(4) DEFAULT 0,
	   constraint FK_userId foreign key (userId) references member(userId),
   );
 */

@Setter
@Getter
@ToString
public class BulletinVO {
	
	private int bulletinNum;
	private String userId;
	private String name;
	private String bulletinTitle;
	private Timestamp bulletinDate;
	private String bulletinContent;
	private int readCount;
	private int contentNum;


}
