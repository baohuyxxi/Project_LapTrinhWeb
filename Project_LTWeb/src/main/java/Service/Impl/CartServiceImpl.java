package Service.Impl;

import java.util.List;

import DAO.ICartDao;
import DAO.Impl.CartDaoImpl;
import Models.CartModel;
import Service.ICartService;


public class CartServiceImpl implements ICartService {
	ICartDao icartdao= new CartDaoImpl();
	

	public void insert(CartModel cart) {
		icartdao.insert(cart);
	}
	
	public void edit(CartModel cart) {
		icartdao.edit(cart);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public CartModel get(int id) {
		return icartdao.get(id);
	}

	public CartModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CartModel> getAll() {
		return icartdao.getAll();
	}

	public List<CartModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	public CartModel findById(int id) {
		return icartdao.findById(id);
	}

	@Override
	public String findCartIdByUserId(int userid) {
		return icartdao.findCartIdByUserId(userid);
	}

	@Override
	public String findDeliveryIdByCardId(int cardid) {
		return icartdao.findDeliveryIdByCardId(cardid);
	}
}
