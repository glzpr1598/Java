package chap10.ex05.sync;

// user1이 컴퓨터에 점수를 500으로 입력하고
// 일정 시간 후에 user2가 그 컴퓨터에 점수를 100으로 입력하는 작업
// 동기화 이용
public class PcRoom {

	public static void main(String[] args) {
		
		Computer com = new Computer();
		User1 user1 = new User1(com);
		User2 user2 = new User2(com);
		
		user1.start();
		user2.start();
		
	}

}
