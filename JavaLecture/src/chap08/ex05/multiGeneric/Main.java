package chap08.ex05.multiGeneric;

public class Main {

	public static void main(String[] args) {

		MultiBox<String, Integer> box = new MultiBox<String, Integer>();
		box.setKey("Kim");
		box.setValue(100);
		
		String name = box.getKey();
		int score = box.getValue();
		
		System.out.println(name + " : " + score);

	}

}
