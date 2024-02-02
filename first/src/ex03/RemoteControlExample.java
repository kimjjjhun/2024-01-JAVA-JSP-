package ex03;

public class RemoteControlExample {

	public static void main(String[] args) {
		
		System.out.println("리모컨 최대볼륨:" + RenmoteControl MAX_VOLUME);
		System.out.println("리모컨 최저볼륨:" + RemoteControl MIN_VOLUME);
		
		RemoteControl rc;
		
		//rc 변수에 Television 객체를 대입
		rc = new Television();
	    rc.turnOn();
	    
	    //rc 변수에 Audio 객체를 대입(교체시킴)
	    rc = new Audio();
	    rc.turnOn();
		

	}

}
