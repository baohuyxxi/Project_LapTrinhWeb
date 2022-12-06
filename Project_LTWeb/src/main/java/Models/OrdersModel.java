package Models;

import java.math.BigDecimal;
import java.sql.Date;

public class OrdersModel {
	private int id;
	private int userId;
	private int storeId;
	private int deliveryId;
	private String address;
	private String phone;
	private int status;
	private BigDecimal total_price;
	private Date createAt;
	private Date updateAt;
	public OrdersModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdersModel(int userId, int storeId, int deliveryId, String address, String phone, int status,
			BigDecimal total_price, Date createAt, Date updateAt) {
		super();
		this.userId = userId;
		this.storeId = storeId;
		this.deliveryId = deliveryId;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.total_price = total_price;
		this.createAt = createAt;
		this.updateAt = updateAt;
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
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
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
	public int getId() {
		return id;
	}
	
	
}
