package ex03;

public class Textbook extends Book{


public Textbook(String title, String author, int publishYear) {
		super(title, author, publishYear);
		
	}

String getDetails() {
		
		return super.getDetails() + " : 학문분야";
	}
	
	
}
