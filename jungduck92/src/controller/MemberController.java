package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import repository.MemberDAO;
import service.MemberService;
import vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("/joinForm.jd")
	public String joinForm () {
		
		return "join_form";
		
	}
	
	@RequestMapping(value="/idCheck.jd", method=RequestMethod.POST)
	public void idCheck (String userId, HttpServletResponse response) {
		
		try {
			
			response.getWriter().print(service.idCheck(userId));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	@RequestMapping(value="/join.jd", method=RequestMethod.POST)
	public ModelAndView join (@RequestParam Map<String, Object> joinInfos) {
		
		ModelAndView mv = new ModelAndView();
		
		if (service.join(joinInfos)) {
			
			mv.addObject("memberId", joinInfos.get("userId").toString());
			mv.setViewName("join_success");
			
		} else {
			
			mv.setViewName("join_form");
			
		}
		
		return mv;
		
	}
	
	@RequestMapping("/index.jd")
	public String index () {
		
		return "index";
		
	}
	
	@RequestMapping(value="/login.jd", method=RequestMethod.POST)
	public ModelAndView login (@RequestParam Map<String, Object> userInfos) {
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> login = service.login(userInfos);
		
		if (login.get("loginResult").toString().equals("false")) {
			
			mv.addObject("loginStatement", login.get("loginStatement"));
			mv.setViewName("index");
			
		} else if (login.get("loginResult").toString().equals("true")) {
			
			mv.addObject("member", login.get("member"));
			mv.setViewName(login.get("viewName").toString());
			
		} else {
			
			mv.addObject("loginStatement", "로그인 실패 관리자에게 문의하세요");
			mv.setViewName("index");
			
		}
		
		return mv;
		
	}
	
	@RequestMapping("/findForm.jd")
	public String findForm () {
		
		return "find_form";
		
	}
	
}
