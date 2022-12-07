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
}
