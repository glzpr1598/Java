package chap12.ex06.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {
	
	public static void main(String[] args) throws Exception {

		DatagramSocket socket = new DatagramSocket(5001);
		DatagramPacket packet = new DatagramPacket(new byte[100], 100);
		
		Thread th = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						socket.receive(packet);
						System.out.println("데이터 수신");
						byte[] byteArr = packet.getData();
						String msg = new String(byteArr);
						System.out.println(msg);
					} catch (IOException e) {
						e.printStackTrace();
						break;
					}
					
				}
			}
		};
		
		th.setDaemon(true);
		th.start();
		Thread.sleep(5000);
		socket.close();
		
	}

}
