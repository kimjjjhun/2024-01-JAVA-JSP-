package ex14;

class Box<T>{   //T --> String         // 클래스 박스를 제네릭메소드로 선언
	private T obj;                     // 접근제한자 private obj 초기값 설정 클래스 내에서만 사용할수있게 하기위해서
	
	void set(T obj){                   // 박스값안에 obj값을 넣는다. 라는 문장
		this.obj = obj; }              // obj값은 박스클래스안에 있는 제네릭 obj 값이다 라고 좌표를 찍어줌
	
	T get() {                          // 멤버변수를 리턴시킨다.   세터에서 멤버변수값을 초기화했을때 멤버변수를 리턴시켜준다.
		return this.obj;}
		
		public String toString() {       //문자열로 만들어 리턴시킨다.
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
	         // extends Integer -> Integer 이거나 Integer 하위클래스면 ok
	         // Integer -> 자료형배열(double , float , long , int , short , byte)
	
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

