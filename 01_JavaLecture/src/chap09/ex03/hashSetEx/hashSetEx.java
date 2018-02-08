package chap09.ex03.hashSetEx;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class hashSetEx {
	// Set은 데이터 중복을 허용하지 않음. 순서가 없음.
	public static void main(String[] args) {
		
		// Set 선언
		HashSet<String> set1 = new HashSet<String>();
		Set<Member> set2 = new HashSet<Member>();

		// 데이터 추가(add)
		set1.add("JAVA");
		set1.add("ORACLE");
		set1.add("FRONT");
		set1.add("JSP");
		set1.add("JAVA"); // 중복 데이터는 추가되지 않음. false 반환
		
		set2.add(new Member());
		set2.add(new Member());
		set2.add(new Member()); // 서로 다른 객체이기 때문에 3개 모두 추가됨.
		
		// 데이터 개수 확인(size)
		System.out.println(set1.size()); // 4
		System.out.println(set2.size()); // 3
		
		// 데이터 가져오기 : Set 덩어리 -> 쪼개서 Iterator 형태로 변환 -> Iterator를 통해 데이터를 가져옴
		System.out.println("데이터 출력");
		Iterator<String> iter = set1.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next()); // 데이터 추가 순서대로 출력되지 않음.
		}
		
		// 데이터 삭제(remove)
		set1.remove("JAVA");
		
		// 향상된 for문을 사용해서 데이터를 가져올 수도 있음.
		System.out.println("데이터 출력");
		for (String temp : set1) {
			System.out.println(temp);
		}
		
		// 데이터 초기화(clear, isEmpty)
		if (!set1.isEmpty()) {
			System.out.println("데이터 초기화");
			set1.clear();
		}
		
	}

}

class Member {}
