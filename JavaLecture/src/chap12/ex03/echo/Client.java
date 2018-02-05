package chap12.ex03.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {

		// 1. 소켓 생성
		Socket socket = new Socket();

		try {
			// 2. 접속 요청
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("소켓 연결 완료");

			// 3. IS, OS 준비
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			InputStreamReader isr = new InputStreamReader(is);
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");

			// 4. 데이터 전송
			osw.write("Hello Server!");
			osw.flush();
			System.out.println("전송 완료");

			// 5. 데이터 수신
			char[] charArr = new char[20];
			isr.read(charArr);
			String str = new String(charArr);
			System.out.println(str);
			
			// 6. 자원 반납
			is.close();
			os.close();
			isr.close();
			osw.close();
			
		} catch (IOException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			System.out.println("소켓 반납");
			socket.close();
		}

	}

}
