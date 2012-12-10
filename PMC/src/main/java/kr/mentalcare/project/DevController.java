package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.model.FieldName;
import kr.mentalcare.project.util.AuthUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dev")
public class DevController {
	@RequestMapping("/")
	public String aa_main(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("dev_main", model, request);
	}
	
	@RequestMapping("/test")
	public String aa(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("test", model, request);
	}
	
	@RequestMapping("/cost")
	public String aa_cost(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("dev_cost", model, request);
	}
	
	@RequestMapping("/invite_work")
	public String aa_invite_work(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("dev_invite", model, request);
	}
	
	@RequestMapping("/all_work")
	public String aa_all_work(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("dev_allwork", model, request);
	}
	
	@RequestMapping("/past_work")
	public String aa_past_work(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("dev_pastwork", model, request);
	}
	
	//invite_work에서 클릭 -> auction?wid=xxxx
	@SuppressWarnings("unchecked")
	@RequestMapping("/auction")
	public String aa_work_auction(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
/*
		model.addAttribute("expertField",(ArrayList<FieldName>)sqlMapClient.queryForList("Field.getExpertField"));
		model.addAttribute("detailField",(ArrayList<FieldName>)sqlMapClient.queryForList("Field.getDetailField"));
		model.addAttribute("allDev",developerService.getAllDeveloperList());
	*/	
		return AuthUtil.retModelWithUserInfo("dev_workauction", model, request);
	}
	
	//사이드메뉴에서 진행중인 work 선택 -> work?wid=xxxx
	@RequestMapping("/work")
	public String aa_work_info(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("dev_workinfo", model, request);
	}
}