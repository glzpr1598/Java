package chap08.ex06.multiGenericEx;

public class Employee<T1, T2, T3, T4, T5, T6, T7, T8> {
	
	private T1 num;
	private T2 name;
	private T3 age;
	private T4 salary;
	private T5 money;
	private T6 bonus;
	private T7 married;
	private T8 hobby;
	
	public T1 getNum() {
		return num;
	}
	public void setNum(T1 num) {
		this.num = num;
	}
	public T2 getName() {
		return name;
	}
	public void setName(T2 name) {
		this.name = name;
	}
	public T3 getAge() {
		return age;
	}
	public void setAge(T3 age) {
		this.age = age;
	}
	public T4 getPay() {
		return salary;
	}
	public void setPay(T4 pay) {
		this.salary = pay;
	}
	public T5 getMoney() {
		return money;
	}
	public void setMoney(T5 money) {
		this.money = money;
	}
	public T6 getBonus() {
		return bonus;
	}
	public void setBonus(T6 bonus) {
		this.bonus = bonus;
	}
	public T7 getMarried() {
		return married;
	}
	public void setMarried(T7 married) {
		this.married = married;
	}
	public T8 getHobby() {
		return hobby;
	}
	public void setHobby(T8 hobby) {
		this.hobby = hobby;
	}
	
}
