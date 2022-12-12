package Models;

import java.util.List;

public class StoreId_ProductId {

	private String _storeid;
	private List<String> _productid;
	public StoreId_ProductId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreId_ProductId(String _storeid, List<String> _productid) {
		super();
		this._storeid = _storeid;
		this._productid = _productid;
	}
	public String get_storeid() {
		return _storeid;
	}
	public void set_storeid(String _storeid) {
		this._storeid = _storeid;
	}
	public List<String> get_productid() {
		return _productid;
	}
	public void set_productid(List<String> _productid) {
		this._productid = _productid;
	}
	
	
}
