package businessapp.business;


import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
public class dbPropertiestTest {
        @Autowired
		private Properties Property;

	@Test
	public void getEncryptedPassword() throws IOException
	{
		FileReader fileReader=new FileReader("db.properties");
		Property.load(fileReader);
		assertEquals("thou", Property.getProperty("name"));
		
	}

	@Test
	public void getEncryptedName() throws IOException
	{
		FileReader fileReader=new FileReader("db.properties");
		Property.load(fileReader);
	assertEquals("password", Property.getProperty("password"));
	}
}
