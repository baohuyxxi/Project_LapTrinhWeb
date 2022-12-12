package Service;

import java.util.List;

import Models.ProductModel;

public interface IProductService {
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
	List<ProductModel> getAllByStoreId(int storeId);
	List<ProductModel> proTop3();

	List<ProductModel> findIdbyStore(int storeId);
	List<ProductModel> findProByAllId(int valueId, String columnId);
	ProductModel findByProductId(int id);
	String findStoreIdByProductId(int productId);
	ProductModel findMinSoldProduct(int storeId);

	int CountProductSold();
	int CountProduct();
}
