package chap08.ex09.genericInherit;

public class BasicInfo<N, A> {
	
	private N name;
	private A age;
	
	public N getName() {
		return name;
	}
	public void setName(N name) {
		this.name = name;
	}
	public A getAge() {
		return age;
	}
	public void setAge(A age) {
		this.age = age;
	}

}
