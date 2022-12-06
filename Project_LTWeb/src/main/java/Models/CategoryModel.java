package Models;

import java.sql.Date;

public class CategoryModel {
	private int id;
	private String name;
	private String slug;
	private Date createdAt;
	private Date updatedAt;

	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryModel(int id, String name, String slug, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
	}

}
