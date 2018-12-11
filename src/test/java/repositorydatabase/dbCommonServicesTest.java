package repositorydatabase;
import java.sql.SQLException;


import org.junit.Test;

import appDBrepository.dbCommonServices;
import junit.framework.Assert;
public class dbCommonServicesTest {
	
	public dbCommonServices dbCommonServices=new dbCommonServices();

	@Test
	public void checkvalueExists() throws SQLException
	{  
		String actual="exist";
		String expected=dbCommonServices.checkValueExists("payment", "payment_no", 3);
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void checkvalueStringExists() throws SQLException
	{
		String actual="exist";
		String expected=dbCommonServices.checkStringValueExists("bank_table", "bank_name","'cash'");
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void getMax() throws SQLException
	{
		String actual=Integer.toString(20);
		String expected=dbCommonServices.readMaxFrom("payment","payment_no");
		Assert.assertEquals(expected, actual);
	}
}
