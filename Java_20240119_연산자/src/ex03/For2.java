package ex03;

import java.util.Scanner;

public class For2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("길이 :");
		
		int a = sc.nextInt();
		
		for (int i=0; i < a; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
		for (int j = 0; j < (2*a)-1-(i*2); j++) {
			System.out.print("*");
		}
		System.out.println("");
		}
		
		
		
		
		
		
		

	}

}
