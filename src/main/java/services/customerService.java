package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.customerDbRepository;
import appDBrepository.dbCommonServices;
import businessapp.business.viewModel;

@Service
public class customerService {
	@Autowired
	private customerDbRepository customerDbRepository;
	
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	public String addCustomer(String customerName) throws SQLException
	{
		customerDbRepository.insertIntoCustomer(customerName);
		return "Customer added";
		
	}
	
	
	public String deleteCustomer(int customerCode) throws SQLException
	{
		
		String returnValue="deleted";	
		if(!(dbCommonServices.checkValueExists("customer","customer_code",customerCode)).equals("exist"))
		{
			returnValue="Customer not exists";
		}
		
		else
		
		{
			customerDbRepository.deleteFromCustomer(customerCode);
		}
		return returnValue;	
		
	}
	
	public String updateCustomer(int customerCode,String customerName) throws SQLException
	{
		String returnValue="Updated";
		
		if(!(dbCommonServices.checkValueExists("customer","customer_code",customerCode)).equals("exist"))
		{
		returnValue="Customer not exists";
		}
		else
		{
			customerDbRepository.updateCustomer(customerCode, customerName);
		}
		
		return returnValue;	
	}

	public ArrayList<viewModel> viewCustomers() throws ClassNotFoundException, SQLException, IOException
	{	
	     return customerDbRepository.readFromCustomer();
	}
}
