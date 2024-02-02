package ex03;

import java.util.Scanner;

public class dowhile02 {

	public static void main(String[] args) {
		
		int input, answer,count;
		input= answer = 0; count = 0; // 정수 입력
		
		answer = (int)(Math.random()*100)+1; // answer 변수에 100까지 수를 랜덤하게 생성
		
		Scanner sc = new Scanner(System.in);  // 입력을 받겠다 선언
		do {     // 반복문 실행
			
             System.out.println("1과 100사이의 정수를 입력하세요!!");
         input = sc.nextInt();
         count++;
		if(input > answer)
			System.out.println("더 작은수 입력!!");
		else if(input < answer)
			System.out.println("더 큰 수 입력!!");
		
		} while(input != answer);
		System.out.println(count + "회" + input + "맞추었습니다.");
		
		
		
		
		
		

	}

}
