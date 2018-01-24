package chap09.ex02.linkedListEx;

import java.util.ArrayList;
import java.util.LinkedList;

public class BenchMark {
	// ArrayList, LinkedList 데이터 추가 속도 비교
	public static void main(String[] args) {

		// 각각의 객체 정의
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		LinkedList<Integer> lnkList = new LinkedList<Integer>();

		// 데이터 입력
		for (int i = 0; i < 100; i++) {
			arrList.add(i);
			lnkList.add(i);
		}

		long start = 0;
		long end = 0;
		long result = 0;

		// 시작시간 기록
		start = System.currentTimeMillis();

		// 데이터 삽입
		for (int i = 0; i < 100000; i++) {
			arrList.add(50, i);
		}

		// 종료시간 기록
		end = System.currentTimeMillis();
		result = end - start; // 걸린 시간

		System.out.println("ArraryList 걸린 시간 : " + result);

		
		// LinkedList도 똑같이 반복
		// 시작시간 기록
		start = System.currentTimeMillis();

		// 데이터 삽입
		for (int i = 0; i < 100000; i++) {
			lnkList.add(50, i);
		}

		// 종료시간 기록
		end = System.currentTimeMillis();
		result = end - start; // 걸린 시간

		System.out.println("LinkedList 걸린 시간 : " + result);

	}

}
