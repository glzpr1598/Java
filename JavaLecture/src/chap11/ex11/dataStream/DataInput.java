package chap11.ex11.dataStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

// 데이터 스트림 이용하여 파일 읽기
public class DataInput {

	public static void main(String[] args) throws Exception {
		
		// 파일 경로 설정
		String path = "C:/img/data.dat";
		
		// 스트림 연결
		FileInputStream fis = new FileInputStream(path);
		DataInputStream dis = new DataInputStream(fis);
		
		// 데이터 가져오기
		String str = dis.readUTF();
		int num = dis.readInt();
		boolean bool = dis.readBoolean();
		
		// 데이터 출력
		System.out.println(str);
		System.out.println(num);
		System.out.println(bool);
		
		// 스트림 닫기
		fis.close();
		dis.close();

	}

}
