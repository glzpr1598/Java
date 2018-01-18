package chap05.ex08.polyField;

public class Mage {

	public static void main(String[] args) {

		// 1. 다형성을 사용하지 않고
		Fire f = new Fire();
		System.out.println(f.casting());
		Ice i = new Ice();
		System.out.println(i.casting());
		Light l = new Light();
		System.out.println(l.casting());
		
		System.out.println();
		
		// 2. 다형성을 사용하여
		Spell spell = new Fire();
		System.out.println(spell.casting());
		spell = new Ice();
		System.out.println(spell.casting());
		spell = new Light();
		System.out.println(spell.casting());

	}

}
