package kr.mentalcare.project;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.model.ResultData;
import kr.mentalcare.project.model.UploadItem;
import kr.mentalcare.project.model.UserInfo;
import kr.mentalcare.project.service.UserInfoService;
import kr.mentalcare.project.util.FileUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("func")
public class FuncController {
	ObjectMapper obj=new ObjectMapper();
	@Autowired
	UserInfoService userInfoService;
		
	@RequestMapping(value="/signIn",method=RequestMethod.GET)
	@ResponseBody
	public String signIn(HttpServletRequest request,String username,String password) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		System.out.println(username+","+password);
		UserInfo loginUser=userInfoService.findUserInfo(username, password);
		boolean result=false;
		if(loginUser!=null){
			request.getSession().setAttribute("userInfo",loginUser);
			result=true;
		}
		return obj.writeValueAsString(new ResultData(result,loginUser));
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	  public String create(UploadItem uploadItem, BindingResult result)
	  {
	    if (result.hasErrors())
	    {
	      for(ObjectError error : result.getAllErrors())
	      {
	        System.err.println("Error: " + error.getCode() +  " - " + error.getDefaultMessage());
	      }
	      return "upload/uploadForm";
	    }
	 
	    // Some type of file processing...
	    System.err.println("-------------------------------------------");
	    System.err.println("Test upload: " + uploadItem.getName());
	    System.err.println("Test upload: " + uploadItem.getFileData().getOriginalFilename());
	    
	    FileUtil fileUtil=new FileUtil();
	    fileUtil.writeFile(uploadItem.getFileData(), "d:\\download",  (new GregorianCalendar()).getTimeInMillis()+"_"+uploadItem.getFileData().getOriginalFilename());
	    
	    System.err.println("-------------------------------------------");
	 
	    return "true";
	  }
	
	 @RequestMapping("/download")
	    public ModelAndView download( 
	                                  @RequestParam("fileName")String fileName){
	         
	        String fullPath = "d:\\download\\" + fileName;
	         
	        File file = new File(fullPath);
	         
	        return new ModelAndView("download", "downloadFile", file);
	    }
}
