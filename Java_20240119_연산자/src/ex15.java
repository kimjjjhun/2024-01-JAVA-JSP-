import java.util.Scanner;

public class ex15 {

	public static void main(String[] args) {
		//큰 금액의 동전을 우선적으로 거슬러 줘야된다.
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		for(int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원 : " + money / coinUnit[i]);
			money = money % coinUnit[i];
			v
		}
	}
	

}
