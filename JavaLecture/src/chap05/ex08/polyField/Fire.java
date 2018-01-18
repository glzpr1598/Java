package chap05.ex08.polyField;

public class Fire extends Spell {
	
	@Override
	public String casting() {
		return "화염 "+super.casting();
	}

}
