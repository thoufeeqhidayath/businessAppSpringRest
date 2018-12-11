package businessapp.business;



import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import appDBrepository.authenticationDb;


public class authenticationServiceTests {
	
	@Autowired
	public static authenticationDb authenticationDb;
	
    @Before
    public  void initialize()
    {
      authenticationDb=new authenticationDb() ;
    }
   
	
	
	
	@Test
	public void authenticateCustomer() throws SQLException {
		
		String returnValue="exist";
		
		if(!(authenticationDb.checkUserNameExists("admin").equals("exist")))
		{ 
		returnValue="User Name Not exists";
		}
		else if(!(authenticationDb.checkPasswordExists("admin").equals("exist")))
		{
		 returnValue="password Not exist";
		}
		
		Assert.assertEquals("password Not exist", returnValue);
	}
	
	

	
	
	

}
