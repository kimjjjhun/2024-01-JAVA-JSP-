package ex13;

import java.time.LocalDate;

public class Review implements Comparable<Review>{
	
	int reviewCount; // 리뷰수
	LocalDate date;
	
	public Review(int reviewCount, LocalDate date) {
		this.reviewCount = reviewCount;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "review [reviewCount=" + reviewCount + ", date=" + date + "]";
	}
	
	public int compareTo(Review o) {
		int x = this.reviewCount;
		int y= o.reviewCount;
		
		/* int result = 0;
		
		if(x > y)
			result = 1;
		else if(x<y)
			result = -1;
		else
			result = 0; */
		
		//return ( x < y )? -1 : ( ( x < y ) ? 1 : 0 );
		//삼항연산자를 사용하여 위보다 간결하게  reviewCount와 date를 정렬 시킬수있다.
		
		return Integer.compare(x, y);
	}
	

}
