package service;

import java.util.HashMap;
import java.util.Map;
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
	
	public String emailCheck (String userEmail) {
		
		MemberVO member = dao.getMemberByEmail(userEmail);
		
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
			
			result.put("loginResult", false);
			result.put("loginStatement", "<h1>아이디가 존재하지 않습니다</h1>");
			
		} else if (!member.getMemberPw().equals(userInfos.get("userPw").toString())) {
			
			result.put("loginResult", false);
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
			result.put("loginResult", true);
			
		}
		
		return result;
		
	}
	
	public Map<String, Object> findMemberId (String findIdEmail) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
		
		if (findIdEmail.matches(regex)) {
			
			result.put("emailMathced", true);
			
			MemberVO member = dao.getMemberByEmail(findIdEmail);
			
			if (member == null) {
				
				result.put("resultStatement", "<h1>이메일에 해당하는 아이디가 존재하지 않습니다.</h1>");
				
			} else {
				
				result.put("resultStatement", "<h1>해당하는 아이디는 "+member.getMemberId()+"입니다.</h1>");
				
			}
			
		} else {
			
			result.put("emailMathced", false);
			
		}
		
		return result;
		
	}
	
	public Map<String, Object> findMemberPw (Map<String, Object> findPwInfos) {
		
		String findPwId = findPwInfos.get("findPwId").toString();
		String findPwEmail = findPwInfos.get("findPwEmail").toString();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
		
		MemberVO memberById = dao.getMemberById(findPwId);
		
		if (memberById == null) {
			
			result.put("findResult", false);
			result.put("resultStatement", "<h1>존재하지 않는 아이디입니다.</h1>");
			
		} else {
			
			if (!findPwEmail.matches(regex)) {
				
				result.put("findResult", false);
				result.put("resultStatement", "<h1>올바르지 않은 이메일입니다.</h1>");
				
			} else {
				
				MemberVO memberByEmail = dao.getMemberByEmail(findPwEmail);
				
				if (memberByEmail == null) {
					
					result.put("findResult", false);
					result.put("resultStatement", "<h1>존재하지 않는 이메일입니다.</h1>");
					
				} else {
					
					if (memberById.getMemberIdx().toString().equals(memberByEmail.getMemberIdx().toString())) {
						
						result.put("findResult", true);
						result.put("memberIdx", memberById.getMemberIdx().toString());
						
					} else {
						
						result.put("findResult", false);
						result.put("resultStatement", "<h1>회원 정보가 일치하지 않습니다.</h1>");
						
					}
					
				}
				
			}
			
		}
		
		return result;
		
	}
	
	public boolean updateMemberPw (Map<String, Object> pwInfos) {
		
		String memberIdx = pwInfos.get("memberIdx").toString();
		String userPw = pwInfos.get("userPw").toString();
		
		if (memberIdx.isEmpty() || userPw.isEmpty()) {
			
			return false;
			
		} else {
			
			if (dao.updateMemberPw(pwInfos) == 1) {
				
				return true;
				
			} else {
				
				return false;
				
			}
			
		}
		
	}
	
}
