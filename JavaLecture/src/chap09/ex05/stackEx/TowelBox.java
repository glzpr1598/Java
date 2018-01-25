package chap09.ex05.stackEx;

import java.util.Stack;

public class TowelBox {

	public static void main(String[] args) {
		
		// Stack : LIFO(Last In First Out)
		Stack<Towel> stack = new Stack<Towel>();
		
		// 데이터 넣기(push)
		stack.push(new Towel("red"));
		stack.push(new Towel("orange"));
		stack.push(new Towel("yellow"));
		stack.push(new Towel("green"));
		stack.push(new Towel("blue"));
		stack.push(new Towel("navy"));
		stack.push(new Towel("pupple"));
		
		// 데이터 확인(peek) : 데이터를 꺼내지 않고 확인만 함
		System.out.println("peek : " + stack.peek().getColor());
		
		// 데이터 꺼내기(pop)
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().getColor() + " 수건 꺼냄 : " + stack.size() + "장 남음"); // 나중에 넣은 pupple부터 꺼냄
		}
				
	}

}
