package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;

@Service
public class bankDbRepository extends dbConnections{

	public void insertIntoBank(String bankName) throws SQLException
	{ 
		
		String query = "Call insert_bank_table(?);";
		PreparedStatement preparedStatement=createPreparedStatement(query);
		
		
		try{
			
		preparedStatement.setString(1, bankName);
		preparedStatement.executeUpdate();
		
		}
		 	
		finally
		{
			preparedStatement.close();
		}
	}
	
	public void deleteFromBank(int bankCode) throws SQLException
	
	{   
		
	     String query = "call soft_delete_bank_table(?)";
	     PreparedStatement preparedStatement=createPreparedStatement(query);
	     
	     try{
	    	 
		 preparedStatement.setInt(1, bankCode);
		 preparedStatement.executeUpdate();
	    
	     }
	     
	     finally
			{
				preparedStatement.close();
			}
	     
        
    }
	
	public void updateBank(int bankCode,String bankName) throws SQLException
	{   
		 String query = "call update_bank_table(?,?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
		
		 try{
		 preparedStatement.setString(1, bankName);
		 preparedStatement.setInt(2, bankCode);
		 preparedStatement.executeUpdate();
		 }
		 
		 finally{
			 
			 preparedStatement.close();
			 
		 }
    }
	
	
	public ArrayList<viewModel> readFromBank() throws SQLException
	{ 
		
		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> bankRecord=new ArrayList<viewModel>();
	   
        String query ="call read_bank_table()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs=null;
        		
        try
        {
        	rs=preparedStatement.executeQuery();
        	while(rs.next())
    	  
        	{
        		int bankCode=rs.getInt("bank_code");
        		String bankName=rs.getString("bank_name");
        		double balance=rs.getDouble("balance");
        		viewModel=new viewModel(bankCode,bankName,balance);
        		bankRecord.add(viewModel);
       
            }   
        }
        finally
        {
    	   preparedStatement.close();
    	   if(rs!=null)
    	   rs.close();
        }
      
      
		return bankRecord;
		
	}
	
}
