package kr.mentalcare.project.service;

import java.sql.SQLException;

import kr.mentalcare.project.model.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class UserInfoService {
	@Autowired
	SqlMapClient sqlMapClient;
	
	public UserInfo findUserInfo(String username,String password) throws SQLException{
		UserInfo u=new UserInfo();
		u.setUsername(username);
		u.setPassword(password);
		return (UserInfo)sqlMapClient.queryForObject("UserInfo.findUserInfo",u);
	}
}
