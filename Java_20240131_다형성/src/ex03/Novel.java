package ex03;

public class Novel extends Book{
	
	       private String Novel;

	public Novel(String title, String author, int publishYear) {
		super(title, author, publishYear);
		
		
	}

String getDetails() {
		
		return super.getDetails() + " : 장르";
	}
	
}
