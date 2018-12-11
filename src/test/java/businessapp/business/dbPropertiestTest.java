package businessapp.business;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import org.junit.Test;
import org.springframework.stereotype.Service;

import junit.framework.Assert;


public class dbPropertiestTest {

		Properties Property=new Properties();

	@Test
	public void getEncryptedPassword() throws IOException
	{
		FileReader fileReader=new FileReader("db.properties");
		Property.load(fileReader);
		Assert.assertEquals("thou", Property.getProperty("name"));
		
	}

	@Test
	public void getEncryptedName() throws IOException
	{
		FileReader fileReader=new FileReader("db.properties");
		Property.load(fileReader);
		Assert.assertEquals("password", Property.getProperty("password"));
	}
}
