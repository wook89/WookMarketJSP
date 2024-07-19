package cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapCartDAO implements CartDAO {
	
	private static HashMapCartDAO instance = null;
	
	private HashMap<Integer, CartItem> cartTable = new HashMap<>();
	private int cart_seq = 0;
	
	private HashMapCartDAO() {
		System.out.println("HashMapCartDAO객체가 생성되었습니다.");
	}
	
	public static HashMapCartDAO getInstance() {
		if(instance == null) {
			instance = new HashMapCartDAO();
		}
		return instance;
	}
	@Override
	public int insert(CartItem item) {
		int result = 0;
		item.setId(++cart_seq);
		cartTable.put(cart_seq, item);
		result++;
		return result;
	}

	@Override
	public CartItem select(int memberNo, int cartId) {
		CartItem item = cartTable.get(cartId);
		
		if(cartTable.get(cartId).getMemberNo() == memberNo)
			return item;
		
		return null;
	}

	@Override
	public CartItem selectByBookId(int memberNo, int bookId) {
		List<CartItem> itemList = selectAll(memberNo);
		if(itemList.size() ==0) return null;
		for(CartItem item : itemList) {
			if(item.getBookId() == bookId) return item;
		}
		return null;
	}

	@Override
	public List<CartItem> selectByBookId(int bookId) {
		List<CartItem> itemList = new ArrayList<>();
		for(CartItem item : cartTable.values()) {
			if(item.getBookId() == bookId)
				itemList.add(item);
		}
		return itemList;
	}

	@Override
	public List<CartItem> selectAll(int memberNo) {
		List<CartItem> itemList = new ArrayList<>();
		for(CartItem item : cartTable.values()) {
			if(item.getMemberNo() == memberNo) {
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public int update(int cartId, int memberNo, int quantity) {
		CartItem item = cartTable.get(cartId);
		if(item == null) return 0;
		if(item.getMemberNo() != memberNo) return 0;
		item.setQuantity(quantity);
		return 1;
	}

	@Override
	public int delete(int memberNo, int cartId) {
		CartItem item = cartTable.get(cartId);
		if(item != null && item.getMemberNo()==memberNo) {
		cartTable.remove(cartId);
		return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(int memberNo) {
		int result =0;
		List<CartItem> itemList = selectAll(memberNo);
		for(CartItem item : itemList) {
			cartTable.remove(item.getId());
			result++;
		}
		return result;
	}

	@Override
	public int deleteByBookId(int bookId) {
		int result =0;
		List<CartItem> itemList = selectByBookId(bookId);
		for(CartItem item : itemList) {
			cartTable.remove(item.getId());
			result++;
		}
		return result;
	}

}
