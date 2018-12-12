package models;

public class paymentModel {

	  int paymentNo;
	  public paymentModel() {
		super();
	}
	public paymentModel(int paymentNo, String paymentDate, int supplierCode, double balance, int bankCode) {
		super();
		this.paymentNo = paymentNo;
		this.paymentDate = paymentDate;
		this.supplierCode = supplierCode;
		this.balance = balance;
		this.bankCode = bankCode;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(int supplierCode) {
		this.supplierCode = supplierCode;
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
	String paymentDate;
	  int supplierCode;
	  double balance;
	  int bankCode;
	
}
