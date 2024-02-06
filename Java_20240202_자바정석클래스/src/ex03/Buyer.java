package ex03;

import java.util.Vector;

public class Buyer {         //고객, 물건을 사는 사람
	
	int money = 1000;         // 소유금액
	int bonusPoint = 0;       // 보너스점수
	Vector item = new Vector();   // 구입한 제품을 저장하는데 사용될 vECTOR객체 생성
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액부족");
			return;
		}
	money -= p.price;          // 가진 돈에서 구입한 제품의 가격을 뺀다.
	bonusPoint += p.bonusPoint;   // 제품의 보너스 점수를 추가한다.
	item.add(p);                    // 구입한 제품을 Vector에 저장한다.
	System.out.println(p + "을/를 구매하셨습니다.");
	}
	
	void refund(Product p) {        // 구입한 제품을 환불한다.
		if(item.remove(p)) {        // 제품을 Vector에서 제거한다.
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "물품을 반품하셨습니다.");
		} else {                               // 제거에 실패한경우
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}
	void summary() {                    // 구매한 물품에 대한 정보를 요약해서 보여준다.
		int sum= 0;                     // 구입한 물품의 가격합계
		String itemList = " ";          // 구입한 물품의 물품목록
		
		if(item.isEmpty()) {            // Vector가 비어있는지 확인한다.
			System.out.println("구입하신 제품이 없습니다.");
		return;
		
		}

	for(int i=0; i<item.size();i++) {
		Product p = (Product)item.get(i);     // Vector의 i번째에 있는 객체를 얻어온다.
		sum += p.price;
		itemList += (i==0) ? "" + p : ", " + p;
	}
		System.out.println("물품총액:" + sum);
		System.out.println("구입하신제품:"+ itemList);
	
	
	
	
	}
	}
	


