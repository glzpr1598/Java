package chap03.ex04.arrFor;

public class Ex01 {
	// 향상된 for문
	// 배열에 사용
	public static void main(String[] args) {
		
		int[] scores = {95, 75, 35, 88, 84};
		
		// 일반 for문
		System.out.println("일반 for문");
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		// 향상된 for문
		System.out.println("향상된 for문");
		for (int temp : scores) { // socres의 값을 하나씩 temp에 대입.
			System.out.println(temp); // scores[temp]가 아님!!
		}
		
		// 합계와 평균 구하기
		int sum = 0;
		double avg = 0;
		for (int temp : scores) {
			sum += temp; // 합계
		}
		avg = (double)sum / scores.length; // 평균. sum 형변환 필요.
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);

	}

}
