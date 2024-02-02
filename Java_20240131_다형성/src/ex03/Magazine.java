package ex03;

public class Magazine extends Book{

public Magazine(String title, String author, int publishYear) {
		super(title, author, publishYear);
		
	}

String getDetails() {
		
		return super.getDetails() + " : 발행주기";
	}
}
