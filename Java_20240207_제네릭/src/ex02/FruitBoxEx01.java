package ex02;

/*
 * 이 코드 문제점(?)
 * 1. 이 박스에는 사과, 오렌지만 담고싶은데..다른것이 담겨도 제거 불가
 * 2. get할 때 형변환 해야한다. (다운케스팅을 해야한다..)
 */

class Apple{  //사과
	public String toString() {
		return "I am an apple";
	}
}

class Orange{ //오렌지
	public String toString() {
		return "I am an Orange";
	}
}

class Box{  //사과,오렌지 담는 상자
	private Object obj;
	
	void setObj(Object obj) {
		this.obj = obj;
	}
	
	Object getObj(){
		return obj;
	}
}

public class FruitBoxEx01 {

	public static void main(String[] args) {
		
		Box abox = new Box();                    // 클래스박스를 참조하는 참조변수 abox 라는 새로운 box 생성
		Box bbox = new Box();                    // 클래스박스를 참조하는 참조변수 bbox 라는 새로운 box 생성
		
		abox.setObj(new Apple());  //사과 담음
		bbox.setObj(new Orange()); //오렌지 담음
		
		Apple ap = (Apple)abox.getObj();               // apple 박스에 있는 리턴값을 꺼내옴
		Orange op = (Orange)bbox.getObj();             // orange 박스에 있는 리턴값을 꺼내옴
		
		System.out.println(ap);                         // ap 값 출력
		System.out.println(op);                         // op 값 출력
		
		abox.setObj(10);                                 // 문제점 obj는 모든 클래스의 조상이기에 아무값이나 입력이 된다.
		abox.setObj(1.2);
		abox.setObj("String");
				
	}

}










