package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import kr.mentalcare.project.model.Work;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("func")
public class DataFuncController {
	
	@RequestMapping(value="/insertWork",method=RequestMethod.POST)
	@ResponseBody
	public String insertWork(@ModelAttribute Work work,List<Integer> developers) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		
		return null;
	}
}
