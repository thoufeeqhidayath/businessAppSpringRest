package controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.authenticationService;


@RestController
public class authenticationController {
	
	@Autowired
	private authenticationService authenticationService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String Login(@RequestParam(value="customerName",defaultValue="nothing")String customerName,@RequestParam(value="customerPassword",defaultValue="nothing")String customerPassword) throws SQLException
	{
		return authenticationService.authenticateCustomer(customerName,customerPassword);	
	}
	
	

}
