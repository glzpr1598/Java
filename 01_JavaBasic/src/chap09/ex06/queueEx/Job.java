package chap09.ex06.queueEx;

public class Job {

	private String command;
	private String to;
	
	public Job(String command, String to) {
		this.command = command;
		this.to= to;
	}

	// Getter
	public String getCommand() {
		return command;
	}
	public String getTo() {
		return to;
	}

}
