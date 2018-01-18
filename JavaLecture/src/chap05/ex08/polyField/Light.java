package chap05.ex08.polyField;

public class Light extends Spell {

	@Override
	public String casting() {
		return "번개 "+super.casting();
	}

}
