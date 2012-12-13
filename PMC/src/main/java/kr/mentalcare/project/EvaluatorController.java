package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.model.SW_Work;
import kr.mentalcare.project.model.UserInfo;
import kr.mentalcare.project.util.AuthUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibatis.sqlmap.client.SqlMapClient;

@Controller
@RequestMapping("evaluator")
public class EvaluatorController {
	
	@Autowired
	SqlMapClient sqlMapClient;
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("test", model, request);
	}
	
	@RequestMapping("/")
	public String aa_main(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
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
		return AuthUtil.retModelWithUserInfo("evaluator_past", model, request);
	}
	
	@RequestMapping("/work")
	public String aa_work(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("dev_workinfo", model, request);
	}
}
