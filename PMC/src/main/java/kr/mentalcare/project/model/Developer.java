package kr.mentalcare.project.model;

public class Developer {
	int sn;
	String name;
	String address;
	String phone;
	double cost_per_day;
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
	public double getCost_per_day() {
		return cost_per_day;
	}
	public void setCost_per_day(double cost_per_day) {
		this.cost_per_day = cost_per_day;
	}
	public double getCost_average() {
		return cost_average;
	}
	public void setCost_average(double cost_average) {
		this.cost_average = cost_average;
	}
	public double getCost_deviation() {
		return cost_deviation;
	}
	public void setCost_deviation(double cost_deviation) {
		this.cost_deviation = cost_deviation;
	}
	public int getExpert_part() {
		return expert_part;
	}
	public void setExpert_part(int expert_part) {
		this.expert_part = expert_part;
	}
	public int getDetail_part() {
		return detail_part;
	}
	public void setDetail_part(int detail_part) {
		this.detail_part = detail_part;
	}
	double cost_average;
	double cost_deviation;
	int expert_part;
	int detail_part;
}
