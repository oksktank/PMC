package kr.mentalcare.project.model;

import java.util.List;

public class DeveloperTeam {
	int dt_number;
	Integer cost;
	String dt_name;
	Integer r_num;
	
	List<Developer> devList;
	
	public Integer getR_num() {
		return r_num;
	}
	public void setR_num(Integer r_num) {
		this.r_num = r_num;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getDt_name() {
		return dt_name;
	}
	public void setDt_name(String dt_name) {
		this.dt_name = dt_name;
	}
	
	public int getDt_number() {
		return dt_number;
	}
	public void setDt_number(int dt_number) {
		this.dt_number = dt_number;
	}
	public Integer getCost() {
		return cost;
	}
	public List<Developer> getDevList() {
		return devList;
	}
	public void setDevList(List<Developer> devList) {
		this.devList = devList;
	}
	
	
}
