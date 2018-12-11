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
	
	
	public String authenticateCustomer(String customerName,String password) throws SQLException
	{
	
		String returnValue="exist";
		
		if(!(authenticationDb.checkUserNameExists(customerName).equals("exist")))
		{
		returnValue="User Name Not exists";
		}
		else if(!(authenticationDb.checkPasswordExists(password).equals("exist")))
		{
		 returnValue="password Not exist";
		}
		
		return returnValue;
	}
	
	

}
