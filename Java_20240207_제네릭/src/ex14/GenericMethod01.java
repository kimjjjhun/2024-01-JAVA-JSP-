package ex14;

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

class A {
	public String toString() {
		return "A class";
	}
}

class Unboxer{       
             // super Integer -> Integer 이거나 Integer 상위클래스면 ok
	         // Integer -> Number -> Object
	
	public static void peekBox(Box<? super Integer> box) {    // 와일드카드
		System.out.println(box);
	}
}


public class GenericMethod01 {
	
	public static void main(String[] args) {
	
      Box<Integer> ibox = new Box();
      ibox.set(1234);
      Unboxer.peekBox(ibox);
         //integer 위로 상위클래스면 가능 Number , Object
      Box<Number> dbox = new Box<Number>();
      dbox.set(12.5);
      Unboxer.peekBox(dbox);
      
      Box<Object> obox = new Box<Object>();
      obox.set("설날");
      Unboxer.peekBox(obox);

	Box<Object> obox2 = new Box<Object>();
	obox2.set(new A());
	Unboxer.peekBox(obox2);
}
	}

