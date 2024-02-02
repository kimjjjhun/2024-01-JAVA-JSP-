package ex06;

public class PersonController {

	public static void main(String[] args) {
		// 인스턴스 메소드는 객체를 생성한다음 참조변수로 접근가능
		Person p = new Person();
		p.showInfo();
		
		// 스태틱 메소드는 객체 생성하지않고 바로 접근 가능
		// 클래스명.메소드명으로 호출가능
  
		Person.staticShow(); // 이것을 주로 사용
		p.staticShow(); // 사용자제..
	}

}
