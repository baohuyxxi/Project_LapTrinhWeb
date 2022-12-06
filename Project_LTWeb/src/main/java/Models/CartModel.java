package Models;

public class CartModel {
	private int id;
	private int userId;
	private int storeId;
	private boolean complete;
	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartModel(int userId, int storeId, boolean complete) {
		super();
		this.userId = userId;
		this.storeId = storeId;
		this.complete = complete;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
