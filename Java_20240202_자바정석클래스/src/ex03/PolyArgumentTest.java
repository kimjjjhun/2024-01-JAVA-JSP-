package ex03;

public class PolyArgumentTest {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		Audio audio = new Audio();
		
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Audio());
		b.summary();
		System.out.println();
		b.refund(com);
		b.summary();
		
		System.out.println("남은금액" + b.money + "만원입니다.");
		System.out.println("잔여포인트는" + b.bonusPoint + "점입니다.");

	}

}
