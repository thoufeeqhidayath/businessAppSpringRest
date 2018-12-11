package appDBrepository;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class authenticationDb  extends dbConnections{
	
	
	public String checkUserNameExists(String name) throws SQLException
    {
    	 String returnValue="exist";
    	 String query = "call check_user_name_exist(?)";
    	 
    	 PreparedStatement preparedStatement =createPreparedStatement(query);
    	 preparedStatement.setString(1,name);
    	 ResultSet rs = preparedStatement.executeQuery();
    	  
    	 if(!rs.next())
         	{
    		returnValue="not exists";

         	}
    	return returnValue; 	
    }
	
	public String checkPasswordExists(String password) throws SQLException
    {
    	 String returnValue="exist";
    	 String query = "call check_user_password_exist(?)";
    	 
    	 PreparedStatement preparedStatement =createPreparedStatement(query);
    	 preparedStatement.setString(1,password);
    	 ResultSet rs = preparedStatement.executeQuery();
    	  
    	 if(!rs.next())
         	{
    		returnValue="not exists";

         	}
    	return returnValue; 	
    }

}
