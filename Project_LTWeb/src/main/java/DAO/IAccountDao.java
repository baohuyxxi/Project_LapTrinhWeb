package DAO;

import java.util.List;

import Models.AccountModel;


public interface IAccountDao {
	void insert(AccountModel account);
	void edit(AccountModel account);
	void delete(int id);
	AccountModel checkLogin(String username, String password);
	AccountModel get(int id);
	AccountModel getName(String name);
	List<AccountModel> getAll();
	List<AccountModel> search(String keyword);
	AccountModel findById(int id);
}
