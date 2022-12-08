package Service;

import java.util.List;

import Models.SizeModel;

public interface ISizeService {
	void insert(SizeModel size);
	void edit(SizeModel size);
	void delete(int id);
	SizeModel get(int id);
	SizeModel getName(String name);
	List<SizeModel> getAll();
	List<SizeModel> search(String keyword);
	SizeModel findById(int id);
}
