package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dbCommonServices extends dbConnections{
	
	public String checkValueExists(String tablename,String columnName,int value) throws SQLException
    {
    	
		String returnValue="exist";
        stmt=createStatement();
        String query="call check_value_exist(?,?,?)";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs;
	     try
	     {
	    	 preparedStatement.setString(1, columnName);
	    	 preparedStatement.setString(2,tablename);
	    	 preparedStatement.setInt(3,value); 
	    	 rs = preparedStatement.executeQuery();
		 
	    	 if(!rs.next())
	    	 {
	    		 returnValue="not exists";
	    	 }

	     }
	    
	     finally
	     {
	    	 preparedStatement.close(); 
	     }

    	 return returnValue; 	
    }
	
	public String checkStringValueExists(String tablename,String columnName,String value) throws SQLException
    {
    	
		String returnValue="exist";
        stmt=createStatement();
    	String query = "call check_string_value_exist(?,?,?)"; 
    	PreparedStatement preparedStatement=createPreparedStatement(query);
    	ResultSet rs;
        try
	   
        {
	    	 preparedStatement.setString(1, columnName);
	    	 preparedStatement.setString(2,tablename);
	    	 preparedStatement.setString(3,value); 
	    	 rs = preparedStatement.executeQuery();
		 
	    	 if(!rs.next())
	    	 {
	    		 returnValue="not exists";
	    	 }

	     }
	    
	     finally
	     {
	    	 preparedStatement.close(); 
	     }

    	return returnValue; 	
    }
	
	
	public String readMaxFrom(String tablename,String columnName) throws SQLException
	{ 
		int returnValue=1;
		stmt=createStatement();
	   	String query ="call read_max_from_table(?,?)";
	   	PreparedStatement preparedStatement=createPreparedStatement(query);
    	ResultSet rs=null;
        try
        {
	    	 preparedStatement.setString(1, tablename);
	    	 preparedStatement.setString(2,columnName);
	    	
	    	 rs = preparedStatement.executeQuery();
		 
	    	 while(rs.next())
	    	 {
	    		 returnValue=rs.getInt("max("+columnName+")");
	    	 }

	     }
	    
	     finally
	     {
	    	 preparedStatement.close(); 
	    	 if(rs!=null)
	    	  rs.close();
	     }

       
		return Integer.toString(returnValue);
		
	}
	

}
