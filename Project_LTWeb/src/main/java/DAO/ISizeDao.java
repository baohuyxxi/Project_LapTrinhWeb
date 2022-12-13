package DAO;

import java.util.List;

import Models.SizeModel;

public interface ISizeDao {

	void insert(SizeModel size);

	void edit(SizeModel size, String name_old);

	SizeModel get(int id);

	List<SizeModel> getAll();

	SizeModel findByIdAndSize(String product_id, String size_name);

	SizeModel getName(String name);

	List<SizeModel> search(String keyword);

	void delete(int id);

	List<SizeModel> getAllProductId(int productId);

	void editSize(SizeModel size_new);


	
}
