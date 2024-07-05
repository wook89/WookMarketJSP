package member;

import java.util.List;

public class OracleMemberService implements MemberService {
	private MemberDAO memberDao;

	public OracleMemberService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public boolean editAdditionInfo(int No, String mobile, String email, String address) {
		Member member = new Member();
		member.setNo(No);
		member.setMobile(mobile);
		member.setEmail(email);
		member.setAddress(address);
		return memberDao.updateAdditionalInfo(member)==1 ? true:false;
	}

	@Override
	public boolean regist(Member member) {
		int result = memberDao.insertMember(member);
		return (result == 1) ? true : false;

	}

	@Override
	public Member read(int no) {
		Member member = memberDao.selectMember(no);
		return member;
	}

	@Override
	public List<Member> listAll() {
		List<Member> memberList = memberDao.selectMemberAll();
		return memberList;
	}

	@Override
	public boolean edit(Member member, String oldPassword) {
		if (member == null)
			return false;
		if (oldPassword == null)
			return false;

		int result = 0;

		Member memInfo = memberDao.selectMember(member.getNo());
		if (oldPassword.equals(memInfo.getPassword())) {
			result = memberDao.updateMember(member);
		}
		return (result == 1) ? true : false;
	}

	@Override
	public boolean remove(int no) {
		if(memberDao.selectMember(no)==null) {
			return false;
		}
		int result = memberDao.deleteMember(no);
		return result==1 ? true:false;
	}

	@Override
	public Member login(String id, String pw) {
		return memberDao.selectMember(id,pw);
	}

}
