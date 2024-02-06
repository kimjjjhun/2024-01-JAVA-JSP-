package ex01;

public class ExcceptionEx3 {

	public static void main(String[] args) {
		
		System.out.println(1);         // 1출력
		System.out.println(2);         // 2출력
		try {                          // try-catch문 
			System.out.println(3);     // 3출력
			System.out.println(0/0);   // 정수를 0으로 나누려고하여 오류밠행 다음문장 실행안함
			System.out.println(4);     // 4출력
		} catch (ArithmeticException ae) {        // 오류로 인한 5출력을 건너뜀
			if (ae instanceof ArithmeticException)
				System.out.println("true");
			System.out.println("arithmeticException");
		}catch (Exception e) {
			System.out.println("Exception");
		}
		System.out.println(6);          // 6출력

	}
}