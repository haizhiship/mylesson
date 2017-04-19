package ch7.cglib;

public class Task {

	public String execute() {
		String message = "-------------test()-------------";
		System.out.println(message);
		return message;
	}

	public void endTask() {
		System.out.println("end task");
	}
}
