package kr.mentalcare.project.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import kr.mentalcare.project.model.Evaluator;
import kr.mentalcare.project.model.FieldName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class EvaluatorService {
	
	@Autowired
	SqlMapClient sqlMapClient;
	
	@Autowired
	FieldNameService fieldNameService;
	
	public List<Evaluator> getAllEvaluatorList() throws SQLException{
		List<Evaluator> allEva=sqlMapClient.queryForList("Evaluator.getAllEvaluator");
		HashMap<Integer,FieldName> fieldMap=fieldNameService.getFieldNameMap();
		
		for(int i=0;i<allEva.size();i++){
			Evaluator eva=allEva.get(i);
			eva.setExpert_part_name(fieldMap.get(eva.getExpert_part()).getName());
			eva.setDetail_part_name(fieldMap.get(eva.getDetail_part()).getName());
		}
		
		return allEva;
	}
}
