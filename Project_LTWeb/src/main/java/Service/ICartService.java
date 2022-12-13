package Service;

import java.util.List;

import Models.CartModel;

public interface ICartService {
	void insert(CartModel cart);

	void edit(CartModel cart);

	void delete(int id);

	CartModel get(int id);

	List<CartModel> getAll();

	List<CartModel> search(String keyword);

	CartModel findById(int id);
	String findCartIdByUserId(int userid);
	String findDeliveryIdByCardId(int cardid);
	
}
