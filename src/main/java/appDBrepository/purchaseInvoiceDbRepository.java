package appDBrepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import businessapp.business.viewModel;

import models.purchaseInvoiceModel;
@Service
public class purchaseInvoiceDbRepository extends dbConnections {
	
	public void insertIntoPurchaseInvoice(int supplierCode,int bankCode) throws SQLException
	{
		String query = "call insert_purchase_invoice(?,?,);";
		PreparedStatement preparedStatement=createPreparedStatement(query);
		
		try
		{
			preparedStatement.setInt(1, supplierCode);
			preparedStatement.setInt(2, bankCode);
			preparedStatement.executeUpdate();
		}
	    finally
		{
	    	preparedStatement.close();
		}
	}
	
	
	
	public void deleteFromPurchaseInvoice(int purchaseNo) throws SQLException
	{    
         String query = "call soft_delete_purchase_invoice(?)";
	     PreparedStatement preparedStatement=createPreparedStatement(query);
	     
	     try
	     {
	    	 preparedStatement.setInt(1, purchaseNo);
	    	 preparedStatement.executeUpdate();
	     }
	     finally
	     {
		      preparedStatement.close();
	     }
     
    }
	
	
	
	public void updatePurchaseInvoice(int  purchaseNo,int supplierCode,int bankCode) throws SQLException
	{
		 String query = "call update_purchase_invoice(?,?,?)";
		 PreparedStatement preparedStatement=createPreparedStatement(query);
		 
		 try
		 {
			 preparedStatement.setInt(1, supplierCode);
			 preparedStatement.setInt(2, bankCode);
			 preparedStatement.setInt(3, purchaseNo);
			 preparedStatement.executeUpdate();
		 }
		 finally
		 {
		   preparedStatement.close();
		 }
	}
	
	
	
	
	
	
	public ArrayList<purchaseInvoiceModel> readFromPurchaseInvoice() throws SQLException
	{ 
		purchaseInvoiceModel purchaseInvoiceModel=new purchaseInvoiceModel();
	    ArrayList<purchaseInvoiceModel> purchaseInvoiceRecord=new ArrayList<purchaseInvoiceModel>();
	   
	    String query ="call read_purchase_invoice()";
        PreparedStatement preparedStatement=createPreparedStatement(query);
        ResultSet rs= preparedStatement.executeQuery();
       
        try
        {
        	
        while(rs.next())
     
        {
    	  int purchaseNo=rs.getInt("purchase_no");
    	  String purchaseDate=(rs.getDate("purchase_date")).toString();
    	  int supplierCode=rs.getInt("supplier_code");
    	  int bankCode=rs.getInt("bank_code");
    	  double balance=rs.getDouble("total");
    	  
    	  purchaseInvoiceModel=new purchaseInvoiceModel(purchaseNo,purchaseDate,supplierCode,balance,bankCode);
    	  purchaseInvoiceRecord.add(purchaseInvoiceModel);
        }
        }
        
        finally{
        	
        	preparedStatement.close();
        	rs.close();
        
        }
		return purchaseInvoiceRecord;
		
	}
}
