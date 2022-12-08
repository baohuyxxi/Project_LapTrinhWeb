package Service;

import java.util.List;

import Models.DeliveryModel;

public interface IDeliveryService {

	void insert(DeliveryModel delivery);

	void edit(DeliveryModel delivery);

	void delete(int id);

	DeliveryModel get(int id);

	List<DeliveryModel> getAll();

	List<DeliveryModel> search(String keyword);

	DeliveryModel findById(int id);
	
	
}
