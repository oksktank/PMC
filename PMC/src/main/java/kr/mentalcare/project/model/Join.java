package kr.mentalcare.project.model;

public class Join {
	Integer role;
	String name;
	String username;
	String password;
	String phone;
	String address;
	Integer expert_part;
	Integer detail_part;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getExpert_part() {
		return expert_part;
	}
	public void setExpert_part(Integer expert_part) {
		this.expert_part = expert_part;
	}
	public Integer getDetail_part() {
		return detail_part;
	}
	public void setDetail_part(Integer detail_part) {
		this.detail_part = detail_part;
	}
	
}
