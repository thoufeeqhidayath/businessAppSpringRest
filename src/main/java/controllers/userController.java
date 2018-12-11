/*package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import businessapp.business.viewModel;
import services.userService;

@RestController
public class userController {

	@Autowired
	private userService userService;
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public String addProduct(@RequestParam(value="userName",defaultValue="nothing")String userName,@RequestParam(value="userPassword",defaultValue="nothing")String userPassword) throws SQLException
	{
		return userService.addUser(userName,userPassword);	
	}
	
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public String deleteProduct(@RequestParam(value="userId",defaultValue="000")int userId) throws SQLException
	{
		return userService.deleteUser(userId);	
	}
	
	
	@RequestMapping(value="/updateUser",method=RequestMethod.GET)
	public String updateProduct(@RequestParam(value="userCode",defaultValue="000")int userCode,@RequestParam(value="userName",defaultValue="nothing")String userName,@RequestParam(value="userPassword",defaultValue="nothing")String userPassword) throws SQLException
	{
		return userService.updateUser(userCode, userName,userPassword);
	}
	
	
	@RequestMapping(value= "/viewUser" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewProducts() throws ClassNotFoundException, SQLException, IOException
	{ 	
		return userService.viewUser();
	}
}
*/