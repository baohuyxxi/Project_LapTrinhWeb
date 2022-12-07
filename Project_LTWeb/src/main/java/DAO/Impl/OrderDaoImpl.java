package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IOrderDao;
import Models.OrdersModel;

public class OrderDaoImpl extends DBConnection implements IOrderDao {

	@Override
	public void insert(OrdersModel order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(OrdersModel order) {
		String sql = "UPDATE Orders SET deliveryId = ?, "
				+ "address = ?, phone = ?"
				+ ", status = ?, total_price = ?, "
				+ "updatedAt = ? WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getDeliveryId());
			ps.setString(2, order.getAddress());
			ps.setString(3, order.getPhone());
			ps.setInt(4, order.getStatus());
			ps.setBigDecimal(5, order.getTotal_price());
			ps.setDate(6, order.getUpdatedAt());
			
			ps.setInt(7, order.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrdersModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<OrdersModel> getAll() {
//		List<OrdersModel> orders = new ArrayList<OrdersModel>();
//		String sql = "SELECT * FROM Orders";
//		try {
//			Connection conn = super.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				orders.add(new OrdersModel(rs.getInt(1), 
//						rs.getInt(2), 
//						rs.getInt(3), 
//						rs.getInt(4), 
//						rs.getString(5), 
//						rs.getString(6), 
//						rs.getInt(7), 
//						rs.getBigDecimal(8), 
//						rs.getDate(9), 
//						rs.getDate(10)));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return orders;
//	}
	public List<OrdersModel> getAll() {
		List<OrdersModel> orders = new ArrayList<OrdersModel>();
		String sql = "select *from view_Order_Of_Store";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(new OrdersModel(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getBigDecimal(7),
						rs.getDate(8),
						rs.getDate(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	

	@Override
	public List<OrdersModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersModel findById(int id) {
		String sql = "SELECT * FROM Orders WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrdersModel order = new OrdersModel(rs.getInt(1), 
						rs.getInt(2), 
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7), 
						rs.getBigDecimal(8), 
						rs.getDate(9), 
						rs.getDate(10));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
