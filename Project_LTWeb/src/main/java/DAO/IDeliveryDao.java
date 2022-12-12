package DAO;

import java.util.List;

import Models.DeliveryModel;

public interface IDeliveryDao {

	void insert(DeliveryModel delivery);

	void edit(DeliveryModel delivery);

	DeliveryModel get(int id);

	List<DeliveryModel> getAll();

	DeliveryModel findById(int id);

	DeliveryModel getName(String name);

	List<DeliveryModel> search(String keyword);

	void delete(int id);

	String getDeliveryIdTop1();


	
}
