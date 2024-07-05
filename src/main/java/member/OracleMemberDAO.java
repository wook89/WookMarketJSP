package member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import common.JDBConnection;

public class OracleMemberDAO implements MemberDAO {

	@Override
	public Member selectMember(int no) {

		Member member = null;
		// DB연결
		JDBConnection jdbc = new JDBConnection();

		// sql문 만들기
		String sql = new StringBuilder().append("SELECT * FROM MEMBER WHERE NO = ?").toString();

		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, no);

			jdbc.rs = jdbc.pstmt.executeQuery();
			if (jdbc.rs.next()) {
				member = new Member(jdbc.rs.getInt("no"), jdbc.rs.getString("id"), jdbc.rs.getString("password"),
						jdbc.rs.getString("nickname"), jdbc.rs.getDate("regdate"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbc.close();
		return member;
	}

	@Override
	public Member selectMember(String id, String pw) {
		Member member = null;
		// DB연결
		JDBConnection jdbc = new JDBConnection();

		// sql문 만들기
		String sql = new StringBuilder().append("SELECT * FROM MEMBER WHERE id = ?" + "and password = ?").toString();

		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, id);
			jdbc.pstmt.setString(2, pw);
			jdbc.rs = jdbc.pstmt.executeQuery();
			if (jdbc.rs.next()) {
				member = new Member(jdbc.rs.getInt("no"), jdbc.rs.getString("id"), jdbc.rs.getString("password"),
						jdbc.rs.getString("nickname"), jdbc.rs.getDate("regdate"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbc.close();
		return member;

	}

	@Override
	public List<Member> selectMemberAll() {
		// DB연결
		JDBConnection jdbc = new JDBConnection();

		/// SQL문 만들기
		String sql = "SELECT * FROM MEMBER";

		// 결과를 저장할 List<> 객체를 생성
		List<Member> memberList = new ArrayList<>();
		try {
			// PreaareStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();
			while (jdbc.rs.next()) {
				Member member = new Member(jdbc.rs.getInt("no"), jdbc.rs.getString("id"), jdbc.rs.getString("password"),
						jdbc.rs.getString("nickname"), jdbc.rs.getDate("regDate"));
				memberList.add(member);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return memberList;
	}

	@Override
	public int insertMember(Member member) {
		// DB 연결
		JDBConnection jdbc = new JDBConnection();

		// sql문 만들기
		String sql = new StringBuilder().append("insert into member (no, id, password, nickname, regdate)")
				.append("values (member_seq.nextval, ? , ? , ? , sysdate)").toString();
		int result = 0;
		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			// SQL문 매개변수에 값 추가
			jdbc.pstmt.setString(1, member.getId());
			jdbc.pstmt.setString(2, member.getPassword());
			jdbc.pstmt.setString(3, member.getNickname());
			// SQL문 실행
			result = jdbc.pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(result + "행이 추가되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;
	}

	@Override
	public int updateMember(Member member) {
		// DB 연결
		JDBConnection jdbc = new JDBConnection();

		// sql문
		String sql = new StringBuilder().append("update member ").append("set password=?, nickname=? ")
				.append("where no=? ").toString();

		// PrepareStatement 객체 생성
		int result = 0;
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, member.getPassword());
			jdbc.pstmt.setString(2, member.getNickname());
			jdbc.pstmt.setInt(3, member.getNo());

			// sql 실행
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 수정 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;
	}

	@Override
	public int updateAdditionalInfo(Member member) {
		// DB 연결
		JDBConnection jdbc = new JDBConnection();

		// sql문
		String sql = new StringBuilder().append("update member ").append("set mobile=?, email=?,address=? ")
				.append("where no=? ").toString();

		// PrepareStatement 객체 생성
		int result = 0;
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, member.getMobile());
			jdbc.pstmt.setString(2, member.getEmail());
			jdbc.pstmt.setString(3, member.getAddress());
			jdbc.pstmt.setInt(4, member.getNo());

			// sql 실행
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 수정 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;
	}
	@Override
	public int deleteMember(int no) {
		int result = 0;
		// DB연결
		JDBConnection jdbc = new JDBConnection();
		// SQL문 생성
		String sql = "delete member where no=? ";
		try {
			// PrepareStatement객체 생성 <- SQL문 삽입
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			// 파라미터 set
			jdbc.pstmt.setInt(1, no);
			// 실행
			result = jdbc.pstmt.executeUpdate();
			// 결과처리
			System.out.println(result + "행이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 닫기
			jdbc.close();
		}
		return result;
	}
}
