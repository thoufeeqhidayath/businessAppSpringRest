package businessapp.business;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import appDBrepository.dbCommonServices;
import appDBrepository.paymentDbRepositry;
import junit.framework.Assert;
import models.paymentModel;

@SpringBootTest
@RunWith(SpringRunner.class)
public class paymentServiceTest {
	
    paymentDbRepositry paymentDbRepositry=new paymentDbRepositry();
    dbCommonServices dbCommonServices=new dbCommonServices();
    
    
    @Test
    public void  addPayment() throws SQLException
	{
		String returnValue="payment   added";
		
		if(!(dbCommonServices.checkValueExists("supplier","supplier_code",4)).equals("exist"))
		{
			returnValue="SupplierID not exists";
		
		}
		else if(!(dbCommonServices.checkValueExists("bank_table","bank_code",1)).equals("exist"))
		{
			returnValue="bank code not exists";
		}
		else
		{
			paymentDbRepositry.insertIntoPayment(4,321,1);
		}
		
		assertEquals(returnValue,"payment   added");

	}
    
    @Test
	public void  deletePayment() throws SQLException
	{
		
		String returnValue="payment deleted";
	   
		int paymentNo=2;
	
		if(!(dbCommonServices.checkValueExists("payment","payment_no",paymentNo)).equals("exist"))
	
		{
			returnValue="payment number not exist";
		}
		else
		{
			paymentDbRepositry.deleteFromPayment(paymentNo);
		}
		assertEquals("payment deleted", returnValue);
	}
	
    
    
    @Test
	public void  updatePayment() throws SQLException
	{
		
		String returnValue="payment updated";
		int paymentNo=0;
		int supplierCode=0;
		double amount=0;
		int bankCode=0;
		
		if(!(dbCommonServices.checkValueExists("payment","payment_no",paymentNo)).equals("exist"))
		{
		returnValue="payment number not exists";
		}
		else if(!(dbCommonServices.checkValueExists("supplier","supplier_code",supplierCode).equals("exist")))
		{
		returnValue="supplier code not exists";
		
		}
		else  if(!(dbCommonServices.checkValueExists("bank_table","bank_code",bankCode).equals("exist")))
		{
			returnValue="bank code not exists";	
		}
		else
		{
			paymentDbRepositry.updatePayment(paymentNo, supplierCode, amount, bankCode);
		}
		assertEquals("payment updated", returnValue);
	}
	
	public ArrayList<paymentModel> viewPayment() throws ClassNotFoundException, SQLException, IOException
	{
		return paymentDbRepositry.readFromPayment();
	}

}
