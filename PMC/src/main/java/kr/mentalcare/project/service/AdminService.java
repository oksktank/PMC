package kr.mentalcare.project.service;

import java.sql.SQLException;

import kr.mentalcare.project.model.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.mysql.jdbc.Driver;

@Service
public class AdminService {
	@Autowired
	SqlMapClient sqlMapClient;
	public Admin insertAdmin(String name,String address,String phone) throws SQLException{
		Admin admin=new Admin(name,address,phone);
		return (Admin)sqlMapClient.insert("Admin.insertAdmin", admin);
	}
}