package Movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class Movie {
	
	private long id;              //영화 고유번호
	private String title;         //영화 제목
	private String genre;         //영화 장르
	
	private static final File file = new File("src/Movie/movies.txt");   // 영화를 저장한 텍스트문서 file에 저장

public Movie(String title, String genre) {                          // 생성자 무비 선언 반환타입 String 매개변수 title , genre
	this(Instant.now().getEpochSecond(),title,genre);               //
}
public static ArrayList<Movie> findAll(){                           // ArrayList 배열 findAll이 참조하는 컬렉션 생성 값은 제네릭을 통해서 Movie에 상속되거나 본인만 넣을수있음 
	ArrayList<Movie> movies = new ArrayList<Movie>();               // Movie 배열값을 넣을 새로운 movies ArrayList 배열을 생성
	BufferedReader br = null;                                       // bufferedreader를 사용하여 file을 읽어올거기때문에 클래스안에 정젹메소드 선언
	String line = null;                                             // null 값을 선언하여 반복문을 빠져나올 line 문자열 변수 선언
	try {                                                           // try,catch구문으로 예외처리 사용
	               br = new BufferedReader(new FileReader(file));   // filereader 로 file 을 읽어와서 br에 값을 넣음
	               
	               while((line = br.readLine())!=null) {            //while 반복문으로 null 값이 들어있는 line에 split 을 사용하여 ',' 기준으로 나눠서 문자열배열 temp에 넣는다.
	            	   String[] temp = line.split(",");
	            	   Movie m = new Movie(Long.parseLong(temp[0]), //나눠서 들어가있는 temp배열을 넣어줄 Movie를 참조하는 m 객체를 생성하여 다시 하나로 묶어서 넣는다. Movie에 초기값을 
	            			   temp[1],                             //String이 아닌 정수타입으로 변환하기위하여 parseLong을 사용하여 temp[0]배열에 들어있는 문자열을 정수형으로 변환시켜서 m에 넣는다.
	            			   temp[2]);
	}
	               br.close();                                      // 모두 불러왔으면 통로를 끊어준다.
}catch (FileNotFoundException e) {                                  // try 문 사이에 오류가 있을시 처리하여 출력받을수있게 처리하는 catch 문을쓴다. try문에서 catch는 생략할수없다.
	e.printStackTrace();
}catch (IOException e) {
	e.printStackTrace();
}
	return movies;                                                   //try문까지 완벽화게 작동하고 실행되면 값을 movies 로 넘긴다.
}
}
