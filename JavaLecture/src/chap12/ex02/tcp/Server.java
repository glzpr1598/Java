package chap12.ex02.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// TCP로 통신
// 이클립스에서 동시에 두개를 실행할 수 없음.
// 서버는 이클립스에서 실행하고 클라이언트는 cmd로 실행
public class Server {

	public static void main(String[] args) throws IOException {
		
		// 1. 서버소켓 생성
		ServerSocket serverSocket = new ServerSocket();

		try {
			// 2. IP 개방
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			
			// 3. 클라이언트 요청 대기
			while (true) {
				System.out.println("요청 대기 중");
				// 4. 요청에 따른 실행 및 응답
				Socket socket = serverSocket.accept(); // 요청이 올 때까지 기다림.
				// 해야할 일 - client의 주소 확인
				InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("클라이언트 주소 : " + addr.getAddress() + ":" + addr.getPort());
			}
		} catch (IOException e) { // 예외가 발생하면 종료
			// 5. 소켓 반납
			serverSocket.close();
			System.out.println("서버 종료");
		}

	}

}
