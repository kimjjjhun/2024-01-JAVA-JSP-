

public class Exam02 {

	public static void main(String[] args) {
		/* 메서드명 : abs
		 * 반환타입 : int
		 * 매개변수 : int
		 * 기능 : 주어진 값의 절대값을 반환한다.
		 */
             System.out.println("절대값 출력 프로그램");
             // 메서드명 int는 반환타입
             int num = abs(-1);
             
             System.out.println("절대값:" + num);
	}
             
            		 static int abs(int num) {
            			 
       // 위 아래 같은 문장    	 //return num>0 ? num : -num;
            			 return Math.abs(num);
             
            
	}
}
