package chap05.ex08.polyField;

public class Ice extends Spell {

	@Override
	public String casting() {
		return "냉기 "+super.casting();
	}

}
