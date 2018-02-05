package chap12.ex04.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {

	private Socket socket;
	OutputStream os = null;
	OutputStreamWriter osw = null;
	Scanner sc = null;

	public Sender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		String str;

		try {

			// 스트림 준비
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os, "UTF-8");
			
			while (os != null) { // 스트림이 반납될 때까지(여기서는 true와 같음)
				// 메시지 입력
				sc = new Scanner(System.in);
				str = sc.nextLine();
				// 메시지 전송
				osw.write(str);
				osw.flush();
			}
			
		} catch (Exception e) {
			try {
				os.close();
				osw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

}
