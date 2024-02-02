package ex05;

public abstract class   Speaker1 extends Speaker{
	   
	   private boolean button;
	   private int volume;
	   
	   Speaker1() {}
	   
	   Speaker1(int volume) {
	      button = true;
	      this.volume = volume;
	   }
	   
	   @Override
	   public void powerOn() {
	      button = true;
	      System.out.println("전원이 켜졌습니다");
	   }
	   
	   @Override
	   public void powerOff() {
	      button = false;
	      System.out.println("전원이 꺼졌습니다");
	   }
	   
	   @Override
	   public void SoundUp() {
	      volume++;
	      System.out.println("볼륨 : " + volume);
	   }
	   
	   @Override
	   public void SoundDown() {
	      volume--;
	      System.out.println("볼륨 : " + volume);
	   }


	}
