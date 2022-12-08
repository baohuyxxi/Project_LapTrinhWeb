package DAO.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IAccountDao;
import Models.AccountModel;
import Models.StoreModel;

public class AccountDaoImpl extends DBConnection implements IAccountDao{

	@Override
	public void insert(AccountModel account) {
		String sql = "INSERT INTO Account(username, password, role) VALUES (?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setInt(3, account.getRole());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(AccountModel account) {
		String sql = "UPDATE Account SET username=?, password=? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setInt(3, account.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		String sql = "SELECT * FROM Account";
		List<AccountModel> accounts = new ArrayList<AccountModel>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				AccountModel account = new AccountModel();
				account.setId(Integer.parseInt(rs.getString("id")));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setRole(Integer.parseInt(rs.getString("role")));
				accounts.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public List<AccountModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountModel findById(int id) {
		String sql = "SELECT * FROM Account WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel account = new AccountModel();
				account.setId(Integer.parseInt(rs.getString("id")));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setRole(Integer.parseInt(rs.getString("role")));
				return account;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountModel checkLogin(String username, String password) {
		String sql = "SELECT * FROM Account WHERE username=? and password=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel account = new AccountModel();
				account.setId(Integer.parseInt(rs.getString("id")));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setRole(Integer.parseInt(rs.getString("role")));
				return account;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
