package Service.Impl;

import java.io.File;
import java.sql.Date;
import java.util.List;

import DAO.IInfoUserDao;
import DAO.Impl.InfoUserDaoImpl;
import Models.AccountModel;
import Models.InfoUserModel;
import Service.IInfoUserService;

public class InfoUserServiceImpl implements IInfoUserService{

	IInfoUserDao infoUserDao = new InfoUserDaoImpl();
	@Override
	public void insert(InfoUserModel infoUser) {
		infoUserDao.insert(infoUser);
	}

	@Override
	public void edit(InfoUserModel newinfoUser) {
		InfoUserModel oldUser = infoUserDao.get(newinfoUser.getId());
		oldUser.setName(newinfoUser.getName());
		oldUser.setSlug(newinfoUser.getSlug());
		oldUser.setEmail(newinfoUser.getEmail());
		oldUser.setPhone(newinfoUser.getPhone());
		oldUser.setAddress(newinfoUser.getAddress());
		oldUser.setUpdatedAt(new Date(System.currentTimeMillis()));
		
		if (newinfoUser.getAvatar() != null) {
			// XOA ANH CU DI
			String fileName = oldUser.getAvatar();
			final String dir = "D://HCMUTE/HK1_2022_2023/LTWeb/DoAn/Project_LapTrinhWeb/Project_LTWeb/src/main/webapp/upload";
			File file = new File(dir + "/user" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldUser.setAvatar(newinfoUser.getAvatar());
		}
		infoUserDao.edit(newinfoUser);
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
