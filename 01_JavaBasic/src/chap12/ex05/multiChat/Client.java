package chap12.ex05.multiChat;

import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket socket = null;
		
		try {
			// 소켓 생성, 연결 요청
			socket = new Socket("127.0.0.1", 5252); // 127.0.0.1은 localhost IP
			System.out.println("연결 수락됨");
			
			// 쓰레드 생성 및 실행
			ClientSender sender = new ClientSender(socket);
			ClientReceiver receiver = new ClientReceiver(socket);
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("소켓 연결 실패");
			socket.close(); // 연결 실패
		}
		


	}

}
