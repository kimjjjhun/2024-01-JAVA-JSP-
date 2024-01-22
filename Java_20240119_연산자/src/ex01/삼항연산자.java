package ex01;

public class 삼항연산자 {

	public static void main(String[] args) {
		int jumsu = 90;
		
		if(jumsu >= 60)
			System.out.println("합 격");
		else
			System.out.println("불합격");
		
		String msg = ( jumsu >= 60 ) ? "합격" : "불합격"; // 참일때 합격 거짓일때 불합격 (?)( ,) 등 있다 
		System.out.println(msg);   

	}

}
