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
	public void insert(SizeModel size) {
		String sql = "INSERT INTO Size(size, product_id, quantity) VALUES (?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, size.getSize());
			ps.setInt(2, size.getProduct_id());
			ps.setInt(3, size.getQuantity());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(SizeModel size, String name_old) {
		String sql = "UPDATE  Size SET size=?, quantity=? WHERE product_id=? and size=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, size.getSize());
			ps.setInt(2, size.getQuantity());
			ps.setInt(3, size.getProduct_id());
			ps.setString(4, name_old);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public SizeModel get(int id) {
		return null;
	}

	@Override
	public List<SizeModel> getAllProductId(int productId) {
		List<SizeModel> sizes = new ArrayList<SizeModel>();
		String sql = "SELECT * FROM Size WHERE product_id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SizeModel size = new SizeModel();
				size.setSize(rs.getString("size"));
				size.setProduct_id(rs.getInt("product_id"));
				size.setQuantity(rs.getInt("quantity"));
				sizes.add(size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sizes;
	}

	@Override
	public SizeModel findByIdAndSize(String product_id, String size_name) {
		String sql = "SELECT * FROM Size WHERE product_id = ? and size=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product_id);
			ps.setString(2, size_name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SizeModel size = new SizeModel();
				size.setSize(rs.getString("size"));
				size.setProduct_id(rs.getInt("product_id"));
				size.setQuantity(rs.getInt("quantity"));
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

	@Override
	public List<SizeModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
