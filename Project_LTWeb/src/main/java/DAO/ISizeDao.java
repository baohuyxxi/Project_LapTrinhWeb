package DAO;

import java.util.List;

import Models.SizeModel;

public interface ISizeDao {

	void insert(SizeModel size);

	void edit(SizeModel size);

	SizeModel get(int id);

	List<SizeModel> getAll();

	SizeModel findById(int id);

	SizeModel getName(String name);

	List<SizeModel> search(String keyword);

	void delete(int id);


	
}
