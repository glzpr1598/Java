package chap09.ex06.queueEx;

import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {

	public static void main(String[] args) {
		
		// Queue : FIFO(First In First Out)
		// Queue는 LinkedList를 이용한다.
		Queue<Job> q = new LinkedList<Job>();
		
		// 데이터 추가(offer, add)
		q.add(new Job("Command1", "To1"));
		q.add(new Job("Command2", "To2"));
		q.add(new Job("Command3", "To3"));
		q.add(new Job("Command4", "To4"));
		q.add(new Job("Command5", "To5"));
		
		// 크기 확인(size)
		System.out.println("데이터 수 : " + q.size());
		
		// 데이터 꺼내기(poll)
		int size = q.size();
		for(int i = 0; i < size; i++) { // q.size()를 조건에 넣으면 안됨(계속 줄어들기 때문)
			Job job = q.poll();
			System.out.println(job.getCommand() + " " + job.getTo());
			System.out.println("남은 데이터 수 : " + q.size());
		}

	}

}
