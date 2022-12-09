package DAO.Impl;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		
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
	

}
