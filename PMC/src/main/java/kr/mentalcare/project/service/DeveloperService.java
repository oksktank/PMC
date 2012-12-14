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
	public long getAverageGrade(Integer sn) throws SQLException{
		Double average=(Double) sqlMapClient.queryForObject("Developer.getAverageGrade",sn);
		if(average==null) average=0.0;
		return Math.round(average * 10) / 10;
	}
	public int getGradeLevel(Integer sn) throws SQLException{
		long average=getAverageGrade(sn);
		int gradeLevel=10;
		if(average<=100&&average>=90){
			gradeLevel=1;
		}else if(average<90&&average>=80){
			gradeLevel=2;
		}else if(average<80&&average>=70){
			gradeLevel=3;
		}else if(average<70&&average>=60){
			gradeLevel=4;
		}else if(average<60&&average>=50){
			gradeLevel=5;
		}else if(average<50&&average>=40){
			gradeLevel=6;
		}else if(average<40&&average>=30){
			gradeLevel=7;
		}else if(average<30&&average>=20){
			gradeLevel=8;
		}else if(average<20&&average>=10){
			gradeLevel=9;
		}else if(average<10&&average>=0){
			gradeLevel=10;
		}
		return gradeLevel;
		
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
