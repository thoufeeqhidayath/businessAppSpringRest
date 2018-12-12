package models;

public class userModel {
	
	  int supplierCode;
	  String supplierName;
	  String password;
	
	  
    public int getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(int supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public userModel() {
		super();
	}
	
	
	
	
	public userModel(int supplierCode, String supplierName, String password) {
		super();
		this.supplierCode = supplierCode;
		this.supplierName = supplierName;
		this.password = password;
	}
	
	
	

}
