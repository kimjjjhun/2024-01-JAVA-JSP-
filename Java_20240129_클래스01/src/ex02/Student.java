 package ex02;


public class Student {

	
	 private String name;
	 private String studentId;
	 private String major;
	
    
Student(String s,String s2,String s3) {      //인자값 3개 받는것....
	
	  name = s;
	  studentId = s2;
	  major = s3;
}

void displayInformation() {
	System.out.println("이름\t" + name);
	System.out.println("학번\t" + studentId);
	System.out.println("전공\t" + major);
	


}
}