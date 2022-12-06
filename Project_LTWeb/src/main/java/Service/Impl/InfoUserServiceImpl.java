package Service.Impl;

import java.util.List;

import DAO.IInfoUserDao;
import DAO.Impl.InfoUserDaoImpl;
import Models.InfoUserModel;
import Service.IInfoUserService;

public class InfoUserServiceImpl implements IInfoUserService{

	IInfoUserDao infoUserDao = new InfoUserDaoImpl();
	@Override
	public void insert(InfoUserModel infoUser) {
		infoUserDao.insert(infoUser);
	}

	@Override
	public void edit(InfoUserModel infoUser) {
		infoUserDao.edit(infoUser);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InfoUserModel get(int id) {
		return infoUserDao.get(id);
	}

	@Override
	public InfoUserModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InfoUserModel> getAll() {
		return infoUserDao.getAll();
	}

	@Override
	public List<InfoUserModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoUserModel findById(int id) {
		return infoUserDao.findById(id);
	}

}
