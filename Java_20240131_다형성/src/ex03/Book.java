package ex03;

public class Book {               // 북클래스 선언
           
	
	private String title;         // 
	private String author;        // 변수값 선언
	private int publishYear;      //
	
	
   public Book(String title,String author,int publishYear) {         //Book 생성자 선언 , Book의 인자값 선언 
	   this.title = title;                                           // this 로 또다른 생성자 호출
	   this.author = author;                                         // this 로 또다른 생성자 호출
	   this.publishYear = publishYear;                               // this 로 또다른 생성자 호출
	   
   }
	
	
	String getDetails() {                             //getDetails 생성자 선언 
		
		
		return title + ":" + author + ":" + publishYear;     // 리턴을 이용하여 초기값으로 이동
	}
	
}
