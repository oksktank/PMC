package kr.mentalcare.project.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import kr.mentalcare.project.model.FieldName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class FieldNameService {
	
	@Autowired
	SqlMapClient sqlMapClient;
	
	HashMap<Integer,FieldName> fieldNameMap;
	
	public HashMap<Integer,FieldName> getFieldNameMap() throws SQLException{
		if(fieldNameMap==null){
			fieldNameMap=new HashMap<Integer,FieldName>();
			@SuppressWarnings("unchecked")
			List<FieldName> allField=sqlMapClient.queryForList("Field.getAllField");
			for(int i=0;i<allField.size();i++){
				FieldName t=allField.get(i);
				fieldNameMap.put(t.getId(), t);
			}
			return fieldNameMap;
		}else{
			return fieldNameMap;
		}
	}
}
