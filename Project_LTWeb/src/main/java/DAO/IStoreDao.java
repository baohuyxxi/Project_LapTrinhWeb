package DAO;

import java.util.List;

import Models.StoreModel;

public interface IStoreDao {
	void insert(StoreModel store);
	void edit(StoreModel store);
	void editByAdmin(StoreModel store);
	void delete(int id);
	StoreModel get(int id);
	StoreModel getName(String name);
	List<StoreModel> getAll();
	List<StoreModel> getAllStoreAD();
	List<StoreModel> search(String keyword);
	StoreModel findById(int id);
	List<StoreModel> getAllInfo();
	int CountStore();
	
}
