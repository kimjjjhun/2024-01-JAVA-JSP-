package ex04;

public class Book {

	
	private String title;
	private String author;
	private String publisher;
	private int price;
	
	Book(String title,String author,String publisher,int price){
		this.title();
		this.author();
		this.publisher();
		this.price();
	}
	void title() {
		System.out.println("도서명" + title);
	}
	void author() {
		System.out.println("저자" + author);
	}
	void publisher() {
		System.out.println("출판사" + publisher);
	}
	void price() {
		System.out.println("가격" + price);
	}
}

// Book(){
//        this(t,a,p,0);    // this : 다른생성자 호출
// }
// Book(){ this(); }         
// Book(String t, String a, String p, int rice){
// title = t;
// author = a;
// publisher = p;
// price = rice;
// }

// void displayBookInfo() {
//	System.out.println();
//	System.out.println();
//	System.out.println();
//	System.out.println();
//}


