package mapper;

import java.util.Map;

import vo.MemberVO;

public interface MemberMapper {
	
	public MemberVO getMemberById (String userId);
	
	public String createMemberIdx ();
	
	public int createMember (Map<String, Object> memberInfos);
	
}
