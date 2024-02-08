package ex07;

class A{
	@Override
	public String toString() {
		
		return "A class";
	}
}
class B extends A{
	@Override
	public String toString() {
		
		return "B class";
	}
}
class C extends B{
	@Override
	public String toString() {
		
		return "C class";
	}
}
// Box 클래스를 통해서 생성되는 대상은 정수 및 실수만 클래스만 생성한다.
class Box<T extends Number>{
	private T obj;
	
	void set( T obj) {
		this.obj = obj;
	}
	
	T get() {
		return obj;
	}
}

public class BoxEx02 {

	public static void main(String[] args) {
		
		Box<Integer> ibox = new Box<Integer>();
		Box<Double> dbox = new Box<Double>();
		Box<String> sbox = new Box<String>();
		
		

	}

}
