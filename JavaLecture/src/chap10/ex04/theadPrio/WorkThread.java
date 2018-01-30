package chap10.ex04.theadPrio;

public class WorkThread extends Thread {

	public WorkThread(String name) {
		setName(name); //스레드 이름 지정
	}
	
	@Override
	public void run() {		
		System.out.println(getName()+" 작업 시작");
		for(int i=0; i<=1000000;i++) {}
		System.out.println(getName()+" 작업 끝");
	}

}
