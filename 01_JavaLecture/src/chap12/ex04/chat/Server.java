package chap12.ex04.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 1:1 채팅 프로그램
public class Server {

	public static void main(String[] args) {

		ServerSocket serverSocket;
		
		try {
			
			// 1. 서버소켓 생성 + 특정 IP 개방(호스트일 때에는 포트만 지정하면 한번에 가능)
			serverSocket = new ServerSocket(5001);
			System.out.println("요청 대기");
			
			// 2. 연결 수락
			Socket socket = serverSocket.accept();
			System.out.println("요청 수락");
			
			// 3. 메시지 수신 쓰레드 객체화
			Receiver rec = new Receiver(socket);
			
			// 4. 메시지 전송 쓰레드 객체화
			Sender sen = new Sender(socket);
			
			// 쓰레드 시작
			rec.start();
			sen.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
