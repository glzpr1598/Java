package chap11.ex12.objStream;

import java.io.Serializable;

// 클래스를 IO하려면 Serializable 인터페이스를 구현해야한다.
public class Sample implements Serializable{
	
	int num = 0;
	String str = "Sample String";
	
	public String method() {
		return "Sample Method";
	}

}
