package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class MultiServerController implements Initializable{
	
	@FXML TextArea serverWin;
	
	static ArrayList<Socket> list = new ArrayList<Socket>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startServer();
	}
	
	public void startServer() {
		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					//1. 소켓 생성 + 특정 IP 개방
					ServerSocket server = new ServerSocket(5252);
					Socket socket;
					//2. 연결 수락(소켓)
					while(true) {
						serverWin.appendText("요청 대기중\n");

						serverWin.appendText("소켓 리스트갯수"+list.size()+"\n");

						socket = server.accept();
						//3. 생성된 소켓 저장
						list.add(socket);
						//4. 서버 스레드 생성
						ServerManager manager = new ServerManager(socket);
						manager.start();	
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		th.start();
	}
	
	class ServerManager extends Thread {

		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		public ServerManager(Socket socket) throws Exception {
			this.socket =socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				sendMsg(socket.getPort() + "님이 입장 했습니다. ");
				sendMsg("현재 접속자 : "+list.size()+"명");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			int name = socket.getPort();
			try {
				while(in!=null) {
					String text = in.readUTF();
					sendMsg(socket.getPort()+"> "+text);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.exit(0);
//				try {
//					sendMsg(name + "님이 퇴장했습니다. ");
//					sendMsg("프로그램을 종료합니다.");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
		}
		
		//전체메시지
		public void sendMsg(String msg) throws IOException {
			serverWin.appendText(msg+"\n");
			String arr[] = msg.split(">");
			String portNum1 = arr[0];
			//1. 소켓을 뽑아오고
			for(Socket s:MultiServerController.list) {
				//2. 스트림을 뽑아오고
				String portNum2 = Integer.toString(s.getPort());
				out = new DataOutputStream(s.getOutputStream());
				if(portNum2.equals(portNum1))
					out.writeUTF(msg+"\n");
				else
					out.writeUTF(msg+"\n");//3. 메시지 전송
					out.flush();
				
			}		
		}
	}
	
}
