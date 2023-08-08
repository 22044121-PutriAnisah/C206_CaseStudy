public class User {
	private int userId;
	private static String role;
	private String name;
	private String email;
	private String password;
	private int phoneNum;
	
	public User(int userId, String role, String name, String email, String password, int phoneNum) {
		super();
		this.userId = userId;
		this.role = role;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public static String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	

}

