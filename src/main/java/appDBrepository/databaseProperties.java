package appDBrepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class databaseProperties {
	
	@Autowired
	private Properties Property;
	
	
	private FileReader fileReader;
	
	public void initilaizeReader() throws FileNotFoundException
	{
	fileReader=new FileReader("db.properties");
	}
	
	public String getEncryptedName() throws IOException
	{
		initilaizeReader();
		Property.load(fileReader);
		return Property.getProperty("name");	
	}
	
	public String getEncryptedPassword() throws IOException
	{
		initilaizeReader();
		Property.load(fileReader);
		return Property.getProperty("password");	
	}
	
	public String getEncryptedServer() throws IOException
	{
		initilaizeReader();
		Property.load(fileReader);
		return Property.getProperty("server");	
	}
	
	public String getEncryptedDatabase() throws IOException
	{
		initilaizeReader();
		Property.load(fileReader);
		return Property.getProperty("database");	
	}

}
