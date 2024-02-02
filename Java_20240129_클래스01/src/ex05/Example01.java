package ex05;

public class Example01 {

	public static void main(String[] args) {
		
      Car c = new Car("그랜저", "현대", "2024", "검정", false);
	  
            c.displayCarDetails();
	        
            c.setCar("그랜저", "현대", "2024", "흰색");
            c.displayCarDetails();
            c.setModel("기아");
            c.displayCarDetails();
            
	}


}
