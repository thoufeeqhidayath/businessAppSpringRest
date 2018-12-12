package models;

public class customerModel {
	
	int customerCode;
	String customerName;
	double balance;
	
	
	public int getCustomerCode() {
		return customerCode;
	}
	
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public customerModel() {
		super();
	}

	public customerModel(int customerCode, String customerName, double balance) {
		super();
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.balance = balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
