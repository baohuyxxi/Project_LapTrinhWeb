package Models;

import java.math.BigDecimal;
import java.sql.Date;

public class OrderItemModel {
	private int id;
	private int orderId;
	private int productId;
	private int count;
	private BigDecimal price;
	private Date createdAt;
	private Date updatedAt;
	public OrderItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItemModel(int orderId, int productId, int count, BigDecimal price, Date createdAt, Date updatedAt) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.count = count;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createAt) {
		this.createdAt = createAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updateAt) {
		this.updatedAt = updateAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
