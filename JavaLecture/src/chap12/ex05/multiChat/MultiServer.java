package chap12.ex05.multiChat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {

	static ArrayList<Socket> arrList = new ArrayList<>();

	public static void main(String[] args) {
		try {
			// 서버소켓 생성, 특정 IP 개방
			ServerSocket serverSocket = new ServerSocket(5252);
			Socket socket;

			while (true) {
				// 연결 수락(소켓 반환)
				System.out.println("요청 대기 중");
				socket = serverSocket.accept();
				System.out.println("요청 수락");

				// 생성된 소켓 저장
				arrList.add(socket);

				// 서버 스레드 생성
				ServerManager manager = new ServerManager(socket);
				manager.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
