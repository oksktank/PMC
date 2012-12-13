package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mentalcare.project.model.Admin;
import kr.mentalcare.project.model.Developer;
import kr.mentalcare.project.model.DeveloperTeam;
import kr.mentalcare.project.model.DeveloperWorkDeveloperTeam;
import kr.mentalcare.project.model.Evaluator;
import kr.mentalcare.project.model.Join;
import kr.mentalcare.project.model.SW_Work;
import kr.mentalcare.project.model.UploadItem;
import kr.mentalcare.project.model.UserInfo;
import kr.mentalcare.project.service.AdminService;
import kr.mentalcare.project.service.TeamService;
import kr.mentalcare.project.util.AuthUtil;
import kr.mentalcare.project.util.FileUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibatis.sqlmap.client.SqlMapClient;

@Controller
@RequestMapping("func")
public class DataFuncController {
	
	@Autowired
	AdminService adminService;
	@Autowired
	TeamService teamService;
	
	@Autowired
	SqlMapClient sqlMapClient;
	
	@RequestMapping(value="/insertWork",method=RequestMethod.POST)
	@ResponseBody
	public String insertWork(UploadItem uploadItem,HttpServletRequest request,@ModelAttribute SW_Work work,@RequestParam String developers) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_ADMIN)){
			
			String[] developerArray=developers.split(";");
			
			UserInfo userInfo=AuthUtil.getLoginUser(request);
			work.setAdmin_num(userInfo.getId());
			
			FileUtil fileUtil=new FileUtil();
			String filePath=FileUtil.filePath;
			String originFileName=uploadItem.getFileData().getOriginalFilename();
			String fileName=(new GregorianCalendar()).getTimeInMillis()+"_"+originFileName;
			if(originFileName!=null&&!originFileName.equals("")){
				fileUtil.writeFile(uploadItem.getFileData(), filePath,  fileName);
			
				work.setFile_name(fileName);
			}
			
			Integer workNum=adminService.insertSwWork(work);
			for(int i=0;i<developerArray.length;i++){
				DeveloperWorkDeveloperTeam team=new DeveloperWorkDeveloperTeam();
				team.setW_num(workNum);
				team.setD_sn(Integer.parseInt(developerArray[i]));
				team.setDt_num(-1);
				adminService.insertWorkDevTeam(team);
			}
			return "Success";
		}
		
		return "Fail";
	}
	

	@RequestMapping(value="/insertTeam",method=RequestMethod.POST)
	@ResponseBody
	@Transactional
	public String insertTeam(HttpServletRequest request,@RequestParam Integer w_num,
			@ModelAttribute DeveloperTeam team,@RequestParam String developers) throws SQLException{
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_DEVELOPER)){
			String[] developerArray=developers.split(";");
			System.out.println(developerArray);
			Integer dt_num=(Integer) sqlMapClient.insert("Team.insertTeam", team);
			
			for(int i=0;i<developerArray.length;i++){
				DeveloperWorkDeveloperTeam workTeam=new DeveloperWorkDeveloperTeam();
				workTeam.setW_num(w_num);
				workTeam.setD_sn(Integer.parseInt(developerArray[i]));
				workTeam.setDt_num(dt_num);
				adminService.updateWorkDevTeam(workTeam);
			}
			return "Success";
		}
		
		return null;
	}
	
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	@Transactional
	public void joinUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Join join) throws JsonGenerationException, JsonMappingException, IOException, SQLException{
		System.out.println(new ObjectMapper().writeValueAsString(join));
		UserInfo userInfo=new UserInfo();
		userInfo.setUsername(join.getUsername());
		userInfo.setPassword(join.getPassword());
		userInfo.setRole(join.getRole());
		
		Integer sn=(Integer)sqlMapClient.insert("UserInfo.insertUser", userInfo);
		switch(join.getRole()){
		case 1: //개발자
			Developer dev=new Developer();
			dev.setSn(sn);
			dev.setName(join.getName());
			dev.setPhone(join.getPhone());
			dev.setAddress(join.getAddress());
			dev.setExpert_part(join.getExpert_part());
			dev.setDetail_part(join.getDetail_part());
			sqlMapClient.insert("Developer.insertDeveloper", dev);
			break;
		case 2: //평가자
			Evaluator ev=new Evaluator();
			ev.setSn(sn);
			ev.setName(join.getName());
			ev.setPhone(join.getPhone());
			ev.setAddress(join.getAddress());
			ev.setExpert_part(join.getExpert_part());
			ev.setDetail_part(join.getDetail_part());
			sqlMapClient.insert("Evaluator.insertEvaluator", ev);
			break;
		case 3: //관리자
			Admin a=new Admin(join.getName(),join.getAddress(),join.getPhone());
			a.setSn(sn);
			sqlMapClient.insert("Admin.insertAdmin", a);
			break;
		default:
			
			break;
		}
		
		response.sendRedirect(request.getContextPath()+"/");
	}
	
	
	@RequestMapping(value="/bid",method=RequestMethod.POST)
	@ResponseBody
	public String bid(HttpServletRequest request,HttpServletResponse response,
			@RequestParam Integer wnum,@RequestParam Integer cost) throws SQLException{
		UserInfo userInfo=AuthUtil.getLoginUser(request);
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_DEVELOPER)){
			Integer sn=userInfo.getId();
			DeveloperWorkDeveloperTeam param=new DeveloperWorkDeveloperTeam();
			param.setD_sn(sn);
			param.setW_num(wnum);
			
			DeveloperTeam myTeam=teamService.getTeamBySnAndWnum(param);
			if(cost<myTeam.getCost()){
				myTeam.setCost(cost);

				int count=sqlMapClient.update("Team.setCost", myTeam);
				if(count>0){
					return "Success";
				}
			}
		}
		return "Fail";
	}
}
