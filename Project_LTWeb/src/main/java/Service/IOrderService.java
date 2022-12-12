package Service;

import java.math.BigDecimal;
import java.util.List;

import Models.OrdersModel;

public interface IOrderService {
	void insert(OrdersModel order);
	void edit(OrdersModel order);
	OrdersModel get(int id);
	List<OrdersModel> getAll();
	List<OrdersModel> search(String keyword);
	List<OrdersModel> getAllOfStore(int storeId);
	OrdersModel findById(int id);
	BigDecimal totalSales(int storeId);
	int CountOrder();
}
