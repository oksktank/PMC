package kr.mentalcare.project.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import kr.mentalcare.project.model.Developer;
import kr.mentalcare.project.model.DeveloperTeam;
import kr.mentalcare.project.model.FieldName;
import kr.mentalcare.project.model.SW_Work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class DeveloperService {
	@Autowired
	SqlMapClient sqlMapClient;
	
	@Autowired
	WorkService workService;
	
	@Autowired
	FieldNameService fieldNameService;
	
	public Developer getDeveloper(Integer sn) throws SQLException{
		Developer dev=(Developer) sqlMapClient.queryForObject("Developer.getDeveloper",sn);
		HashMap<Integer,FieldName> fieldMap=fieldNameService.getFieldNameMap();
		dev.setExpert_part_name(fieldMap.get(dev.getExpert_part()).getName());
		dev.setDetail_part_name(fieldMap.get(dev.getDetail_part()).getName());
		return dev;
	}
	
	public List<Developer> getNoTeamDeveloperInWork(Integer w_num) throws SQLException{
		@SuppressWarnings("unchecked")
		List<Developer> devList=sqlMapClient.queryForList("Developer.getNoTeamDeveloperInWork", w_num);
		HashMap<Integer,FieldName> fieldMap=fieldNameService.getFieldNameMap();
		
		for(int i=0;i<devList.size();i++){
			Developer dev=devList.get(i);
			dev.setExpert_part_name(fieldMap.get(dev.getExpert_part()).getName());
			dev.setDetail_part_name(fieldMap.get(dev.getDetail_part()).getName());
		}
		return devList;
	}
	
	public Integer getInvitedWorkCount(Integer sn) throws SQLException{
		return (Integer) sqlMapClient.queryForObject("Developer.getInvitedWorkCount", sn);
	}
	
	public List<SW_Work> getInvitedWork(Integer sn) throws SQLException{
		List<SW_Work> workList=sqlMapClient.queryForList("Developer.getInvitedWork",sn);
		workService.setPartName(workList);
		return workList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DeveloperTeam> getMyTeamList(Integer sn) throws SQLException{
		return sqlMapClient.queryForList("Developer.getMyTeamList",sn);
	}
	
	public List<Developer> getAllDeveloperList() throws SQLException{
		List<Developer> allDev=sqlMapClient.queryForList("Developer.getAllDeveloper");
		HashMap<Integer,FieldName> fieldMap=fieldNameService.getFieldNameMap();
		
		for(int i=0;i<allDev.size();i++){
			Developer dev=allDev.get(i);
			dev.setExpert_part_name(fieldMap.get(dev.getExpert_part()).getName());
			dev.setDetail_part_name(fieldMap.get(dev.getDetail_part()).getName());
		}
		
		return allDev;
	}
}
