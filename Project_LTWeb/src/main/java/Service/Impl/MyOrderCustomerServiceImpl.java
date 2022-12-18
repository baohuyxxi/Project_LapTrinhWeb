package Service.Impl;

import java.util.List;

import DAO.IMyOrderCustomerDao;
import DAO.Impl.MyOrderCustomerDaoImpl;
import Models.OrderUserModel;
import Service.IMyOrderCustomerService;

public class MyOrderCustomerServiceImpl implements IMyOrderCustomerService{

	IMyOrderCustomerDao myOrderCustomerDao = new MyOrderCustomerDaoImpl();
	@Override
	public List<OrderUserModel> myorder(int userid, int status) {
		return myOrderCustomerDao.myorder(userid, status);
	}

}
