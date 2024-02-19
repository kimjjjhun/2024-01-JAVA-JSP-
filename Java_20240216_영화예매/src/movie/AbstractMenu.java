package movie;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public abstract class AbstractMenu implements Menu{   //추상클래스 완벽하게 추상메소드를 구현하지 않았기
	                                                  //때문에
	
	protected String menuText; //기본문구               //값이있는 클래스생성자,기본클래스생성자 생성
	protected Menu prevMenu; //이전메뉴                 //메뉴의 값을 입력받을 스캐너메서드 생성
	
	protected static final Scanner sc = new Scanner(System.in);
	
/*    AbstractMenu(String menuText, Menu prevMenu){
    	this.menuText = menuText;
    	this.prevMenu = prevMenu;
    }
    
    public void setPrevMenu(Menu prevMenu) {
    	this.prevMenu = prevMenu;
    }  */

	@Override                                // 추상클래스에서 물려받은 void print 구현
	public void print() {                     
		System.out.println("\n" + menuText); //추상메소드 void print 값 입력
	}

/*	@Override
	public Menu next() {
		
		return null;
	}    */

}

// 인터페이스에 상속받은 2가지 추상메소드를 구현하지 않았기에
// 아직 미완성 추상클래스라는걸 선언하기위해 앞쪽에 abstract 입력
