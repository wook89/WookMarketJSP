package book;

import java.util.List;

public interface BookDAO {
	
	public Book selectBook(int id);
	public List<Book> selectBookAll();
	public int insertBook(Book book);
	public int updateBook(Book book);
	public int deleteBook(int id);
}
