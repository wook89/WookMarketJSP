package member;

import java.util.List;

public interface MemberDAO {
	public Member selectMember(int no);
	public Member selectMember(String id, String pw);
	public List<Member> selectMemberAll();
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int updateAdditionalInfo(Member member);
	public int deleteMember(int no);
}
