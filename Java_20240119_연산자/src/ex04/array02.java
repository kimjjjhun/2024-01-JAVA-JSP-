package ex04;

public class array02 {

	public static void main(String[] args) {
		
       //1. int형 배열 생성후 랜덤(1~100)이용해서 배열 크기 10값 저장
		//2. 그 배열 총점.평균 구하기
          double avg=0;
          int total=0;
          
          int[] arrNum = new int[5];
          
          //1~100이 값을 랜덤하게 추출해서 저장
	      
          
          for(int i=0; i<arrNum.length; i++) {
	    	  
        	  int num = (int)(Math.random()*100)+1;
	      
        	  arrNum[i] = num;
	      
          }
	       // 배열 10개값 출력
	      
          for(int i=0; i<arrNum.length; i++)
	    	  System.out.println(arrNum[i] + " ");
	
	 System.out.println("\n==================================");
	 
	 for(int i=0; i<arrNum.length; i++) 
		 total += arrNum[i];
	 avg = (double)total/arrNum.length;
	 System.out.println("총점 :" + total + " 평균 :" + avg); 
	 
	 // 최대값 구하기
	 
	 
	 int max=0;
	 for(int i=0; i<arrNum.length; i++) 
	 
	if (max < arrNum[i]) {
		 max = arrNum[i];
	 }
	
	System.out.println("최대값 :" + max);
	System.out.println("======================================");
	
    // 정렬...
	for(int i=0; i<arrNum.length-1; i++)            //반복문 -1만큼 실행
		for(int j=i+1; j<arrNum.length; j++ ) {       //j는 i+1이다. j가 arrnum보다 커질때까지 j값 증가
			int tmp;                                // tmp 초기값 새로 생성
			if(arrNum[i]>arrNum[j]) {               // tmp 값을 arrnum[i]에다가 넣는다
				tmp = arrNum[i];                    // i의 값을 j에 넣는다.
				arrNum[i] = arrNum[j];              // j값을 tmp로
				arrNum[j] = tmp;
			}
		}
	 
	 for(int i=0; i<arrNum.length; i++)             // 반복문 실행 arrnum이 i 
   	  System.out.println(arrNum[i] + " ");
	 
	 
	 
	
	}

}
