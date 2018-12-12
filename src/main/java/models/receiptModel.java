package models;

public class receiptModel {

	  int receiptCode;
	  String receiptDate;
	  int customerCode;
	  double balance;
	  int bankCode;
	  
	  
	public int getReceiptCode() {
		return receiptCode;
	}
	public void setReceiptCode(int receiptCode) {
		this.receiptCode = receiptCode;
	}
	public String getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
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
	
	public receiptModel() {
		super();
	}
	
	public receiptModel(int receiptCode, String receiptDate, int customerCode, double balance, int bankCode) {
		super();
		this.receiptCode = receiptCode;
		this.receiptDate = receiptDate;
		this.customerCode = customerCode;
		this.balance = balance;
		this.bankCode = bankCode;
	}

}
