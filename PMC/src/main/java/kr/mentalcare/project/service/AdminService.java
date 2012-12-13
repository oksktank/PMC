package kr.mentalcare.project.service;

import java.sql.SQLException;

import kr.mentalcare.project.model.Admin;
import kr.mentalcare.project.model.DeveloperWorkDeveloperTeam;
import kr.mentalcare.project.model.SW_Work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class AdminService {
	@Autowired
	SqlMapClient sqlMapClient;
	public Admin insertAdmin(String name,String address,String phone) throws SQLException{
		Admin admin=new Admin(name,address,phone);
		return (Admin)sqlMapClient.insert("Admin.insertAdmin", admin);
	}
	
	public Integer insertSwWork(SW_Work work) throws SQLException{
		return (Integer)sqlMapClient.insert("Admin.insertSwWork",work);
	}
	
	public DeveloperWorkDeveloperTeam insertWorkDevTeam(DeveloperWorkDeveloperTeam workDevTeam) throws SQLException{
		return (DeveloperWorkDeveloperTeam)sqlMapClient.insert("Admin.insertWorkDevTeam",workDevTeam);
	}
	
	public int updateWorkDevTeam(DeveloperWorkDeveloperTeam workDevTeam) throws SQLException{
		return sqlMapClient.update("Admin.updateWorkDevTeam",workDevTeam);
	}
}
