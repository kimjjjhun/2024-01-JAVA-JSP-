package ex05;

import java.util.Scanner;

public class 메서드스트링배열 {

	public static void main(String[] args) {
		
       
		Scanner sc = new Scanner(System.in);
		System.out.println("3개의 문자열을 입력하세요.");
		String[] myArr = new String[3];
		myArr[0] = "kor";
		myArr[1] = "eng";
		for (int i=0; i < 3; i++) 
			System.out.println(myArr[i]+ " ");
		}
		
	}


