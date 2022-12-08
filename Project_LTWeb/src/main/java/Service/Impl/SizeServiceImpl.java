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
	
	public void edit(SizeModel size) {
		isizedao.edit(size);
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

	public SizeModel findById(int id) {
		return isizedao.findById(id);
	}
}
