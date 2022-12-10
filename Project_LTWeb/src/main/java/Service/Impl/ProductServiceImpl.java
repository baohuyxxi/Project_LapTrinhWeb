package Service.Impl;

import java.util.List;

import DAO.IProductDao;
import DAO.Impl.ProductDaoImpl;
import Models.ProductModel;
import Service.IProductService;

public class ProductServiceImpl implements IProductService{

	IProductDao productDao = new ProductDaoImpl();
	@Override
	public void insert(ProductModel product) {
		productDao.insert(product);
		
	}

	@Override
	public void edit(ProductModel product) {
		productDao.edit(product);
		
	}
	
	
	
	
	@Override
	public void delete(int id) {
		productDao.delete(id);
		
	}

	@Override
	public ProductModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getAll() {
		return productDao.getAll();
	}
	
	@Override
	public List<ProductModel> proTop3() {
		return productDao.proTop3();
	}


	@Override
	public List<ProductModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel findById(int id) {
		return productDao.findById(id);
	}

	@Override
	public String findStoreIdByUserId(int userId) {
		return productDao.findStoreIdByUserId(userId);
	}

	@Override
	public List<ProductModel> findProByAllId(int valueId, String columnId) {
		return productDao.findProByAllId(valueId,columnId);
	}

	@Override
	public List<ProductModel> getAllByStoreId(int storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> findIdbyStore(int storeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
