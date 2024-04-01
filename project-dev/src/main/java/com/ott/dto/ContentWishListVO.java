package com.ott.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE CONTENTWISHLIST(
contentNum NUMBER(10) NOT NULL,
CONTENTUSERNUM NUMBER(10) NOT NULL,
CONSTRAINT fk_contentNum FOREIGN KEY(contentNum) REFERENCES Content(contentNum),
CONSTRAINT fk_CONTENTUSERNUM  FOREIGN KEY(CONTENTUSERNUM) REFERENCES MEMBER1(userNum)
);
 */

@Setter
@Getter
@ToString
public class ContentWishListVO {
	private int contentNum;
	private String contentUserId;
}
