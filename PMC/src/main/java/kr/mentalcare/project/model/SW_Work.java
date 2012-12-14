package kr.mentalcare.project.model;

public class SW_Work {
	int num;
	String file_name;
	Integer cost;
	Integer start_period;
	Integer end_period;
	Integer admin_num;
	Integer dt_num;
	String w_name;
	String description;
	Integer expert_part;
	Integer detail_part;
	String expert_part_name;
	String detail_part_name;
	String result_file_name;
	Integer r_num;
	Integer grade;
	long avgGrade;
	
	
	public long getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(long avgGrade) {
		this.avgGrade = avgGrade;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getR_num() {
		return r_num;
	}
	public void setR_num(Integer r_num) {
		this.r_num = r_num;
	}
	public String getResult_file_name() {
		return result_file_name;
	}
	public void setResult_file_name(String result_file_name) {
		this.result_file_name = result_file_name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getStart_period() {
		return start_period;
	}
	public void setStart_period(Integer start_period) {
		this.start_period = start_period;
	}
	public Integer getEnd_period() {
		return end_period;
	}
	public void setEnd_period(Integer end_period) {
		this.end_period = end_period;
	}
	public Integer getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(Integer admin_num) {
		this.admin_num = admin_num;
	}
	public Integer getDt_num() {
		return dt_num;
	}
	public void setDt_num(Integer dt_num) {
		this.dt_num = dt_num;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
