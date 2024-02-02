import java.util.Scanner;public class a01 { 
         //배열 변수 선언
	public static void main(String[] args) {            //메인 메소드 선언
		//배열변수에 배열을 대입
		int[] scores; 
		scores = new int[] {83,90,87};
		//배열 항목의 총합을 구하고 출력
		int sum1 = 0;
		for(int i=0; i<3; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합:"+ sum1);
		
		//배열을 매개값으로 주고, printItem() 메소드 호출
		
		//printItem() int 배열 선언
		printItem (new int[] {83,90,87} );	
		}
	public static void printItem( int[] scores) {    
		//매개변수가 참조하는 배열의 항목을 출력
		for(int i=0; i<3; i++) {
			System.out.println("score[" + i + "]: " + scores[i]);
		}
}

}
