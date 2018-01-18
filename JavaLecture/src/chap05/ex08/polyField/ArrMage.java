package chap05.ex08.polyField;

public class ArrMage {
	
	public static void main(String[] args) {
		
		Spell[] spellArr = new Spell[3];
		spellArr[0] = new Fire();
		spellArr[1] = new Ice();
		spellArr[2] = new Light();
		
		for (Spell temp : spellArr) {
			System.out.println(temp.casting());
		}
		
	}

}
