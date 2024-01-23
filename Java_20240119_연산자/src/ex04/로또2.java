package ex04;

public class 로또2 {

	public static void main(String[] args) {
		int[] lotto = new int[45];
		
		for(int i=0; i<1000; i++) {
			int num = (int)(Math.random()*44)+1;
		    int tmp = lotto[0];
		    lotto[0] = lotto[num];
		    lotto[num] = tmp;
		}
		
	

	}   
}
	
	

