package Models;

import java.sql.Date;

public class StoreModel {
	private int id;
	private int userId;
	private String name;
	private String slug;
	private String address;
	private Date createAt;
	private Date updateAt;
	public StoreModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreModel(int userId, String name, String slug, String address, Date createAt, Date updateAt) {
		super();
		this.userId = userId;
		this.name = name;
		this.slug = slug;
		this.address = address;
		this.createAt = createAt;
		this.updateAt = updateAt;
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
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
		
		//this.createAt = new Date(System.currentTimeMillis())
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
