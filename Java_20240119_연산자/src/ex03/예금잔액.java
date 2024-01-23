package ex03;

import java.util.Scanner;

public class 예금잔액 {

	public static void main(String[] args) {
			
				int bankbalance = 0;
				int tmp;
				boolean flag = true;
				Scanner sc = new Scanner(System.in);
				
				for (;flag = true;) {
					System.out.println("-----------------------------------");
					System.out.println("1.예금\t|2.출금\t|3.잔고\t|4.종료");
					System.out.println("-----------------------------------");
				int num = sc.nextInt(); 
				switch (num) {
				case 1:
				System.out.println("예금액>>>");
				tmp = sc.nextInt();
				bankbalance += tmp;
				break;
				case 2:
					System.out.println("출금액>>>");
					tmp = sc.nextInt();
					bankbalance -= tmp;
					break;
				case 3:
					System.out.println("잔고>>>" + bankbalance);
					break;
					default:
						flag = false;
				
				}
			
		
			   
			
		
		}
				System.out.println("시스템종료");    
		
		    
		
		
		
		
	}
	}


