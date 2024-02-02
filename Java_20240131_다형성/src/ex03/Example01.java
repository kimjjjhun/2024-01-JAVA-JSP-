package ex03;

public class Example01 {

	public static void main(String[] args) {

	
		detaills(new Textbook("Java","신용권",2022));
		detaills(new Novel("js","몰라",2023));
		detaills(new Magazine("리액트","몰라",2424));
	}
	
	static void detaills(Book book) {
		String msg = book.getDetails();
		System.out.println(msg);
	}
	
}

