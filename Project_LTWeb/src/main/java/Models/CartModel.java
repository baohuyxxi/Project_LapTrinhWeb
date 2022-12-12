package Models;

public class CartModel {
	private int id;
	private int userId;
	private boolean complete;
	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartModel(int userId, boolean complete) {
		super();
		this.userId = userId;
		this.complete = complete;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
