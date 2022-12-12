package Models;

public class CartItemModel {
	private int id;
	private int cartId;
	private int productId;
	private int count;
	private String size;
	
	
	//Biến phụ
	private int countCartId;
	private ProductModel product;
	
	public CartItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CartItemModel(int cartId, int countCartId) {
		super();
		this.cartId = cartId;
		this.countCartId = countCartId;
	}

	public CartItemModel(int cartId, int productId, int count, String size) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.count = count;
		this.size = size;
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
	public void setId(int id) {
		this.id = id;
	}
	public int getCountCartId() {
		return countCartId;
	}
	public void setCountCartId(int countCartId) {
		this.countCartId = countCartId;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
}
