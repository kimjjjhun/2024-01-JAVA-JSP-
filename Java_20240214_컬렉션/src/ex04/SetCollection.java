package ex04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetCollection {

	public static void main(String[] args) {
		
		//중복저장되지 않는다. , 순서가 없다.
		Set<String> set = new HashSet<String>();
		
		set.add("Toy");
		set.add("Box");
		set.add("Robot");				
	    set.add("Toy");
	    
	    Iterator<String> it = set.iterator();  //반복자.
	    
	    while(it.hasNext()) {
	    	System.out.println(it.next() + '\t');
	    }
	    System.out.println();

	}

}
