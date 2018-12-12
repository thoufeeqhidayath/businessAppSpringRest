package services;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.authenticationDb;

@Service
public class authenticationService {

	@Autowired
	private authenticationDb authenticationDb;
	
	
	public String authenticateUser(String userName,String userPassword) throws SQLException
	{
	
		String returnValue="exist";
		
		if(!(authenticationDb.checkUserNameExists(userName).equals("exist")))
		{
			returnValue="User Name Not exists";
		}
		else if(!(authenticationDb.checkPasswordExists(userPassword).equals("exist")))
		{
		
			returnValue="password Not exist";
		
		}
		
		return returnValue;
	}
	
	

}
