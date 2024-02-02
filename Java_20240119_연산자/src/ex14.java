import java.util.Scanner;

public class ex14 {

	public static void main(String[] args) {
		// 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내느 프로그램이다.
		// 1~2에 알맞은 코드를 넣어서 프로그램 완성
		//math.radom 사용으로 결과가 다를수있음
		
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		//배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
		for(int i=0; i<ballArr.length; i++) {
			int j = (int)(Math.random()*ballArr.length);
		int tmp = 0;
		tmp = ballArr[i];
		ballArr[i] = ballArr[j];
		ballArr[j] = tmp;	
		}
		for(int i=0; i<ball3.length; i++) {
			ball3[i] = ballArr[i];
		}
		
		//배열 BallArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		for(int i=0;i<ball3.length;i++)
			System.out.println(ball3[i]);
	
	}
	

}
