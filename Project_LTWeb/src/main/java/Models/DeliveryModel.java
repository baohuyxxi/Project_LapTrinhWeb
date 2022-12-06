package Models;

import java.math.BigDecimal;
import java.sql.Date;

public class DeliveryModel {
	private int id;
	private String name;
	private String phone;
	private BigDecimal price;
	private int status;
	private Date createdAt;
	private Date updatedAt;
	public DeliveryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeliveryModel(int id, String name, String phone, BigDecimal price, int status, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.price = price;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
