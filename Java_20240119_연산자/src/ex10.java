import java.util.Scanner;

public class ex10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=6; i++) {
			for(int j=1; j<=6; j++)
				if((i+j) == 6)
					System.out.println(i+"+"+j+"="+(i+j));
		}

	}

}
