package member;

import java.util.Date;

public class Member {
	private int no;//회원번호
	private String id;
	private String password;
	private String nickname;
	private Date regdate;
	private String mobile;
	private String email;
	private String address;
	
	public Member() {}
	public Member(int no, String id, String password, String nickname,Date regDate) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.regdate = regDate;
		
	}
	public Member(String id, String password, String nickname) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", password=" + password + ", nickname=" + nickname + ", regdate="
				+ regdate + "]";
	}
	
}
