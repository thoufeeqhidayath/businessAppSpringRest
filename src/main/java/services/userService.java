package services;

import org.springframework.stereotype.Service;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;


import appDBrepository.userDbRepository;
import businessapp.business.viewModel;
import appDBrepository.dbCommonServices;
import models.userModel;
@Service
public class userService {
	
	@Autowired
	private userDbRepository userDbRepository;
	
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	
	
	public String addUser(String userName,String Password) throws SQLException
	{
		String returnValue="added";
		
		if((dbCommonServices.checkStringValueExists("user","user_name",userName)).equals("exist"))
		{
			returnValue="User already exists";
		}
		else
		{
		userDbRepository.insertIntoUser(userName,Password);
		}
		return returnValue;
		
	}
	
	
	public String deleteUser(int userCode) throws SQLException
	{
		
		String returnValue="deleted";
		if(!(dbCommonServices.checkValueExists("user","user_id",userCode)).equals("exist"))
		{
		returnValue="User not exists";
		}
		else
		{
			userDbRepository.deleteFromUser(userCode);
		}
		return returnValue;

	}
	
	public String updateUser(int userCode,String userName,String userPassword) throws SQLException
	{	
		String returnValue="updated";
		
		if(!(dbCommonServices.checkValueExists("user","user_id",userCode)).equals("exist"))
		{
		returnValue="User not exists";
		}
		else
		{
			userDbRepository.updateUser(userCode,userName,userPassword);
		}
		return returnValue;
	}
	
	
	
	
	
	public ArrayList<userModel> viewUser() throws ClassNotFoundException, SQLException, IOException
	{
		
		return userDbRepository.readFromUser();	
	}

}

