package DAO;



import java.util.List;

import Models.CartItemModel;
public interface ICartItemDao {
	void insert(CartItemModel cartItem);

	void edit(CartItemModel cartItem);

	void delete(int id);

	CartItemModel get(int id);

	CartItemModel findById(int id);

	List<CartItemModel> search(String keyword);

	CartItemModel getName(String name);

	List<CartItemModel> getAll();
	
	CartItemModel findCartAndCountProductID(int userId);

	List<CartItemModel> getAllByCartId(int cartid);

}
