package service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDAO;
import vo.MemberVO;

@Component
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		
		this.dao = dao;
		
	}
	
	public String idCheck (String userId) {
		
		MemberVO member = dao.getMemberById(userId);
		
		String result = "{";
		
		if (member == null) {
			
			result += "\"val\":\"true\"";
			
		} else {
			
			result += "\"val\":\"false\"";
			
		}
		
		result += "}";
		
		return result;
		
	}
	
	public boolean join (Map<String, Object> joinInfos) {
		
		String userId = joinInfos.get("userId").toString();
		String userPw = joinInfos.get("userPw").toString();
		String userEmailId = joinInfos.get("userEmailId").toString();
		String userEmailAddress = joinInfos.get("userEmailAddress").toString();
		String userEmail = joinInfos.get("userEmailId").toString()+"@"+joinInfos.get("userEmailAddress").toString();
		String userType = joinInfos.get("userType").toString();
		
		if (userId.isEmpty() || userId.matches(".*([\\s]).*")) {
			
			return false;
			
		}else if (userPw.isEmpty() || userPw.matches(".*([\\s]).*")) {
			
			return false;
			
		} else if (userEmailId.isEmpty() || userEmailId.matches(".*([\\W&&[^-_]]).*")) {
			
			return false;
			
		} else if (userEmailAddress.isEmpty() || userEmailAddress.matches(".*([\\s]).*")) {
			
			return false;
			
		} else if (userType.isEmpty() || userType.matches(".*([\\s]).*")) {
			
			return false;
			
		} else {
			
			Map<String, Object> memberInfos = new HashMap<String, Object>();
			
			memberInfos.put("userId", userId);
			memberInfos.put("userPw", userPw);
			memberInfos.put("userEmail", userEmail);
			memberInfos.put("userType", userType);
			
			if (dao.createMember(memberInfos) == 1) {
				
				return true;
				
			} else {
				
				return false;
				
			}
			
		}
		
	}
	
	public Map<String, Object> login (Map<String, Object> userInfos) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		MemberVO member = dao.getMemberById(userInfos.get("userId").toString());
		
		if (member == null) {
			
			result.put("loginResult", "false");
			result.put("loginStatement", "<h1>아이디가 존재하지 않습니다</h1>");
			
		} else if (!member.getMemberPw().equals(userInfos.get("userPw").toString())) {
			
			result.put("loginResult", "false");
			result.put("loginStatement", "<h1>아이디와 비밀번호가 일치하지 않습니다</h1>");
			
		} else {
			
			if (member.getMemberType().equals("CUS")) {
				
				result.put("viewName", "cus_index");
				
			} else if (member.getMemberType().equals("VEN")) {
				
				result.put("viewName", "ven_index");
				
			} else if (member.getMemberType().equals("FAC")) {
				
				result.put("viewName", "fac_index");
				
			}
			
			result.put("member", member);
			result.put("loginResult", "true");
			
		}
		
		return result;
		
	}
	
}
