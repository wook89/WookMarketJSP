package cart;

import java.util.List;

public interface CartDAO {
	//C
	int insert(CartItem item);
	//R
	CartItem select(int memberNo,int cartId);
	CartItem selectByBookId(int memberNo,int bookId);
	List<CartItem> selectByBookId(int bookId);
	List<CartItem> selectAll(int memberNo);
	//U
	int update(int cartId,int memberNo, int quantity);//장바구니 내에 업데이트 될 항목이 수량 뿐이라서
	//D
	int delete(int memberNo, int cartId);
	int deleteAll(int memberNo);
	int deleteByBookId(int bookId);
	
}
