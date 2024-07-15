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
	int update(int cartId,int memberNo, int quantity);//��ٱ��� ���� ������Ʈ �� �׸��� ���� ���̶�
	//D
	int delete(int memberNo, int cartId);
	int deleteAll(int memberNo);
	int deleteByBookId(int bookId);
	
}
