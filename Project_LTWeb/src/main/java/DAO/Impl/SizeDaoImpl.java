package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.ISizeDao;
import Models.SizeModel;

public class SizeDaoImpl extends DBConnection implements ISizeDao{

	@Override
	public void insert(SizeModel size) {	// TODO Auto-generated method stub
		String sql = "INSERT INTO Size(size,product_id) VALUES (?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, size.getSize());
			ps.setInt(2, size.getProduct_id());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void edit(SizeModel size) {
		String sql = "UPDATE  Size SET size=?, product_id=? WHERE product_id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, size.getSize());
			ps.setInt(2, size.getProduct_id());
			ps.setInt(3, size.getProduct_id());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public SizeModel get(int id) {
		String sql = "SELECT * FROM Size WHERE product_id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SizeModel size = new SizeModel();
				size.setSize(rs.getInt("size"));
				size.setProduct_id(rs.getInt("product_id"));
				return size;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SizeModel> getAll() {
		List<SizeModel> users= new ArrayList<SizeModel>();
		String sql = "SELECT * FROM Size";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SizeModel size = new SizeModel();
				size.setSize(rs.getInt("size"));
				size.setProduct_id(rs.getInt("product_id"));
				users.add(size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public SizeModel findById(int id) {
		String sql = "SELECT * FROM Size WHERE product_id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SizeModel size = new SizeModel();
				size.setSize(rs.getInt("size"));
				size.setProduct_id(rs.getInt("product_id"));
				return size;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SizeModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SizeModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
