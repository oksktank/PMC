package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.model.ResultData;
import kr.mentalcare.project.model.UserInfo;
import kr.mentalcare.project.service.UserInfoService;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("func")
public class FuncController {
	ObjectMapper obj=new ObjectMapper();
	@Autowired
	UserInfoService userInfoService;
		
	@RequestMapping(value="/signIn",method=RequestMethod.GET)
	@ResponseBody
	public String signIn(HttpServletRequest request,String username,String password) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		System.out.println(username+","+password);
		UserInfo loginUser=userInfoService.findUserInfo(username, password);
		boolean result=false;
		if(loginUser!=null){
			request.getSession().setAttribute("userInfo",loginUser);
			result=true;
		}
		return obj.writeValueAsString(new ResultData(result,loginUser));
	}
}
