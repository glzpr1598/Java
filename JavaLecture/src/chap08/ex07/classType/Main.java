package chap08.ex07.classType;

public class Main {

	public static void main(String[] args) {

		Info info = new Info();
		
		info.setEmp_no(1);
		info.setName("Kim");
		//...
		info.setHobby("soccer");
		
		Employee<Info> emp = new Employee<>();
		emp.setT(info);
		
	}

}
