package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class MultiClientController implements Initializable {

	@FXML
	TextArea clientWin;
	@FXML
	TextField chatWin;

	Socket socket = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startClient();
	}

	public void startClient() {
		Thread th = new Thread() {
			@Override
			public void run() {
				// 1. 소켓 생성 + 연결 요청
				try {
					System.out.println(MultiServerController.list.size());
					socket = new Socket("127.0.0.1", 5252);
					// 2. 할일 하기 - 스레드 생성 및 실행
					clientWin.appendText("연결 수락\n");
					ClientSender sender = new ClientSender(socket);
					ClientReceiver receiver = new ClientReceiver(socket);
					sender.start();
					receiver.start();

				} catch (Exception e) {
					e.printStackTrace();
					try {
						socket.close();// 문제 발생시 소켓 종료
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		};
		th.start();
	}

	class ClientSender extends Thread {
		Socket socket;
		DataOutputStream out;

		public ClientSender(Socket socket) {
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			while (out != null) {
				chatWin.setOnKeyPressed((event) -> {
					if (event.getCode() == KeyCode.ENTER) {
						try {
							if (!chatWin.getText().equals("")) {
								out.writeUTF(chatWin.getText());// 입력 내용을 전송
							} else {
							}
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
			while (in != null) {
				try {
					clientWin.appendText(in.readUTF());// 받아온 내용을 출력
				} catch (IOException e) {
					e.printStackTrace();
					break;// 프로그램을 멈춘다.
				}
			}
		}

	}

}
