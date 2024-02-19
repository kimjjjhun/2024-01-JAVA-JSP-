package movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Reservation {
	
	private long id; // 예매번호
	private long movieId; // 영화 고유 번호
	private String movieTitle; // 영화 제목
	private String SeatName; // 좌석번호
	
	private static final File file = new File("src/movie/reservation.txt");
	
	public Reservation(long id, long movieId, String movieTitle, String SeatName) {}
	/*	this.id = id;
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.SeatName = SeatName;
	} */
		public static Reservation FindById(String reservationId) {   
			Reservation reservation = null;          // 초기값 설정
			BufferedReader br = null;                //   ""
			String line = null;                      //   ""
			 
			try {                                    // try 문으로 예외처리
				br = new BufferedReader(new FileReader(file));  // 버퍼리더를 통해서 file목록 호출
				while((line = br.readLine()) != null) {         //while 문으로 반복문 실행
					
					String[] temp = line.split(",");            //불러온 file목록을 ","단위로 자름
					
					if(reservationId.equals(temp[0])) {        //예매번호와 영화목록temp[0]이 일치하면 실행
						reservation = new Reservation(         // 
								Long.parseLong(temp[0]),       // 새로운 예매번호
								Long.parseLong(temp[1]),       // 
								(temp[2]),                     // 
								(temp[3])                      //
										);
						break;
					}
				}
			br.close();
			return reservation;
		}catch (Exception e) {
			e.printStackTrace();
		}
			return null;
		}
		public String toString() {
			
			return String.format("영화 : %s, 좌석 : %s", movieTitle, SeatName);
		}
		
	}



