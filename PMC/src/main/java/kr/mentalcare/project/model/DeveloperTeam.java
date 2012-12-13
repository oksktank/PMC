package kr.mentalcare.project.model;

public class DeveloperTeam {
	int dt_num;
	int cost;
	String dt_name;
	
	public String getDt_name() {
		return dt_name;
	}
	public void setDt_name(String dt_name) {
		this.dt_name = dt_name;
	}
	public int getDt_num() {
		return dt_num;
	}
	public void setDt_num(int dt_num) {
		this.dt_num = dt_num;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
