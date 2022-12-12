package Models;

public class CartModel {
	private int id;
	private int userId;
	private boolean complete;
	private int deliveryId;
	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartModel(int userId, boolean complete, int delevery) {
		super();
		this.userId = userId;
		this.complete = complete;
		this.deliveryId = delevery;
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
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	
}
