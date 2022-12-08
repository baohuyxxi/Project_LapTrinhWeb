package DAO;

import java.util.List;

import Models.CategoryModel;

public interface ICategoryDao {
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);

	CategoryModel getName(String name);

	List<CategoryModel> getAll();

	List<CategoryModel> search(String keyword);

	CategoryModel findById(int id);
	CategoryModel get(int id);
}
