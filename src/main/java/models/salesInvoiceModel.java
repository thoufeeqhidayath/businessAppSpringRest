package models;

public class salesInvoiceModel {

	int salesNo;
    String salesDate;
	int customerCode;
    double balance;
	int bankCode;
	
	
	public salesInvoiceModel() {
		super();
	}
	
	
	public salesInvoiceModel(int salesNo, String salesDate, int customerCode, double balance, int bankCode) {
		super();
		this.salesNo = salesNo;
		this.salesDate = salesDate;
		this.customerCode = customerCode;
		this.balance = balance;
		this.bankCode = bankCode;
	}
	public int getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(int salesNo) {
		this.salesNo = salesNo;
	}
	public String getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getBankCode() {
		return bankCode;
	}
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	
	
}
