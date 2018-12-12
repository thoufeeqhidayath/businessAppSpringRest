package models;

public class purchaseListModel {
	
	int purchaseNo;
	int itemCode;
	double price;
	double quantity;
	
	
	public int getPurchaseNo() {
		return purchaseNo;
	}
	public purchaseListModel() {
		super();
	}
	public purchaseListModel(int purchaseNo, int itemCode, double price, double quantity) {
		super();
		this.purchaseNo = purchaseNo;
		this.itemCode = itemCode;
		this.price = price;
		this.quantity = quantity;
	}
	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
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

}
