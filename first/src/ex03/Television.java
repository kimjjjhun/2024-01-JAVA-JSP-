package ex03;

public class Television implements RemoteControl {
    
	//필드
	private int volume;
	
	//turnOn() 추상 메소드 오버라이딩
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");      // 인터페이스에 선언된 turnOn() 추상 메소드 재정의
	}
    //turnOff() 추상 메소드 오버라이딩
	public void turnOff() {
	}
    //setVolume() 추상 메소드 오버라이딩
	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl MAX_VOLUME) {
			this volume = RemoteControl MAX_VOLUME;
		}
	}
	
	//

	
}
