package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IMyOrderCustomerDao;
import Models.AccountModel;
import Models.OrderUserModel;

public class MyOrderCustomerDaoImpl extends DBConnection implements IMyOrderCustomerDao{

	@Override
	public List<OrderUserModel> myorder(int userid) {
		String sql = "select Orders.id, Store.name, Delivery.name, Orders.address, Orders.phone, Orders.status ,orders.total_price, Orders.createdAt\r\n"
				+ "from OrderItem, orders, Store, Delivery\r\n"
				+ "where OrderItem.orderId=Orders.id and Store.id=storeId and Orders.deliveryId=Delivery.id and Orders.userId=?";
		List<OrderUserModel> orders = new ArrayList<OrderUserModel>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderUserModel order = new OrderUserModel();
				order.setId(rs.getInt(1));
				order.setStorename(rs.getString(2));
				order.setDeliveryname (rs.getString(3));
				order.setAddress(rs.getString(4));
				order.setPhone(rs.getString(5));
				order.setStatus(rs.getString(6));
				order.setTotal_price(rs.getBigDecimal(7));
				order.setDayorder(rs.getDate(8));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	
}
