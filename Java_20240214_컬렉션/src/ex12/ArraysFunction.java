package ex12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysFunction {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		int[] arr2;
		int[] arr3;
		
		Arrays.fill(arr, 10);
		Arrays.setAll(arr, i -> (int)(Math.random()*45)+1);
	    System.out.println(Arrays.toString(arr));
	    
	    arr2 = Arrays.copyOf(arr, 5);
	    arr3 = Arrays.copyOfRange(arr, 2, 7);
	    System.out.println("arr2 : " +Arrays.toString(arr2));
	    System.out.println("arr3 : " +Arrays.toString(arr3));
	    
	    
	    //ArrayList는 선언과 동시 초기화 불가 그럴때 aslist 사용
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(10);
	    System.out.println(list);
	    
	    list = Arrays.asList(10,20,30,40,50); // 리스트 초기화 , 값추가를 따로 할수없음
	    System.out.println(list);
	    
	    // list.add(60);  aslist를 사용하면 초기값을 넣을수있지만 값을 추가할수는없다.
	    list = new ArrayList( Arrays.asList(10,20,30,40,50));
	    //list.add(20);                 // 값을 추가하고 싶으면 ArrayList로 다시 변경해야된다.
	    System.out.println(list);

	}

}
