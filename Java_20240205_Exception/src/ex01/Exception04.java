package ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception04 {

	public static void main(String[] args) {
        int sum=0;
		try {
		     sum = func1();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
        //func2()에서 예외를 던지기 때문에 2가지 방법으로 예외처리가능
        //내부처리,외부던지기
        System.out.println("두 수 합은 :" + sum);
	}
	
	static int func1() {
		return func2();

}
	static int func2() throws  InputMismatchException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수 입력 >>");
		
		// 예외가 발생하면 
		// 내부에서 해결 or 예외 던지기
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println("func2 end........");
		
		return num1+num2;
		
	}
}
                             // 예외 던지는 방법