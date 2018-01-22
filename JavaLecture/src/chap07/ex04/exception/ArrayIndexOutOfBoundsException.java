package chap07.ex04.exception;

public class ArrayIndexOutOfBoundsException {

	public static void main(String[] args) {
		
		String[] strArr = new String[2];
		
		strArr[0] = "data1";
		strArr[1] = "data2";
		strArr[2] = "data3"; // ArrayIndexOutOfBoundsException
		
	}

}
