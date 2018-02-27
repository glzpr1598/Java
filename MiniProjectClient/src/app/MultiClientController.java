package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class MultiClientController implements Initializable{
	
	@FXML TextArea clientWin;
	@FXML TextArea quizWin;
	@FXML TextArea scoreWin;
	@FXML TextField chatWin;
	@FXML TextField timerWin;
	
	Socket socket = null;	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startClient();
	}
	
	public void end() {
		Platform.exit();
		System.exit(0);
	}
	
	public void startClient() {
		Thread th = new Thread() {
			@Override
			public void run() {
				//1. 소켓 생성 + 연결 요청
				try {
					socket = new Socket(Info.ip, Info.port) ;			
					//2. 할일 하기 - 스레드 생성 및 실행
					ClientReceiver receiver = new ClientReceiver(socket);
					ClientSender sender = new ClientSender(socket);
					receiver.start();
					Thread.sleep(1);
					sender.start();
					
				} catch (Exception e) {
					e.printStackTrace();
					try {
						socket.close();//문제 발생시 소켓 종료
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		};
		th.start();
	}
	
	// 생성자
	class ClientSender extends Thread {
		Socket socket;
		DataOutputStream out;	

		public ClientSender(Socket socket) {
			this.socket = socket;		
			try {
				out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF(Info.nickName); // 닉네임 전송
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		@Override
		public void run() {		

			while(out != null) {
				chatWin.setOnKeyPressed((event) -> {
					if (event.getCode() == KeyCode.ENTER) {//엔터로 입력했을때
						try {	
							if(!chatWin.getText().equals("")) {
							out.writeUTF(chatWin.getText());//입력 내용을 전송
							}else {}
							chatWin.clear();
						} catch (Exception e) {				
							e.printStackTrace();
						}
					}
				});
			}

		}
	}
	
	class ClientReceiver extends Thread {
		
		Socket socket;
		DataInputStream in;
		
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while(in != null) {
				try {
					String msg = in.readUTF();
					String arr[] = msg.split(">");
					String portNum1 = arr[0];
					if(portNum1.equals("q")) {
						msg="";
						for(int i=1;i<arr.length;i++) {
							msg += arr[i];
						}
						quizWin.appendText(msg);//받아온 내용을  문제창에 출력
					}else if(portNum1.equals("s")){
						msg="";
						for(int i=1;i<arr.length;i++) {
							msg += arr[i];
						}
						scoreWin.appendText(msg);//받아온 내용을  스코어창에 출력
					}else if(portNum1.equals("c")){
						scoreWin.clear();//스코어창 초기화
					}else if(portNum1.equals("t")){
						msg="";
						for(int i=1;i<arr.length;i++) {
							msg += arr[i];
						}
						timerWin.setText(msg);//받아온 내용을  타이머 창에 출력
					}else {
						clientWin.appendText(msg);//받아온 내용을  채팅창에 출력
					}
				} catch (IOException e) {
					e.printStackTrace();
					break;//프로그램을 멈춘다.
				}
			}
		}	

	}

	
}
