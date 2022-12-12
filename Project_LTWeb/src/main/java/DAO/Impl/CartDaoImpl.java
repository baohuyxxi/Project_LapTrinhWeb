package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.ICartDao;
import Models.CartModel;

public class CartDaoImpl extends DBConnection implements ICartDao {
	@Override
	public void insert(CartModel cart) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Cart(userId,complete, deliveryId) VALUES (?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, cart.getUserId());
			ps.setBoolean(2, false);
			ps.setInt(3, cart.getDeliveryId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(CartModel cart) {
		String sql = "UPDATE  Cart SET deliveryId=? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, cart.getDeliveryId());
			ps.setInt(2, cart.getId());
			
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
	public CartModel get(int id) {
		String sql = "SELECT * FROM Cart WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = new CartModel();
				
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setComplete(rs.getBoolean("complete"));
				
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CartModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartModel> getAll() {
		List<CartModel> Cart= new ArrayList<CartModel>();
		String sql = "SELECT * FROM cart";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = new CartModel();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));	
				cart.setComplete(rs.getBoolean("complete"));
				Cart.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Cart;
	}

	@Override
	public List<CartModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartModel findById(int id) {
		String sql = "SELECT * FROM Cart WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = new CartModel();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setComplete(rs.getBoolean("complete"));
				cart.setDeliveryId(rs.getInt("deliveryId"));
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String findCartIdByUserId(int userid) {
		String sql = "SELECT * FROM Cart WHERE userId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String findDeliveryIdByCardId(int cardid) {
		String sql = "SELECT deliveryId FROM Cart WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cardid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString("deliveryId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
