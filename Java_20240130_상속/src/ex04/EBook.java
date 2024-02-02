package ex04;

public class EBook extends Book{

	private double fileSize;
	private String forMat; 
    	
	
	 public EBook(String title,String author,int publicationYear,double fileSize,String forMat) {
		 super(title,author,publicationYear);
		 this.fileSize = fileSize;
		 this.forMat = forMat;
    }


	

	
}
