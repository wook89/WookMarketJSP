package temp;

import java.util.List;

import cart.CartItem;
import cart.CartService;
import cart.ListCartDAO;
import cart.WookCartService;

public class CartTest {
	public static void main(String[] args) {
		CartService service = new WookCartService(new ListCartDAO());
		List<CartItem> itemList;

		// C
		service.add(new CartItem(65, 8, 1));
//		service.add(new CartItem(5, 2));
//		// R
		itemList = service.listAll(65);
		for (CartItem item : itemList) {
			System.out.println(item.toString());
		}
//		// C
//		service.add(new CartItem(2, 5));
//		service.add(new CartItem(5, 2));
		// U
		service.update(1, 65, 8);
		itemList = service.listAll(65);
		for (CartItem item : itemList) {
			System.out.println("update = "+item.toString());
		}
//		if (service.clear()) {
//			System.out.println("Ã¥ ¾øÁö·Õ");
//		}
	}
}
