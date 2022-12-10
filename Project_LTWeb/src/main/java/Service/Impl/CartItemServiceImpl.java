package Service.Impl;

import java.util.List;

import DAO.ICartItemDao;
import DAO.Impl.CartItemDaoImpl;
import Models.CartItemModel;
import Service.ICartItemService;

public class CartItemServiceImpl implements ICartItemService{

	ICartItemDao cartItemDao = new CartItemDaoImpl();
	@Override
	public void insert(CartItemModel cartItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(CartItemModel cartItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartItemModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItemModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItemModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItemModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItemModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItemModel findCartAndCountProductID(int userId) {
		// TODO Auto-generated method stub
		return cartItemDao.findCartAndCountProductID(userId);
	}

}
