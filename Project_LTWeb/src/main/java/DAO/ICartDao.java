package DAO;

import java.util.List;

import Models.CartModel;

public interface ICartDao {

	void insert(CartModel cart);

	void edit(CartModel cart);

	void delete(int id);

	CartModel get(int id);

	CartModel getName(String name);

	List<CartModel> getAll();

	List<CartModel> search(String keyword);

	CartModel findById(int id);

	String findCartIdByUserId(int userid);

	String findDeliveryIdByCardId(int cardid);

}
