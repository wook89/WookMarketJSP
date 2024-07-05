package book;

import java.util.List;

public interface BookService {
	 boolean regist(Book book);
	 boolean edit(Book book,String name, String author, int oldPrice);
	 boolean remove(int id);
	 List<Book> listAll();
	 Book read(int id);
}
