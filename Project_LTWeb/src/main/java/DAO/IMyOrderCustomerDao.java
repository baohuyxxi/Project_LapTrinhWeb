package DAO;

import java.util.List;

import Models.OrderUserModel;

public interface IMyOrderCustomerDao {
	List<OrderUserModel> myorder(int userid);
}
