package movie;

import java.util.ArrayList;

public class AdminMenu extends AbstractMenu {
	
	
	private static final AdminMenu instance = new AdminMenu(null);
	private static final String ADMIN_MENU_TEXT = //기본 문구
			"1: 영화 등록하기 \n" + 
	        "2: 영화 목록 보기 \n" +
			"3: 영화 삭제하기 \n" +
			"B: 메인 메뉴로 이동\n\n" +
	        "메뉴를 선책하세요 : " ;
	
	private AdminMenu(Menu prevMenu) {            // 관리자 메뉴 생성
		super(ADMIN_MENU_TEXT, prevMenu);         // 부모생성자호출 text , prevmenu
	}
	
	public static AdminMenu getInstance() {
		return instance;                   //MainMenu 객체 생성 주소반환(싱글톤패턴)
	}

	@Override
	public Menu next() {
		switch(sc.nextLine()) {
		case "1" :                     // 영화 등록하기
			createMoie();   
			return this;               // 등록한값을 admin메뉴에 저장
		case "2" :
			printAllMovies();        //영화 목록 (printAllMovies) 호출
			return this;             //다시 adminMenu 주소값으로 돌아감
		case "3" :
			deleteMovie();           // 영화 삭제하기
			return this;
		case "b" : return prevMenu; // b입력하면, 이전 메뉴 반환
		default: return this;  // 자기자신(AdminMenu) ==> new AdminMenu(null); 객체 반환
		}
	}

	private void deleteMovie() {
		printAllMovies(); // 전체 목록 출력한다.
		
		System.out.println("삭제할 영화의 ID값을 입력하세요: ");
			try {
				Movie.delete(sc.nextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(">> 삭제되었습니다.");
		
	}

	private void createMoie() {
		System.out.println("제목 : ");
		String title = sc.nextLine(); // 제목 입력
		
		System.out.println("장르 : "); // 장르 입력
		String genre = sc.nextLine();
		
		Movie movie = new Movie(title, genre);
		
		
		}
		
	

	private void printAllMovies() {
		
		ArrayList<Movie> movies = Movie.findAll();  // 모든 영화를 가져옴
		for(Movie movie : movies) {      // 변수타입 변수이름 배열이름
			System.out.println(movie);
		}
	}

}
