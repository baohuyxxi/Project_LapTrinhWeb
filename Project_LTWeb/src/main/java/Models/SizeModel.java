package Models;

public class SizeModel {
	private String size;
	private int product_id;
	private int quantity;

	public SizeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public SizeModel(String size, int product_id, int quantity) {
		super();
		this.size = size;
		this.product_id = product_id;
		this.quantity = quantity;
	}

	
}
