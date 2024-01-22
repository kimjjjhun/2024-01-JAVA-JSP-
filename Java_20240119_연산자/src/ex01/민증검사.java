package ex01;

import java.util.Scanner;

public class 민증검사 {

	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
    
	  System.err.println("나이 입력 :");
	  
	  int age = sc.nextInt();
	  
	  if(age >= 20) {
		  System.out.println("성인입니다.");
	  }
	  
	  if(age < 20) {
		  System.out.println("미성년자입니다.");
	  }
	
	
	  
	  
	  
	  
	
	}

}
