package businessapp.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class appDBrepository {
	
	final static  String JDBC_DRIVER = "com.mysql.cj.jdbc.driver";  
    final static String DB_URL = "jdbc:mysql://localhost:3306/businessapp";
	
    final static String USER = "root";
    final static String PASS = "password";
   
    @Autowired
    protected static Statement stmt=null;
  
    @Autowired
    protected static  Connection conn=null;
   
    public String checkValueExists(String tablename,String columnName,int value) throws SQLException
    {
    	String returnValue="exist";
    	 stmt=createStatement();
    	 String sql = "SELECT "+columnName+" FROM "+tablename+" where "+columnName+"="+value; 
    	 ResultSet rs = stmt.executeQuery(sql);
    	  
    	 if(!rs.next())
         	{
    		returnValue="not exists";
    	
         	}
    	return returnValue; 	
    }
	
    public Connection createConnection() throws SQLException	
    {
		 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/businessapp?autoReconnect=true&useSSL=false&maxReconnects=10 ",USER,PASS);
		 return conn;
	}
	
	public Statement createStatement() throws SQLException
	
	{   
		 conn=createConnection();
         stmt = conn.createStatement();
		 return stmt;
	}
	
	
	public void insertIntoProduct(String productName) throws SQLException
	{
	 stmt=createStatement();
	 String query = "Call insert_product('"+productName+"');";
	 stmt.execute(query); 
	}
	
	public void deleteFromProduct(int productCode) throws SQLException
	{   
		 stmt=createStatement();
	     String sql = "call delete_product("+productCode+")";
         stmt.executeUpdate(sql);
    }
	
	public void updateProduct(int productCode,String productName) throws SQLException
	{
		stmt=createStatement();
		String sql = "call update_product("+productCode+",'"+productName+"')";
		stmt.executeUpdate(sql);
		
	}
	public ArrayList<viewModel> readFromProduct() throws SQLException
	{ 
		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="call read_product()";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int productCode=rs.getInt("product_code");
    	  String productName=rs.getString("product_name");
    	  viewModel=new viewModel(productCode,productName);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}
	
    public void insertIntoCustomer(String customerName) throws SQLException
	
	{
	 stmt=createStatement();
	 String sql = "Call insert_customer('"+customerName+"');";
	 stmt.execute(sql);
	}
	
	public void deleteFromCustomer(int customerCode) throws SQLException
	
	{   
		 stmt=createStatement();
	     String sql = "call delete_customer( "+customerCode+")";
         stmt.executeUpdate(sql);
    }
	
	public void updateCustomer(int customerCode,String customerName) throws SQLException
	
	{
		stmt=createStatement();
		String sql = "call update_customer('"+customerName+"',"+customerCode+")";
		stmt.executeUpdate(sql);	
	}
	
	public ArrayList<viewModel> readFromCustomer() throws SQLException
	{ 
		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="call read_customer()";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int customerCode=rs.getInt("customer_code");
    	  String customerName=rs.getString("name");
    	  double balance=rs.getDouble("balance");
    	  viewModel=new viewModel(customerCode,customerName,balance);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}
	
   
	public void insertIntoSupplier(String supplierName) throws SQLException
	{
	 stmt=createStatement(); 
	 String sql = " Call insert_supplier('"+supplierName+"');";
	 stmt.execute(sql);
	}
	
	public void deleteFromSupplier(int supplierCode) throws SQLException
	{   
		 stmt=createStatement();
	     String sql = "call delete_supplier("+supplierCode+")";
         stmt.executeUpdate(sql);
    }
	
	public void updateSupplier(int supplierCode,String supplierName) throws SQLException
	{
		stmt=createStatement();
		String sql = "call update_supplier('"+supplierName+"',"+supplierCode+")";
		stmt.executeUpdate(sql);
		
	}
	
	public ArrayList<viewModel> readFromSupplier() throws SQLException
	{ 
		

		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="call read_supplier()";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int supplierCode=rs.getInt("supplier_code");
    	  String supplierName=rs.getString("name");
    	  double balance=rs.getDouble("balance");
    	  System.out.println(balance+" ");
    	  viewModel=new viewModel(supplierCode,supplierName,balance);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}
	

	public void insertIntoBank(String bankName) throws SQLException
	{ 
	 stmt=createStatement();
	 String sql = "Call insert_bank_table('"+bankName+"');";
	 stmt.execute(sql);
	}
	
	public void deleteFromBank(int bankCode) throws SQLException
	
	{   
		 stmt=createStatement();
	     String sql = "call delete_bank_table("+bankCode+")";
         stmt.executeUpdate(sql);
    }
	
	public void updateBank(int bankCode,String bankName) throws SQLException
	
	{   
		 stmt=createStatement();
		 String sql = "call update_bank_table('"+bankName+"',"+bankCode+")";
         stmt.executeUpdate(sql);
    }
	
	public ArrayList<viewModel> readFromBank() throws SQLException
	{ 
		
		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="call read_bank_table()";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int bankCode=rs.getInt("bank_code");
    	  String bankName=rs.getString("bank_name");
    	  double balance=rs.getDouble("balance");
    	  viewModel=new viewModel(bankCode,bankName,balance);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}

    

	public void insertIntoPayment(int supplierId,double amount,int bankCode) throws SQLException
	
	{
	 stmt=createStatement();
	 String sql = "Call insert_payment('"+supplierId+"',"+amount+","+bankCode+");";
	 stmt.execute(sql);
	}
	
	public void deleteFromPayment(int paymentNo) throws SQLException
	
	{   
		 stmt=createStatement();
	     String sql = "call delete_payment("+paymentNo+")";
         stmt.executeUpdate(sql);
    }
	
	public void updatePayment(int paymentNo,int supplierCode,double amount,int bankCode) throws SQLException
	{
		
		stmt=createStatement(); 
		String sql = "call update_payment("+supplierCode+","+amount+","+bankCode+","+paymentNo+")";
		stmt.execute(sql);
		
	}
	
	
	public ArrayList<viewModel> readFromPayment() throws SQLException
	{ 
		

		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="call read_payment()";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int paymentNo=rs.getInt("payment_no");
    	  String paymentDate=(rs.getDate("payment_date")).toString();
    	  int supplierCode=rs.getInt("supplier_code");
    	  double balance=rs.getDouble("amount");
    	  int bankCode=rs.getInt("bank_code");
    	
    	  viewModel=new viewModel(paymentNo,paymentDate,supplierCode,balance,bankCode);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}

	public void insertIntoReceipt(int customerCode,double amount,int bankCode) throws SQLException
	
	{
	 stmt=createStatement();
	 String sql = "Call insert_receipt('"+customerCode+"',"+amount+","+bankCode+");";
	 stmt.execute(sql);
	}
	
	public void deleteFromReceipt(int receipt_code) throws SQLException
	
	{   
		 stmt=createStatement();
	     String sql = "call delete_receipt("+receipt_code+")";
         stmt.executeUpdate(sql);
    }

	public void updateReceipt(int receiptCode,int customerCode,double amount,int bankCode) throws SQLException
	{
		
		stmt=createStatement(); 
		String sql = "call update_receipt("+customerCode+","+amount+","+bankCode+","+receiptCode+")";
		stmt.execute(sql);
		
	}
	public ArrayList<viewModel> readFromReceipt() throws SQLException
	{ 
		

		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="call read_receipt()";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int receiptCode=rs.getInt("receipt_code");
    	  String receiptDate=(rs.getDate("receipt_date")).toString();
    	  int customerCode=rs.getInt("customer_code");
    	  double balance=rs.getDouble("amount");
    	  int bankCode=rs.getInt("bank_code");
    	 
    	  viewModel=new viewModel(receiptCode,receiptDate,customerCode,balance,bankCode);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}
	

	public void insertIntoStock(int productCode,int itemCode,double buyingPrice,double sellingPrice,double quantity) throws SQLException
	{
		stmt=createStatement();
		String sql = "call insert_stock("+productCode+","+itemCode+","+buyingPrice+","+sellingPrice+",'"+quantity+"'"+")";
		stmt.execute(sql);
	}
	
	public void deleteFromStock(int productNo) throws SQLException
	{   
		 stmt=createStatement();
	     String sql = "call delete_stock("+productNo+")";
         stmt.executeUpdate(sql);
    }
	
	
	
	public void updateStock(int productCode,int itemCode,double buyingPrice,double sellingPrice,double quantity) throws SQLException
	{
		 stmt=createStatement();
	     String sql = "update stock set product_code="+productCode+",item_code="+itemCode+",buying_price="+buyingPrice+",selling_price="+sellingPrice+",quantity="+quantity+" WHERE item_code = "+itemCode;
         stmt.executeUpdate(sql);	
	}
	
	public void updateStockInc(double newQuantity,int itemCode) throws SQLException
	{
		 stmt=createStatement();
	     String sql = "update stock set quantity=quantity+"+newQuantity+" WHERE item_code = "+itemCode;
         stmt.executeUpdate(sql);	
	}
	
	public void updateStockDec(double newQuantity,int itemCode) throws SQLException
	{
		 stmt=createStatement();
		 String sql = "update stock set quantity=quantity-"+newQuantity+" WHERE item_code = "+itemCode;
         stmt.executeUpdate(sql);
	}
	
	
	public ArrayList<viewModel> readFromStock() throws SQLException
	{ 
		

		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="select * from stock";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int productCode=rs.getInt("product_code");
    	  int itemCode=rs.getInt("item_code");
    	  double buyingPrice=rs.getDouble("buying_price");
    	  double sellingPrice=rs.getDouble("selling_price");
    	  double quantity=rs.getDouble("quantity");
    	
    	  viewModel=new viewModel(productCode,itemCode,buyingPrice,sellingPrice,quantity);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}
	
	
	
	
	
	public void insertIntoPurchaseInvoice(int supplierCode,int bankCode) throws SQLException
	{
	 stmt=createStatement();
	 String sql = "call insert_purchase_invoice("+"'"+supplierCode+"',"+"'"+bankCode+"',"+")";
	 stmt.execute(sql);
	}
	
	public void deleteFromPurchaseInvoice(int purchaseNo) throws SQLException
	{   
		 stmt=createStatement();
	     String sql = "call delete_purchase_invoice("+purchaseNo+")";
         stmt.executeUpdate(sql);
    }
	
	public void updatePurchaseInvoice(int  purchaseNo,int supplierCode,int bankCode) throws SQLException
	{
		stmt=createStatement(); 
		String sql = "update purchase_invoice set supplier_code="+supplierCode+",bank_code="+bankCode+"where purchase_no="+purchaseNo;
		stmt.equals(sql);	
	}
	
	public ArrayList<viewModel> readFromPurchaseInvoice() throws SQLException
	{ 
		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="select * from purchase_invoice";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int purchaseNo=rs.getInt("purchase_no");
    	  String purchaseDate=(rs.getDate("purchase_date")).toString();
    	  int supplierCode=rs.getInt("supplier_code");
    	  int bankCode=rs.getInt("bank_code");
    	  double balance=rs.getDouble("total");
    	  
    	  viewModel=new viewModel(purchaseNo,purchaseDate,supplierCode,balance,bankCode);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}

	public void updateSalesInvoice(int  salesNo,int customerCode,int bankCode) throws SQLException
	{
		stmt=createStatement(); 
		String sql = "update sales_invoice set customer_code="+customerCode+",bank_code="+bankCode+"where sales_no="+salesNo;
		stmt.execute(sql);
		
	}

	public void insertIntoSalesInvoice(int customerCode,int bankCode) throws SQLException
	
	{
	 stmt=createStatement();
	 String sql = "CALL insert_sales_invoice("+"'"+customerCode+"',"+"'"+bankCode+"',"+0+")";
	 stmt.execute(sql);
	}
	
	public void deleteFromSalesInvoice(int salesNo) throws SQLException
	
	{   
		 stmt=createStatement();
	     String sql = "call delete_sales_invoice("+salesNo+")";
         stmt.executeUpdate(sql);
    }
     
	

	public void insertIntoPurchaseList(int purchaseNo,int itemCode,double price,double quantity) throws SQLException
	
	{
		stmt=createStatement();
		String sql = "call insert_purchase_list VALUES("+purchaseNo+","+"'"+itemCode+"',"+price+",'"+quantity+"'"+")";
		stmt.execute(sql);
	}
	
	public void deleteFromPurchaseList(int purchaseNo) throws SQLException
	{   
		 stmt=createStatement();
	     String sql = "call delete_purchase_list("+purchaseNo+")";
         stmt.executeUpdate(sql);
    }
	
	public void updatePurchaseList(int purchaseNo,int itemCode,double price,double quantity) throws SQLException
	{
		
		stmt=createStatement(); 
		String sql = "update purchase_list set item_code="+itemCode+",price="+price+",quantity="+quantity+"where purchase_no="+purchaseNo;
		stmt.execute(sql);
		
	}
	
	public ArrayList<viewModel> readFromPurchaseList() throws SQLException
	{ 
		

		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="select * from purchase_list";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int purchaseNo=rs.getInt("purchase_no");
    	  int itemCode=rs.getInt("item_code");
    	  double price=rs.getDouble("price");
    	  double quantity=rs.getDouble("quantity");
    	 
    	  viewModel=new viewModel(purchaseNo,itemCode,price,quantity);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}

	

	public void insertIntoSalesList(int salesNo,int itemCode,double price,double quantity) throws SQLException
	
	{
		stmt=createStatement();
		String sql = "call insert_sales_list("+salesNo+","+"'"+itemCode+"',"+price+",'"+quantity+"'"+")";
		stmt.execute(sql);
	}
	
	public void deleteFromSalesList(int salesNo) throws SQLException
	{   
		 stmt=createStatement();
	     String sql = "call delete_sales_list("+salesNo+")";
         stmt.executeUpdate(sql);
    }
	
	public void updateSalesList(int salesNo,int itemCode,double price,double quantity) throws SQLException
	{
		
		stmt=createStatement(); 
		String sql = "update sales_list set item_code="+itemCode+",price="+price+",quantity="+quantity+"where sales_no="+salesNo;
		stmt.execute(sql);
		
	}
	
	public ArrayList<viewModel> readFromSalesList() throws SQLException
	{ 
		

		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="select * from sales_list";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int salesNo=rs.getInt("sales_no");
    	  int itemCode=rs.getInt("item_code");
    	  double price=rs.getDouble("price");
    	  double quantity=rs.getDouble("quantity");
    	 
    	  viewModel=new viewModel(salesNo,itemCode,price,quantity);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}

	public ArrayList<viewModel> readFromSalesInvoice() throws SQLException
	{ 
		

		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> sendArray=new ArrayList<viewModel>();
	    stmt=createStatement();
        String sql ="select * from sales_invoice";
        ResultSet rs=stmt.executeQuery(sql);
    
        while(rs.next())
     
        {
    	  int salesNo=rs.getInt("sales_no");
    	  String salesDate=(rs.getDate("sales_date")).toString();
    	  int customerCode=rs.getInt("customer_code");
    	  double balance=rs.getDouble("total");
    	  int bankCode=rs.getInt("bank_code");
    	 
    	  viewModel=new viewModel(salesNo,salesDate,customerCode,balance,bankCode);
    	  sendArray.add(viewModel);
        }
      
        rs.close();
      
		return sendArray;
		
	}

	public String readMaxFrom(String tablename,String columnName) throws SQLException
	{ 
		
		stmt=createStatement();
	   	String sql ="select max("+columnName+") from "+tablename;
	   	ResultSet rs=stmt.executeQuery(sql);
      
        int returnValue=1;
     
        while(rs.next())
     
        {
        	returnValue=rs.getInt("max(purchase_no)");
    	 
        }
      
        rs.close();
        
		return Integer.toString(returnValue);
		
	}

}
