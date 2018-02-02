package chap11.ex12.objStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

// dat 파일에서 Object 읽기
public class ObjInput {

	public static void main(String[] args) throws Exception {
		
		// 파일 경로 설정
		String path = "C:/img/obj.dat";
		
		// 스트림 연결
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream oos = new ObjectInputStream(fis);
		
		// 데이터 읽기
		HashMap<String, Integer> map = (HashMap<String, Integer>) oos.readObject();
		int[] arr = (int[]) oos.readObject();
		Sample sample = (Sample) oos.readObject();
		String str = oos.readUTF();
		
		// 데이터 출력
		System.out.println(map.get("One"));
		System.out.println(map.get("Two"));
		System.out.println(map.get("Three"));
		
		for (int temp : arr) {
			System.out.println(temp);
		}
		
		System.out.println(sample.num);
		System.out.println(sample.str);
		System.out.println(sample.method());
		
		System.out.println(str);
		
		
		// 스트림 닫기
		fis.close();
		oos.close();

	}

}
