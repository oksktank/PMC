package kr.mentalcare.project.model;

public class UserInfo {
	public static final int ROLE_DEVELOPER=1;
	public static final int ROLE_EVALUATOR=2;
	public static final int ROLE_ADMIN=3;
	int id;
	String username;
	String password;
	int role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}