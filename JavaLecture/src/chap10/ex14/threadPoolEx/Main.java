package chap10.ex14.threadPoolEx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {

		// pool 생성 방법 : ExcutorService 객체
		// 1개 이상의 쓰레드가 추가되었을 경우 60초 동안 쉬고 있으면 쓰레드를 제거
		ExecutorService pool = Executors.newCachedThreadPool();
		
		int n = Runtime.getRuntime().availableProcessors(); // 현재 CPU의 최대 쓰레드 수
		System.out.println("현재 CPU의 최대 쓰레드 수 : " + n);
		pool = Executors.newFixedThreadPool(n); // 기본적으로 n개의 쓰레드 유지

	}

}
