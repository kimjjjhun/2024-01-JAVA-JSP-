package ex02;


public class Example01 {

	public static void main(String[] args) {
  /*      Animal d = new Dog();
          d.makeSound();
          Animal c = new Cat();
          c.makeSound();
          Animal b = new Bird();
          b.makeSound();
*/       
		
		
		 sound(new Bird());     //
         sound(new Cat());      // 상속 다형성을 이용한 출력
         sound(new Dog());      //
		
	
	}     
	  
         static void sound(Animal animal) {      // 사운드생성자 선언 , 애니멀클래스에 포함된 
        	  animal.makeSound();                // 메이크사운드 출력문실행
          }

}
