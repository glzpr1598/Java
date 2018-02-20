package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class MultiClientController implements Initializable {

	@FXML
	TextArea textAreaQuestion; // 문제 창
	@FXML
	TextArea textAreaChat; // 채팅 창
	@FXML
	TextArea textAreaScore; // 점수 창
	@FXML
	TextField textFieldInput; // 사용자 입력 창
	@FXML
	Label labelTime; // 남은 시간

	Socket socket = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					// 1. 소켓 생성 + 연결 요청
					socket = new Socket("127.0.0.1", 5252);
					// 2. 스레드 생성 및 실행
					ClientSender sender = new ClientSender(socket);
					ClientReceiver receiver = new ClientReceiver(socket);
					sender.start();
					receiver.start();

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("서버에 접속할 수 없습니다.");
				}
			}
		};
		th.start();
	}

	class ClientSender extends Thread {
		Socket socket;
		DataOutputStream out;

		// 생성자
		public ClientSender(Socket socket) {
			this.socket = socket;
			try {
				// 출력 스트림 생성
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (out != null) {
				textFieldInput.setOnKeyPressed((event) -> {
					// 엔터키를 입력하고 텍스트가 공백이 아니면
					if (event.getCode() == KeyCode.ENTER && !textFieldInput.getText().equals("")) {
						try {
							out.writeUTF(textFieldInput.getText()); // 텍스트 전송
							textFieldInput.clear();
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

		// 생성자
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				// 입력 스트림 생성
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (in != null) {
				try {
					String msg = in.readUTF(); // 입력받은 메시지
					if (msg.charAt(0) == 'C') { // 입력받은 메시지가 채팅창에 해당하는 경우
						msg = msg.substring(1); // 첫 글자 제거
						// " > " 을 포함하는 경우(시스템 메시지가 아닌 경우)
						if (msg.contains(" > ")) {
							String[] sub = msg.split(" > ");
							int port = Integer.parseInt(sub[0]);
							if (socket.getLocalPort() == port) // 내가 보낸 메시지인 경우
								textAreaChat.appendText("(나)"); // 앞에 "(나)"를 붙임
							textAreaChat.appendText(msg); // 메시지 출력
						}
						else { // 시스템 메시지인 경우 바로 출력
							textAreaChat.appendText(msg);
						}
					} else if (msg.charAt(0) == 'S') { // 입력받은 메시지가 점수일 경우
						msg = msg.substring(1); // 첫 글자 제거
						textAreaScore.setText(msg);
					} else if (msg.charAt(0) == 'Q') { // 입력받은 메시지가 문제일 경우
						msg = msg.substring(1); // 첫 글자 제거
						textAreaQuestion.setText(msg);
					} else if (msg.charAt(0) == 'T') { // 입력받은 메시지가 시간일 경우
						msg = msg.substring(1); // 첫 글자 제거
						labelTime.setText(msg);
					}else {
						textAreaChat.appendText("메시지 수신 에러");
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
