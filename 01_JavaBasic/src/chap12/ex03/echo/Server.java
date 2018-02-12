package chap12.ex03.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// Echo server
// 소켓안에 있는 InputStream, OutputStream으로 통신
public class Server {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;

		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 2. IP 개방
			serverSocket.bind(new InetSocketAddress("localhost", 5001));

			// 3. 요청 대기
			while (true) {
				System.out.println("요청 대기 중");

				// 4. 접속 요청 수락
				Socket socket = serverSocket.accept(); // 요청이 올 때까지 기다림.
				System.out.println("요청 허용");

				// 5. InputSteam과 OutputStream 준비
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");

				// 6. IS와 OS로 데이터 주고받기
				char[] charArr = new char[20];
				isr.read(charArr);
				String str = new String(charArr);
				System.out.println(str);
				osw.write(str);
				osw.flush();
				System.out.println("전송 완료");

				// 7. 자원 반납
				is.close();
				os.close();
				isr.close();
				osw.close();

			}

		} catch (IOException e) {
			System.out.println("서버 종료");
			serverSocket.close();
		}

	}

}
