package chap07.ex02.nestedInterface;

public class Element {
	
	EventListener listener;
	
	void regist(EventListener listener) {
		this.listener = listener;
	}
	
	void trigger() {
		listener.call();
	}
	
	interface EventListener {
		void call();
	}

}
