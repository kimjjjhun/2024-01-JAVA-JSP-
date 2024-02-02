import java.util.Scanner;

public class ex09 {

	public static void main(String[] args) {
		int i = 0;  // 변수 i 선언하고 0값을 출력
		while (i<10) {   // while문 선언 - 반복문 - i 가 10보다 클때까지 반복
			int j = 0;  // 변수 j 선언하고 0값을 출력
			while (j <=i) { // while문 선언 - 박복문 - j가 i와 같거나 클때까지 반복
				System.out.print("*"); // 출력 별모양
				j++;                     // j값 +1증가
			}                    
			System.out.println();        //출력 공백
			i++;                         //출력 i값 증가
		}
	}

}
