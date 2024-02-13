package ex15;

import java.util.ArrayList;

class Fruit {                                             // 과일바구니 클래스 생성

	@Override
	public String toString() {
		return "Fruit";
	}
	
}

class Apple extends Fruit {                             // 과일바구니클래스를 상속받은 사과클래스 생성

	@Override
	public String toString() {
		return "Apple";
	}
	
}

class Grape extends Fruit {                              // 과일바구니클래스를 상속받은 포도클래스 생성

	@Override
	public String toString() {
		return "grape";
	}
	
}

class Toy {                                             // 부모클래스가 없는 토이클래스 생성

	@Override
	public String toString() {
		return "Toy";
	}
	
}

public class FruitBoxEx1 {                                     // 과일바구니를 살펴볼 클래스 과일박스클래스 생성

	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>();                   // 안에는 Fruit 거나 Fruit 를 상속받은 클래스만 넣을수있는 박스를 생성
		Box<Apple> appleBox = new Box<Apple>();                   // 안에는 Apple 이거나 Apple을 상속받은 클래스만 넣을수있는 박스 생성
		Box<Toy> toyBox = new Box<Toy>();                         // 안에는 Toy만 넣을수있는 박스 생성
	//	Box<Grape> grapeBox = new Box<Apple>();
		
		fruitBox.add(new Fruit());                                    // 과일박스안에 과일값 넣음
		fruitBox.add(new Apple()); // OK . void add(Fruit item)
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		//appleBox.add(new Toy());  // 에러 Box<Apple>에는 Apple만 담을 수 있음
		
		toyBox.add(new Toy());
		//toyBox.add(new Apple()); // 에러 Box<Toy>에는 Apple을 담을수 없음
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
		
		

	}

}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item);
	}
	T get(int i) {
		return list.get(i);
	}
	int size() {
		return list.size();
	}
	public String toString() {
		return list.toString();
	}
}
