package Movie;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor        // 생성자 자동생성
@NoArgsConstructor         // 매개변수없는 생성자 자동생성
@Setter                    // 세터 자동생성
public abstract class AbstractMenu implements Menu{
	
	protected String menuText; // 기본 문구
	protected Menu prevMenu;  // 이전 메뉴
	
	protected static final Scanner sc = new Scanner(System.in);  // 이용자로부터 입력받음
	

	@Override
	public void print() {
		System.out.println("\n" + menuText); // 메뉴출력문장
	}

	
	}


