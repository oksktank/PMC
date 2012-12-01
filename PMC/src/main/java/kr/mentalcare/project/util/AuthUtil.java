package kr.mentalcare.project.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.ui.Model;

public class AuthUtil {
	
	static public String retModelWithUserInfo(String path,Model model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper obj=new ObjectMapper();
		model.addAttribute("loginUser",obj.writeValueAsString(request.getSession().getAttribute("userInfo")));
		return path;
	}
}
