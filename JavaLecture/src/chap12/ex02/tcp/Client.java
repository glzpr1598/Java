package chap12.ex02.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

// cmd로 실행(프로젝트의 bin 폴더에서 "패키지명.클래스명"으로 실행)
public class Client {

	public static void main(String[] args) throws IOException {
		
		// 1. 소켓 생성
		Socket socket = new Socket();
		
		// 2. 접속 요청
		try {
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("연결 완료");
			// 3. 요청이 허가되면 작업 수행
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		} finally {
			// 4. 소켓 반납
			System.out.println("소켓 반납");
			socket.close();
		}

	}

}
