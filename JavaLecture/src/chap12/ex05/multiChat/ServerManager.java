package chap12.ex05.multiChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerManager extends Thread {

	Socket socket;
	DataInputStream in;
	DataOutputStream out;

	public ServerManager(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
			sendMsg(socket.getPort() + "님이 입장하셨습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {
			while (in != null) {
				sendMsg(socket.getPort() + " > " + in.readUTF());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void sendMsg(String msg) throws IOException {
		System.out.println(msg);

		// 모든 클라이언트에게 메시지 전송
		for (Socket temp : MultiServer.arrList) {
			out = new DataOutputStream(temp.getOutputStream());
			out.writeUTF(msg);
			out.flush();
		}
	}

}
