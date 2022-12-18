package DAO;

import java.util.List;

import Models.InfoUserModel;


public interface IInfoUserDao {
	void insert(InfoUserModel infoUser);
	void edit(InfoUserModel infoUser);
	void delete(int id);
	InfoUserModel get(int id);
	InfoUserModel getUserName(String username);
	List<InfoUserModel> getAll();
	List<InfoUserModel> search(String keyword);
	InfoUserModel findById(int id);
	String findUserIdByStoreId(int storeid);
	int CountUser();
	void editStatusByAdmin(InfoUserModel user);
}
