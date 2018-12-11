package services;


import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import services.paymentService;
public class paymentServiceTest {
	
	private paymentService paymentService=new paymentService();;
	
	@BeforeClass
	public static void initialize()
	{
		
	
	}
	
	
	@Test
	public void addPayment() throws SQLException
	{
		int supplierId=4;
		double amount=21;
		int bankCode=1;
		final String actual="payment added";
		String expected=paymentService.addPayment(supplierId,amount,bankCode);
		Assert.assertEquals(expected, actual);
	}
	
	

}
