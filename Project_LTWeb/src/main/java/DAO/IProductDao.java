package DAO;

import java.util.List;

import Models.ProductModel;

public interface IProductDao {
	void insert(ProductModel product);
	void edit(ProductModel product);
	void delete(int id);
	ProductModel get(int id);
	ProductModel getName(String name);
	List<ProductModel> getAll();
	List<ProductModel> search(String keyword);
	ProductModel findById(int id);
	ProductModel findTop1Product(int storeId);
	String findStoreIdByUserId(int userId);
	List<ProductModel> findProByAllId(int storeId, String columnId);
	List<ProductModel> proTop3();
	List<ProductModel> getAllByStoreId(int storeId);
	ProductModel findByProductId(int id);
	String findStoreIdByProductId(int productId);
	ProductModel findMinSoldProduct(int storeId);
	int CountProductSold();
	int CountProduct();
}
