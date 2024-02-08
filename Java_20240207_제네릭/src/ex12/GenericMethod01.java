package ex12;

class Box<T>{   //T --> String
	private T obj;
	
	void set(T obj){ 
		this.obj = obj; }
	
	T get() {
		return this.obj;}
		
		public String toString() {
			return obj.toString();
	}
}

class Unboxer{                                                      //클래스선언

	public static <T> void openBox(Box<T> box) {        //제네릭메소드 선언 제네릭메소드는 넘버를 상속
		System.out.println(box);
	}
	
	public static void peekBox(Box<?> box) {    // 와일드카드
		System.out.println(box);
	}
}


public class GenericMethod01 {
	
	public static void main(String[] args) {
	
	Box<String> sbox = new Box();
	sbox.set("Korea");	
	
	Unboxer.<String>peekBox(sbox);
	Unboxer.<String>openBox(sbox);


	
}
	}

