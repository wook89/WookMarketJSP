package cart;

import java.util.ArrayList;
import java.util.List;

public class WookCartService implements CartService {
	CartDAO cartDao;
	
	public WookCartService(CartDAO cartDao) {
		this.cartDao = cartDao;
	}
	
	@Override
	public boolean add(CartItem item) {
		if(item == null)return false;
		
		int result = 0;
		CartItem inItem = cartDao.selectByBookId(item.getMemberNo(),item.getBookId());
		if(inItem ==null) {
		result =cartDao.insert(item);
		}else {
			int quantity = item.getQuantity() + inItem.getQuantity();
			
			result = cartDao.update(inItem.getId(),item.getMemberNo(), inItem.getQuantity()+1);
		}
		return result ==1?true:false;
	}

	@Override
	public List<CartItem> listAll(int loggedMemberNo) {
		return cartDao.selectAll(loggedMemberNo);
	}

	@Override
	public boolean update(int cartId,int loggedMemberNo, int quantity) {
		int result = cartDao.update(cartId,loggedMemberNo, quantity);
		return result==1?true:false;
	}

	@Override
	public boolean remove(int cartId,int loggedMemberNo) {
		int result = cartDao.delete(cartId,loggedMemberNo);
		return result==1?true:false;
	}

	@Override
	public boolean clear(int loggedMemberNo) {
		int result =cartDao.deleteAll(loggedMemberNo);
		
		return result>0?true:false;
	}

	@Override
	public List<CartItem> readByBookId(int book_id) {
			List<CartItem> itemList = new ArrayList<>();
		return cartDao.selectByBookId(book_id);
	}

	@Override
	public boolean removeByBookId(int loggedMemberNo) {
		int result = cartDao.deleteByBookId(loggedMemberNo);
		return result==1?true:false;
	}
	
	

}
