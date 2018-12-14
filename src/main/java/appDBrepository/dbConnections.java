package appDBrepository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class dbConnections {

	 String USER ;
	 String PASS ;
	 String serverName;
	 String databaseName;
  
		
	@Autowired
	private databaseProperties databaseProperties;
		
    @Autowired
    protected static Statement stmt=null;
    
    @Autowired
    protected static PreparedStatement preapareStmt=null;
  
    @Autowired
    protected static  Connection conn=null;
    
    dbConnections()
    {
    	
    }
    public void getUserCredentials() throws IOException
	{
		USER = databaseProperties.getEncryptedName();
		PASS = databaseProperties.getEncryptedPassword();
		serverName=databaseProperties.getEncryptedServer();
		databaseName=databaseProperties.getEncryptedDatabase();
	}
    
    

    public Connection createConnection() throws SQLException
    {
    	try{
    	getUserCredentials();
		 conn= DriverManager.getConnection("jdbc:mysql://"+serverName+"/"+databaseName+"?autoReconnect=true&useSSL=false&maxReconnects=10 ",USER,PASS);
		
    }catch(IOException e)
    {
    	
    }
    return conn;
	}
	
    
   
    
	public Statement createStatement() throws SQLException
	{   
		 conn=createConnection();
         stmt = conn.createStatement();
		 return stmt;
	}
	
	
	public PreparedStatement createPreparedStatement(String query) throws SQLException
	{   
		 conn=createConnection();
		 preapareStmt = conn.prepareStatement(query);
		 return preapareStmt;
	}


}
