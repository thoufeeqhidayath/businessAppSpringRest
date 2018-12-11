package businessapp.business;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class viewModel {
	 int id;
	 String name;
	 String password;
	 public viewModel(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	double balance;
	 String date;
	 int code;
	 double price;
	 public viewModel(int id, int code, double balance, double price, double quantity) {
		super();
		this.id = id;
		this.code = code;
		this.balance = balance;
		this.price = price;
		this.quantity = quantity;
	}
	double quantity;
	 
	 
	 public viewModel(int id, int code, double price, double quantity) {
		super();
		this.id = id;
		this.code = code;
		this.price = price;
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public viewModel(int id,String date, int code,  double balance,int bankCode) {
		super();
		this.id = id;
		this.balance = balance;
		this.date = date;
		this.code = code;
		this.bankCode = bankCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getBankCode() {
		return bankCode;
	}
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	int bankCode;
	
	public viewModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public viewModel(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public viewModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	 
}
