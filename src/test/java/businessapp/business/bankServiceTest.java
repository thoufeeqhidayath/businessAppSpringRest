package businessapp.business;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import appDBrepository.authenticationDb;
import appDBrepository.bankDbRepository;
import appDBrepository.dbCommonServices;
import junit.framework.Assert;
import businessapp.business.viewModel;
public class bankServiceTest {
	

	private bankDbRepository bankDbRepository;
	private dbCommonServices dbCommonServices;
	
	@Before
	public void initialize()
	{
		
		bankDbRepository=new bankDbRepository();
		dbCommonServices=new dbCommonServices();
	}
	
	
	@Test
	public void addBank() throws SQLException
	{	
		    String returnValue="ADDED";
			bankDbRepository.insertIntoBank("bila");	
			Assert.assertEquals("ADDED",returnValue);	
	}
	
	
	@Test
	public void deleteBank() throws SQLException
	{
		String returnValue="deleted";
		if(!(dbCommonServices.checkValueExists("bank_table","bank_code",3)).equals("exist"))
	
		{
		returnValue="bank not exists";
		}
	
		else
		{
			bankDbRepository.deleteFromBank(3);
		}
		
		Assert.assertEquals("bank not exists",returnValue);
       
	}
	
	
     @Test
	public void updateBank() throws SQLException
	{
		String returnValue="Updated";
		if(!(dbCommonServices.checkValueExists("bank_table","bank_code",6)).equals("exist"))
	
		{
		returnValue="bank not exists";
		}
	
		else
		{
			bankDbRepository.updateBank(6, "world bank");
		}
		 Assert.assertEquals("Updated", returnValue);
	}
	
    
    @Test
	public void viewBank() throws ClassNotFoundException, SQLException, IOException
	{    
    	 ArrayList<viewModel> value= new ArrayList<viewModel>();
    	 viewModel viewModel=new viewModel(1,"cash",434);
    	 value.add(0, viewModel);
    	 ArrayList<viewModel> bankRecord= new ArrayList<viewModel>();
    	 bankRecord=bankDbRepository.readFromBank();
    	 Assert.assertEquals(value.get(0).balance, bankRecord.get(0).balance);
    	 Assert.assertEquals(value.get(0).bankCode, bankRecord.get(0).bankCode);
	}
	

}
