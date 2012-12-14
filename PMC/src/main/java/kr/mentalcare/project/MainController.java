package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mentalcare.project.model.FieldName;
import kr.mentalcare.project.model.UserInfo;
import kr.mentalcare.project.service.AdminService;
import kr.mentalcare.project.service.FieldNameService;
import kr.mentalcare.project.service.WorkService;
import kr.mentalcare.project.util.AuthUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	SqlMapClient sqlMapClient;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	FieldNameService fieldNameService;
	
	@Autowired
	WorkService workService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		if(userInfo!=null){
			String contextPath=request.getContextPath();
			if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_DEVELOPER)){
				response.sendRedirect(contextPath+"/dev/");
			}else if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_ADMIN)){
				response.sendRedirect(contextPath+"/admin/");
			}else if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_EVALUATOR)){
				response.sendRedirect(contextPath+"/evaluator/");
			}
		}
		
		model.addAttribute("recentWork",workService.getRecentWork());
		return AuthUtil.retModelWithUserInfo("home", model, request);
	}
	
	@RequestMapping("/test")
	public String aa(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("test", model, request);
	}
	
	@RequestMapping("/join")
	public String aa_join(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		
		model.addAttribute("expertField",(ArrayList<FieldName>)sqlMapClient.queryForList("Field.getExpertField"));
		model.addAttribute("detailField",(ArrayList<FieldName>)sqlMapClient.queryForList("Field.getDetailField"));
		
		return AuthUtil.retModelWithUserInfo("join", model, request);
	}
	
	
}
