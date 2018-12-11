package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;
@Service
public class customerDbRepository extends dbConnections {

	 public void insertIntoCustomer(String customerName) throws SQLException
		
		{
		 	String query = "Call insert_customer(?);";
			PreparedStatement preparedStatement=createPreparedStatement(query);
			
			try{
				
			preparedStatement.setString(1, customerName);
			preparedStatement.executeUpdate();
			
			}
			finally
			{
				preparedStatement.close();
			}
		}
		
	 
		public void deleteFromCustomer(int customerCode) throws SQLException
		
		{    
		     String query = "call soft_delete_customer(?)";
		     PreparedStatement preparedStatement=createPreparedStatement(query);
		     try
		     {
		     preparedStatement.setInt(1, customerCode);
			 preparedStatement.executeUpdate();
		     }
		     finally
		     {
		    	 preparedStatement.close(); 
		     }
	    }
		
		public void updateCustomer(int customerCode,String customerName) throws SQLException
		
		{
			 String query = "call update_customer(?,?)";
			 PreparedStatement preparedStatement=createPreparedStatement(query);
			
			 try{
				 preparedStatement.setInt(1,customerCode);
				 preparedStatement.setString(2, customerName);
				
				 preparedStatement.executeUpdate();
			 }
			 finally
			 {
				 preparedStatement.close(); 
			 }
		}
		
		public ArrayList<viewModel> readFromCustomer() throws SQLException
		{ 
			viewModel viewModel=new viewModel();
		    ArrayList<viewModel> customerRecord=new ArrayList<viewModel>();
		   
	        String query ="call read_customer()";
	        PreparedStatement preparedStatement=createPreparedStatement(query);
	        ResultSet rs= preparedStatement.executeQuery();
	    
	    try
	    {
	        while(rs.next())
	     
	        {
	    	  int customerCode=rs.getInt("customer_code");
	    	  String customerName=rs.getString("name");
	    	  double balance=rs.getDouble("balance");
	    	  viewModel=new viewModel(customerCode,customerName,balance);
	    	  customerRecord.add(viewModel);
	        }
		 
	    }
	    
	     finally
	     	{
	    	 	preparedStatement.close(); 
	    	 	rs.close();
	     	}
	      
	       
	      
			return customerRecord;
			
		}
	
	
	
	
}
