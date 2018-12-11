package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;

@Service
public class paymentDbRepositry extends dbConnections {

	public void insertIntoPayment(int supplierId,double amount,int bankCode) throws SQLException
	
	{
	
	     String query = "Call insert_payment(?,?,?);";
	     PreparedStatement preparedStatement=createPreparedStatement(query);
	    
	     try
	     {
	     preparedStatement.setInt(1, supplierId);
		 preparedStatement.setDouble(2,amount);
		 preparedStatement.setInt(3,bankCode); 
		 preparedStatement.executeUpdate();
	     }
	     finally
	     {
	    	 preparedStatement.close(); 
	     }
		 
		 
	 
	}
	
	public void deleteFromPayment(int paymentNo) throws SQLException
	{
	     String query = "call soft_delete_payment(?)";
	     PreparedStatement preparedStatement=createPreparedStatement(query);
	    
	     try{
	    	 
	 	 preparedStatement.setInt(1, paymentNo);
	 	 preparedStatement.executeUpdate();
	 	 
	 	 }
	     finally
	     {
			preparedStatement.close(); 
	     }
    }
	
	public void updatePayment(int paymentNo,int supplierCode,double amount,int bankCode) throws SQLException
	{
		 String query = "call update_payment(?,?,?,?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
		
		 try{
			
		 preparedStatement.setInt(1, supplierCode);
		 preparedStatement.setDouble(2, amount);
		 preparedStatement.setInt(3, bankCode);
		 preparedStatement.setInt(4, paymentNo);
		 preparedStatement.executeUpdate();
			
	 	    }
    		finally
    		{
    			preparedStatement.close(); 
    		}
	}
	
	
	public ArrayList<viewModel> readFromPayment() throws SQLException
	{ 
		

		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> paymentRecord=new ArrayList<viewModel>();
	    
        String query ="call read_payment()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs= preparedStatement.executeQuery();
        
        try{
        	while(rs.next())
        {
    	  int paymentNo=rs.getInt("payment_no");
    	  String paymentDate=(rs.getDate("payment_date")).toString();
    	  int supplierCode=rs.getInt("supplier_code");
    	  double balance=rs.getDouble("amount");
    	  int bankCode=rs.getInt("bank_code");
    	
    	  viewModel=new viewModel(paymentNo,paymentDate,supplierCode,balance,bankCode);
    	  paymentRecord.add(viewModel);
        } 
        
        	}
	     
        finally
	     
	     {
	    	 preparedStatement.close();
	    	 rs.close();
	     }
    
		return paymentRecord;
		
	}

}
