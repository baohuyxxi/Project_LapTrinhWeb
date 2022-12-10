package Service.Impl;

import java.util.List;

import DAO.IImageDao;
import DAO.Impl.ImageDaoImpl;
import Models.ImagesModel;
import Service.IImageService;

public class ImageServiceImpl implements IImageService{

	IImageDao imageDao = new ImageDaoImpl();
	@Override
	public void edit(ImagesModel image) {
		imageDao.insert(image);
		
	}

	@Override
	public void delete(int id) {
		imageDao.delete(id);
		
	}

	@Override
	public ImagesModel get(int id) {
		return null;
	}

	@Override
	public ImagesModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImagesModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImagesModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImagesModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ImagesModel image) {
		imageDao.insert(image);
		
	}

	@Override
	public List<ImagesModel> getAllProductId(int productId) {
		return imageDao.getAllProductId(productId);
	}

}
