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
	private Date createAt;
	private Date updateAt;
	public InfoUserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InfoUserModel(String name, String slug, String email, String phone, String address, String avatar,
			Date createAt, Date updateAt) {
		super();
		this.name = name;
		this.slug = slug;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.avatar = avatar;
		this.createAt = createAt;
		this.updateAt = updateAt;
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
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt  = createAt;
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
