package models;

public class supplierModel {
	
	
	  int supplierCode;
 	  String supplierName;
 	  double balance;
	
 	  
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
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
 	
	public supplierModel(int supplierCode, String supplierName, double balance) {
		super();
		this.supplierCode = supplierCode;
		this.supplierName = supplierName;
		this.balance = balance;
	}

	public supplierModel() {
		super();
	}


}
