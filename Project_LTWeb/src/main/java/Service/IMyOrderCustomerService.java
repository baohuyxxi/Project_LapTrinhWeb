package Service;

import java.util.List;

import Models.OrderUserModel;

public interface IMyOrderCustomerService {
	List<OrderUserModel> myorder(int userid, int status);
}
