package movie;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");                    // 첫번째 . 메인앱 실행시 문구출력 
		
		Menu menu = MainMenu.getInstance();                        // MainMenu 인스턴스 생서후 하나만 쓰겠다고 선언
		
		while(menu != null) {                                      // MainMenu를 반복할 반복문
			menu.print();                                          // menu 인스턴스 호출
			menu = menu.next();                                    // 선택할 메뉴를 입력받음
		}
		
		System.out.println("프로그램 종료");                    // 반복문 빠져나올시 프로그램 종료

	}

}
