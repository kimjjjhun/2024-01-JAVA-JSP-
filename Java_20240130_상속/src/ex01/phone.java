package ex01;

public class phone {

	private String model;
	private String color;
    
	
	public phone() {
	
		System.out.println("Phone");
	}
	
	@Override
	public String toString() {
		return "phone [model=" + model + ", color=" + color + "]";
	}

	public phone(String model, String color) {
		System.out.println("Phone");
	    this.model = model;
	    this.color = color;
	
	}
	
	public void color() {
		System.out.println();
	}
	
	
	public void bell() {
		System.out.println("전화 벨이 울린다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("자 신 :" + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대방 :" + message);
	}
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	
}
