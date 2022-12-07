package Service;

import java.util.List;

import Models.OrdersModel;

public interface IOrderService {
	void insert(OrdersModel order);
	void edit(OrdersModel order);
	OrdersModel get(int id);
	List<OrdersModel> getAll();
	List<OrdersModel> search(String keyword);
	OrdersModel findById(int id);
}
