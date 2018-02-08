package chap12.ex01.ipAddr;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP {

	public static void main(String[] args) throws UnknownHostException {
		
		// 내 컴퓨터의 IP 가져오기
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress()); // 컴퓨터 IP
		System.out.println();
		
		// 특정 도메인으로 IP 얻기
		String domain = "tour.pcs21.net";
		addr = InetAddress.getByName(domain);
		System.out.println(addr.getHostAddress()); // 특정 컴퓨터 IP
		System.out.println();
		
		// 특정 도메인에 여러 IP가 있을 경우(대형 사이트는 서버 분산을 위해 여러 IP 사용)
		domain = "www.naver.com";
		InetAddress[] addrArr = InetAddress.getAllByName(domain);
		for (InetAddress temp : addrArr) {
			System.out.println(temp.getHostAddress());
		}

	}

}
