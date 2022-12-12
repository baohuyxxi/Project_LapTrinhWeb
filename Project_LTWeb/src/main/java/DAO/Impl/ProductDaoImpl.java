package DAO.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IProductDao;
import Models.ProductModel;

public class ProductDaoImpl extends DBConnection implements IProductDao{

	@Override
	public void insert(ProductModel product) {
		String sql = "INSERT INTO Product(name, slug, description, price, promotion, quantity, category_id, storeId, createdAt, updatedAt) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getSlug());
			ps.setString(3, product.getDescription());
			ps.setBigDecimal(4, product.getPrice());
			ps.setInt(5, product.getPromotion());
			ps.setInt(6, 0);
			ps.setInt(7, product.getCategory_id());
			ps.setInt(8, product.getStoreId());
			ps.setDate(9,new Date(System.currentTimeMillis()));
			ps.setDate(10, new Date(System.currentTimeMillis()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(ProductModel product) {
		String sql = "UPDATE Product SET name=?, slug=?, description=?, price=?, promotion=?, category_id=?, updatedAt=? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getSlug());
			ps.setString(3, product.getDescription());
			ps.setBigDecimal(4, product.getPrice());
			ps.setInt(5, product.getPromotion());
			ps.setInt(6, product.getCategory_id());
			ps.setDate(7, new Date(System.currentTimeMillis()));
			ps.setInt(8, product.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE Images WHERE product_id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sql = "DELETE Size WHERE product_id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sql = "DELETE Product WHERE id = ?";
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
	public ProductModel get(int id) {
		// TODO Auto-generated method stub
				return null;

	}

	@Override
	public ProductModel getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getAll() {
		String sql = "SELECT * FROM Product";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setPromotion(Integer.parseInt(rs.getString("promotion")));
				product.setQuantity(Integer.parseInt(rs.getString("quantity")));
				product.setSold(Integer.parseInt(rs.getString("sold")));
				product.setCategory_id(Integer.parseInt(rs.getString("category_id")));
				product.setStoreId(Integer.parseInt(rs.getString("storeId")));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<ProductModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel findById(int id) {
		String sql = " SELECT sold, name, category_id, id, description, price, \r\n"
				+ "quantity, slug, storeId, createdAt, updatedAt, promotion,\r\n"
				+ "(select top 1 img from Images where Product.id =Images.product_id ) as img,\r\n"
				+ "(select Category.name from Category where category_id =id) as categoryName,\r\n"
				+ "(select Store.name from Store where Store.id = Product.storeId ) as storeName\r\n"
				+ "FROM Product\r\n"
				+ "WHERE Product.id =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setPromotion(Integer.parseInt(rs.getString("promotion")));
				product.setQuantity(Integer.parseInt(rs.getString("quantity")));
				product.setSold(Integer.parseInt(rs.getString("sold")));
				product.setCategory_id(Integer.parseInt(rs.getString("category_id")));
				product.setStoreId(Integer.parseInt(rs.getString("storeId")));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				product.setImg(rs.getString("img"));
				product.setCategoryName(rs.getString("categoryName"));
				product.setStoreName(rs.getString("storeName"));
				
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String findStoreIdByUserId(int userId) {
		String sql = "SELECT Store.id FROM InfoUser, Store WHERE InfoUser.id=Store.userId and InfoUser.id=?";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String storeId = rs.getString("id");
				return storeId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	


	public List<ProductModel> proTop3() {
		String sql = "select top (3) Product.sold, Product.name, Product.category_id, Product.storeId, Product.id,\r\n"
				+ "(select top 1 img from Images where Product.id =Images.product_id ) as img\r\n"
				+ "from Product\r\n"
				+ "ORDER BY Product.sold DESC";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setStoreId(Integer.parseInt(rs.getString("storeId")));
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setSold(Integer.parseInt(rs.getString("sold")));
				product.setName(rs.getString("name"));
				product.setCategory_id(Integer.parseInt(rs.getString("category_id")));
				product.setImg(rs.getString("img"));
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<ProductModel> getAllByStoreId(int storeId) {
		String sql = "SELECT * FROM Product, Store WHERE Store.id=Product.storeId and Store.id=?";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				products.add(new ProductModel(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getBigDecimal(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getInt(10),
						rs.getDate(11),
						rs.getDate(12)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<ProductModel> findProByAllId(int valueId, String columnId ) {
		String sql = "select sold, name, category_id, id, description, price,\r\n"
				+ "quantity, slug, storeId, createdAt, updatedAt, promotion,\r\n"
				+ "(select top 1 img from Images where Product.id =Images.product_id ) as img,\r\n"
				+ "(select Category.name from Category where category_id =id) as categoryName,\r\n"
				+"(select Store.name from Store where Store.id = Product.storeId ) as storeName\r\n"
				+ "from Product\r\n"
				+ "where " + columnId+" = " + String.valueOf(valueId) +"\r\n"
				+ " ORDER BY sold DESC";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setPromotion(Integer.parseInt(rs.getString("promotion")));
				product.setQuantity(Integer.parseInt(rs.getString("quantity")));
				product.setSold(Integer.parseInt(rs.getString("sold")));
				product.setCategory_id(Integer.parseInt(rs.getString("category_id")));
				product.setStoreId(Integer.parseInt(rs.getString("storeId")));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				product.setImg(rs.getString("img"));
				product.setCategoryName(rs.getString("categoryName"));
				product.setStoreName(rs.getString("storeName"));
				
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
			

	
	@Override
	public String findStoreIdByProductId(int productId) {
		String sql = "SELECT storeId FROM Product WHERE Product.id=?";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String storeId = rs.getString("storeId");
				return storeId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductModel findTop1Product(int storeId) {
		String sql = "select Top(1) Product.id, Product.name, Product.description, \r\n"
				+ "Product.sold, Product.category_id , Images.img, Product.updatedAt\r\n"
				+ "from product, Images \r\n"
				+ "where storeId = ? and Product.id = Images.product_id \r\n"
				+ "order by sold DESC";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setSold(Integer.parseInt(rs.getString("sold")));
				product.setCategory_id(Integer.parseInt(rs.getString("category_id")));
				product.setImg(rs.getString("img"));
				product.setUpdatedAt(new Date(System.currentTimeMillis()));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ProductModel findMinSoldProduct(int storeId) {
		String sql = "select Top(1) Product.id, Product.name, Product.description, \r\n"
				+ "Product.sold, Product.category_id , Images.img, Product.updatedAt\r\n"
				+ "from product, Images \r\n"
				+ "where storeId = ? and Product.id = Images.product_id \r\n"
				+ "order by sold ASC";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setSold(Integer.parseInt(rs.getString("sold")));
				product.setCategory_id(Integer.parseInt(rs.getString("category_id")));
				product.setImg(rs.getString("img"));
				product.setUpdatedAt(new Date(System.currentTimeMillis()));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductModel findByProductId(int id) {
		//of Tuấn
		String sql = "SELECT * FROM Product WHERE id=?";
		ProductModel product = new ProductModel();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setPromotion(Integer.parseInt(rs.getString("promotion")));
				product.setQuantity(Integer.parseInt(rs.getString("quantity")));
				product.setSold(Integer.parseInt(rs.getString("sold")));
				product.setCategory_id(Integer.parseInt(rs.getString("category_id")));
				product.setStoreId(Integer.parseInt(rs.getString("storeId")));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String findProductIdByCardId(int cardid) {
		String sql = "SELECT productId FROM CartItem WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cardid);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				return rs.getString("productId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

