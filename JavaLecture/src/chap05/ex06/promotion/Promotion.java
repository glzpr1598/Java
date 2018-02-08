package chap05.ex06.promotion;

// promotion : 묵시적 형변환
// casting : 명시적 형변환

/*
            Vertebrate : 척추동물
           /              \
        Bird        Mammal : 포유류
      /       \         /    \
Chicken Duck  Dog Cat
   
 */

class Vertebrate {
	
}

class Bird extends Vertebrate {
	
}

class Mammal extends Vertebrate {
	
}

class Chicken extends Bird {
	
}

class Duck extends Bird {
	
}

class Dog extends Mammal {
	
}

class Cat extends Mammal {
	
}


public class Promotion {
	
	static Vertebrate vert; // main 메서드 밖에 선언된 것은 다이어그램에서 실선으로 표시

	public static void main(String[] args) {
		// 척추 동물에는 닭, 오리, 개, 고양이 모두 들어간다.(묵시적 형변환)
		vert = new Chicken();
		vert = new Duck();
		vert = new Dog();
		vert = new Cat();

	}

}
