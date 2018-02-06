package ncs.test1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import ncs.test2.Book;

public class Main {

	public static void main(String[] args) {

		HashMap map = null;
		
		// 객체 생성과 맵에 객체 정보 저장 처리 코드는 생략
		
		Set<Book> keySet = map.keySet();
		Iterator<Book> keyIter = keySet.iterator();
		
		while (keyIter.hasNext()) {
			Book key = keyIter.next();
			System.out.println(key + " = " + map.get(key));
			// key는 Book 클래스의 toString() 메서드로 출력
			// value는 HashMap 클래스의 get() 메서드로 출력
		}
		
	}

}
