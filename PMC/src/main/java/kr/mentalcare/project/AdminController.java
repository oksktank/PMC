package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.model.Admin;
import kr.mentalcare.project.model.FieldName;
import kr.mentalcare.project.model.SW_Work;
import kr.mentalcare.project.model.UserInfo;
import kr.mentalcare.project.service.AdminService;
import kr.mentalcare.project.service.DeveloperService;
import kr.mentalcare.project.service.EvaluatorService;
import kr.mentalcare.project.service.WorkService;
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
	
	@Autowired
	AdminService adminService;
	@Autowired
	WorkService workService;
	@Autowired
	EvaluatorService evaluatorService;
	
	@RequestMapping("/")
	public String aa_main(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_ADMIN)){
			Integer sn=userInfo.getId();
			Admin admin=(Admin) sqlMapClient.queryForObject("Admin.getAdmin", sn);
			
			model.addAttribute("admin",admin);
			
			List<SW_Work> auctionWorkList=sqlMapClient.queryForList("Admin.getAuctionWorkList",sn);
			int auctionWorkCount=0;
			if(auctionWorkList!=null){
				auctionWorkCount=auctionWorkList.size();
			}
			model.addAttribute("auctionWorkCount",auctionWorkCount);
			
			List<SW_Work> onWorkList=sqlMapClient.queryForList("Admin.getOnWorkList",sn);
			int onWorkCount=0;
			if(onWorkList!=null){
				onWorkCount=onWorkList.size();
			}
			model.addAttribute("onWorkCount",onWorkCount);
			
			model.addAttribute("recentWork",workService.getRecentWork());
			
		}
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
	
	@RequestMapping("/auction_list")
	public String aa_work_auction_list(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_ADMIN)){
			Integer sn=userInfo.getId();
			List<SW_Work> auctionWorkList=sqlMapClient.queryForList("Admin.getAuctionWorkList",sn);
			workService.setPartName(auctionWorkList);
			model.addAttribute("auctionList",auctionWorkList);
		}
		return AuthUtil.retModelWithUserInfo("admin_workauctionlist", model, request);
	}
	
	@RequestMapping("/on_work")
	public String aa_on_work(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_ADMIN)){
			Integer sn=userInfo.getId();
			List<SW_Work> onWorkList=sqlMapClient.queryForList("Admin.getOnWorkList",sn);
			workService.setPartName(onWorkList);
			model.addAttribute("onWorkList",onWorkList);
			model.addAttribute("allEva",evaluatorService.getAllEvaluatorList());
		}
		return AuthUtil.retModelWithUserInfo("admin_onworklist", model, request);
	}
	
	//auction_list에서 클릭 -> auction?wid=xxxx
	@RequestMapping("/auction")
	public String aa_work_auction(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("admin_workauction", model, request);
	}
	
	@RequestMapping("/work")
	public String aa_work(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("dev_workinfo", model, request);
	}
}
