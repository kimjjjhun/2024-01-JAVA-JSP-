package ex04;

public class AudioBook extends Book{

	private double length;
	private String narrator; 
	
	public AudioBook() {
		
	}
	public AudioBook(String title,String author,int publicationYear,double length
			,String narrator) {
		 super(title,author,publicationYear);
		 this.length = length;
		 this.narrator = narrator;
	}

	
	void displayinfo() {
		super.displayinfo();
	System.out.println("length:[" + length + "]" + "narrator:[" + narrator + "]");
	}
	
	
    
    
    
}
