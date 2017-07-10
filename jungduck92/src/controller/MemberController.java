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
	
	@RequestMapping(value="/emailCheck.jd", method=RequestMethod.POST)
	public void emailCheck (String userEmail, HttpServletResponse response) {
		
		try {
			
			response.getWriter().print(service.emailCheck(userEmail));
			
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
	
	@RequestMapping(value="/findMemberId.jd", method=RequestMethod.POST)
	public ModelAndView findMemberId (String findIdEmail) {
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> findIdResult = service.findMemberId(findIdEmail);
		
		if (findIdResult.get("emailMathced").toString().equals("true")) {
			
			mv.addObject("resultStatement", findIdResult.get("resultStatement"));
			
		} else {
			
			mv.addObject("resultStatement", "<h1>이메일을 올바르게 입력하시오</h1>");
			
		}
		
		mv.setViewName("find_form");
		
		return mv;
		
	}
	
	@RequestMapping(value="/findMemberPw.jd", method=RequestMethod.POST)
	public ModelAndView findMemberPw (@RequestParam Map<String, Object> findPwInfos) {
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> findPwResult = service.findMemberPw(findPwInfos);
		
		if (findPwResult.get("findResult").toString().equals("false")) {
			
			mv.addObject("resultStatement", findPwResult.get("resultStatement"));
			mv.setViewName("find_form");
			
		} else {
			
			mv.addObject("memberIdx", findPwResult.get("memberIdx"));
			mv.setViewName("change_pwd");
			
		}
		
		return mv;
		
	}
	
	@RequestMapping(value="/updateMemberPw.jd", method=RequestMethod.POST)
	public ModelAndView updateMemberPw (@RequestParam Map<String, Object> pwInfos) {
		
		ModelAndView mv = new ModelAndView();
		
		if (service.updateMemberPw(pwInfos)) {
			
			mv.setViewName("update_pw_success");
			
		} else {
			
			mv.setViewName("change_pwd");
			
		}
		
		return mv;
		
	}
	
}
