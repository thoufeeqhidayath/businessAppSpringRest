package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.stockModel;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;


@Service
public class stockDbRepository extends dbConnections {
	
	
	public void insertIntoStock(int productCode,int itemCode,double buyingPrice,double sellingPrice,double quantity) throws SQLException
	{
			stmt=createStatement();
			String sql = "call insert_stock("+productCode+","+itemCode+","+buyingPrice+","+sellingPrice+",'"+quantity+"'"+")";
			stmt.execute(sql);
	}

	
	public void deleteFromStock(int productNo) throws SQLException
	{   
         	String query = "call soft_delete_stock(?)";
         	PreparedStatement preparedStatement=createPreparedStatement(query);
         	preparedStatement.setInt(1, productNo);
         	preparedStatement.executeUpdate(); 
    }
	
	
	
	public void updateStock(int productCode,int itemCode,double buyingPrice,double sellingPrice,double quantity) throws SQLException
	{

	     	String query = "call update_stock_inc(?,?,?,?,?)";
	     	PreparedStatement preparedStatement=createPreparedStatement(query);
	     		
	     	
	     	
	     		preparedStatement.setInt(1, productCode);
	     		preparedStatement.setInt(2, itemCode);
	     		preparedStatement.setDouble(3, buyingPrice);
	     		preparedStatement.setDouble(4, sellingPrice);
	     	    preparedStatement.setDouble(5, quantity);
	     	    
	     	    
	     	    
	     	preparedStatement.executeUpdate(); 
		
	}
	
	public void updateStockInc(double newQuantity,int itemCode) throws SQLException
	{

     	String query = "call update_stock_inc(?,?)";
     	PreparedStatement preparedStatement=createPreparedStatement(query);
     	
     		preparedStatement.setDouble(1, newQuantity);
     		preparedStatement.setInt(2, itemCode);
     
        preparedStatement.executeUpdate(); 
	}
	
	
	public void updateStockDec(double newQuantity,int itemCode) throws SQLException
	{
		String query = "call update_stock_dec(?,?)";
     	PreparedStatement preparedStatement=createPreparedStatement(query);
     	preparedStatement.setDouble(1, newQuantity);
     	preparedStatement.setInt(2, itemCode);
     	preparedStatement.executeUpdate(); 
		
	}
	
	
	public ArrayList<stockModel> readFromStock() throws SQLException
	{ 
		

		
		stockModel stockModel=new stockModel();
	    ArrayList<stockModel> stockRecord=new ArrayList<stockModel>();
	   
	    String query ="call read_stock_details()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs= preparedStatement.executeQuery();
	    
        while(rs.next())
     
        {
    	  int productCode=rs.getInt("product_code");
    	  int itemCode=rs.getInt("item_code");
    	  double buyingPrice=rs.getDouble("buying_price");
    	  double sellingPrice=rs.getDouble("selling_price");
    	  double quantity=rs.getDouble("quantity");
    	  String productName=rs.getString("product_name");
    	
    	  stockModel=new stockModel(productCode,itemCode,buyingPrice,sellingPrice,quantity,productName);
    	  stockRecord.add(stockModel);
        }
      
        rs.close();
      
		return stockRecord;
		
	}

}
