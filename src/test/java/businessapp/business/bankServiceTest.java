package businessapp.business;

import static org.junit.Assert.*;

import java.io.IOException;



import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import appDBrepository.authenticationDb;
import appDBrepository.bankDbRepository;
import appDBrepository.dbCommonServices;

import models.bankModel;

@SpringBootTest
@RunWith(SpringRunner.class)
public class bankServiceTest {
	
     @Autowired
	private bankDbRepository bankDbRepository;
  @Autowired
	private dbCommonServices dbCommonServices;
	

	
	
	@Test
	public void addBank() throws SQLException
	{	
		    String returnValue="ADDED";
			bankDbRepository.insertIntoBank("bila");	
			assertEquals("ADDED",returnValue);	
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
		
	assertEquals("bank not exists",returnValue);
       
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
		assertEquals("Updated", returnValue);
	}
	
    
    @Test
	public void viewBank() throws ClassNotFoundException, SQLException, IOException
	{    
    	 ArrayList<bankModel> value= new ArrayList<bankModel>();
    	 bankModel bankModel=new bankModel(1,"cash",434);
    	 value.add(0, bankModel);
    	 ArrayList<bankModel> bankRecord= new ArrayList<bankModel>();
    	 bankRecord=bankDbRepository.readFromBank();
    	 
    assertEquals(value.get(0).bankCode, bankRecord.get(0).bankCode);
	}
	

}
