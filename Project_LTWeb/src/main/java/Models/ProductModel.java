package Models;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class ProductModel {
	private int id;
	private String name;
	private String slug;
	private String description;
	private BigDecimal price;
	private int promotion;
	private int quantity;
	private int sold;
	private int category_id;
	private int storeId;
	private List<SizeModel> sizemd;
	private List<ImagesModel> imgmd;
	private Date createdAt;
	private Date updatedAt;
	
	
	private String img;
	private String CategoryName;
	private String storeName;
	
	private int pageId;
	private int element;
	
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductModel(int id, String name, String slug, String description, BigDecimal price, int promotion,
			int quantity, int sold, int category_id, int storeId, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.price = price;
		this.promotion = promotion;
		this.quantity = quantity;
		this.sold = sold;
		this.category_id = category_id;
		this.storeId = storeId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getPromotion() {
		return promotion;
	}
	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
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
	public List<SizeModel> getSizemd() {
		return sizemd;
	}
	public void setSizemd(List<SizeModel> sizemd) {
		this.sizemd = sizemd;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public List<ImagesModel> getImgmd() {
		return imgmd;
	}
	public void setImgmd(List<ImagesModel> imgmd) {
		this.imgmd = imgmd;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public int getElement() {
		return element;
	}
	public void setElement(int element) {
		this.element = element;
	}

	
 }