package chap03.ex03.multiArr;

// 다차원 배열
public class Ex01 {
	// 2차원 배열
	public static void main(String[] args) {
		// 총 5층 4호 royal 아파트 (0층 ~ 4층)
		String[][] royal = new String[5][4];
		
		// 층, 호 입출력
		for (int i = 0 ; i < royal.length; i++) { // 범위 주의!
			System.out.println("-" + i + "층" + "-");
			for (int j = 0; j < royal[i].length; j++) { // 범위 주의!
				royal[i][j] = i + "층 " + j + "호"; // 입력 (0층 0호)
				System.out.println(royal[i][j]); // 출력
			}
			System.out.println();
		}
		
		// 총 2층 4호 crown 아파트 (직접 정의)
		int crown[][] = {
				{00, 01, 02, 03},
				{10, 11, 12, 13}
		};
		
	}

}
