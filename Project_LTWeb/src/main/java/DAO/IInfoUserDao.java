package DAO;

import java.util.List;

import Models.InfoUserModel;


public interface IInfoUserDao {
	void insert(InfoUserModel infoUser);
	void edit(InfoUserModel infoUser);
	void delete(int id);
	InfoUserModel get(int id);
	InfoUserModel getName(String name);
	List<InfoUserModel> getAll();
	List<InfoUserModel> search(String keyword);
	InfoUserModel findById(int id);
}
