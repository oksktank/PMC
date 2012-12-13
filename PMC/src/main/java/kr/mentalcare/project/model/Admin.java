package kr.mentalcare.project.model;

public class Admin {
	int sn;
	String name;
	String address;
	String phone;
	public Admin(){
		
	}
	public Admin(String name, String address, String phone) {
		this.name=name;
		this.address=address;
		this.phone=phone;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
