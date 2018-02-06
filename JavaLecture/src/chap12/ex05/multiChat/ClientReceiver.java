package chap12.ex05.multiChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceiver extends Thread {
	
	Socket socket;
	DataInputStream in;
	
	public ClientReceiver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream()); // 소켓의 주스트림으로 보조스트림(DataInputStram) 정의
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (in != null) {
			try {
				System.out.println(in.readUTF()); // 입력받은 내용 출력
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
}
