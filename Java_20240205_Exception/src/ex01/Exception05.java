package ex01;

import java.util.Scanner;

public class Exception05 {

	public static void main(String[] args) {
        int sum = func1();
        System.out.println("두 수 합은 :" + sum);
	}
	
	static int func1() {
		return func2();

}
	static int func2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수 입력 >>");
		
		// 예외가 발생하면 
		// 내부에서 해결 or 예외 던지기
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		return num1+num2;
		
	}
}