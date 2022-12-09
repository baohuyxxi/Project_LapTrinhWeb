package DAO;

import java.util.List;

import Models.OrderItemModel;
import Models.OrdersModel;

public interface IOrderItemDao {
	void insert(OrderItemModel orderItem);
	void delete(int id);
	OrdersModel get(int id);
	List<OrderItemModel> getAll(int orderId);
	List<OrderItemModel> search(String keywork);
	OrderItemModel findByOrderId(int orderId);
}
