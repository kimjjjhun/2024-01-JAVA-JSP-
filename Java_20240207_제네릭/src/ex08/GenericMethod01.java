package ex08;

class Box<T>{
	private T obj;
	
	void set(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return this.obj;
	}
}

class BoxFactory{
	//제네릭 메소드 ==> <T>: 제네릭메소드 표시 
	//Box<T>: 반환타입 makeBox: 함수명, (T o) : 매개변수
	public static <T> Box<T> makeBox(T o){
		Box<T> box = new Box<T>();
		box.set(o);
		return box;
		
	}
}

class IntFactory{
	//<T> 제네릭메소드 표시
	//Box<T>: 반환타입 makeBox : 함수명 (T i) : 매개변수
	public static <T> Box<T> makeBox(T i){
       Box<T> box = new Box<T>();   // 새로운 박스생성
       box.set(i);                 //박스의값은 i박스로 설정
       return box;                 //재정의한것을 box값으로 반환
	}
}

public class GenericMethod01 {

	public static void main(String[] args) {

		Box<String> sBox = BoxFactory.makeBox("Korea");
		System.out.println(sBox.get());
		
		Box<Integer> iBox = BoxFactory.makeBox(100);
		System.out.println(iBox.get());
	}

}
