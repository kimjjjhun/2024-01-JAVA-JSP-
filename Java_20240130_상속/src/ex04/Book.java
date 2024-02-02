package ex04;

public class Book {                      //접근제한자 클래스 구현
   private String title;                 // 클래스의 변수값 설정
   private String author;                //  자료형,멤버변수명,초기값 설정 **** (생략가능하다)
   private int publicationYear;
    
    public Book() {                      //생성자 호출  **** 인스턴스 메서드 호출
    	
    }
    
    public Book(String title,String author,int publicationYear) {           //생성자 Book의 title , author , publicationYear 호출
    	this.title = title;                                                 
    	this.author = author;                                               // this------>  동일한 클래스 내의 서로 다른 생성자에서 오버로딩된 또 다른 생성자 하나를 호출함
this.publicationYear = publicationYear;
    }
    
     void displayinfo(){                                                     //displayinfo 일반 생성자 호출
    	System.out.println("Title:[" + title + "]");                         
    	System.out.println("Author:[" + author + "]");
    	System.out.println("publicationYear:[" + publicationYear + "]");
    }

}
