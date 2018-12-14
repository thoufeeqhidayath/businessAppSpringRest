package businessapp.business;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import appDBrepository.customerDbRepository;
import appDBrepository.dbCommonServices;


public class customerServiceTest {
	
	@Autowired
	 customerDbRepository customerDbRepository=new customerDbRepository();
	@Autowired
	 dbCommonServices dbCommonServices=new  dbCommonServices();
	
	 
	@Test
	public void addCustomer() throws SQLException
	{
		customerDbRepository.insertIntoCustomer("miller");	
	}
	
	 
	@Test
	public void deleteCustomer() throws SQLException
	{
		
		String returnValue="deleted";	
		if(!(dbCommonServices.checkValueExists("customer","customer_code",4)).equals("exist"))
		{
			returnValue="Customer not exists";
		}
		
		else
		
		{
			customerDbRepository.deleteFromCustomer(4);
		}
        
		Assert.assertEquals("deleted", returnValue);
		
	}
	
	
	
	@Test
	public void updateCustomer() throws SQLException
	{
		String returnValue="updated";
		
		if(!(dbCommonServices.checkValueExists("customer","customer_code",5)).equals("exist"))
		{
		returnValue="Customer not exists";
		}
		else
		{
			customerDbRepository.updateCustomer(5,"miller");
		}
		
		Assert.assertEquals("updated", returnValue);
	}

	
	
	@Test
	public void viewCustomers() throws ClassNotFoundException, SQLException, IOException
	{	
	     customerDbRepository.readFromCustomer();
	}
	
	

}
