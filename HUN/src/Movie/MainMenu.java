package Movie;

public class MainMenu extends AbstractMenu{  // AbstractMenu를 상속받음(자식클래스)
	
	@Override
	public Menu next() {                                           //메뉴인터페이스의 next() 메서드를 상속하여 구현하기위해 오버라이딩
		switch(sc.nextLine()) {                                    // switch ~ case 문으로 반복문을 돌린다. 값은 입력받는다.
		case "1":
			reserve();            // 영화예매                        // 1번을 입력하면 reserve 생성자 메소드가 실행이 되고 값이 MainMenu로 올라간다.
			return this;
		case "2":
			checkReservation();  //예매확인
			return this;
		case "3":
			cancelReservation();  // 예매취소
			return this;
		case "4":
			if(! checkAdminPassword()) {
				System.out.println("비밀번호를 다시 입력해주세요.");
			return this;
		}
			
		case "5": return prevMenu;                                // 5번을 입력하면 prevMenu 생성자 메소드가 실행이 된다.
		default : return this;                                    // 1~5번이 아닌 다른값을 누를경우 MainMenu의 인터페이스가 다시 실행된다.
		}
		
		
		
	}
	private boolean checkAdminPassword() { // 관리자 비밀번호를 설정해놓기위해 생성자를 만들어 놓는다.
 	
	return false;
}
	private void cancelReservation() {            // 예매한것을 취소하기위한 메소드
	}

	private void checkReservation() {             // 예매확인을 위한 메소드
	}
	
	private void reserve() {                      // 예매하기위한 메소드
		
			
		
}
    private static final MainMenu instance = new MainMenu(null);    // 메인메뉴 instance를 만들어놓고 null 초기값을 넣는다.
	private static final String MAIN_MENU_TEXT =                    // 메인메뉴에 띄울 텍스트를 쓰고 값을 변경할일이 없기에 final을 넣어서 생성한다.            
           			"1: 영화 예매하기\n" +
					"2: 예매 확인하기\n" +
					"3: 예매 취소하기\n" +
					"4: 관리자 메뉴\n" +
					"5: 종료\n\n" +
					"메뉴를 선택하세요: ";
	private MainMenu(Menu prevMenu) {
		super(MAIN_MENU_TEXT, prevMenu);
	}
	public static MainMenu getInstance() {
		return instance;
	}

}
