package ex05;

//추상 클래스 추상클래스는 객체를 생성할수없음
public abstract class  Speaker {                 
	   
	   public abstract void powerOn();    
	   
	   public abstract void powerOff();
	 // abstract //추상메소드    : "반드시 재정의해야해" 라고 선언   
	   public abstract void SoundUp();
	   
	   public abstract void SoundDown(); 
}