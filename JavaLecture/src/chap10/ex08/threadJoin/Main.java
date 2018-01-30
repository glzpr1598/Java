package chap10.ex08.threadJoin;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		WorkThread thread = new WorkThread();
		
		System.out.println("1부터 100까지 합은?");
		thread.start();
		thread.join(); // join이 없으면 work thread가 일을 끝내기전에 결과를 출력함 -> 0 출력
		System.out.println(thread.getSum());

	}

}
