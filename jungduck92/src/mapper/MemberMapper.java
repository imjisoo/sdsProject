package mapper;

import java.util.Map;

import vo.MemberVO;

public interface MemberMapper {
	
	public MemberVO getMemberById (String userId);
	
	public int createMember (Map<String, Object> memberInfos);
	
}
