package mapper;

import java.util.Map;

import vo.MemberVO;

public interface MemberMapper {
	
	public MemberVO getMemberById (String userId);
	
	public MemberVO getMemberByEmail (String userEmail);
	
	public int updateMemberPw (Map<String, Object> pwInfos);
	
	public int createMember (Map<String, Object> memberInfos);
	
}
