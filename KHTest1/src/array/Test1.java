package array;

public class Test1 {

	public static void main(String[] args) {
	
		 int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}}; 
		 double sum = 0; // 합
		 double avg = 0; // 평균
		 int leng = 0; // 원소의 총 개수
		 
		 for (int i = 0; i < array.length; i++) {
			 for (int j = 0; j < array[i].length; j++) {
				 sum += array[i][j];
			 }
		 }
		 
		 leng = array.length * array[0].length; // 행 개수 * 열 개수
		 avg = sum / leng; // 평균 계산
		 
		 System.out.println("합계 : " + sum);
		 System.out.println("평균 : " + avg);
		
	}
	
}
