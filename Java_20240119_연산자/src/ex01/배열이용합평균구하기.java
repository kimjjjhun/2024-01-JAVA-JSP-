package ex01;


public class 배열이용합평균구하기 {

	public static void main(String[] args) {

		double[] gradeArr = {90,70.5,80,79,82.5,50,70,90.2,89.5,89.7};
		double sum = 0.0;
		
		for(int i=0; i<gradeArr.length; i++) {
			sum+= gradeArr[i];
		}
		
		double average = sum / gradeArr.length;
		System.out.println("합계:" +  (int)sum);
		System.out.format("평균:" + (int)average);
		 	}
}
