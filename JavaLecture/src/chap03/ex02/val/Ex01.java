package chap03.ex02.val;

// 배열 값 입출력
public class Ex01 {

	public static void main(String[] args) {
		// 크기 10의 배열 생성
		int[] scores = new int[10];
		
		// 배열 크기 확인
		System.out.println("배열의 크기 : " + scores.length);
		
		// 0번 배열에 20 넣기
		scores[0] = 20;
		// 1번 배열에 50 넣기
		scores[1] = 50;
		// 2번 배열에 70 넣기
		scores[2] = 70;
		// 3~9번 배열에 100 넣기
		for (int i = 3; i < scores.length; i++) {
			scores[i] = 100;
		}
		
		// 값 출력
		for (int i = 0; i < scores.length; i++) {
			System.out.println(i + "번째 값 : " + scores[i]);
		}

	}

}
