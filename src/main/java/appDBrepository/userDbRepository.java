package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;

@Service
public class userDbRepository extends dbConnections {
	
	
	public void insertIntoUser(String userName,String password) throws SQLException
	{
		String query = "Call insert_user(?,?);";
		PreparedStatement preparedStatement=createPreparedStatement(query);
		try
		{
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			preparedStatement.executeUpdate();
		}
		finally
		{
			preparedStatement.close();
		}
		
	}
	
	public void deleteFromUser(int userCode) throws SQLException
	{   
        String query = "call soft_delete_user(?)";
      	PreparedStatement preparedStatement=createPreparedStatement(query);
      	try
      	{
      		preparedStatement.setInt(1, userCode);
          	preparedStatement.executeUpdate(); 
      	}
      	finally
		{
			preparedStatement.close();
		}
      	
    }
	
	public void updateUser(int userCode,String userName,String userPassword) throws SQLException
	{
		 String query = "call update_user(?,?,?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
		
		 try
		 {
			 preparedStatement.setString(1, userName);
			 preparedStatement.setString(2, userPassword);
			 preparedStatement.setInt(3, userCode);
			 preparedStatement.executeUpdate();
	
		 }
		 finally
		 {
			preparedStatement.close();
		
		 }
		
	}
	
	public ArrayList<viewModel> readFromUser() throws SQLException
	{ 
		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> userRecord=new ArrayList<viewModel>();
	  
        String query ="call read_user()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs= preparedStatement.executeQuery();
        
        try
        {
        	while(rs.next())
        	     
            {
        	  int supplierCode=rs.getInt("user_id");
        	  String supplierName=rs.getString("user_name");
        	  String password=rs.getString("password");        
        	  viewModel=new viewModel(supplierCode,supplierName,password);
        	  userRecord.add(viewModel);
            }
        }
        finally
        {
        	preparedStatement.close();
        	 rs.close();
        }
		return userRecord;
	}
	

}
