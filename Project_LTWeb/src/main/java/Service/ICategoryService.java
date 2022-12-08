package Service;

import java.util.List;

import Models.CategoryModel;

public interface ICategoryService {
	void insert(CategoryModel category);

	void edit(CategoryModel category);

	void delete(int id);

	CategoryModel get(int id);

	List<CategoryModel> getAll();

	List<CategoryModel> search(String keyword);

	CategoryModel findById(int id);
	
}
