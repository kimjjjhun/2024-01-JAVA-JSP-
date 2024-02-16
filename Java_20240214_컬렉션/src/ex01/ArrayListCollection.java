package ex01;

import java.util.ArrayList;

public class ArrayListCollection {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();   // list가 참조하는 ArrayList 뉴 컬렉션 생성 제네릭을 사용 
		
		
		//문자열 인스턴스 저장
		list.add("Toy");                       // list 안에 객체를 추가함 (Toy , Box , Robot )
		list.add("Box");
		list.add("Robot");
		
		//저장된 리스트 출력
	    for(int i=0; i<list.size(); i++)            // for문과 Object.get을 사용하여 객체를 꺼냄
	    	System.out.println(list.get(i) + " ");
	    System.out.println();
	    
	    
	    //삭제
	    list.remove(0);                                // Object.remove 는 배열에 있는 저장된 객체를 제거
	    // System.out.println(list.get(0));
	    // 앞자리가 삭제되면 뒤 데이터들이 전부 배열을 앞으로 한칸식 이동한다.
	    // 따라서 arraylist는 빈번한 삭제가 있는 경우에는 속도가 저하 될 수 있다.
	    
	    
	    //향상된 for문 사용
	    for(String str : list)                         // 향상된 for문으로 간결하게 출력가능
	    	System.out.println(str + " ");
		
	    

	}

}
