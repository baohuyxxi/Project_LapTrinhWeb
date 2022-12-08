package Service.Impl;

import java.util.List;

import DAO.IOrderItemDao;
import DAO.Impl.OrderItemDaoImpl;
import Models.OrderItemModel;
import Models.OrdersModel;
import Service.IOrderItemService;

public class OrderItemServiceImpl implements IOrderItemService{
	
	IOrderItemDao orderItemDao = new OrderItemDaoImpl();
	@Override
	public void insert(OrderItemModel orderItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrdersModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItemModel> getAll(int orderId) {
		// TODO Auto-generated method stub
		return orderItemDao.getAll(orderId);
	}

	@Override
	public List<OrderItemModel> search(String keywork) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItemModel findByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
