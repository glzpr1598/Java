package chap07.ex08.customException;

import javax.management.RuntimeErrorException;

public class JoinMember {
	
	String[] reserved = {"admin", "tester", "member"};
	
	public void regID(String id) {
		// 입력된 id가 reserved 값과 일치하면 예외 발생
		for (String temp : reserved) {
			if (id.equals(temp)) {
				System.out.println("해당 ID가 이미 존재합니다.");
				// 강제 예외 발생시키기
				//throw new RuntimeException("강제 실행 예외 발생!");
				//throw new Exception("강제 일반 예외 발생!"); // try-catch 강제함
				throw new ReservedException(id + "는(은) 예약어입니다.");
			}
		}
	}

}
