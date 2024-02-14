package ex05;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ArrayListCollection {

	public static void main(String[] args) {
		
		
		//List<String> list = new ArrayList<String>();
		Set<String> list = new HashSet<String>();
		
		//문자열 인스턴스 저장
		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		list.add("Toy");
		//list.add(10);
		
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext())                                // Iterator 를 사용하는 이유는 List , Map , Set 등 다양하게활용하기 
			                                               // 위해서다.
			System.out.println(it.next() + '\t');          // 중간에 변경하지않고 ArrayList만 사용할꺼면 for문을 돌려도 상관없다.
	    
	    

	}

}
