package chap10.ex16.blocking;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Result {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// 1. 쓰레드 풀 생성
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		// 2. 작업 내용 생성
		Callable<String> call = new Callable<String>() {
			@Override
			public String call() throws Exception {
				for (int i = 0; i < 10; i++) {
					System.out.println("작업 처리 : " + i);
				}
				return "완료";
			}
		};
				
		// 3. 작업 내용 실행
		Future<String> future = pool.submit(call);
		System.out.println(future.get()); // Future를 get() 하는 것은 join()과 같은 역할(blocking)
		System.out.println("작업 완료");
		
		// 4. 쓰레드 풀 종료
		pool.shutdown();
		
	}

}
