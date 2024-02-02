package ex03;

public interface RemoteControl {
	 // 상수필드
	 int MAX_VOLUME = 10;
	 int MIN_VOLUME = 0;

	
	
	
	//public 추상메소드
	void turnOn();
	void turnOff();	
	void setVolume(int volume);
	
	

}
