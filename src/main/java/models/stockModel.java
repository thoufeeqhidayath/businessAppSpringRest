package models;

public class stockModel {
	
	
	
	
	public stockModel() {
		super();
	}

	public stockModel(int productId, int itemCode, double buyingPrice, double sellingPrice, double quantity,String productName
			) 
	{
		super();
		this.productName = productName;
		this.itemCode = itemCode;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
		this.productId = productId;
	}
	
	
	
	String productName;
	int itemCode;
	double buyingPrice;
	double sellingPrice;
	double quantity;
	int productId;
	
	
	
	
	
	public int getProductId()
	{
		return productId;
	}
	
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	
	public String getProductName() 
	{
		return productName;
	}
	
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	
	public int getItemCode() 
	{
		return itemCode;
	}
	
	public void setItemCode(int itemCode)
	{
		this.itemCode = itemCode;
	}
	
	public double getBuyingPrice()
	{
		return buyingPrice;
	}
	
	public void setBuyingPrice(double buyingPrice) 
	{
		this.buyingPrice = buyingPrice;
	}
	
	public double getSellingPrice()
	{
		return sellingPrice;
	}
	
	public void setSellingPrice(double sellingPrice)
	{
		this.sellingPrice = sellingPrice;
	}
	
	public double getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(double quantity)
	{
		this.quantity = quantity;
	}

	
	
	

}
