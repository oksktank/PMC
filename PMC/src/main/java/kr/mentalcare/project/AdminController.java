package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.model.FieldName;
import kr.mentalcare.project.service.DeveloperService;
import kr.mentalcare.project.util.AuthUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibatis.sqlmap.client.SqlMapClient;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	SqlMapClient sqlMapClient;
	
	@Autowired
	DeveloperService developerService;
	
	@RequestMapping("/")
	public String aa_main(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("admin_main", model, request);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/workadd")
	public String workadd(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		
		model.addAttribute("expertField",(ArrayList<FieldName>)sqlMapClient.queryForList("Field.getExpertField"));
		model.addAttribute("detailField",(ArrayList<FieldName>)sqlMapClient.queryForList("Field.getDetailField"));
		model.addAttribute("allDev",developerService.getAllDeveloperList());
		
		
		return AuthUtil.retModelWithUserInfo("workadd", model, request);
	}
}
