package chap03.ex03.multiArr;

public class Ex02 {
	// 3차원 배열
	public static void main(String[] args) {
		// 5개층 4개호 royal 아파트는 방이 3개
		String[][][] royal = new String[5][4][3];

		// 층 수 확인
		System.out.println(royal.length + "개 층");
		// 호 수 확인
		System.out.println(royal[0].length + "개 호");
		// 방 수 확인
		System.out.println(royal[0][0].length + "개 방");

		// 2층 3호 2번방을 "철수의 방"
		// 0층 0호 0번방을 "영희의 방"
		// 나머지 방은 "공실"
		royal[2][3][2] = "철수의 방";
		royal[0][0][0] = "영희의 방";

		for (int i = 0; i < royal.length; i++) {
			for (int j = 0; j < royal[i].length; j++) {
				for (int k = 0; k < royal[i][j].length; k++) {
					if (royal[i][j][k] == null)
						royal[i][j][k] = "공실";
					System.out.println(i + "층 " + j + "호 " + k + "번방 : " + royal[i][j][k]);
				}
			}
		}

	}

}
