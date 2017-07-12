package vo;

/*

MEMBER

MEMBER_IDX
MEMBER_ID
MEMBER_PW
MEMBER_EMAIL
MEMBER_TYPE

 */

public class MemberVO {
	
	private String memberIdx;
	private String memberId;
	private String memberPw;
	private String memberEmail;
	private String memberType;
	
	public MemberVO () {}
	
	public MemberVO (String memberId, String memberPw, String memberEmail, String memberType) {
		
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberEmail = memberEmail;
		this.memberType = memberType;
		
	}
	
	public String getMemberIdx() {
		
		return memberIdx;
		
	}
	
	public void setMemberIdx(String memberIdx) {
		
		this.memberIdx = memberIdx;
		
	}
	
	public String getMemberId() {
		
		return memberId;
		
	}
	
	public void setMemberId(String memberId) {
		
		this.memberId = memberId;
		
	}
	
	public String getMemberPw() {
		
		return memberPw;
		
	}
	
	public void setMemberPw(String memberPw) {
		
		this.memberPw = memberPw;
		
	}
	
	public String getMemberEmail() {
		
		return memberEmail;
		
	}
	
	public void setMemberEmail(String memberEmail) {
		
		this.memberEmail = memberEmail;
		
	}
	
	public String getMemberType() {
		
		return memberType;
		
	}
	
	public void setMemberType(String memberType) {
		
		this.memberType = memberType;
		
	}
	
	@Override
	public String toString() {
		
		return "MEMBER[IDX:"+this.memberIdx+"/ID:"+this.memberId+"/PW:"+this.memberPw+"/EMAIL:"+this.memberEmail+"/TYPE:"+this.memberType+"]";
		
	}
	
}
