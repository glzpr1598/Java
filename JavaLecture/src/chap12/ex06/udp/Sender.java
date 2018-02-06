package chap12.ex06.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

// UDP 통신
public class Sender {

	public static void main(String[] args) {

		// DatagramSocket 생성
		try (DatagramSocket socket = new DatagramSocket();) { // try with resoures -> 자원이 자동 반납됨.
			System.out.println("전송 시작");
			for (int i = 1; i <= 3; i++) {
				// 보낼 메시지 준비
				String msg = "data-" + i;
				byte[] byteArr = msg.getBytes();
				// 보낼 메시지를 DatagramPacket에 담음
				DatagramPacket packet = new DatagramPacket(byteArr, byteArr.length, new InetSocketAddress("localhost", 5001));
				// socket을 통해 packet의 내용을 전송
				socket.send(packet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
