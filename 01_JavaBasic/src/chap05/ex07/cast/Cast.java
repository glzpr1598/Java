package chap05.ex07.cast;

public class Cast {

	public static void main(String[] args) {
		
		Mammal mam = null;
		
		mam = new Dog(); // promotion(묵시적)
		mam.birth();
		mam.eat();
		//mam.bark(); // 포유류로 선언되면서 개의 고유 특성을 잃게 된다.
		
		// 개의 고유 특성을 찾기 위해서는 개의 형태로 변환해야한다.(명시적 형변환)
		// 방법 1
		Dog dog = (Dog) mam; // casting
		dog.bark();
		
		// 방법 2
		((Dog)mam).bark();
		
		// 객체 원형이 무엇인지 확인하는 방법
		if (mam instanceof Dog) {
			dog = (Dog) mam;
		} else {
			System.out.println("객체 원형이 일치하지 않습니다.");
		}

	}

}
