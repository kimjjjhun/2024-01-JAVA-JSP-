package ex07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapCollection {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();   // 제네릭을 사용하여 맵 생성
		
		map.put(33, "Toy");                // key , value 와 함께 사용하여 맵에 값을 넣어줌
		map.put(47, "Box1");
		map.put(67, "Robot");
		
		//반복해서 출력할 때..
		
		System.out.println(map.get(33));             // map에 찍힌값을 찾을때 get을사용하여 출력함
		System.out.println("--------------------------");
		
		Set<Integer> set = map.keySet(); // 키만 모아서 set저장한다.
		
		Iterator<Integer> it = set.iterator();         
		                                                           ////반복문
		while(it.hasNext())                                     
			//System.out.println(it.hasNext() + "\t");
		      System.out.println(map.get(it.next()) + '\t');

	}

}
