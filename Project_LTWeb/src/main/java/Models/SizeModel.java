package Models;

public class SizeModel {
	private int size;
	 private 	int product_id;
	public SizeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public SizeModel(int size, int product_id) {
		super();
		this.size = size;
		this.product_id = product_id;
	}
}
