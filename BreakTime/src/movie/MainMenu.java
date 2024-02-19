package movie;

public class MainMenu extends AbstractMenu{
	
	private static final MainMenu instance = new MainMenu(null);
	private static final String MAIN_MENU_TEXT = 
			"1: 영화예매하기\n "+
	        "2: 예매확인하기\n "+
	        "3: 예매취소하기\n "+
	        "4: 관리자메뉴로이동하기\n "+
	        "5: 종료\n\n "+
	        "메뉴를 선택하세요: ";
	
	private MainMenu(Menu PrevMenu) {
		super(MAIN_MENU_TEXT, prevMenu);
	}
	

	@Override
	public Menu next() {
		
		return null;
	}

}
