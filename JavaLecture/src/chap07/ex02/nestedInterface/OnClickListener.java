package chap07.ex02.nestedInterface;

import chap07.ex02.nestedInterface.Element.EventListener;

public class OnClickListener implements EventListener {

	@Override
	public void call() {
		System.out.println("마우스 클릭");
	}

}
