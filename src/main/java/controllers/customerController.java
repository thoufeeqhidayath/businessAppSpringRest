package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.customerService;

import models.customerModel;

@RestController
public class customerController {

	@Autowired
	private customerService customerService;

	
	@RequestMapping(value="/addCustomer",method=RequestMethod.GET)
	public String addCustomer(@RequestParam(value="customerName",defaultValue="nothing")String customerName) throws SQLException
	{
		return customerService.addCustomer(customerName);	
	}
	
	
	@RequestMapping(value="/deleteCustomer",method=RequestMethod.GET)
	public String deleteCustomer(@RequestParam(value="customerCode",defaultValue="000")int customerCode) throws SQLException
	{
		return customerService.deleteCustomer(customerCode);	
	}
	
	
	@RequestMapping(value="/updateCustomer",method=RequestMethod.GET)
	public String updateCustomer(@RequestParam(value="customerCode",defaultValue="000")int customerCode,@RequestParam(value="customerName",defaultValue="nothing")String customerName) throws SQLException
	{
		return customerService.updateCustomer(customerCode, customerName);
	}
	
	
	@RequestMapping(value= "/viewCustomers" ,method = RequestMethod.GET)
	public ArrayList<customerModel> viewCustomers() throws ClassNotFoundException, SQLException, IOException
	{	
		return customerService.viewCustomers();
	}
}
