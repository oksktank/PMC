package kr.mentalcare.project.service;

import java.sql.SQLException;

import kr.mentalcare.project.model.DevelopmentResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class ResultService {
	@Autowired
	SqlMapClient sqlMapClient;
	
	public Integer insertResult(DevelopmentResult result) throws SQLException{
		DevelopmentResult inDb=(DevelopmentResult) sqlMapClient.queryForObject("DevelopmentResult.getResultByWnum",result.getW_num());
		if(inDb==null){
			return (Integer) sqlMapClient.insert("DevelopmentResult.insertResult",result);
		}else{
			inDb.setFile_name(result.getFile_name());
			sqlMapClient.update("DevelopmentResult.updateResult",inDb);
			return inDb.getR_num();
		}
	}
}
