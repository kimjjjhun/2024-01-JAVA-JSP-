package ex08;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {

	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList(10);                       //arrayList를 사용하여 list1이 참조하는 새로운배열 생성
		list1.add(new Integer(5));                                 //생성한 배열에 값을 넣어줌
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));     //sublist 를 사용하여 list2가 1번째방부터 4번째방전까지 참조하는 새로운 배열을 생성
		print(list1, list2);                                      
		
		Collections.sort(list1);                                  //list1과 list2를 정렬한다.
		Collections.sort(list2);                                  
		print(list1, list2);                                      
		
		System.out.println("list1.containsAll(list2):"+ list1.containsAll(list2));   // lsit1과 list2가 겹치는 확인
		
		list2.add("B");
		list2.add("C");
		
		list2.add(3,"A");
		print(list1, list2);
		
		list2.set(3, "AA");
		print(list1, list2);
		
		//list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2):"
				            + list1.retainAll(list2));
		print(list1, list2);
		
		// list2에서 list1에 포함된 객체들을 삭제한다.
		for(int i=list2.size()-1; i >= 0; i--) {  // for문을 활용하여 반복
			if(list1.contains(list2.get(i)))
				list2.remove(i);                    
		}
		
		print(list1, list2);
	}  // main의 끝

	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();
	}
}      // class