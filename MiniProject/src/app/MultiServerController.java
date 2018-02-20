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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class MultiServerController implements Initializable {

	static final int USERS = 2; // 게임 유저 수
	static final int ENDSCORE = 5; // 게임 종료 점수
	static final int GAME = 1; // 게임 중
	static final int READY = 0; // 준비 중
	static final int TIME_LIMIT = 10; // 제한 시간
	
	static int state = READY; // 현재 게임 상태
	static int INIT_TIME = 0; // 시간 초기화 플래그

	static ArrayList<Socket> socketList = new ArrayList<Socket>(); // 소켓 리스트
	static HashMap<Integer, Integer> scoreMap = new HashMap<>(); // 점수 리스트
	static ArrayList<Question> questionList = new ArrayList<Question>(); // 문제 리스트
	static int curQuestion = 0; // 현재 문제 번호

	@FXML
	TextArea serverWin;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Thread th = new Thread() {
			@Override
			public void run() {
				ServerSocket server;
				try {
					// 1. 소켓 생성 + 특정 IP 개방
					server = new ServerSocket(5252);
					while (true) {
						if (socketList.size() < USERS) { // 4명미만이면 접속을 허가
							serverWin.appendText("요청 대기중\n");
							// 2. 연결 수락(소켓)
							Socket socket = server.accept();
							serverWin.appendText("요청 수락\n");
							// 3. 생성된 소켓 저장, 점수 저장
							socketList.add(socket);
							scoreMap.put(socket.getPort(), 0);
							// 4명이 되면 게임 중 상태
							if (socketList.size() == USERS) {
								state = GAME;
							}
							// 4. 서버 스레드 생성
							ServerManager manager = new ServerManager(socket);
							manager.start();
						} else {
							Thread.sleep(1); // 없으면 게임 재시작이 안된다.. 빈 while문을 돌기 때문인 것으로 생각됨
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
				sendMsg("C[" + socket.getPort() + "님이 입장하셨습니다.]");
				sendMsg("C[현재 접속자 : " + socketList.size() + "명]");
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
					sendMsg("C" + name + " > " + text);

					// 게임 중이면 정답 확인
					if (state == GAME) {
						if (text.equals(questionList.get(curQuestion).a)) { // 정답인 경우
							sendMsg("C[정답입니다!]");
							// 점수 증가
							int score = scoreMap.get(name);
							scoreMap.put(name, ++score);
							sendScore(); // 점수 보내기
							if (score == ENDSCORE) { // 게임이 끝난 경우(점수 도달)
								sendMsg("C[우승자 : " + name + "]");
								state = READY;
								continue;
							}
							curQuestion++; // 문제번호 증가
							sendQuestion(); // 문제 보내기
						}
					}

				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally { // 클라이언트 강제 종료
				socketList.remove(socket); // 소켓 리스트에서 제거
				scoreMap.remove(socket.getPort()); // 점수 맵에서 제거
				sendMsg("C[" + name + "님이 퇴장하셨습니다.]");
				sendMsg("C[게임이 종료되었습니다.]");
				sendMsg("C[현재 접속자 : " + socketList.size() + "명]");
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
			sendMsg("C[게임을 시작합니다.]");
			Timer timer = new Timer();
			timer.start();
			initialize(); // 문제 번호, 점수 초기화
			sendScore(); // 점수 보내기
			loadQuestion(); // 문제 가져오기
			sendQuestion(); // 문제 보내기
		}

		// 문제 번호, 점수 초기화
		public void initialize() {
			// 문제 번호 초기화
			curQuestion = 0;
			// 점수 초기화
			Set<Integer> set = scoreMap.keySet();
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				int key = iter.next();
				scoreMap.put(key, 0); // 0으로 초기화
			}
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
				scan.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		// 문제 보내기
		public void sendQuestion() {
			try {
				INIT_TIME = 1;
				Question question = questionList.get(curQuestion);
				sendMsg("Q[영화] " + question.q);
			} catch (IndexOutOfBoundsException e) { // 문제 끝
				sendMsg("C[무승부]");
				state = READY;
			}
		}

		// 점수 보내기
		public void sendScore() {
			String msg = "S";
			Set<Integer> set = scoreMap.keySet();
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				int key = iter.next();
				msg += key + " : " + scoreMap.get(key) + "\n";
			}
			sendMsg(msg);
		}

	}

	public class Timer extends Thread {
			int time;
			DataOutputStream out;
			
			@Override
			public void run() {
				while (true) {
					if (state == GAME) {
						time = TIME_LIMIT;
						while (time > 0) {
							try {
								if (INIT_TIME == 1) { // 시간을 초기화해야하는 경우
									time = TIME_LIMIT;
									INIT_TIME = 0;
								}
								Thread.sleep(1000);
								time--;
								sendTime("T"+time);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						// 시간 초과, 다음 문제 출제
						curQuestion++;
						try {
							Question question = questionList.get(curQuestion);
							sendTime("Q[영화] " + question.q);
						} catch (IndexOutOfBoundsException e) { // 문제 끝
							sendTime("C[무승부]");
							state = READY;
						}
					} else {
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
			}

			public void sendTime(String msg) {
				serverWin.appendText(msg + "\n");
				// 1. 모든 소켓(클라이언트)
				for (Socket s : MultiServerController.socketList) {
						// 2. 클라이언트별 출력 스트림
						try {
							out = new DataOutputStream(s.getOutputStream());
							out.writeUTF(msg + "\n"); // 3. 메시지 전송
//							out.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			}
		
		}
	
}
