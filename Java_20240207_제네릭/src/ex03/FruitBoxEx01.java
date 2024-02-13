package ex03;

/*
 * 이 코드 문제점(?)
 * 1. 이 박스에는 사과, 오렌지만 담고싶은데..다른것이 담겨도 제거 불가 이럴때 제네릭문법 사용 - 다른것을 담을수없다.
 * 2. get할 때 형변환 해야한다. (다운케스팅을 해야한다..)
 */

class Apple{  //사과
	public String toString() {                                             // abox 참조변수가 생성한 new Box값에 오버라이딩해서 문자열값으로 출력
		return "I am an apple";                                            
	}
}

class Orange{ //오렌지
	public String toString() {
		return "I am an Orange";                        
	}
}

class Box<T>{  //사과,오렌지 담는 상자                             // Box클래스를 제네릭클래스로 선언 <T>
	private T obj;  // T는 CC ,C+부터 써오던 템플릿의 약자이다.      
	
	void setObj(T obj) {                                      // 세터,게터를 사용하여 Box클래스에 접근 
		this.obj = obj;                                       // 여기에 설정된 obj값은 Box클래스의 obj값이라고 this.obj 로 가리킴
	}
	
	T getObj(){                                               // 세터를 사용하여 변경한 값을 게터를 사용하여 리턴시킴
		return obj;
	}
}

public class FruitBoxEx01 {

	public static void main(String[] args) {
		
		Box<Apple> abox = new Box();  // 사과만 담을수있다. 상속클래스는 허용
		
		Box<Orange> bbox = new Box();  // 오렌지만 담을수있다. 상속클래스는 허용
		
		abox.setObj(new Apple());  //사과 담음                       
		
		bbox.setObj(new Orange()); //오렌지 담음
		
		Apple ap = abox.getObj();                // apple 을 참조하는 ap참조변수의 abox값을 꺼냄
		Orange op = bbox.getObj();              // orange 을 참조하는 op참조변수의 bbox값을 꺼냄
		
		System.out.println(ap);
		System.out.println(op);
		
//		abox.setObj(10);
//		abox.setObj(1.2);
//		abox.setObj("String");
		
		
		
				
	}

}










