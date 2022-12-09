package DAO.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IStoreDao;
import Models.StoreModel;

public class StoreDaoImpl extends DBConnection implements IStoreDao{

	@Override
	public void insert(StoreModel store) {
		String sql = "INSERT INTO Store(userId, name, slug, address, createdAt, updatedAt) VALUES (?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, store.getUserId());
			ps.setString(2, store.getName());
			ps.setString(3, store.getSlug());
			ps.setString(4, store.getAddress());
			ps.setDate(5, new Date(System.currentTimeMillis()));
			ps.setDate(6, new Date(System.currentTimeMillis()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(StoreModel store) {
		String sql = "UPDATE Store SET name=?, slug=?, address=?, updatedAt=? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, store.getName());
			ps.setString(2, store.getSlug());
			ps.setString(3, store.getAddress());
			ps.setDate(4, new Date(System.currentTimeMillis()));
			ps.setInt(5, store.getId());
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
	public StoreModel get(int id) {
		String sql = "SELECT * FROM Store WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreModel store = new StoreModel();
				store.setUserId(Integer.parseInt(rs.getString("userId")));
				store.setName(rs.getString("name"));
				store.setSlug(rs.getString("slug"));
				store.setAddress(rs.getString("address"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
				return store;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StoreModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreModel> getAll() {
		String sql = "SELECT * FROM Store";
		List<StoreModel> stores = new ArrayList<StoreModel>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				StoreModel store = new StoreModel();
				store.setId(Integer.parseInt(rs.getString("id")));
				store.setUserId(Integer.parseInt(rs.getString("userId")));
				store.setName(rs.getString("name"));
				store.setSlug(rs.getString("slug"));
				store.setAddress(rs.getString("address"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
				stores.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stores;
	}

	@Override
	public List<StoreModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreModel findById(int id) {
		String sql = "SELECT * FROM Store WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreModel store = new StoreModel();
				store.setId(Integer.parseInt(rs.getString("id")));
				store.setName(rs.getString("name"));
				store.setSlug(rs.getString("slug"));
				store.setAddress(rs.getString("address"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
				return store;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
