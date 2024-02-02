package ex04;

public class Speaker {
	   
	   private boolean button;
	   private int volume;
	   
	   Speaker(int volume) {
	      button = true;
	      this.volume = volume;
	   }
	   
	   public void powerOn() {
	      button = true;
	      System.out.println("전원이 켜졌습니다");
	   }
	   
	   public void powerOff() {
	      button = false;
	      System.out.println("전원이 꺼졌습니다");
	   }	
	   
	   public void SoundUp() {
	      volume++;
	      System.out.println("볼륨 : " + volume);
	   }
	   
	   public void SoundDown() {
	      volume--;
	      System.out.println("볼륨 : " + volume);
	   }


	}
