package kr.mentalcare.project.model;

public class ResultData {
	public ResultData(boolean result,Object data){
		this.result=result;
		this.data=data;
	}
	boolean result;
	Object data;
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
