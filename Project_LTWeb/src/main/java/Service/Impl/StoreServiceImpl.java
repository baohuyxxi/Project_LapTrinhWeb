package Service.Impl;

import java.util.List;

import DAO.IStoreDao;
import DAO.Impl.StoreDaoImpl;
import Models.StoreModel;
import Service.IStoreService;

public class StoreServiceImpl implements IStoreService{
	IStoreDao storeDao = new StoreDaoImpl();
	
	@Override
	public void insert(StoreModel store) {
		storeDao.insert(store);
	}

	@Override
	public void edit(StoreModel store) {
		storeDao.edit(store);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StoreModel get(int id) {
		return storeDao.get(id);
	}

	@Override
	public StoreModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreModel> getAll() {
		
		return storeDao.getAll();
	}

	@Override
	public List<StoreModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreModel findById(int id) {
		return storeDao.findById(id);
	}

	public List<StoreModel> getAllInfo(int valueId, String columnId ) {
		
		return storeDao.getAllInfo(valueId,columnId);
	}

	@Override
	public List<StoreModel> getAllStoreAD() {
		return storeDao.getAllStoreAD();
	}

	@Override
	public void editByAdmin(StoreModel store) {
		storeDao.editByAdmin(store);
		
	}

	@Override
	public int CountStore() {
		return storeDao.CountStore();
	}

}
