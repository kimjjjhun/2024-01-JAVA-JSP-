package Movie;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("프로그램을 시작");  // 프로그램실행시 처음으로 출력되는 문장
		Menu menu = MainMenu.getInstance();
		while(menu != null) {
			menu.print();
			menu = menu.next();
		}
		
		System.out.println("프로그램을 종료");
		

	}

}
