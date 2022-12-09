package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IImageDao;
import Models.ImagesModel;


public class ImageDaoImpl extends DBConnection implements IImageDao{
	@Override
	public void insert(ImagesModel image) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Images(image_id,img,product_id) VALUES (?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, image.getImage_id());
			ps.setString(2, image.getImg());
			ps.setInt(3, image.getProduct_id());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(ImagesModel image) {
		String sql = "UPDATE  Images SET img=?, product_id=? WHERE image_id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
					
			ps.setString(1, image.getImg());
			ps.setInt(2, image.getProduct_id());
			ps.setInt(3, image.getImage_id());
			
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
	public ImagesModel get(int id) {
		String sql = "SELECT * FROM Images WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ImagesModel image = new ImagesModel();
				
				image.setImage_id(rs.getInt("image_id"));
				image.setProduct_id(rs.getInt("product_id"));
				image.setImg(rs.getString("img"));			
				
				return image;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ImagesModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImagesModel> getAll() {
		List<ImagesModel> images= new ArrayList<ImagesModel>();
		String sql = "SELECT * FROM image";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ImagesModel image = new ImagesModel();
				image.setImage_id(rs.getInt("image_id"));
				image.setProduct_id(rs.getInt("product_id"));
				image.setImg(rs.getString("img"));			
				images.add(image);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return images;
	}

	@Override
	public List<ImagesModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImagesModel findById(int id) {
		String sql = "SELECT * FROM Images WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ImagesModel image = new ImagesModel();
				image.setImage_id(rs.getInt("image_id"));
				image.setProduct_id(rs.getInt("product_id"));
				image.setImg(rs.getString("img"));			
				return image;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
