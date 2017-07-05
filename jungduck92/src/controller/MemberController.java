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
import vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("/joinForm.jd")
	public String joinForm () {
		
		return "join_form";
		
	}
	
	@RequestMapping(value="/idCheck.jd", method=RequestMethod.POST)
	public void idCheck (String userId, HttpServletResponse response) {
		
		MemberVO member = dao.getMemberById(userId);
		
		String result = "{";
		
		if (member == null) {
			
			result += "\"result\":\"<h1>YOU CAN USE THIS ID</h1>\",";
			result += "\"val\":\"true\"";
			
		} else {
			
			result += "\"result\":\"<h1 class='red'>ALREADY EXIST</h1>\",";
			result += "\"val\":\"false\"";
			
		}
		
		result += "}";
		
		try {
			
			response.getWriter().print(result);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	@RequestMapping(value="/join.jd", method=RequestMethod.POST)
	public ModelAndView join (@RequestParam Map<String, Object> joinInfos, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> memberInfos = new HashMap<String, Object>();
		
		memberInfos.put("userId", joinInfos.get("userId").toString());
		memberInfos.put("userPw", joinInfos.get("userPw").toString());
		memberInfos.put("userEmail", joinInfos.get("userEmailId").toString()+"@"+joinInfos.get("userEmailAddress").toString());
		memberInfos.put("userType", joinInfos.get("userType").toString());
		
		int result = dao.createMember(memberInfos);
		
		mv.addObject("memberId", joinInfos.get("userId").toString());
		mv.setViewName("join_success");
		
		return mv;
		
	}
	
	@RequestMapping("/index.jd")
	public String index () {
		
		return "index";
		
	}
	
	@RequestMapping(value="/login.jd", method=RequestMethod.POST)
	public ModelAndView login (@RequestParam Map<String, Object> joinInfos) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("main_list");
		
		return mv;
		
	}
	
	@RequestMapping("/findForm.jd")
	public String findForm () {
		
		return "find_form";
		
	}
	
}
