import java.util.Scanner;

public class ex11 {

	public static void main(String[] args) {
		int answer =(int)(Math.random()*100)+1;
		int count = 0;
		int input = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1과 100사이의 값을 입력해주세요:");
			input = sc.nextInt();
			count++;
			if(input > answer)
				System.out.println("더 작은수를 입력하세요");
			else if(input < answer)
			System.out.println("더 큰수를 입력하세요");
		}while(input != answer);
		System.out.println("맞추었습니다.\n" + "시도횟수는" + count+"회입니다.");
	
	
	
	
	
	}
	

}
