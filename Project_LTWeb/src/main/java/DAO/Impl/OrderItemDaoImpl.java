package DAO.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IOrderItemDao;
import Models.OrderItemModel;
import Models.OrdersModel;

public class OrderItemDaoImpl extends DBConnection implements IOrderItemDao{

	@Override
	public void insert(OrderItemModel orderItem) {
		String sql = "INSERT INTO OrderItem(orderId, productId, count, price, createdAt, updatedAt) VALUES (?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, orderItem.getOrderId());
			ps.setInt(2, orderItem.getProductId());
			ps.setInt(3, orderItem.getCount());
			ps.setBigDecimal(4, orderItem.getPrice());
			ps.setDate(5, new Date(System.currentTimeMillis()));
			ps.setDate(6, new Date(System.currentTimeMillis()));
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
	public OrdersModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItemModel> getAll(int orderId) {
		List<OrderItemModel> orders = new ArrayList<OrderItemModel>();
		String sql = "SELECT OrderItem.id, Product.name, "
				+ "OrderItem.count, OrderItem.count * OrderItem.price, "
				+ "OrderItem.createdAt, OrderItem.updatedAt "
				+ "FROM OrderItem INNER JOIN Product "
				+ "ON OrderItem.productId = Product.id "
				+ "WHERE orderId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {				
				orders.add(new OrderItemModel(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getBigDecimal(4),
						rs.getDate(5),
						rs.getDate(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<OrderItemModel> search(String keywork) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItemModel findByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String findStoreIdLast() {
		String sql = "select top(1) id from orders order by id desc";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
