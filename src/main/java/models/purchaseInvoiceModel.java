package models;

public class purchaseInvoiceModel {
	
	  int purchaseNo;
	  String purchaseDate;
	  int supplierCode;
	  int bankCode;
	  double balance;
	  
	  
	  
	public int getPurchaseNo() 
	{
		return purchaseNo;
	}
	
	public void setPurchaseNo(int purchaseNo) 
	{
		this.purchaseNo = purchaseNo;
	}
	
	public String getPurchaseDate() 
	{
		return purchaseDate;
	}
	
	public void setPurchaseDate(String purchaseDate) 
	{
		this.purchaseDate = purchaseDate;
	}
	
	public int getSupplierCode()
	{
		return supplierCode;
	}
	
	public void setSupplierCode(int supplierCode)
	{
		this.supplierCode = supplierCode;
	}
	
	public int getBankCode()
	{
		return bankCode;
	}
	
	public void setBankCode(int bankCode) 
	{
		this.bankCode = bankCode;
	}
	
	
	public double getBalance() 
	{
		return balance;
	}
	
	public void setBalance(double balance) 
	{
		this.balance = balance;
	}
	
	public purchaseInvoiceModel()
	{
		super();
	}
	
	
	public purchaseInvoiceModel(int purchaseNo, String purchaseDate, int supplierCode, double balance,int bankCode) {
		super();
		this.purchaseNo = purchaseNo;
		this.purchaseDate = purchaseDate;
		this.supplierCode = supplierCode;
		this.bankCode = bankCode;
		this.balance = balance;
	}
	
	
	  
	  
	

}
