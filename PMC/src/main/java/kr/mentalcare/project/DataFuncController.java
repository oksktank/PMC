package kr.mentalcare.project;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.model.SW_Work;
import kr.mentalcare.project.model.UploadItem;
import kr.mentalcare.project.model.UserInfo;
import kr.mentalcare.project.service.AdminService;
import kr.mentalcare.project.util.AuthUtil;
import kr.mentalcare.project.util.FileUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("func")
public class DataFuncController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="/insertWork",method=RequestMethod.POST)
	@ResponseBody
	public String insertWork(UploadItem uploadItem,HttpServletRequest request,@ModelAttribute SW_Work work,@RequestParam String developers) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		if(AuthUtil.isAvailableRole(request,UserInfo.ROLE_ADMIN)){
			ObjectMapper obj=new ObjectMapper();
			System.out.println(obj.writeValueAsString(work));
			System.out.println(developers);
			String[] developerArray=developers.split(";");
			System.out.println(developerArray.length);
			
			UserInfo userInfo=AuthUtil.getLoginUser(request);
			work.setAdmin_num(userInfo.getId());
			
			FileUtil fileUtil=new FileUtil();
			String filePath="d:\\upload\\sw_work";
			String originFileName=uploadItem.getFileData().getOriginalFilename();
			String fileName=(new GregorianCalendar()).getTimeInMillis()+"_"+originFileName;
		    fileUtil.writeFile(uploadItem.getFileData(), filePath,  fileName);
		    work.setFile_name(fileName);
		    work.setFile_path(filePath);
			
			adminService.insertSwWork(work);
			
		}
		
		return null;
	}
}
