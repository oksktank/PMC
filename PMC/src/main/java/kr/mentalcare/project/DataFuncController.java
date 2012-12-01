package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;

import kr.mentalcare.project.model.Work;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("func")
public class DataFuncController {
	
	@RequestMapping(value="/insertWork",method=RequestMethod.POST)
	@ResponseBody
	public String insertWork(@ModelAttribute Work work,@RequestParam String developers) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper obj=new ObjectMapper();
		System.out.println(obj.writeValueAsString(work));
		System.out.println(developers);
		String[] developerArray=developers.split(";");
		System.out.println(developerArray.length);
		return null;
	}
}
