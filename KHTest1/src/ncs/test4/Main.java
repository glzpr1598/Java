package ncs.test4;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class Main {

	public void fileOpen(String fileName) {

		try {
			// 스트림 연결
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			// 데이터 출력
			int data;
			while ((data = br.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
