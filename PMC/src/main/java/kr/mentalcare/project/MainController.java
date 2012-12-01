package kr.mentalcare.project;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.model.UploadItem;
import kr.mentalcare.project.service.AdminService;
import kr.mentalcare.project.util.AuthUtil;
import kr.mentalcare.project.util.FileUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	SqlMapClient sqlMapClient;
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request,Locale locale, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		System.out.println(sqlMapClient);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		System.out.println("login User:"+request.getSession().getAttribute("userInfo"));
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return AuthUtil.retModelWithUserInfo("home", model, request);
	}
	
	@RequestMapping("/test")
	public String aa(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		//adminService.insertAdmin("이원석", "공A", "010-2242-2424");
		return AuthUtil.retModelWithUserInfo("test", model, request);
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
	    fileUtil.writeFile(uploadItem.getFileData(), "d:\\download",  uploadItem.getFileData().getOriginalFilename());
	    
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
