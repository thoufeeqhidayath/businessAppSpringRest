package models;

public class salesListModel {
	
	  int salesNo;
	  int itemCode;
	  double price;
	  double quantity;
	
	  public int getSalesNo() {
		return salesNo;
	
	  }
	
	public void setSalesNo(int salesNo) {
		this.salesNo = salesNo;
	}
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
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
	  
	public salesListModel(int salesNo, int itemCode, double price, double quantity) {
		super();
		this.salesNo = salesNo;
		this.itemCode = itemCode;
		this.price = price;
		this.quantity = quantity;
	}

	public salesListModel() {
		super();
	}
	

}
