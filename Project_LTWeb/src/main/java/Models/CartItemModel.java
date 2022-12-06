package Models;

public class CartItemModel {
	private int id;
	private int cartId;
	private int productId;
	private int count;
	public CartItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItemModel(int cartId, int productId, int count) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.count = count;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getId() {
		return id;
	}
	
	
}
