package chap11.ex12.objStream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

// Object를 dat 파일에 쓰기
public class ObjOutput {

	public static void main(String[] args) throws Exception {
		
		// 파일 경로 설정
		String path = "C:/img/obj.dat";
		
		// 스트림 연결
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 쓸 데이터 준비
		HashMap<String, Integer> map = new HashMap<>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		
		int[] arr = {10, 20, 30, 40, 50};
		
		// 데이터 쓰기
		oos.writeObject(map);
		oos.writeObject(arr);
		oos.writeObject(new Sample());
		oos.writeUTF("문자열"); // 문자열은 writeUTF
		
		// 스트림 닫기
		oos.flush();
		fos.close();
		oos.close();

	}

}
