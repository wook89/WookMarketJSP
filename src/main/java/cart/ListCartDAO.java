package cart;

import java.util.LinkedList;
import java.util.List;

public class ListCartDAO implements CartDAO {

	static List<CartItem> itemList = new LinkedList<>();
	static int cart_seq = 0;

	@Override
	public int insert(CartItem item) {
		int result = 0;
		item.setId(++cart_seq);
		if (itemList.add(item))
			result = 1;
		return result;
	}

	@Override
	public CartItem select(int memberNo,int id) {
		for (CartItem item : itemList)
			if (item.getId() == id) {
				return item;
			}
		return null;
	}

	@Override
	public CartItem selectByBookId(int memberNo,int bookId) {
		for (CartItem item : itemList) {
			if (item.getBookId() == bookId && item.getMemberNo() == memberNo)
				return item;
		}
		return null;
	}

	@Override
	public List<CartItem> selectAll(int memberNo) {
		List<CartItem> resultList = new LinkedList<CartItem>();
		for(CartItem item : itemList) {
			if(item.getMemberNo() == memberNo) {
				resultList.add(item);
			}
		}
		return resultList;
	}

	@Override
	public int update(int id,int memberNo, int quantity) {
		int result = 0;
		CartItem item = select(memberNo,id);
		if (item != null) {
			System.out.println("update ("+id+")"+quantity);
			item.setQuantity(quantity);
			result = 1;
		}
		return result;
	}

	@Override
	public int delete(int memberNo,int id) {
		int result = 0;

		CartItem item = select(memberNo,id);
		if (item != null && itemList.remove(item)) {
			result = 1;
		}
		return result;
	}

	@Override
	public int deleteAll(int memberNo) {
		int result = 0;
		for(CartItem item : itemList) {
			if(item.getMemberNo() == memberNo) {
				itemList.remove(item);
				result++;
			}
		}
		return result;
	}

	@Override
	public List<CartItem> selectByBookId(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByBookId(int loggedMemberNo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
