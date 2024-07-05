package book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBConnection;

public interface BookDAO {
	
	public Book selectBook(int id);
	public List<Book> selectBookAll();
	public int insertBook(Book book);
	public int updateBook(Book book);
	public int deleteBook(int id);
}
