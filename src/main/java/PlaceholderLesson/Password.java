package PlaceholderLesson;

public class Password {
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("【注入属性】注入属性password");
		this.password = password;
	}

}
