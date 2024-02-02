package ex04;

public class 로또3 {

	public static void main(String[] args) {
		int[] lotto = new int[45];
		// 로또 변수 45개를 생성
		for(int i=0; i < lotto.length; i++)
			lotto[i] = i+1;
		//1~45의 숫자를 순서대로 저장
		for(int i=0; i<1000; i++) {
			int num = (int)(Math.random()*44)+1;
			// 1~45의 숫자를 랜덤하게 생성
			int tmp = lotto[0];
			// 변수 tmp는 로또변수번호 0번에 저장한다.
		    lotto[0] = lotto[num];
		    // 로또 변수번호0은 랜덤하게 변수값이다.
		    lotto[num] = tmp;
		    //로또 변수번호num은 tmp의 값이다.
		}   // 포문을 나간다.
		
		for(int i=0; i<6; i++)
			//반복For문 6번 실행 
			System.out.println(lotto[i]+ " ");
		//로또변수i의 값
	

	}   
}
	

