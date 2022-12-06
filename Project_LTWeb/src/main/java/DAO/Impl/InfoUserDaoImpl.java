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
		String sql = "INSERT INTO InfoUser(name, slug, email, phone, address, avatar, createdAt, updatedAt) VALUES (?,?,?,?,?,?,?,?)";
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
		String sql = "UPDATE  InfoUser SET name=?, slug=?, email=?, phone=?, address=?, avatar=?, updatedAt=? WHERE id=?";
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
			
			System.out.println(infoUser.getId());
			System.out.println(infoUser.getName());
			System.out.println(infoUser.getSlug());
			System.out.println(infoUser.getEmail());
			System.out.println(infoUser.getPhone());
			System.out.println(infoUser.getAddress());
			System.out.println(infoUser.getAvatar());
			
			ps.setInt(8, infoUser.getId());
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
	public InfoUserModel getName(String name) {
		// TODO Auto-generated method stub
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
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
