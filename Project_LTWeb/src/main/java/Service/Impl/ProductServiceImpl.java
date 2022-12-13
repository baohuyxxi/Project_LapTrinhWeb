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
	public List<ProductModel> findProByString(String string) {
		return productDao.findProByString(string);
	}

	
	@Override
	public List<ProductModel> getAllByStoreId(int storeId) {
		return productDao.getAllByStoreId(storeId);
	}

	@Override
	public List<ProductModel> findIdbyStore(int storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel findByProductId(int id) {
		return productDao.findByProductId(id);
	}

	@Override
	public String findStoreIdByProductId(int productId) {
		return productDao.findStoreIdByProductId(productId);
	}

	@Override
	public ProductModel findTop1Product(int storeId) {
		return productDao.findTop1Product(storeId);
	}

	@Override
	public ProductModel findMinSoldProduct(int storeId) {
		// TODO Auto-generated method stub
		return productDao.findMinSoldProduct(storeId);
	}

	@Override
	public int CountProductSold() {
		// TODO Auto-generated method stub
		return productDao.CountProductSold();
	}

	@Override
	public int CountProduct() {
		// TODO Auto-generated method stub
		return productDao.CountProduct();
	}
	public String findProductIdByCardId(int cardid) {
		return productDao.findProductIdByCardId(cardid);

	}

	@Override
	public void editSold(ProductModel product) {
		productDao.editSold(product);
		
	}
}
