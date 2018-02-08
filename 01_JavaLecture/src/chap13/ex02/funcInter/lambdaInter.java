package chap13.ex02.funcInter;

@FunctionalInterface // 함수형 인터페이스 : 메서드를 하나만 가지고 있는 인터페이스
public interface lambdaInter {
	
	int operation(int a, int b);
	
	//void sendMsg(String msg);

}
