package ex05;

public class 메서드오버로딩 {

	public static void main(String[] args) {

		/*메소드명 : calculateEvenSum
		 * 매개변수 : int
		 * 반환타입 : int
		 * 기능 : 주어진 정수 n까지의 모든 짝수의 합을 계산하는 함수 작성
		 * 
		 */
		System.out.println(add(10,20));
		System.out.println(add(10,20,30));
		System.out.println(add(10.2,20.2));
	}
	
	static int add(int i, int j) {
		System.out.println("add(int i, int j");
		return i+j;
	}
	
	static int add(int i, int j , int x) {
		return i+j+x;
	}
	static double add(double i, double j) {
		return i+j;
	
		
		}
	}
	
