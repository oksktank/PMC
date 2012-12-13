package kr.mentalcare.project.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import kr.mentalcare.project.model.FieldName;
import kr.mentalcare.project.model.SW_Work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class WorkService {
	@Autowired
	SqlMapClient sqlMapClient;
	
	@Autowired
	FieldNameService fieldNameService;
	public List<SW_Work> getRecentWork() throws SQLException{
		List<SW_Work> workList=sqlMapClient.queryForList("Work.getRecentWork");
		setPartName(workList);
		return workList;
	}
	
	public SW_Work getWork(Integer wnum) throws SQLException{
		SW_Work work=(SW_Work) sqlMapClient.queryForObject("Work.getWork",wnum);
		HashMap<Integer,FieldName> fieldMap=fieldNameService.getFieldNameMap();
		work.setExpert_part_name(fieldMap.get(work.getExpert_part()).getName());
		work.setDetail_part_name(fieldMap.get(work.getDetail_part()).getName());
		
		return work;
	}
	
	public void setPartName(List<SW_Work> workList) throws SQLException{
		HashMap<Integer,FieldName> fieldMap=fieldNameService.getFieldNameMap();
		for(int i=0;i<workList.size();i++){
			SW_Work work=workList.get(i);
			work.setExpert_part_name(fieldMap.get(work.getExpert_part()).getName());
			work.setDetail_part_name(fieldMap.get(work.getDetail_part()).getName());
		}
	}
}
