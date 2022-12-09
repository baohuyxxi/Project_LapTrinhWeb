package DAO.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.ICategoryDao;
import Models.CategoryModel;


public class CategoryDaoImpl extends DBConnection implements ICategoryDao{
	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Category(name,slug,createdAt,updatedAt) VALUES (?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, category.getName());
			ps.setString(2, category.getSlug());
			ps.setDate(3, new Date(System.currentTimeMillis()));
			ps.setDate(4, new Date(System.currentTimeMillis()));
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void edit(CategoryModel category) {
		String sql = "UPDATE  Category SET name=?, slug=?, createdAt=?, updatedAt=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getSlug());
			ps.setDate(3, new Date(System.currentTimeMillis()));
			ps.setDate(4, new Date(System.currentTimeMillis()));
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Category WHERE id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public CategoryModel get(int id) {
		String sql = "SELECT * FROM Category WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setCreatedAt(rs.getDate("createdAt"));
				category.setUpdatedAt(rs.getDate("updatedAt"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public CategoryModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> getAll() {
		List<CategoryModel> users= new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM Category";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setCreatedAt(rs.getDate("createdAt"));
				category.setUpdatedAt(rs.getDate("updatedAt"));
				users.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<CategoryModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryModel findById(int id) {
		String sql = "SELECT * FROM Category WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setCreatedAt(rs.getDate("createdAt"));
				category.setUpdatedAt(rs.getDate("updatedAt"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
