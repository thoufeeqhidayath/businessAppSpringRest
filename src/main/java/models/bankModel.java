package models;

public class bankModel {
int bankCode;
String bankName;
double balance;
public int getBankCode() {
	return bankCode;
}
public void setBankCode(int bankCode) {
	this.bankCode = bankCode;
}

public String getBankName() {
	return bankName;
}

public void setBankName(String bankName) {
	this.bankName = bankName;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public bankModel(int bankCode, String bankName, double balance) {
	super();
	this.bankCode = bankCode;
	this.bankName = bankName;
	this.balance = balance;
}
public bankModel() {
	super();
}

}
