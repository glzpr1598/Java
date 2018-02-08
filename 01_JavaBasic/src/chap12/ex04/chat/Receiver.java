package chap12.ex04.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver extends Thread {
	
	private Socket socket;
	InputStream is = null;
	InputStreamReader isr = null;

	public Receiver(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			
			// 스트림 준비
			is = socket.getInputStream();
			isr = new InputStreamReader(is, "UTF-8");

			while (is != null) {
				// 메시지 읽기
				char[] arr = new char[100];
				isr.read(arr);
				
				// 메시지 출력
				String str = new String(arr);
				System.out.println("상대 > " + str);
			}
						
			// 자원 반납
			is.close();
			isr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
