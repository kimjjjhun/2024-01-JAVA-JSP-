package ex15;
import java.util.*;
public class HashMapEx2 {

	public static void main(String[] args) {
		
		HashMap map = new HashMap();                   // Map 이 참조하는 HashMap을 선언
		map.put("김자바", (100));                       // Map 안에 key , value 값 입력
		map.put("이자바", (100));
		map.put("강자바", (80));
		map.put("안자바", (90));
		
 		Set set = map.entrySet();                      // set 과 Interator 를 사용하여 while 반복문을 사용하여 이름,점수를 출력
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름 :" + e.getKey()
			+" , 점수 : " + e.getValue());
		}
		
		
		set = map.keySet();                                // map의 key값을 set에 입력
		System.out.println("참자가 명단 : " + set );                // key값에 등록된 참가자명단 출력
		
		Collection values = map.values();                  //조상클래스를 사용하여 values의 값을 map.values에서 받아온다. 
		
		it = values.iterator();
		int total = 0;                                         // int total 초기값 입력
		while(it.hasNext()) {                                  //while반복문과 it.hasNext 사용하여 value값을 꺼내온다.
			Integer i = (Integer)it.next();                    // total 초기값 0을 intvalue를 통하여 합산을 구함
			total += i.intValue();
		
		}
		
		System.out.println("총점 :" + total);
		System.out.println("평균 :" + (float)total/set.size());
		System.out.println("최고점수 :" + Collections.max(values));
		System.out.println("최저점수 :" + Collections.min(values));

	}

}
    