package chap12.ex07.fileTrans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 파일을 전송 받아서 쓰기
public class ReceiverMain {

	public static void main(String[] args) throws Exception {

		// 소켓 준비
		ServerSocket serverSocket = new ServerSocket(7777);
		
		// 요청 대기
		while (true) {
			System.out.println("요청 대기");
			Socket socket = serverSocket.accept();
			System.out.println("요청 수락");
			// 동시에 여러 요청을 받을 수 있도록 스레드 사용
			Thread thread = new Thread() {
				@Override
				public void run() {
					try {
						// 파일 위치 지정
						String path = "C:/download/";
						File dir = new File(path);
						if (!dir.exists()) {
							System.out.println("폴더 생성");
							dir.mkdirs();
						}

						// 읽기, 쓰기
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String fileName = dis.readUTF();
						FileOutputStream fos = new FileOutputStream(path+fileName);
						BufferedOutputStream bos = new BufferedOutputStream(fos);
						int data; // byte 배열로 받으면 파일 깨짐
						while ((data = dis.read()) != -1) {
							bos.write(data);
						}
						bos.flush();
						System.out.println("다운로드 완료");
						
						// 자원 반납
						dis.close();
						fos.close();
						bos.close();
						socket.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			thread.start();
		}
		
	}

}
