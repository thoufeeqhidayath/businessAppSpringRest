package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.receiptModel;
import org.springframework.stereotype.Service;


@Service
public class receiptDbRepository extends dbConnections {
	
	
	public void insertIntoReceipt(int customerCode,double amount,int bankCode) throws SQLException
	
	{
		String query = "Call insert_receipt(?,?,?);";
		PreparedStatement preparedStatement=createPreparedStatement(query);
		
		try
		{
			preparedStatement.setInt(1, customerCode);
			preparedStatement.setDouble(2, amount);
			preparedStatement.setInt(3, bankCode);
			preparedStatement.executeUpdate();
		}
		
		finally
		{
			preparedStatement.close();
		}
	}
	
	public void deleteFromReceipt(int receipt_code) throws SQLException
	
	{   
		 String query = "call soft_delete_receipt(?)";
	     PreparedStatement preparedStatement=createPreparedStatement(query);
	    
	     try
	     {
	    	 preparedStatement.setInt(1, receipt_code);
	    	 preparedStatement.executeUpdate();
	     }
	     finally
	     {
	    	 preparedStatement.close();
	     }
    
	}

	public void updateReceipt(int receiptCode,int customerCode,double amount,int bankCode) throws SQLException
	{
		 String query = "call update_receipt(?,?,?,?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
		 
		 try
		 {
			 preparedStatement.setInt(1, customerCode);
			 preparedStatement.setDouble(2, amount);
			 preparedStatement.setInt(3, bankCode);
			 preparedStatement.setInt(4, receiptCode);
			 preparedStatement.executeUpdate();
		 }
		 finally
		 {
			 preparedStatement.close();
		 }
		 
		
	}
	
	public ArrayList<receiptModel> readFromReceipt() throws SQLException
	{ 
		

		receiptModel receiptModel=new receiptModel();
	    ArrayList<receiptModel> receiptRecord=new ArrayList<receiptModel>();
	    
        String query ="call read_receipt()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs= preparedStatement.executeQuery();
        
        try
        {
        	while(rs.next())
        	     
            {
        	  int receiptCode=rs.getInt("receipt_code");
        	  String receiptDate=(rs.getDate("receipt_date")).toString();
        	  int customerCode=rs.getInt("customer_code");
        	  double balance=rs.getDouble("amount");
        	  int bankCode=rs.getInt("bank_code");
        	 
        	  receiptModel=new receiptModel(receiptCode,receiptDate,customerCode,balance,bankCode);
        	  receiptRecord.add(receiptModel);
            }
        }
        finally
        {
        	 preparedStatement.close();
        	 rs.close();
        }
        
		return receiptRecord;
		
	}

}
