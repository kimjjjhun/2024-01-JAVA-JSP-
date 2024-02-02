package ex02;

public class Example {
	public static void action(A a) {
		a.method1();
		if(a instanceof C) {
			C c = new C();
			c.method2();
		}
	}
	public static void main(String[] args) {
		action(new B());
		action(new C());
	}
	}
   
   // if(a instanceof C) a가 참조하고있는대상이
   //  C클래스이거나 C를 상속하고 있니? 라고 물어봄