package com.ott.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * CONTENTNUM  NOT NULL NUMBER(5)      
CONTENTNAME NOT NULL VARCHAR2(50)   
GENRE       NOT NULL VARCHAR2(100)  
ACTOR       NOT NULL VARCHAR2(200)  
YEAR        NOT NULL NUMBER(4)      
STORY       NOT NULL VARCHAR2(2000) 
POSTER      NOT NULL VARCHAR2(100)  
DIRECTOR             VARCHAR2(50)  
 */

@Setter
@Getter
@ToString
public class ContentVO {

	private int contentNum;
	private String contentName;
	private String genre;
	private String actor;
	private int year;
	private String story;
	private String poster;
	private String director;
}
