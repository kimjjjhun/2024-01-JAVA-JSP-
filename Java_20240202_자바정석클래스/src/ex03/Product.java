package ex03;

public class Product {
	
	 int price;    // 제품의 가격
	 int bonusPoint; // 제품구매 시 제공하는 보너스점수
	
	Product(int price){          //조상클래스의 생성자 pRODUCT(INT PRICE)를 호출한다
		this.price = price;
		bonusPoint = (int)(price/10.0);
		
	}
	Product() {            //기본생성자
		
	}
	

}

