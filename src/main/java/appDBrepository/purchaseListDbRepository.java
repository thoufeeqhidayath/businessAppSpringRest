package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;


@Service
public class purchaseListDbRepository extends dbConnections {
	

	public void insertIntoPurchaseList(int purchaseNo,int itemCode,double price,double quantity) throws SQLException
	
	{
		String query = "call insert_purchase_list(?,?,?,?)";
		PreparedStatement preparedStatement=createPreparedStatement(query);
		
		try
		{
		preparedStatement.setInt(1, purchaseNo);
		preparedStatement.setInt(2, itemCode);
		preparedStatement.setDouble(3, price);
		preparedStatement.setDouble(4, quantity);
		preparedStatement.executeUpdate();
		}
		
		finally
		{
			preparedStatement.close();	
		}
	}
	
	
	
	
	public void deleteFromPurchaseList(int purchaseNo) throws SQLException
	{   
		
		 String query = "call soft_delete_purchase_list(?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
	     
	     try
	     {
	    	 preparedStatement.setInt(1, purchaseNo);
	    	 preparedStatement.executeUpdate();
	     }
	     finally
	     {
	    	 preparedStatement.close(); 
	     }
	     
    }
	
	public void updatePurchaseList(int purchaseNo,int itemCode,double price,double quantity) throws SQLException
	{
		
		 String query = "call update_purchase_list(?,?,?,?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
		 try{
		 preparedStatement.setInt(1, itemCode);
		 preparedStatement.setDouble(2, price);
		 preparedStatement.setDouble(3, quantity);
		 preparedStatement.setInt(4, purchaseNo);
		 preparedStatement.executeUpdate();
		 }
		 finally
		 {
			 preparedStatement.close();
		 }
		
	}
	
	public ArrayList<viewModel> readFromPurchaseList() throws SQLException
	{ 
		

		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> purchaseListRecord=new ArrayList<viewModel>();
	    
    
        String query ="call read_purchase_list()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs= preparedStatement.executeQuery();
       
        try{
       
        	while(rs.next())
        	{
    	  
        		int purchaseNo=rs.getInt("purchase_no");
        		int itemCode=rs.getInt("item_code");
        		double price=rs.getDouble("price");
        		double quantity=rs.getDouble("quantity");
        		viewModel=new viewModel(purchaseNo,itemCode,price,quantity);
        		purchaseListRecord.add(viewModel);
            }
            }
    
        	finally
        	{
        		preparedStatement.close();
        		rs.close();
        	}
      
        
      
		return purchaseListRecord;
		
	}

	
	
	

}
