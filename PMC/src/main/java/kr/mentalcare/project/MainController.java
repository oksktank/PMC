package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.model.FieldName;
import kr.mentalcare.project.model.SW_Work;
import kr.mentalcare.project.service.AdminService;
import kr.mentalcare.project.service.FieldNameService;
import kr.mentalcare.project.util.AuthUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@Autowired
	FieldNameService fieldNameService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request,Locale locale, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		System.out.println(sqlMapClient);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		System.out.println("login User:"+request.getSession().getAttribute("userInfo"));
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		@SuppressWarnings("unchecked")
		List<SW_Work> workList=sqlMapClient.queryForList("Work.getRecentWork");
		HashMap<Integer,FieldName> fieldMap=fieldNameService.getFieldNameMap();
		for(int i=0;i<workList.size();i++){
			SW_Work work=workList.get(i);
			work.setExpert_part_name(fieldMap.get(work.getExpert_part()).getName());
			work.setDetail_part_name(fieldMap.get(work.getDetail_part()).getName());
		}
		model.addAttribute("recentWork",workList);
		return AuthUtil.retModelWithUserInfo("home", model, request);
	}
	
	@RequestMapping("/test")
	public String aa(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		//adminService.insertAdmin("이원석", "공A", "010-2242-2424");
		return AuthUtil.retModelWithUserInfo("test", model, request);
	}
	
	@RequestMapping("/join")
	public String aa_join(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("join", model, request);
	}
	
	@RequestMapping("/dev_main")
	public String dev_main11(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		//adminService.insertAdmin("이원석", "공A", "010-2242-2424");
		return AuthUtil.retModelWithUserInfo("dev_main", model, request);
	}
	
	
	
}
