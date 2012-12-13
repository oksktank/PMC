package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mentalcare.project.model.Admin;
import kr.mentalcare.project.model.DeveloperTeam;
import kr.mentalcare.project.model.DeveloperWorkDeveloperTeam;
import kr.mentalcare.project.model.DevelopmentResult;
import kr.mentalcare.project.model.FieldName;
import kr.mentalcare.project.model.SW_Work;
import kr.mentalcare.project.model.UserInfo;
import kr.mentalcare.project.service.DeveloperService;
import kr.mentalcare.project.service.TeamService;
import kr.mentalcare.project.service.WorkService;
import kr.mentalcare.project.util.AuthUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibatis.sqlmap.client.SqlMapClient;

@Controller
@RequestMapping("dev")
public class DevController {
	
	@Autowired
	DeveloperService developerService;
	@Autowired
	WorkService workService;
	@Autowired
	TeamService teamService;
	@Autowired
	SqlMapClient sqlMapClient;
	
	@RequestMapping("/")
	public String aa_main(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_DEVELOPER)){
			Integer sn=userInfo.getId();
			model.addAttribute("developer", developerService.getDeveloper(sn));
			model.addAttribute("invitedWorkCount",developerService.getInvitedWorkCount(sn));
			model.addAttribute("myTeamList",developerService.getMyTeamList(sn));
			model.addAttribute("recentWork",workService.getRecentWork());
		}
		
		
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
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_DEVELOPER)){
			Integer sn=userInfo.getId();
			model.addAttribute("invitedWork", developerService.getInvitedWork(sn));
		}
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
	public String aa_work_auction(HttpServletRequest request, Model model,@RequestParam Integer wnum) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		model.addAttribute("expertField",(ArrayList<FieldName>)sqlMapClient.queryForList("Field.getExpertField"));
		model.addAttribute("detailField",(ArrayList<FieldName>)sqlMapClient.queryForList("Field.getDetailField"));
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_DEVELOPER)){
			Integer sn=userInfo.getId();
			SW_Work work=workService.getWork(wnum);
			model.addAttribute("work", work);
			model.addAttribute("noTeamDeveloper",developerService.getNoTeamDeveloperInWork(wnum));
			model.addAttribute("teamListInWork",teamService.getTeamListInWork(wnum));
			
			DeveloperWorkDeveloperTeam param=new DeveloperWorkDeveloperTeam();
			param.setD_sn(sn);
			param.setW_num(wnum);
			
			model.addAttribute("myTeam",teamService.getTeamBySnAndWnum(param));
		}else if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_ADMIN)){
			Integer sn=userInfo.getId();
			Admin admin=(Admin) sqlMapClient.queryForObject("Admin.getAdmin", sn);
			
			model.addAttribute("admin",admin);
			SW_Work work=workService.getWork(wnum);
			model.addAttribute("work", work);
			model.addAttribute("teamListInWork",teamService.getTeamListInWork(wnum));
		}
		return AuthUtil.retModelWithUserInfo("dev_workauction", model, request);
	}
	
	//사이드메뉴에서 진행중인 work 선택 -> teamId가 넘어옴 해당 팀이 work가 선정되어있을시 work, 아닐 시 auction페이지로 이동
	@RequestMapping("/work")
	public String aa_work_info(@RequestParam Integer id,HttpServletRequest request,HttpServletResponse response, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_DEVELOPER)){
			SW_Work work=workService.getWorkByTeamId(id);
			if(work==null){
				Integer wnum=(Integer) sqlMapClient.queryForObject("Work.getWorkNumByTeamId",id);
				response.sendRedirect(request.getContextPath()+"/dev/auction?wnum="+wnum);
			}else{
				Integer sn=userInfo.getId();
				model.addAttribute("work", work);
				model.addAttribute("team",teamService.getTeamById(id));
				DeveloperWorkDeveloperTeam param=new DeveloperWorkDeveloperTeam();
				param.setD_sn(sn);
				param.setW_num(work.getNum());
				DeveloperTeam myTeam=teamService.getTeamBySnAndWnum(param);
				model.addAttribute("myTeam", myTeam);
				if(myTeam.getR_num()!=null){
					DevelopmentResult result=(DevelopmentResult) sqlMapClient.queryForObject("DevelopmentResult.getResultByRnum",myTeam.getR_num());
					model.addAttribute("myResult",result);
				}
			}
			
		}
		return AuthUtil.retModelWithUserInfo("dev_workinfo", model, request);
	}
}