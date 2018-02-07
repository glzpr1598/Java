package chap12.ex07.fileTrans;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

// 파일을 읽어서 네트워크로 전송
public class SenderMain {

	public static void main(String[] args) throws Exception {

		// 경로 설정
		String path = "C:/img/image01.gif";
		File file = new File(path);
		
		// 입력 스트림 준비
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		// 소켓, 출력 스트림 준비
		Socket socket = new Socket("192.168.30.28", 7777);
		// 파일명과 파일을 전송하기 위해 DataOutputStream 이용
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		// 파일명 전송
		String[] sp = path.split("/");
		dos.writeUTF(sp[sp.length - 1]);
		dos.flush();
		
		// 읽기, 쓰기
		byte[] arr = new byte[1024];
		while (bis.read(arr) != -1) {
			dos.write(arr);
		}
		dos.flush();
		System.out.println("전송 완료");
		System.out.println("전송 파일 사이즈 : " + (file.length() / 1024) + "KB");
		
		// 자원 반납
		fis.close();
		bis.close();
		socket.close();
		dos.close();
		
	}

}
