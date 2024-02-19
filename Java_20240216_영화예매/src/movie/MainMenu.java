package movie;

public class MainMenu extends AbstractMenu {
	//새로운 생성자 메인메뉴를 만들고 그 안에 초기값은 널값을 입력
	//메인메뉴화면에출력할 기본문구를 만들고 final로 값을 못바꾸게 지정
	private static final MainMenu instance = new MainMenu(null);
	private static final String MAIN_MENU_TEXT = //기본 문구
			"1: 영화 예매하기 \n" + 
	        "2: 예매 확인하기 \n" +
			"3: 예매 취소하기 \n" +
	        "4: 관리자 메뉴로 이동하기 \n" +
			"q: 종료\n\n" +
	        "메뉴를 선책하세요 : " ;

	private MainMenu(Menu prevMenu) {    // 메인메뉴생성자(menu prevMenu) null값이 들어가있음
		super(MAIN_MENU_TEXT, prevMenu); // 부모생성자 호출 // 위에 작성한 기본문구 출력
	}
	
	public static MainMenu getInstance() {
		return instance;                   //MainMenu 객체 생성 주소반환(싱글톤패턴)
	}
	
	@Override
	public Menu next() {                   //추상클래스에게 물려받은 인터페이스메뉴 추상메소드 menu next 구현
		switch(sc.nextLine()) {           // switch 반복문으로 입력값을 받고 반복하거나 빠져나감
		
		case"2":
			checkReservation(); // 예매확인하기
			return this; // 메인 메뉴 객체 반환(다시 메인메뉴가 나타난다.)
		case"4":
			if(! checkAdminPassword()) {        //입력받은 비밀번호와 설정한 비밀번호 값이 일치하니? 물어봄
				System.out.println("비밀번호가 틀렸습니다.");  // 틀릴경우 출력하고 메인메뉴주소값으로 돌아감  
				return this;
			}
			AdminMenu adminMenu = AdminMenu.getInstance();
			adminMenu.setPrevMenu(this);
			return adminMenu;
		case "q" : return prevMenu;  //q입력하면, prevMenu를 반환     
		default : return this;       //그 외 입력 MainMenu로 돌아감
		}
	}

	private void checkReservation() {
		System.out.println("예매번호를 입력하세요: ");
		try {
			Reservation reservation = Reservation.FindById(sc.nextLine());
			
			if(reservation == null) {
				System.out.println(">> 예매 내역이 없습니다.");
			}else {
				System.out.println(">>[확인 완료]\n" + reservation);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private boolean checkAdminPassword() {
		System.out.println("관리자 비밀번호를 입력하세요 : ");
		
		String admin = sc.nextLine();
		
		return "admin".equals(admin);
	//  return "admin".equals(sc.nextLine());
	}
	

}
