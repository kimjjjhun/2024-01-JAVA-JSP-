package com.ott.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnAVO {
	private int qnaNum;
	private String userId;
	private String qnaTitle;
	private String qnaContent;
	private Timestamp qnaRegiDate;
	private String qnaPwd;
	private String qnaCategory;
}
