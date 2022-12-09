package Service.Impl;

import java.util.List;

import DAO.ISizeDao;
import DAO.Impl.SizeDaoImpl;
import Models.SizeModel;
import Service.ISizeService;

public class SizeServiceImpl implements ISizeService{
	ISizeDao isizedao= new SizeDaoImpl();
	

	public void insert(SizeModel size) {
		isizedao.insert(size);
	}
	
	public void edit(SizeModel size, String name_old) {
		isizedao.edit(size,name_old);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public SizeModel get(int id) {
		return isizedao.get(id);
	}

	public SizeModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SizeModel> getAll() {
		return isizedao.getAll();
	}

	public List<SizeModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	public SizeModel findByIdAndSize(String product_id, String size_name) {
		return isizedao.findByIdAndSize(product_id,size_name);
	}

	@Override
	public List<SizeModel> getAllProductId(int productId) {
		return isizedao.getAllProductId(productId);
	}
}
