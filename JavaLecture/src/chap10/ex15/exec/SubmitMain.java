package chap10.ex15.exec;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SubmitMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// 1. 풀 생성
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);

		// 2. 해야할 일
		Callable<String> call = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("Callable 처리");
				return "완료";
			}
		};

		// 3. 요청
		Future<String> result = pool.submit(call);
		System.out.println(result.get());

		// 4. 쓰레드 풀 종료
		pool.shutdown(); // 쓰레드가 모두 끝나면 종료
		// pool.shutdownNow(); // 강제 종료
		// pool.awaitTermination(10L, TimeUnit.SECONDS); // 10초 후에 종료

	}

}
