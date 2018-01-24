package chap08.ex09.genericInherit;

public class Main {

	public static void main(String[] args) {
		
		DetailInfo<String, Integer, String> info = new DetailInfo<>();
		
		info.setName("Kim");
		info.setAge(26);
		info.setHobby("soccer");
		
		System.out.println(info.getName());
		System.out.println(info.getAge());
		System.out.println(info.getHobby());

	}

}
