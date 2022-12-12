package Service.Impl;

import java.util.List;

import DAO.IAccountDao;
import DAO.Impl.AccountDaoImpl;
import Models.AccountModel;
import Service.IAccountService;

public class AccountServiceImpl implements IAccountService{

	IAccountDao accountDao = new AccountDaoImpl();
	@Override
	public void insert(AccountModel account) {
		accountDao.insert(account);
		
	}

	@Override
	public void edit(AccountModel account) {
		accountDao.edit(account);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountModel> getAll() {
		return accountDao.getAll();
	}

	@Override
	public List<AccountModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountModel findById(int id) {
		return accountDao.findById(id);
	}

	@Override
	public AccountModel checkLogin(String username, String password) {
		return accountDao.checkLogin(username, password);
	}

	@Override
	public List<AccountModel> getAllAccount() {
		// TODO Auto-generated method stub
		return accountDao.getAllAccount();
	}
	
}
