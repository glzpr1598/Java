package chap08.ex06.multiGenericEx;

public class Main {

	public static void main(String[] args) {
		
		Employee<Integer, String, Integer, Integer, Long, Float, Boolean, String> emp = new Employee<>();

		emp.setNum(1);
		emp.setName("Kim");
		//...
		emp.setHobby("soccer");
	}

}
