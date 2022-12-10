package Service;

import java.util.List;

import Models.ImagesModel;

public interface IImageService {
	void edit(ImagesModel image);

	void delete(int id);

	ImagesModel get(int id);

	ImagesModel getName(String name);

	List<ImagesModel> getAll();

	List<ImagesModel> search(String keyword);

	ImagesModel findById(int id);

	void insert(ImagesModel image);
	
	List<ImagesModel> getAllProductId(int productId);
}
