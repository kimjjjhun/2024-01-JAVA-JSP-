package ex05;

public class Car {

	private String make;
	private String model;
	private String year;
	private String color;
	private boolean engine;
	
    	Car(String m,String o,String y,String c,boolean engine){
    		make = m;
    		model = o;
    		year = y;
    		color = c;
    		
    	}
	void displayCarDetails() {
		System.out.println("제조사:" + make);
		System.out.println("모델:" + model);
		System.out.println("제조년도:" + year);
		System.out.println("색상:" + color);
	}
	boolean startEngine() {
	    return engine = true;
	
	}
	boolean stopEngine() {
		return engine = false;
	}
	
	void setMake(String m) {
	    make = m;	
	}
	
	void setModel(String o) {
		model = o;
	}	
	void setCar(String m,String o,String y,String c) {
		make = m;
		model = o;
		year = y;
		color = c;
		
	}
	
	
	
	}
	
	
	


