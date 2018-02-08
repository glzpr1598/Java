package chap08.ex09.genericInherit;

public class DetailInfo<N, A, H> extends BasicInfo<N, A> {
	
	private H hobby;

	public H getHobby() {
		return hobby;
	}

	public void setHobby(H hobby) {
		this.hobby = hobby;
	}

}
