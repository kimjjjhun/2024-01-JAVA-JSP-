package ex05;

public class 메서드3 {

	public static void main(String[] args) {
		//반환타입 // 이름 // 매개변수 = 반환타입으로 출력
		//void 가 반환타입에 있으면 return 이 포함되서는 안된다.
		System.out.println("Hello~~~~~~");
		int num = max(100,20);                            //함수 호출
		System.out.println("최대값:" + num);

	}
        //static : 움직임이없다.변화가없다 //	
	     static int max(int n1, int n2)                    // 최대값
        {      System.out.println("난 함수!!");
        return n1>n2 ? n1 : n2;
        }
        
	     static int min(int n1, int n2)
        {      System.out.println("난 함수!!");             // 최소값
        return n1<n2 ? n1 : n2; 

}
}