package ex09;

class Box<T>{   //T --> String
	private T obj;
	
	void set(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return this.obj;
	}
}

class Unboxer{

	public static <T> T openBox(Box<T> box) {
		return box.get();
	}
}
public class GenericMethod01 {

	
	public static void main(String[] args) {
		Box<String> sbox = new Box<String>();
		sbox.set("Korea");
		String str =Unboxer.openBox(sbox);
		System.out.println(str);

	}

}
