package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBConnection {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;

	public JDBConnection() {
		// DB������ ���� ����
		final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String userid = "c##java";
		final String passwd = "1234";

		// DB ���� ��ü �����Ͽ� ��ȯ

		try {
			// JDBC ����̹� loading
			Class.forName(jdbcDriverClassName);

			// Connection ��ü ����
			conn = DriverManager.getConnection(url, userid, passwd);
			System.out.println("����Ŭ DB���� ����");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		}
	}
	
	public void close() {
			try {
				if(conn != null)conn.close();
				if(pstmt != null)pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
