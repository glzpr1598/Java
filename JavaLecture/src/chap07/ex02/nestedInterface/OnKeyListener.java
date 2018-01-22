package chap07.ex02.nestedInterface;

import chap07.ex02.nestedInterface.Element.EventListener;

public class OnKeyListener implements EventListener {

	@Override
	public void call() {
		System.out.println("키보드 입력");
	}

}
