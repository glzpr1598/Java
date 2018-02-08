package chap11.ex11.dataStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

// 데이터 스트림 이용하여 파일 쓰기
public class DataOutput {

	public static void main(String[] args) throws Exception {
		
		// 파일 경로 지정
		String path = "C:/img/data.dat";
		
		// 스트림 연결
		FileOutputStream fos = new FileOutputStream(path);
		DataOutputStream dos = new DataOutputStream(fos);
		
		// 데이터 쓰기
		dos.writeUTF("Kim"); // 데이터 스트림에서 String이 아닌 UTF
		dos.writeInt(100);
		dos.writeBoolean(true);
		
		// 스트림 닫기
		fos.flush();
		dos.flush();
		fos.close();
		dos.close();

	}

}
