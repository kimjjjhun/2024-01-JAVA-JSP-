package com.ott.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberVO {

	/**
	 * 
create table member(
userId varchar2(20) NOT NULL PRIMARY KEY,
admin number(1) NOT NULL,
name varchar2(10) NOT NULL,
pwd varchar(30) NOT NULL,
email varchar(30) NOT NULL,
phone varchar(14) NOT NULL,
address varchar(100) NOT NULL);
	 * 
	 * */
	private String userId;
	private int admin;
	private String name;
	private String pwd;
	private String email;
	private String phone;
	private String address;
	
	
}
