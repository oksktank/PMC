package kr.mentalcare.project.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.model.UserInfo;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.ui.Model;

public class AuthUtil {
	
	static public String retModelWithUserInfo(String path,Model model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper obj=new ObjectMapper();
		model.addAttribute("loginUser",obj.writeValueAsString(getLoginUser(request)));
		return path;
	}
	
	static public UserInfo getLoginUser(HttpServletRequest request){
		return (UserInfo) request.getSession().getAttribute("userInfo");
	}
	
	static public boolean isAvailableRole(HttpServletRequest request,int Role){
		UserInfo userInfo=getLoginUser(request);
		if(userInfo!=null){
			if(userInfo.getRole()==Role){
				return true;
			}
		}
		return false;
	}
}
