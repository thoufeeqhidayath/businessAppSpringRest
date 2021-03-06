package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;
import models.salesInvoiceModel;

@Service
public class salesInvoiceDbRepository extends dbConnections{

	
	public void insertIntoSalesInvoice(int customerCode,int bankCode) throws SQLException
	
	{
		String query = "CALL insert_sales_invoice(?,?,?)";
		PreparedStatement preparedStatement=createPreparedStatement(query);
	    try
	    {
	    	preparedStatement.setInt(1, customerCode);
			preparedStatement.setInt(2, bankCode);
			preparedStatement.setDouble(3, 0);
			preparedStatement.executeUpdate();
	    }
	    finally
	    {
	    	preparedStatement.close();
	    }
		
		
		
	}
	
	public void deleteFromSalesInvoice(int salesNo) throws SQLException
	{    
	     String query = "call soft_delete_sales_invoice(?)";
	     PreparedStatement preparedStatement=createPreparedStatement(query);
	     try
	     {
	    	 preparedStatement.setInt(1,salesNo);
			 preparedStatement.executeUpdate();
	     }
	     finally
	     {
	    	 preparedStatement.close();
	     }
		 
    }
     
	public void updateSalesInvoice(int  salesNo,int customerCode,int bankCode) throws SQLException
	{
		 String query = "call update_sales_invoice(?,?,?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
		 
		 try
		 {
			 preparedStatement.setInt(1, customerCode);
			 preparedStatement.setInt(2, bankCode);
			 preparedStatement.setInt(3, salesNo);
			 preparedStatement.executeUpdate();
		 }
		
		 finally
		 {
			 preparedStatement.close(); 
		 }
		 
	}

	public ArrayList<salesInvoiceModel> readFromSalesInvoice() throws SQLException
	
	{ 

		salesInvoiceModel salesInvoiceModel=new salesInvoiceModel();
	    ArrayList<salesInvoiceModel> salesInvoiceRecord=new ArrayList<salesInvoiceModel>();
	   
        String query ="call read_sales_invoice()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs= preparedStatement.executeQuery();
       
        try
        {
        	 while(rs.next())
        	     
             {
         	  int salesNo=rs.getInt("sales_no");
         	  String salesDate=(rs.getDate("sales_date")).toString();
         	  int customerCode=rs.getInt("customer_code");
         	  double balance=rs.getDouble("total");
         	  int bankCode=rs.getInt("bank_code");
         	 
         	  salesInvoiceModel=new salesInvoiceModel(salesNo,salesDate,customerCode,balance,bankCode);
         	  salesInvoiceRecord.add(salesInvoiceModel);
             }
        }
        
        finally
        {
        	preparedStatement.close();
        	rs.close();
        }

		return salesInvoiceRecord;
		
	}
	
}
