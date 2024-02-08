package ex10;

class Box<T>{   //T --> String
	private T obj;
	
	void set(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return this.obj;
	}
}

class BoxFactory{                                                   //클래스선언
	public static <T extends Number> Box<T> makeBox(T o){           // 제네릭메소드 선언 제네릭메소드는 넘버를 상속
		Box<T> box = new Box();                                     //제네릭메소드 박스라는 새로운박스 생성
		box.set(o);                                                 // 박스 매개값은 o = 100;
		
		System.out.println("boxed :" + o.intValue());               // 출력 boxed : 100 값
		return box;                                                 // o값을 box에 넣음
	}
}

class Unboxer{                                                      //클래스선언

	public static <T extends Number> T openBox(Box<T> box) {        //제네릭메소드 선언 제네릭메소드는 넘버를 상속
		System.out.println("unboxed : " + box.get().intValue());    //출력 unboxed : 100값꺼내서
		return box.get();
	}
}

public class GenericMethod01 {

	
	public static void main(String[] args) {
		Box<Integer> ibox = BoxFactory.makeBox(new Integer(100));
		
		int num = Unboxer.openBox(ibox);
		System.out.println("date :" + num);

	}

}
