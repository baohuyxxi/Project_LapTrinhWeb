package Service.Impl;

import java.util.List;

import DAO.ICategoryDao;
import DAO.Impl.CategoryDaoImpl;
import Models.CategoryModel;
import Service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	ICategoryDao icategorydao= new CategoryDaoImpl();
	

	public void insert(CategoryModel category) {
		icategorydao.insert(category);
	}
	
	public void edit(CategoryModel category) {
		icategorydao.edit(category);
	}

	public void delete(int id) {
		icategorydao.delete(id);
		
	}

	public CategoryModel get(int id) {
		return icategorydao.get(id);
	}

	public CategoryModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CategoryModel> getAll() {
		return icategorydao.getAll();
	}

	public List<CategoryModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	public CategoryModel findById(int id) {
		return icategorydao.findById(id);
	}
}
