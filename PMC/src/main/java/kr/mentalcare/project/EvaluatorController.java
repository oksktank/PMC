package kr.mentalcare.project;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import kr.mentalcare.project.util.AuthUtil;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("evaluator")
public class EvaluatorController {
	@RequestMapping("/test")
	public String test(HttpServletRequest request, Model model) throws SQLException, JsonGenerationException, JsonMappingException, IOException{
		return AuthUtil.retModelWithUserInfo("test", model, request);
	}
}
