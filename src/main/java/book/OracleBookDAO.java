package book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBConnection;

public class OracleBookDAO implements BookDAO {

	@Override
	public Book selectBook(int id) {
		Book book = null;
		// DB join
		JDBConnection jdbc = new JDBConnection();
		// create SQL
		String sql = new StringBuilder().append("select * from book where id=?").toString();

		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, id);

			jdbc.rs = jdbc.pstmt.executeQuery();
			if (jdbc.rs.next()) {
				book = new Book(jdbc.rs.getInt("id"),
								jdbc.rs.getString("name"),
								jdbc.rs.getString("author"),
								jdbc.rs.getInt("price_won"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return book;
	}
	@Override
	public List<Book> selectBookAll() {
		List<Book> bookList = new ArrayList<>();
		// DB연결
		JDBConnection jdbc = new JDBConnection();

		// SQL문 만들기
		String sql = "SELECT * FROM BOOK";

		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			jdbc.rs = jdbc.pstmt.executeQuery();
			while (jdbc.rs.next()) {
				Book book = new Book(jdbc.rs.getInt("id"), jdbc.rs.getString("name"), jdbc.rs.getString("author"),
						jdbc.rs.getInt("price_won"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return bookList;
	}
	@Override
	public int insertBook(Book book) {
		// DB join
		JDBConnection jdbc = new JDBConnection();
		// create SQL
		String sql = new StringBuilder().append("insert into book(id,name,author,price_won)")
				.append("values(book_seq.nextval, ? , ? , ?)").toString();
		int result = 0;
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, book.getName());
			jdbc.pstmt.setString(2, book.getAuthor());
			jdbc.pstmt.setInt(3, book.getPrice());

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
	public int updateBook(Book book) {
		JDBConnection jdbc = new JDBConnection();
		int result = 0;
		String sql = new StringBuilder().append("update book ").append("set name = ?,author=?,price_won = ? ")
				.append("where id=?").toString();
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, book.getName());
			jdbc.pstmt.setString(2, book.getAuthor());
			jdbc.pstmt.setInt(3, book.getPrice());
			jdbc.pstmt.setInt(4, book.getId());

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
	public int deleteBook(int id) {
		int result = 0;
		JDBConnection jdbc = new JDBConnection();
		String sql = "delete book where id = ?";

		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, id);
			result = jdbc.pstmt.executeUpdate();

			System.out.println(result + "행이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;
	}
}
