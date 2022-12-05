package Models;

import java.math.BigDecimal;
import java.sql.Date;

public class OrderItemModel {
	private int orderId;
	private int productId;
	private int count;
	private BigDecimal price;
	private Date createAt;
	private Date updateAt;
	public OrderItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItemModel(int orderId, int productId, int count, BigDecimal price, Date createAt, Date updateAt) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.count = count;
		this.price = price;
		this.createAt = createAt;
		this.updateAt = updateAt;
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
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	
}
