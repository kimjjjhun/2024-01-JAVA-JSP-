package ex01;

public class Cat {
	//멤버 변수  --재료(레시피)
	  private String breed;                  //섹터를통해서 or 생성자를통해서만 값을 집어넣을수있다.
      private String color;
    
    //멤버 변수 값을 대입 및 변경은
    //생성자를 이용 또는 setter를 이용해서 값을 변경이나 초기화한다.
    
    //추가..setter, getter
    //setter는 변수값을 변경할 때 사용
    //getter는 변수값을 읽어올 때 사용
    
    
    //setter -> set+변수명 조합 -> 카멜표기법으로 표시
    void setBreed(String s) {
    	breed =s;
    	
    }
    void setColor(String c) {
    	color = c;
    }
    
    
    //생성자(클래스이름하고 같다) --반환타입x
    Cat(String s, String s2){
    	breed = s;
    	color = s2;                                         //System.out.println("디폴트 생성자");
    }
    Cat(){
    	
    }
    
    
    //멤버 메소드 --액션(미역을 3분 불린다..)
    void eat() {
    	System.out.println("츄르를 먹는다");
    	System.out.println("컬러는 " + color + "이다.");
    	
    
    
    
    }
    
    void scratch() {
    	
    }
    
    void meow() {
    	
    
    
    
    
    }
}
