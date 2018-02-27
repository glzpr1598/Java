package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.*;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class MultiServerController implements Initializable{
	
	@FXML TextArea serverWin;
	
	static ArrayList<Socket> list = new ArrayList<Socket>();//소켓 배열
	static HashMap<Integer, Integer> score = new HashMap<Integer, Integer>();//각 클라이언트의 포트번호와 점수 배열
	static HashMap<Integer, String> iden = new HashMap<>(); // 포트번호, 닉네임

	private String answer ="";//현 문제 정답
	private boolean YN;//정답 유무 플래그
	boolean end;//종료여부 플래그
	static int t;//타이머시간
	
	public boolean isYN() {
		return YN;
	}

	public void setYN(boolean yN) {
		YN = yN;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startServer();
	}
	
	public void serverEnd() {
		Platform.exit();
		System.exit(0);
	}
	
	public void startServer() {
		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					//1. 소켓 생성 + 특정 IP 개방
					ServerSocket server = new ServerSocket(5555);
					Socket socket;
					//2. 연결 수락(소켓)
					while(true) {
						int mem = 4; //몇명이 모이면 시작하는지
						if (list.size() < mem) {
							serverWin.appendText("요청 대기중\n");
							serverWin.appendText("소켓 리스트갯수"+list.size()+"\n");
							socket = server.accept();
							//3. 생성된 소켓 저장
							list.add(socket);
							//4. 서버 스레드 생성
							ServerManager manager = new ServerManager(socket) ;
							score.put(socket.getPort(), 0);
							manager.start();	
							/*mem명의 클라이언트가 붙었을때 실행*/
							if(list.size()==mem) {
								Play play = new Play();
								play.start();
							}
						} else {
							Thread.sleep(1);
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
			this.socket =socket;		
			try {
				in = new DataInputStream(socket.getInputStream());
				String id = in.readUTF(); // 닉네임 입력받음
				String nickName = socket.getPort()+"_"+id;
				iden.put(socket.getPort(), nickName); // 닉네임 저장
				sendMsg(iden.get(socket.getPort())+" 님이 입장 했습니다. (현재 접속자 : "+list.size()+"명)");
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}

		@Override
		public void run() {		
			try {
				while(in!=null) {
					String text = in.readUTF();
					sendMsg(iden.get(socket.getPort())+"> "+text);
					/**answer와 입력값이 같을 경우(정답을 맞춘경우)*/
					if(text.equals(answer)) {
						sendMsg(iden.get(socket.getPort())+"님 정답!!");
						setYN(true);
						score.put(socket.getPort(), score.get(socket.getPort())+1);//정답을 맞춘 클라이언트의 스코어 1 증가
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					String name = iden.get(socket.getPort());
					list.remove(socket);
					score.remove(socket.getPort());
					iden.remove(socket.getPort());
					sendMsg(name+"님이 퇴장하셨습니다.");
					sendMsg("(현재 접속자 : "+list.size()+"명)");
					end = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//전체메시지
		public void sendMsg(String msg) throws IOException {

			for(Socket s:MultiServerController.list) {
				out = new DataOutputStream(s.getOutputStream());
				out.writeUTF(msg+"\n");//3. 메시지 전송
				out.flush();
			}		
		}
	}
	
	/////////////////////////////////////////////////////////////////////////
	/**게임을 진행하는 스레드*/
	class Play extends Thread {
		
		DataOutputStream out;
		   
	    private String category; //카테고리 항목
	    private QuizDataList qdList; //문제들 저장하는 array
	    private String winner;
	    //생성자  
	    public Play() {
	    	qdList = new QuizDataList();          
	    }  
	   
	 
	    
	    /**카테고리의 퀴즈데이터 불러오기*/
	    @Override
		public void run() {
	    	String[] categoryList =new String[]{"영화","음식","스포츠"};
	    
	    	try {
	    		sendQuiz("곧 게임이 시작됩니다.");
	    		Random random = new Random();
	    		int key =random.nextInt(3);    //메뉴를 입력받는다.           

	    		category = categoryList[key];
	    		sendQuiz("q>"+category+" 카테고리의 문제가 출제됩니다.");
	    		qdList.loadQuiz(key);
	    		//해당항목의 퀴즈파일을 로드후 Arraylist에 저장
	    		Thread.sleep(3000);
	    		startQuiz(); //퀴즈 시작

	    	} catch ( Exception e) {
	    		try {
					sendQuiz("오류발생!!");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    	}

	    }


		/**퀴즈 시작*/
	    private void startQuiz() {
	    	try {
	    		showResult();//먼저 초기 점수판 쇼
	    		sendQuiz("게임 시작!!");

	    		int i =0;//i는 문제 번호
	    		sendQuiz("q>총 문제수:"+qdList.size());
	    		
	    		setYN(false);//정답유무 초기화
	    		end=false;//종료여부 초기화
	    		for (QuizData q:qdList) {//퀴즈 리스트에서 하나씩 불러온다
	    			
	    			i++;//문제 번호 증가
	    			
	    			Set<Integer> ks = score.keySet();
	    			Iterator<Integer> keyIter = ks.iterator();
	    			while(keyIter.hasNext()) {
	    				int key = keyIter.next();
	    				int vlaue = score.get(key);
	    				if(vlaue==5){//각 클라이언트의 점수를 꺼내서 5인지 확인
	    					sendQuiz("게임끝!!");
	    					winner=iden.get(key);
	    					sendQuiz("우승자는 "+winner);
	    					end=true;//종료 플래그
	    				}
	    			}
		    		if(end) {break;}//종료 플래그시 종료
		    		/*문제와 정답을 받아온다*/
	    			String question = q.getQuestion();
	    			answer = q.getAnswer();

	    			sendQuiz("q>"+i+"번 문제 : " + question);//q>는 qiuizWin에 띄우기 위함
	    			
	    			/*-------------------------------------------------------*/
	    			t=60;//시간 설정
	    			Timer ti = new Timer();//타이머 생성
	    			java.util.Timer timer = new java.util.Timer();
					timer.scheduleAtFixedRate(ti.task, 0, 1000);//scheduleAtFixedRate(task,0,1000)=>딜레이:0, 간격1000밀리초로 task를 실행
					
	    			/*-------------------------------------------------------*/
	    			
	    			while(!isYN()&&t>-1&&!end){//정답 플래그시 반복문 종료, 타이머가 0이 됐을떄 종료, 누군가 나가서 end플래그시 종료
	    				sleep(1);
	    		
	    			}
	    			answer="";//정답값 초기화
	    			setYN(false);//정답 플래그 초기화
	    			timer.cancel();//타이머 정지
	    			showResult();//현 점수 쇼
	    			sleep(900);//타이머 창에 0을 1초가량 보여주기 위함
	
	    		}
	    		sendQuiz("t>TIMER");//타이머창 다시 TIMER로
	    		if(i==qdList.size()) {//문제가 모두 소진 됐을시
	    			sendQuiz("문제가 모두 소진되서 게임을 종료합니다.");
	    			sendQuiz("우승자가 없습니다.");
	    			sendQuiz("s>무승부");
	    		}else {
	    			if(winner==null){//누군가 나가서 종료했을시
	    				sendQuiz("인원이 나가서 게임을 종료합니다.");
	    				sendQuiz("다시 시작인원을 기다립니다.");
	    				sendQuiz("c>");//스코어창 초기화
	    			}
	    			else {//정상적으로 끝났을시
	    				qdList.clear(); //퀴즈데이터 초기화
	    				sendQuiz("게임을 종료합니다.");
	    				sendQuiz("s>우승자 : ");
	    				sendQuiz("s>"+winner);
	    			}

	    		}
	    		
	    		setScore();
	    		
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}

	    }//startQuiz()---------
	   
	    /**현재 스코어 쇼*/
	    public void showResult(){

	    	try {
	    		Set<Integer> ks = score.keySet();	// HashMap score 를 Set 으로 바꿔 Key 값만 뽑아왔다.
	    		Iterator<Integer> keyIter = ks.iterator();	// 받아온 Key 값을 iterator 로 쪼갰다.
	    		sendQuiz("c>"); //c>는 스코어판 초기화
	    		while(keyIter.hasNext()) {//각 클라이언트의 점수를 쇼 // hasNext() 현재 위치에서 다음 데이터가 있으면 true 없으면 false
	    			int key = keyIter.next(); // 다음 데이터를가져오는 메서드 next() -> 쪼개놓은 Key 값을 가져옴.
	    			String name = iden.get(key);	// ID를 담는다.
	    			int vlaue = score.get(key);		// 점수를 담는다.
	    			sendQuiz("s>"+name+" : "+vlaue);// s>는 스코어판에 출력
	    		}
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	        
	    }//showResult()---------
	    
	    /**sendQuiz *데이터를 각 클라이언트로 전송하는 메서드*/
		public void sendQuiz(String msg) throws IOException {
			//1. 소켓을 뽑아오고
			for(Socket s:MultiServerController.list) { //클라이언트들의 소켓이 담긴 list 를 s에 모두 담는다. 
				//2. 스트림을 뽑아오고
				out = new DataOutputStream(s.getOutputStream()); //소켓에서 직접 OutputStream 을 뽑아낸다.
				out.writeUTF(msg+"\n");	// 메세지를 출력한다.
			}		
		}
		/**스코어맵의 벨류 초기화하는 메서드*/
		public void setScore(){	

	    		Set<Integer> ks = score.keySet(); // Map(Key,Value) 을 Set(Key)으로 가져옴 (HashMap score) Key : 포트번호 / Value : 점수
	    		Iterator<Integer> keyIter = ks.iterator(); // iterator() 로 key 값을 쪼갬
	    		while(keyIter.hasNext()) { //각 클라이언트의 점수를 쇼	// hasNext() 현재 위치에서 다음에 데이터가 있으면 true 없으면 false
	    			int key = keyIter.next(); // 다음 데이터를 가져오는 메서드
	    			score.put(key, 0);	 //score(Key,Value) 의 Key 값을 채웠다.
	    		}
	   
	    }//setScore()---------
		
		/**타이머 테스크*/
		public class Timer {
			TimerTask task = new TimerTask() {//타이머 테스크 생성
				@Override
				public void run() {
					try {
						for(Socket s:MultiServerController.list) {
							out = new DataOutputStream(s.getOutputStream());
							out.writeUTF("t>"+t);
						}
						t--;
					}catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				};
		}//Timer
		
	}
	
}
