package chap12.ex04.chat;

import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		try {
			// 1. 소켓 생성 + 접속 요청
			Socket socket = new Socket("localhost", 5001);

			// 2. 메시지 전송 쓰레드
			Receiver rec = new Receiver(socket);

			// 3. 메시지 수신 쓰레드
			Sender sen = new Sender(socket);

			// 쓰레드 시작
			rec.start();
			sen.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
