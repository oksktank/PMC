package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mentalcare.project.model.Admin;
import kr.mentalcare.project.model.DeveloperTeam;
import kr.mentalcare.project.model.DeveloperWorkDeveloperTeam;
import kr.mentalcare.project.model.DevelopmentResult;
import kr.mentalcare.project.model.EvaluateResult;
import kr.mentalcare.project.model.FieldName;
import kr.mentalcare.project.model.SW_Work;
import kr.mentalcare.project.model.UserInfo;
import kr.mentalcare.project.service.AdminService;
import kr.mentalcare.project.service.DeveloperService;
import kr.mentalcare.project.service.EvaluatorService;
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
import org.springframework.web.bind.annotation.ResponseBody;

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
	@Autowired
	TeamService teamService;
	
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
	
	@RequestMapping("/toEvaluator")
	@ResponseBody
	public String toEvaluator(HttpServletRequest request,Integer dt_num,String evaluators) throws SQLException{
		String[] evaluator=evaluators.split(";");
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_ADMIN)){
			DeveloperTeam team=teamService.getTeamById(dt_num);
			for(int i=0;i<evaluator.length;i++){
				EvaluateResult evResult=new EvaluateResult();
				evResult.setR_num(team.getR_num());
				evResult.setE_sn(Integer.parseInt(evaluator[i]));
				EvaluateResult temp=(EvaluateResult) sqlMapClient.queryForObject("Evaluator.getEvaluateResult",evResult);
				
				if(temp==null){
					sqlMapClient.insert("Evaluator.insertEvaluateResult",evResult);
				}
				
			}
			return "Success";
		}
		return "Fail";
	}
	
	//사이드메뉴에서 진행중인 work 선택 -> teamId가 넘어옴 해당 팀이 work가 선정되어있을시 work, 아닐 시 auction페이지로 이동
		@RequestMapping("/work")
		public String aa_work_info(@RequestParam Integer id,HttpServletRequest request,HttpServletResponse response, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
			UserInfo userInfo=AuthUtil.getLoginUser(request);
			if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_DEVELOPER)||AuthUtil.isAvailableRole(request,UserInfo.ROLE_EVALUATOR)||
					AuthUtil.isAvailableRole(request,UserInfo.ROLE_ADMIN)){
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
					if(myTeam!=null&&myTeam.getR_num()!=null){
						DevelopmentResult result=(DevelopmentResult) sqlMapClient.queryForObject("DevelopmentResult.getResultByRnum",myTeam.getR_num());
						model.addAttribute("myResult",result);
					}
				}
				
			}
			return AuthUtil.retModelWithUserInfo("dev_workinfo", model, request);
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
}
