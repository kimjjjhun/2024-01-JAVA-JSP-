package movie;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

public abstract class AbstractMenu implements Menu{            // AbstractMenu는 인터페이스 메뉴를 상속받음
@AllArgsConstructor
@NoArgsConstructor
@Setter
	@Override
	public void print() {
		System.out.println("\n" + menuText); // 메뉴출력
	}

/*	@Override
	public Menu next() {
		
		return null;
	}

	private String menuText;      // 기본 문구
	private Menu prevMenu;       // 이전메뉴
	
	private static final Scanner sc = new Scanner(System.in);
	
	AbstractMenu(String menuText, Menu prevMenu){
		this.menuText = menuText;
		this.prevMenu = prevMenu;
	}
	
	public void setPrevMenu(Menu prevMenu) {
		this.prevMenu = prevMenu;
	} */
	

}
