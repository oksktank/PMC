package kr.mentalcare.project.model;

import java.util.List;

public class DeveloperTeam {
	int dt_number;
	int cost;
	String dt_name;
	List<Developer> devList;
	
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public List<Developer> getDevList() {
		return devList;
	}
	public void setDevList(List<Developer> devList) {
		this.devList = devList;
	}
	
	
}
