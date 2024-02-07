import java.util.Scanner;

public class Welcome {
	static final int NUM_BOOK =3; //도서의 개수에 대한 상수 NUM_BOOK 선언 파이널상수는 대문자로 표기해서 선언 ****************
	static final int NUM_ITEM =7; //도서 정보의 개수에 대한 상수 NUM_ITEM 선언 파이널상수는 대문자로 표기해서 선언 ************

	public static void main(String[] args) {
		
		String[][] mBook = new String[NUM_BOOK][NUM_ITEM]; // 도서 정보를 저장할 mBook을 2차원 배열로 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신의 이름을 입력하세요 :");
		String userName = sc.next();
		
		System.out.println("연락처를 입력하세요 :");
		int userMobile = sc.nextInt();
		//System.out.println("Welcome to Shopping Mall!");
		//System.out.println("welcome to Book Market!");
		
		String greeting = "Welcome to Shopping Mall!";
		String tagline = "Welcome to Book Market!";
		boolean quit = false; // 종료 여부 설정변수
		while(!quit) { // while 반복문 시작
		/*
		System.out.println("***********************************************");
		System.out.println("\t"+greeting);
		System.out.println("\t"+tagline);
		System.out.println("***********************************************");
		System.out.println("1. 고객 정보 확인하기 \t4. 바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기 \t6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기 \t8. 종료");
		System.out.println("***********************************************");
		*/
			menuIntroduction();
		System.out.println("메뉴 번호를 선택해주세요");
		int n = sc.nextInt();
		System.out.println(n+"번을 선택했습니다");
		
		if(n < 1 || n > 8 ) {
			System.out.println("1부터 8까지의 숫자를 입력하세요.");
		}
		else {
			switch(n) {
			
			case 1:
				//System.out.println("현재 고객 정보: ");
				//System.out.println(" 이름 "+ userName +" 연락처 "+ userMobile);
				menuGuestInfo(userName,userMobile); // 고객정보 출력 메서드 호출
				break;
			case 2:
				//System.out.println("장바구니 상품 목록 보기 :");
				menuCartItemList();
				break;
			case 3:
				//System.out.println("장바구니 비우기");
				menuCartClear();
				break;
			case 4:
				//System.out.println("장바구니에 항목 추가하기 : ");
				menuCartAddItem();
				break;
			case 5:
				//System.out.println("5. 장바구니의 항목 수량 줄이기");
				menuCartRemoveItemCount();
				break;
			case 6:
				//System.out.println("6. 장바구니의 항목 삭제하기");
				menuCartRemoveItem();
				break;
			case 7:
				//System.out.println("7. 영수증 표시하기");
				menuCartBill();
				break;
			case 8:
				//System.out.println("8. 종료");
				menuExit();
				quit = true;
				break;
			
			}
		}                  // if~else문 끝
		
	 }
	}
	
	public static void menuIntroduction() {
		System.out.println("***********************************************");
		System.out.println("1. 고객 정보 확인하기 \t4. 바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기 \t6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기 \t8. 종료");
		System.out.println("***********************************************");
		
	}
	
	public static void menuGuestInfo(String name, int mobile) {
		System.out.println("현재 고객 정보 :");
		System.out.println("이름 " + name + " 연락처 " + mobile);
	}
	public static void menuCartItemList() {
		System.out.println("2. 장바구니 상품 목록 보기");
	}
	public static void menuCartClear() {
		System.out.println("3. 장바구니 비우기");
	}
	public static void menuCartAddItem() {
		System.out.println("4. 장바구니에 항목 추가하기");
	}
	public static void menuCartRemoveItemCount() {
		System.out.println("5. 장바구니의 항목 수량 줄이기");
	}
	public static void menuCartRemoveItem() {
		System.out.println("6. 장바구니의 항목 삭제하기");
	}
	public static void menuCartBill() {
		System.out.println("7. 영수증 표시하기");
	}
	public static void menuExit() {
		System.out.println("8. 종료");
	}
	public static void BookList(String[][] book) {
		book[0][0] = "ISBN1234";
		book[0][1] = "쉽게 배우는 JSP 웹 프로그래밍";
		book[0][2] = "27000";
		book[0][3] = "송미영";
		book[0][4] = "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍";
		book[0][5] = "IT전문서";
		book[0][6] = "2018/10/08";
		
		book[1][0] = "ISBN1235";
		book[1][1] = "안드로이드 프로그래밍";
		book[1][2] = "33000";
		book[1][3] = "우재남";
		book[1][4] = "실습 단계별 명쾌한 멘토링!";
		book[1][5] = "IT전문서";
		book[1][6] = "2022/01/22";
		
		book[2][0] = "ISBN1236";
		book[2][1] = "스크래치";
		book[2][2] = "22000";
		book[2][3] = "고광일";
		book[2][4] = "컴퓨팅 사고력을 키우는 블록 코딩";
		book[2][5] = "컴퓨터입문";
		book[2][6] = "2019/06/10";
	}
	
	

}
