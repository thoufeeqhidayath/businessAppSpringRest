package models;

public class productModel {
	int productId;
	String productName;

	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	public String getProductName() {
		return productName;
	}
	
	
	public productModel() {
		super();
	}

	public productModel(int productId, String productName) {
		
		super();
		this.productId = productId;
		this.productName = productName;
	}

	public void setProductName(String productName) {
		
		this.productName = productName;
	}

}
