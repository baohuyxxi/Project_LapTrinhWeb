package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.ICartItemDao;
import Models.CartItemModel;

public class CartItemDaoImpl extends DBConnection implements ICartItemDao {
	@Override
	public void insert(CartItemModel cartItem) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CartItem(cartId, productId, count, size) VALUES (?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ps.setInt(3, cartItem.getCount());
			ps.setString(4, cartItem.getSize());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void edit(CartItemModel cartItem) {
		String sql = "UPDATE  CartItem SET count=?, size=? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, cartItem.getCount());
			ps.setString(2, cartItem.getSize());
			ps.setInt(3, cartItem.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE CartItem WHERE id = ?";
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
	public CartItemModel get(int id) {
		String sql = "SELECT * FROM CartItem WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartItemModel cartItem = new CartItemModel();
				
				cartItem.setId(rs.getInt("id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));	
				cartItem.setCount(rs.getInt("complete"));
				
				return cartItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CartItemModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItemModel> getAll() {
		List<CartItemModel> cartItems= new ArrayList<CartItemModel>();
		String sql = "SELECT * FROM cartItem";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartItemModel cartItem = new CartItemModel();
				cartItem.setId(rs.getInt("id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));	
				cartItem.setCount(rs.getInt("count"));
				cartItem.setSize(rs.getString("size"));
				cartItems.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItems;
	}

	@Override
	public List<CartItemModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItemModel findById(int id) {
		String sql = "SELECT * FROM CartItem WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartItemModel cartItem = new CartItemModel();
				cartItem.setId(rs.getInt("id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));	
				cartItem.setCount(rs.getInt("count"));
				cartItem.setSize(rs.getString("size"));
				return cartItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public CartItemModel findCartAndCountProductID(int userId) {
		String sql = "select CartItem.cartId, count(CartItem.cartId) as sl\r\n"
				+ "from Cart, CartItem \r\n"
				+ "where CartItem.cartId = Cart.id and Cart.userId = ?\r\n"
				+ "Group by CartItem.cartId";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				CartItemModel cartItem = new CartItemModel(rs.getInt(1), rs.getInt(2));
				return cartItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<CartItemModel> getAllByCartId(int cartid) {
		List<CartItemModel> cartItems= new ArrayList<CartItemModel>();
		String sql = "SELECT * FROM cartItem WHERE cartId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartItemModel cartItem = new CartItemModel();
				cartItem.setId(rs.getInt("id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));	
				cartItem.setCount(rs.getInt("count"));
				cartItem.setSize(rs.getString("size"));
				cartItems.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItems;
	}
	
	
}
