package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class MultiServerController implements Initializable {

	final static int GAME = 1; // 게임 중
	final static int READY = 0; // 준비 중
	static int state = READY;
	
	static ArrayList<Socket> socketList = new ArrayList<Socket>(); // 소켓 리스트
	static ArrayList<Question> questionList = new ArrayList<Question>(); // 문제 리스트
	static int curQuestion = 0; // 현재 문제 번호
	
	@FXML
	TextArea serverWin;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					// 1. 소켓 생성 + 특정 IP 개방
					ServerSocket server = new ServerSocket(5252);
					while (true) {
						if (socketList.size() < 4) { // 4명미만이면 접속을 허가 
							serverWin.appendText("요청 대기중\n");
							// 2. 연결 수락(소켓)
							Socket socket = server.accept();
							serverWin.appendText("요청 수락\n");
							// 3. 생성된 소켓 저장
							socketList.add(socket);
							// 4명이 되면 게임 중 상태
							if (socketList.size() == 4) {
								state = GAME;
							} 
							// 4. 서버 스레드 생성
							ServerManager manager = new ServerManager(socket);
							manager.start();
						}
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

		// 생성자
		public ServerManager(Socket socket) throws Exception {
			this.socket = socket;
			try {
				// 입력 스트림 생성
				in = new DataInputStream(socket.getInputStream());
				sendMsg("[" + socket.getPort() + "님이 입장하셨습니다.]");
				sendMsg("[현재 접속자 : " + socketList.size() + "명]");
				// 게임 중인 경우
				if (state == GAME) {
					startGame();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			int name = socket.getPort();
			try {
				while (in != null) {
					// 문자열을 입력받아 클라이언트에게 전송
					String text = in.readUTF();
					sendMsg(name + " > " + text);
					
					// 게임 코드
					if (state == GAME) {
						
					}
					
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally { // 클라이언트 강제 종료
				socketList.remove(3);
				sendMsg("[" + name + "님이 퇴장하셨습니다.]");
				sendMsg("[게임이 종료되었습니다.]");
				sendMsg("[현재 접속자 : " + socketList.size() + "명]");
				state = READY; // 게임 준비 상태
			}
		}


		// 전체 메시지 보내기
		public void sendMsg(String msg) {
			serverWin.appendText(msg + "\n");
			// 1. 모든 소켓(클라이언트)
			for (Socket s : MultiServerController.socketList) {
				try {
					// 2. 클라이언트별 출력 스트림
					out = new DataOutputStream(s.getOutputStream());
					out.writeUTF(msg + "\n"); // 3. 메시지 전송
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// 게임 시작
		public void startGame() {
			sendMsg("[게임을 시작합니다.]");
			initialize();	 // 문제 번호, 점수 초기화
			loadQuestion(); // 문제 가져오기
			sendQuestion(); // 문제 보내기
			sendScore(); // 점수 보내기
		}

		// 문제 번호, 점수 초기화
		public void initialize() {
			// 문제 번호 초기화
			curQuestion = 0;
			// 점수 초기화
			
		}
		
		// 파일로부터 문제 가져오기
		public void loadQuestion() {
			String path = "Question.txt"; // 문제 파일 경로
			try {
				Scanner scan = new Scanner(new FileInputStream(path));
				while (scan.hasNext()) {
	            	String q = scan.nextLine(); // 문제
	            	String a = scan.nextLine(); // 정답
	            	questionList.add(new Question(q, a)); // 문제 리스트에 추가
	            }
				Collections.shuffle(questionList); // 리스트 섞기
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		}
		
		// 문제 보내기
		public void sendQuestion() {
			Question question = questionList.get(curQuestion);
			sendMsg(question.q);
		}
		
		// 점수 보내기
		public void sendScore() {
			
		}
		
	}
	
}
