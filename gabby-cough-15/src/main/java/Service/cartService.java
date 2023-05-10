package Service;

import java.util.List;

import Entity.Cart;

public interface cartService {
	Cart addCart (Cart Cart);
	Cart updateCart(Cart Cart);
	Cart cancelCart(int CartId); 
	List<Cart> showAllCarts();
}
