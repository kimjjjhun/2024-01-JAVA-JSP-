package ex01;

public class Example01 {

	public static void main(String[] args) {
		
		//Cat이란 클래스를 통해서 c1이란 참조변수가 참조하는 객체를 생성함
		Cat c1 = new Cat("페르시안고양이","흰색");
		//--> new Cat()은 Cat()란 생성자 호출을 통해서 객체를 생성한다.
 //       c1.breed = "페르시안고양이";
 //       c1.color = "흰색";
        
        
        c1.eat();
                    //러시안블루
        Cat c2 = new Cat("코리아","검정");
        
 //       c2.breed = "코리아";
 //       c2.color = "검정";
        
        c2.eat();
        
        
        
        
        
	}

}
