package com.ott.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingVO {
	private int page; // 현재 페이지
	private int limit; // 화면에 그려질 데이터
	private int listCount; //전체 게시글 수
	private int startPage; // 게시글 화면에 보여질 첫번째 번호
	private int endPage; // 게시글 화면에 보여질 마지막 번호
	private boolean prev,next; // 이전버튼, 다음버튼 활성화여부
	
	public PagingVO() {}
	
	

	public PagingVO(int page, int limit, int listCount) {
	      this.page = page;
	      this.limit = limit;
	      this.listCount = listCount;
	      int realEnd;
	      realEnd = (int)Math.ceil(listCount/(double)limit);
	      endPage =(int)Math.ceil(page*0.1)*10;
	      startPage = endPage-10+1;
	      
	      if(endPage > realEnd) {
	         endPage = realEnd;
	      }
	      
	      prev = startPage > 1;
	      next = endPage < realEnd ;
	      
	      
	   }

}
