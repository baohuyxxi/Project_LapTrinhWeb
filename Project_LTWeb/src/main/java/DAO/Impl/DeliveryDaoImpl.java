package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import Connection.DBConnection;
import DAO.IDeliveryDao;
import Models.DeliveryModel;

public class DeliveryDaoImpl extends DBConnection implements IDeliveryDao{
	@Override
	public void insert(DeliveryModel delivery) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Delivery(name,phone,price,status,createdAt,updatedAt) VALUES (?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, delivery.getName());
			ps.setString(2, delivery.getPhone());
			ps.setBigDecimal(3, delivery.getPrice());
			ps.setInt(4, delivery.getStatus());
			ps.setDate(5, new Date(System.currentTimeMillis()));
			ps.setDate(6, new Date(System.currentTimeMillis()));
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(DeliveryModel delivery) {
		String sql = "UPDATE  Delivery SET name=?, phone=?, price=?, status=?, updatedAt=? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, delivery.getName());
			ps.setString(2, delivery.getPhone());
			ps.setBigDecimal(3, delivery.getPrice());
			ps.setInt(4, delivery.getStatus());
			ps.setDate(5, new Date(System.currentTimeMillis()));
			ps.setInt(6, delivery.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Delivery WHERE id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public DeliveryModel get(int id) {
		String sql = "SELECT * FROM Delivery WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeliveryModel deliveryer = new DeliveryModel();
				deliveryer.setName(rs.getString("name"));
				deliveryer.setPhone(rs.getString("phone"));
				deliveryer.setPrice(rs.getBigDecimal("price"));
				deliveryer.setStatus(rs.getInt("status"));
				deliveryer.setCreatedAt(rs.getDate("createdAt"));
				deliveryer.setUpdatedAt(rs.getDate("updatedAt"));
				return deliveryer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DeliveryModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeliveryModel> getAll() {
		List<DeliveryModel> users= new ArrayList<DeliveryModel>();
		String sql = "SELECT * FROM delivery";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeliveryModel deliveryer = new DeliveryModel();
				deliveryer.setId(rs.getInt("id"));
				deliveryer.setName(rs.getString("name"));
				deliveryer.setPhone(rs.getString("phone"));
				deliveryer.setPrice(rs.getBigDecimal("price"));
				deliveryer.setStatus(rs.getInt("status"));
				deliveryer.setCreatedAt(rs.getDate("createdAt"));
				deliveryer.setUpdatedAt(rs.getDate("updatedAt"));
				users.add(deliveryer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<DeliveryModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryModel findById(int id) {
		String sql = "SELECT * FROM delivery WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeliveryModel deliveryer = new DeliveryModel();
				deliveryer.setId(rs.getInt("id"));
				deliveryer.setName(rs.getString("name"));
				deliveryer.setPhone(rs.getString("phone"));
				deliveryer.setPrice(rs.getBigDecimal("price"));
				deliveryer.setStatus(rs.getInt("status"));
				deliveryer.setCreatedAt(rs.getDate("createdAt"));
				deliveryer.setUpdatedAt(rs.getDate("updatedAt"));
				return deliveryer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
