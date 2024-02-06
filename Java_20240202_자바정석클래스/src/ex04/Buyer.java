package ex04;

import ex04.Product;

class Buyer {
	int money = 5000;      // 구매자 소지금
	int price;             // 구매비용
	Product[] cart = new Product[3];   // 장바구니에 넣을 카트 배열 생성
	int i = 0;               // 반복문을 위한 i 초기값 설정
	
	void buy(Product p) {              // 생성자 buy 메서드 선언 매개변수 슈퍼클래스 p 
		 //1.1
		if(money < p.price) {              // 소지금이 구매비용보다 작으면 밑에 글 출력
			System.out.println(p.price + "제품을 사기엔 금액부족");
			return;                       // 처음으로 되돌아감 return문
		}
	
		//1.2 
	money -= p.price;                     // 소지금 - 구매비용 = 저장
	//1.3
	add(p);                               // 구매한 물건을 카트배열에 저장
	
}

     void add(Product p) {              // add 생성자 선언 매개변수 슈퍼클래스 p
    	 
    	 //1.1 -> i값이 장바구니 보다 크다면
    	 if(i >= cart.length) {
    		 Product[] temp = new Product[cart.length*2];  //1.1.1
    		 
    		 for(int i=0; i<cart.length; i++) //1.1.2
    			 temp[i] = cart[i];
    		 
    		 cart = temp; // 1.1.3
    	 }
    	 
    	 //1.2 -> 물건을 장바구니 저장
    	 cart[i++] = p;
     }
    	 
    	 void summary() {
    		 String itemList = " ";
    		 int sum=0;
    		 
    		 // 1.1
    		 for(int i=0; i<cart.length; i++) {
    			 if(cart[i] == null) {
    				 break;
    			 }
    			 itemList += cart[i] + ", ";
    		 sum += cart[i].price;     //1.2
    	 }
    		 System.out.println("구입목록:"+itemList);
    		 System.out.println("사용한금액:"+sum);
    		 System.out.println("남은금액:"+money);    //1.3
    		 
    	 }
	
}
