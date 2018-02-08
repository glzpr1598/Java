package chap10.ex10.exProdCons;

public class CommonData {

	private String data;

	public synchronized void getData() {
		// 데이터가 있으면 데이터를 가져온다.
		if (data != null) {
			System.out.println("가져온 데이터 : " + data);
			data = null;
		}
		// 생산자를 깨운다.
		notify();
		// 기다린다.
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void setData(String data) {
		// 데이터가 없으면 데이터를 넣는다.
		if (this.data == null) {
			System.out.println("넣은 데이터 : " + data);
			this.data = data;
		}
		// 소비자를 깨운다.
		notify();
		// 기다린다.
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
