package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@RequestMapping("/joinForm.jd")
	public String joinForm () {
		
		return "join_form";
		
	}
	
	@RequestMapping(value="/login.jd", method=RequestMethod.POST)
	public ModelAndView login () {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("main_list");
		
		return mv;
		
	}
	
	@RequestMapping("/findForm.jd")
	public String findForm () {
		
		return "find_form";
		
	}
	
}
