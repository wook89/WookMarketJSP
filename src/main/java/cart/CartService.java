package cart;

import java.util.List;

public interface CartService {
	
	boolean add(CartItem item);
	List<CartItem> readByBookId(int book_id);
	//CartItem readByBookId(int loggedMemberNo, int book_id);
	List<CartItem> listAll(int loggedMemberNo);	
	boolean update(int cartId,int loggedMemberNo,int quantity);
	boolean remove(int cartId,int loggedMemberNo);
	boolean removeByBookId(int loggedMemberNo);
	boolean clear(int loggedMemberNo);
	
}
