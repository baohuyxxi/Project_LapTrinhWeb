package DAO.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IInfoUserDao;
import Models.InfoUserModel;

public class InfoUserDaoImpl extends DBConnection implements IInfoUserDao{

	@Override
	public void insert(InfoUserModel infoUser) {
		String sql = "INSERT INTO InfoUser(name, slug, email, phone, address, avatar, createdAt, updatedAt, status) VALUES (?,?,?,?,?,?,?,?,1)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, infoUser.getName());
			ps.setString(2, infoUser.getSlug());
			ps.setString(3, infoUser.getEmail());
			ps.setString(4, infoUser.getPhone());
			ps.setString(5, infoUser.getAddress());
			ps.setString(6, infoUser.getAvatar());
			ps.setDate(7, new Date(System.currentTimeMillis()));
			ps.setDate(8, new Date(System.currentTimeMillis()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(InfoUserModel infoUser) {
		String sql = "UPDATE  InfoUser SET name=?, slug=?, email=?, phone=?, address=?, avatar=?, updatedAt=?, status = ? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, infoUser.getName());
			ps.setString(2, infoUser.getSlug());
			ps.setString(3, infoUser.getEmail());
			ps.setString(4, infoUser.getPhone());
			ps.setString(5, infoUser.getAddress());
			ps.setString(6, infoUser.getAvatar());
			ps.setDate(7, new Date(System.currentTimeMillis()));
			ps.setBoolean(8, infoUser.getStatus());
			ps.setInt(9, infoUser.getId());
			
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
	public InfoUserModel get(int id) {
		String sql = "SELECT * FROM InfoUser WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				InfoUserModel user = new InfoUserModel();
				user.setName(rs.getString("name"));
				user.setSlug(rs.getString("slug"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setAvatar(rs.getString("avatar"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InfoUserModel getUserName(String username) {
		String sql = "SELECT InfoUser.id FROM Account,InfoUser WHERE InfoUser.email=Account.username and Account.username=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				InfoUserModel user = new InfoUserModel();
				user.setId(Integer.parseInt(rs.getString("id")));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<InfoUserModel> getAll() {
		List<InfoUserModel> users= new ArrayList<InfoUserModel>();
		String sql = "SELECT * FROM InfoUser";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				InfoUserModel user = new InfoUserModel();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSlug(rs.getString("slug"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setAvatar(rs.getString("avatar"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
				user.setStatus(rs.getBoolean("status"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<InfoUserModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoUserModel findById(int id) {
		String sql = "SELECT * FROM InfoUser WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				InfoUserModel user = new InfoUserModel();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSlug(rs.getString("slug"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setAvatar(rs.getString("avatar"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
				user.setStatus(rs.getBoolean("status"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String findUserIdByStoreId(int storeid) {
		String sql = "SELECT InfoUser.id FROM InfoUser, Store WHERE InfoUser.id = Store.userId and Store.id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, storeid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				return rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int CountUser() {
		String sql = "select count(*) 'sl' from InfoUser";
		int slUser = 0;
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				slUser = rs.getInt("sl");
			}
			return slUser;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return slUser;
	}
}
