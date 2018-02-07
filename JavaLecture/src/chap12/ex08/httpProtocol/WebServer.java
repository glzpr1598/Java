package chap12.ex08.httpProtocol;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// http 프로토콜로 입력 받기
// 크롬에서 IP:port 입력
// 192.168.30.36:8085
public class WebServer {

	public static void main(String[] args) throws Exception {
		
		// thread pool 생성
		ExecutorService pool = Executors.newFixedThreadPool(4);
		
		// 서버소켓 생성
		ServerSocket serverSocket = new ServerSocket(8085);
		
		while (true) {
			System.out.println("요청 대기");
			Socket socket = serverSocket.accept();
			System.out.println("요청 수락");
			// 스레드가 할 일(Runnable : 반환값 X / Callable : 반환값 O)
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try {
						// http 프로토콜로 데이터 수신
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						byte[] byteArr = new byte[65560];
						String str = null;
						while (dis.read(byteArr) != -1) {
							str = new String(byteArr);
							System.out.println(str);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			// submit : 실패한 스레드 재사용 / execute : 실패한 스레드 버림
			pool.submit(run);
		}
		
	}

}
