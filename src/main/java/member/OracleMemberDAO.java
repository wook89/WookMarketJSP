package member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import common.JDBConnection;

public class OracleMemberDAO implements MemberDAO {

	@Override
	public Member selectMember(int no) {

		Member member = null;
		// DB����
		JDBConnection jdbc = new JDBConnection();

		// sql�� �����
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
		// DB����
		JDBConnection jdbc = new JDBConnection();

		// sql�� �����
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
		// DB����
		JDBConnection jdbc = new JDBConnection();

		/// SQL�� �����
		String sql = "SELECT * FROM MEMBER";

		// ����� ������ List<> ��ü�� ����
		List<Member> memberList = new ArrayList<>();
		try {
			// PreaareStatement ��ü ����
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			// SQL�� ����
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
		// DB ����
		JDBConnection jdbc = new JDBConnection();

		// sql�� �����
		String sql = new StringBuilder().append("insert into member (no, id, password, nickname, regdate)")
				.append("values (member_seq.nextval, ? , ? , ? , sysdate)").toString();
		int result = 0;
		try {
			// PreparedStatement ��ü ����
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			// SQL�� �Ű������� �� �߰�
			jdbc.pstmt.setString(1, member.getId());
			jdbc.pstmt.setString(2, member.getPassword());
			jdbc.pstmt.setString(3, member.getNickname());
			// SQL�� ����
			result = jdbc.pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(result + "���� �߰��Ǿ����ϴ�.");
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
		// DB ����
		JDBConnection jdbc = new JDBConnection();

		// sql��
		String sql = new StringBuilder().append("update member ").append("set password=?, nickname=? ")
				.append("where no=? ").toString();

		// PrepareStatement ��ü ����
		int result = 0;
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, member.getPassword());
			jdbc.pstmt.setString(2, member.getNickname());
			jdbc.pstmt.setInt(3, member.getNo());

			// sql ����
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "���� ���� �Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;
	}

	@Override
	public int updateAdditionalInfo(Member member) {
		// DB ����
		JDBConnection jdbc = new JDBConnection();

		// sql��
		String sql = new StringBuilder().append("update member ").append("set mobile=?, email=?,address=? ")
				.append("where no=? ").toString();

		// PrepareStatement ��ü ����
		int result = 0;
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, member.getMobile());
			jdbc.pstmt.setString(2, member.getEmail());
			jdbc.pstmt.setString(3, member.getAddress());
			jdbc.pstmt.setInt(4, member.getNo());

			// sql ����
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "���� ���� �Ǿ����ϴ�.");
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
		// DB����
		JDBConnection jdbc = new JDBConnection();
		// SQL�� ����
		String sql = "delete member where no=? ";
		try {
			// PrepareStatement��ü ���� <- SQL�� ����
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			// �Ķ���� set
			jdbc.pstmt.setInt(1, no);
			// ����
			result = jdbc.pstmt.executeUpdate();
			// ���ó��
			System.out.println(result + "���� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ڿ� �ݱ�
			jdbc.close();
		}
		return result;
	}
}
