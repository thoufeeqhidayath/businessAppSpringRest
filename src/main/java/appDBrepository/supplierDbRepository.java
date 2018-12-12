package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;
import models.supplierModel;

@Service
public class supplierDbRepository extends dbConnections {
	
	public void insertIntoSupplier(String supplierName) throws SQLException
	{
	 
	 
		String query = "Call insert_supplier(?);";
		PreparedStatement preparedStatement=createPreparedStatement(query);
		try
		{
			preparedStatement.setString(1, supplierName);
			preparedStatement.executeUpdate();
		}
		finally
		{
			preparedStatement.close();
		}
	
	 
	}
	
	public void deleteFromSupplier(int supplierCode) throws SQLException
	{   
	    String query = "call soft_delete_supplier(?)";
		PreparedStatement preparedStatement=createPreparedStatement(query);
		try
		{
			preparedStatement.setInt(1, supplierCode);
			preparedStatement.executeUpdate();
		}
		finally
		{
			preparedStatement.close();
		}
	    
    }
	
	
	public void updateSupplier(int supplierCode,String supplierName) throws SQLException
	{
		 String query = "call update_supplier(?,?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
		
		 try{
			 preparedStatement.setString(1, supplierName);
			 preparedStatement.setInt(2, supplierCode);
			 preparedStatement.executeUpdate();
		    }
		 finally
		 {
			 preparedStatement.close();
		 }
		 
	}
	
	public ArrayList<supplierModel> readFromSupplier() throws SQLException
	{ 
		supplierModel supplierModel=new supplierModel();
	    ArrayList<supplierModel> supplierRecord=new ArrayList<supplierModel>();
	 
        String query ="call read_supplier()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs= preparedStatement.executeQuery();
        
        try
        {
        	  while(rs.next())
        		     
              {
          	  int supplierCode=rs.getInt("supplier_code");
          	  String supplierName=rs.getString("name");
          	  double balance=rs.getDouble("balance");
          	  supplierModel=new supplierModel(supplierCode,supplierName,balance);
          	  supplierRecord.add(supplierModel);
              }
        }
        finally
        {
        	preparedStatement.close();
        	rs.close();
        }
      
              
		return supplierRecord;
		
	}

}
