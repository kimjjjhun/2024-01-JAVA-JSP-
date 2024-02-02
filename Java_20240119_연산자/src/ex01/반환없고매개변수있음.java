package ex01;

public class 반환없고매개변수있음 {

	public static void main(String[] args) {
		/* 메소드 : max
		 * 매개변수 : int,int
		 * 반환 : void
		 * 두수 입력받아서 최대값 출력
		 */

		System.out.println("최대값출력:");
		 max(5,20);                                 // 호출
System.out.println("프로그램 종료!");
	}
	
  static void max(int n1, int n2) {          // 반환이 없을때 void를 사용
	   
	   
	   int max = n1 > n2 ? n1 : n2;         // 맥스의값은 삼항연산자로 출력
	   System.out.println("최대값:" + max);    
		
	}

}
