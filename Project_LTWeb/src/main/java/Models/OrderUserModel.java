package Models;

import java.math.BigDecimal;
import java.sql.Date;

public class OrderUserModel {
	private int id;
	private String storename;
	private String deliveryname;
	private String address;
	private String phone;
	private String status;
	private BigDecimal total_price;
	private Date dayorder;
	public OrderUserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderUserModel(int id, String storename, String deliveryname, String address, String phone, String status,
			BigDecimal total_price, Date dayorder) {
		super();
		this.id = id;
		this.storename = storename;
		this.deliveryname = deliveryname;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.total_price = total_price;
		this.dayorder = dayorder;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getDeliveryname() {
		return deliveryname;
	}
	public void setDeliveryname(String deliveryname) {
		this.deliveryname = deliveryname;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	public Date getDayorder() {
		return dayorder;
	}
	public void setDayorder(Date dayorder) {
		this.dayorder = dayorder;
	}
	
	

}
