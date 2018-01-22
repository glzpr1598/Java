package chap07.ex03.nestedInterface2;

public class Element {
	
	EventListener listener;
	
	void regist(EventListener listener) {
		this.listener = listener;
	}
	
	void trigger() {
		listener.call();
	}

}
