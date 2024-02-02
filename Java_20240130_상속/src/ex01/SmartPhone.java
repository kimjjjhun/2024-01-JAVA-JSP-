package ex01;

public class SmartPhone extends phone{
	
	
	private boolean wifi;
	
	
	public SmartPhone(String model, String color) {
		System.out.println("SmartPhone");
	}
	
	public SmartPhone(boolean wifi) {
		System.out.println("SmartPhone(boolean wifi)");
		this.wifi = wifi;
	}
	
	
	public void internet() {
		System.out.println("인터넷 연결!!");
	}

	@Override
	public String toString() {
		System.out.println(super.toString()); // 상위클래스 toString 메소드 호출
		return "SmartPhone [wifi=" + wifi + "]";
	}
}
