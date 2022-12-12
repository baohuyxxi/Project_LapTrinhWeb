package Service.Impl;

import java.util.List;

import DAO.IDeliveryDao;
import DAO.Impl.DeliveryDaoImpl;
import Models.DeliveryModel;
import Service.IDeliveryService;

public class DeliveryServiceImpl implements IDeliveryService{
	IDeliveryDao ideliverydao= new DeliveryDaoImpl();
	

	public void insert(DeliveryModel delivery) {
		ideliverydao.insert(delivery);
	}
	
	public void edit(DeliveryModel delivery) {
		ideliverydao.edit(delivery);
	}

	public void delete(int id) {
		ideliverydao.delete(id);
		
	}

	public DeliveryModel get(int id) {
		return ideliverydao.get(id);
	}

	public DeliveryModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DeliveryModel> getAll() {
		return ideliverydao.getAll();
	}

	public List<DeliveryModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public DeliveryModel findById(int id) {
		return ideliverydao.findById(id);
	}

	@Override
	public String getDeliveryIdTop1() {
		return ideliverydao.getDeliveryIdTop1();
	}

}
