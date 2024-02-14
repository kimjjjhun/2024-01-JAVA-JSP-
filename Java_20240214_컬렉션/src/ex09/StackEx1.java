package ex09;

import java.util.*;

public class StackEx1{
	public static Stack back = new Stack();     //back Stack 구현
	public static Stack Forward = new Stack();  //Forward Stack 구현
	

	public static void main(String[] args) {
		
		goURL("1.네이트");                  
		goURL("2.야후");
		goURL("3.네이버");                  // URL 4개 구현
		goURL("4.다음");
		
        printStatus();                    //Stack 에 들어있는 값을출력[4개]
        
        goBack();                        // 4개의 Back 스택에서 하나
                                         // 를 꺼냄
        System.out.println("= '뒤로' 버튼을 누른 후 =");
        printStatus();                   // Stack 에 들어있는 값을출력[3개]
        
        goBack();                        // 3개의 Back 스택에서 하나
                                         // 를 꺼냄
        System.out.println("= '뒤로' 버튼을 누른 후 =");
        printStatus();                   // Stack 에 들어있는 값을출력[2개]
        
        goForward();                     // 2개의 Forward 스택에서 하나
                                         // 를 저장
        System.out.println("= '앞으로' 버튼을 누른 후 =");
        printStatus();                   // Stack 에 들어있는 값을출력[3개]
        
        goURL("codechobo.com");          // goURL에 새로운값저장
        System.out.println("= 새로운 주소로 이동 후 =");
        printStatus();

	}
	
	public static void printStatus() {
		
		System.out.println("back:"+back);
		System.out.println("forward:"+Forward);
		System.out.println("현재화면은 '" + back.peek()+"' 입니다.");
		System.out.println();
	}
	
	public static void goURL(String url) {
		back.push(url);
		if(!Forward.empty())
			Forward.clear();
	}
	
	public static void goForward() {
		if(!Forward.empty())
			back.push(Forward.pop());
	}
	
	public static void goBack() {
		if(!back.empty())
			Forward.push(back.pop());
	}

}
