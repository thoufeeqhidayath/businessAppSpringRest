package appDBrepository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;


@Service
public class salesListDbRepository extends dbConnections{
	

	public void insertIntoSalesList(int salesNo,int itemCode,double price,double quantity) throws SQLException
	
	{
		
		String query = "call insert_sales_list(?,?,?,?)";
		
		PreparedStatement preparedStatement=createPreparedStatement(query);
		
        try{
				preparedStatement.setInt(1, salesNo);
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
	
	
	
	public void deleteFromSalesList(int salesNo) throws SQLException
	{   
		
		 String query = "call soft_delete_sales_list(?)";
	     PreparedStatement preparedStatement=createPreparedStatement(query);
	     try
	     {
	    	 preparedStatement.setInt(1, salesNo);
			 preparedStatement.executeUpdate(); 
	     }
	     finally
	     {
	    	 preparedStatement.close(); 
	     }
		
    }
	
	
	
	public void updateSalesList(int salesNo,int itemCode,double price,double quantity) throws SQLException
	{
		
		 String query = "call update_sales_list(?,?,?,?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
		 
		 try
		 {
		 	preparedStatement.setInt(1, itemCode);
		 	preparedStatement.setDouble(2, price);
		 	preparedStatement.setDouble(3, quantity);
		 	preparedStatement.setInt(4, salesNo);
		 	preparedStatement.executeUpdate();
		 }
		 finally
		 {
			 preparedStatement.close();
		 }
	}
	
	public ArrayList<viewModel> readFromSalesList() throws SQLException
	{ 
		
		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> salesListRecord=new ArrayList<viewModel>();
	  
    
        String query ="call read_sales_list()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs= preparedStatement.executeQuery();
       
        try
        {
        	 while(rs.next())
        	     
             {
         	  int salesNo=rs.getInt("sales_no");
         	  int itemCode=rs.getInt("item_code");
         	  double price=rs.getDouble("price");
         	  double quantity=rs.getDouble("quantity");
         	  viewModel=new viewModel(salesNo,itemCode,price,quantity);
         	 salesListRecord.add(viewModel);
             }
        }
        finally
        {
        	 rs.close();
        	 preparedStatement.close();
        }
  
			return salesListRecord;
		
	}

}
