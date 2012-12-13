package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mentalcare.project.model.DeveloperTeam;
import kr.mentalcare.project.model.DeveloperWorkDeveloperTeam;
import kr.mentalcare.project.model.DevelopmentResult;
import kr.mentalcare.project.model.Evaluator;
import kr.mentalcare.project.model.FieldName;
import kr.mentalcare.project.model.SW_Work;
import kr.mentalcare.project.model.UserInfo;
import kr.mentalcare.project.service.FieldNameService;
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
@RequestMapping("evaluator")
public class EvaluatorController {
	
	@Autowired
	SqlMapClient sqlMapClient;
	@Autowired
	WorkService workService;

	@Autowired
	TeamService teamService;
	@Autowired
	FieldNameService fieldNameService;
	@RequestMapping("/test")
	public String test(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("test", model, request);
	}
	
	@RequestMapping("/")
	public String aa_main(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_EVALUATOR)){
			Integer sn=userInfo.getId();
			Evaluator evaluator=(Evaluator) sqlMapClient.queryForObject("Evaluator.getEvaluator",sn);

			HashMap<Integer,FieldName> fieldMap=fieldNameService.getFieldNameMap();
			evaluator.setExpert_part_name(fieldMap.get(evaluator.getExpert_part()).getName());
			evaluator.setDetail_part_name(fieldMap.get(evaluator.getDetail_part()).getName());
			model.addAttribute("evaluator", evaluator);
			
			List<SW_Work> evaluateJobList=sqlMapClient.queryForList("Evaluator.getEvaluateJob",sn);
			int evCount=0;
			if(evaluateJobList!=null){
				evCount=evaluateJobList.size();
			}
			model.addAttribute("evCount", evCount);

			model.addAttribute("recentWork",workService.getRecentWork());
		}
		return AuthUtil.retModelWithUserInfo("evaluator_main", model, request);
	}
	
	@RequestMapping("/evaluate")
	public String aa_evaluate(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_EVALUATOR)){
			Integer sn=userInfo.getId();
			List<SW_Work> evaluateJobList=sqlMapClient.queryForList("Evaluator.getEvaluateJob",sn);
			model.addAttribute("evaluateJobList",evaluateJobList);
		}
		return AuthUtil.retModelWithUserInfo("evaluator_evaluate", model, request);
	}
	
	@RequestMapping("/history")
	public String aa_history(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_EVALUATOR)){
			Integer sn=userInfo.getId();
			List<SW_Work> evaluatedList=sqlMapClient.queryForList("Evaluator.getEvaluated",sn);
			workService.setPartName(evaluatedList);
			model.addAttribute("evaluatedList",evaluatedList);
		}
		return AuthUtil.retModelWithUserInfo("evaluator_past", model, request);
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
}
