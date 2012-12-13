package kr.mentalcare.project.model;

public class Evaluator {
	int sn;
	String name;
	String address;
	String phone;
	Double cost_per_day;

	Double cost_average;
	Double cost_deviation;
	Integer expert_part;
	Integer detail_part;
	String expert_part_name;
	String detail_part_name;
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
	public Double getCost_per_day() {
		return cost_per_day;
	}
	public void setCost_per_day(Double cost_per_day) {
		this.cost_per_day = cost_per_day;
	}
	public Double getCost_average() {
		return cost_average;
	}
	public void setCost_average(Double cost_average) {
		this.cost_average = cost_average;
	}
	public Double getCost_deviation() {
		return cost_deviation;
	}
	public void setCost_deviation(Double cost_deviation) {
		this.cost_deviation = cost_deviation;
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
	public String getExpert_part_name() {
		return expert_part_name;
	}
	public void setExpert_part_name(String expert_part_name) {
		this.expert_part_name = expert_part_name;
	}
	public String getDetail_part_name() {
		return detail_part_name;
	}
	public void setDetail_part_name(String detail_part_name) {
		this.detail_part_name = detail_part_name;
	}
	
	
	
}
