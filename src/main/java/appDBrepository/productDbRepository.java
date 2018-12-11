package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;

@Service
public class productDbRepository extends dbConnections {
	
	public void insertIntoProduct(String productName) throws SQLException
	{
		String query = "Call insert_product(?);";
		PreparedStatement preparedStatement=createPreparedStatement(query);
		
		
		try{
			
		preparedStatement.setString(1,productName);
		preparedStatement.executeUpdate();
		
		}
		finally
		{
			preparedStatement.close();
		}
		
	}
	
	public void deleteFromProduct(int productCode) throws SQLException
	{   
			String query = "call soft_delete_product(?)";
			PreparedStatement preparedStatement=createPreparedStatement(query);
			
	     try
	     {
	    	 
	    	 preparedStatement.setInt(1, productCode);
	    	 preparedStatement.executeUpdate();
	    
	     }
	     finally
	     {
	    	 preparedStatement.close(); 
	     }
		
	
		 
    }
	
	public void updateProduct(int productCode,String productName) throws SQLException
	{
		 String query = "call update_product(?,?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
		 
		 try
		 {
			 preparedStatement.setString(2, productName);
			 preparedStatement.setInt(1, productCode);
			 preparedStatement.executeUpdate();	
		 }
		 
		 finally
		 {
			 preparedStatement.close();
		 }
		 
	}
	
	
	public ArrayList<viewModel> readFromProduct() throws SQLException
	{ 
		viewModel viewModel=new viewModel();
	    ArrayList<viewModel> bunchOfProducts=new ArrayList<viewModel>();
	    
        String query ="call read_product()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs= preparedStatement.executeQuery();
    
        try
        {
        	
        while(rs.next())
        {
    	  int productCode=rs.getInt("product_code");
    	  String productName=rs.getString("product_name");
    	  viewModel=new viewModel(productCode,productName);
    	  bunchOfProducts.add(viewModel);
        }
        }
       
        finally
        {
        	preparedStatement.close();
        	rs.close();
        }
        
        
		return bunchOfProducts;
		
	}

}
