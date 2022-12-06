package Models;

import java.sql.Date;

public class StoreModel {
	private int id;
	private int userId;
	private String name;
	private String slug;
	private String address;
	private Date createdAt;
	private Date updatedAt;
	public StoreModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreModel(int userId, String name, String slug, String address, Date createdAt, Date updatedAt) {
		super();
		this.userId = userId;
		this.name = name;
		this.slug = slug;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
