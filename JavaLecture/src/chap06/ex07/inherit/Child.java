package chap06.ex07.inherit;

import chap06.ex04.multiImplements.KeyEvent;
import chap06.ex04.multiImplements.MouseEvent;

public interface Child extends KeyEvent, MouseEvent {
	
	public void textField(String str);
	public void selectOne();
	public void checkOne();

}
