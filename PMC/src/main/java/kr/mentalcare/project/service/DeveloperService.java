package kr.mentalcare.project.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import kr.mentalcare.project.model.Developer;
import kr.mentalcare.project.model.FieldName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class DeveloperService {
	@Autowired
	SqlMapClient sqlMapClient;
	
	@Autowired
	FieldNameService fieldNameService;
	
	
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
