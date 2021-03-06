package repository;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.MemberMapper;
import vo.MemberVO;

@Component
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		
		this.sessionTemplate = sessionTemplate;
		
	}
	
	public MemberVO getMemberById (String userId) {
		
		MemberMapper mapper = sessionTemplate.getMapper(MemberMapper.class);
		
		return mapper.getMemberById(userId);
		
	}
	
	public MemberVO getMemberByEmail (String userEmail) {
		
		MemberMapper mapper = sessionTemplate.getMapper(MemberMapper.class);
		
		return mapper.getMemberByEmail(userEmail);
		
	}
	
	public int updateMemberPw (Map<String, Object> pwInfos) {
		
		MemberMapper mapper = sessionTemplate.getMapper(MemberMapper.class);
		
		return mapper.updateMemberPw(pwInfos);
		
	}
	
	public int createMember (Map<String, Object> memberInfos) {
		
		MemberMapper mapper = sessionTemplate.getMapper(MemberMapper.class);
		
		return mapper.createMember(memberInfos);
		
	}
	
}
