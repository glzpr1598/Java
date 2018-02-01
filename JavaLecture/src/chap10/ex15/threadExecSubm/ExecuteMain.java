package chap10.ex15.threadExecSubm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteMain {

	public static void main(String[] args) {

		// 1. 풀을 만든다.
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);

		/*
		 * 2. 작업 내용 생성
		 * Runnable : 리턴 값 없음
		 * Callable : 리턴 값 있음
		 */
		Runnable run = new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable로 처리");
			}
		};

		 /*
		  * 3. 실행 (Runnable 객체는 submit, execute 모두 사용 가능)
		  * Submit : Future 객체 반환, 비정상적으로 종료 시 재사용
		  * execute : 비정상적으로 종료 시 종료시킴
		 */
		pool.execute(run);

		// 4. 쓰레드 풀 종료
		pool.shutdown(); // 쓰레드가 모두 끝나면 종료
		// pool.shutdownNow(); // 강제 종료
		// pool.awaitTermination(10L, TimeUnit.SECONDS); // 10초 후에 종료

	}

}
