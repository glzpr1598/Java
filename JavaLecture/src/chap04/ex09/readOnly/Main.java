package chap04.ex09.readOnly;

public class Main {

	public static void main(String[] args) {
		
		Person person = new Person("Korea", "Kim");
		
		// final 변수는 값을 변경할 수 없다!
//		person.nation = "USA";
//		person.name = "Lee";
		
		System.out.println(person.nation);
		System.out.println(person.name);
		System.out.println(Person.ssn);

	}

}
