package Models;

import java.sql.Date;

public class InfoUserModel {
	private int id;
	private String name;
	private String slug;
	private String email;
	private String phone;
	private String address;
	private String avatar;
	private Date createdAt;
	private Date updatedAt;
	public InfoUserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InfoUserModel(String name, String slug, String email, String phone, String address, String avatar,
			Date createdAt, Date updatedAt) {
		super();
		this.name = name;
		this.slug = slug;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.avatar = avatar;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
