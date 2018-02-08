package chap12.ex05.multiChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSender extends Thread {
	
	Socket socket;
	DataOutputStream out;
	
	public ClientSender(Socket socket) {
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		while (out != null) {
			try {
//				System.out.print("당신 > ");
				Scanner sc = new Scanner(System.in);
				out.writeUTF(sc.nextLine()); // 입력 내용 전송
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
