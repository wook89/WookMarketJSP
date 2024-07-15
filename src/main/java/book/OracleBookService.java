package book;

import java.util.List;

import cart.CartItem;
import cart.CartService;
import cart.HashMapCartDAO;
import cart.WookCartService;

public class OracleBookService implements BookService {
	private BookDAO bookDao;

	public OracleBookService(BookDAO bookDao) {
		this.bookDao = bookDao;
	}
	@Override
	public boolean regist(Book book) {
		return bookDao.insertBook(book) == 1;
	}
	@Override
	public boolean edit(Book book, String name, String author, int oldPrice) {
	return bookDao.updateBook(book) ==1;
	}
	@Override
	public boolean remove(int id) {
		if(bookDao.selectBook(id) == null) return false;
		
		CartService cartService = new WookCartService(new HashMapCartDAO());
		List<CartItem> itemList = cartService.readByBookId(id);
		System.out.println(itemList.size());
		if(itemList.size() > 0) {
			 cartService.removeByBookId(id);
		}
		int result = bookDao.deleteBook(id);
		return (result==1) ? true : false;

	}
	@Override
	public List<Book> listAll() {
		return bookDao.selectBookAll();
	}
	@Override
	public Book read(int id) {
		return bookDao.selectBook(id);
	}
}
