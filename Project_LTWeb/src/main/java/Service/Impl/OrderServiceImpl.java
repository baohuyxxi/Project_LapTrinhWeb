package Service.Impl;

import java.util.List;

import DAO.IOrderDao;
import DAO.Impl.OrderDaoImpl;
import Models.OrdersModel;
import Service.IOrderService;

public class OrderServiceImpl implements IOrderService{

	IOrderDao orderDao = new OrderDaoImpl();
	@Override
	public void insert(OrdersModel order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(OrdersModel order) {
		orderDao.edit(order);
	}

	@Override
	public OrdersModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersModel> getAll() {
		// TODO Auto-generated method stub
		return orderDao.getAll();
	}

	@Override
	public List<OrdersModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
