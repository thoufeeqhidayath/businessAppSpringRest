package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.paymentDbRepositry;
import appDBrepository.dbCommonServices;
import businessapp.business.viewModel;

@Service
public class paymentService {

	@Autowired
	private paymentDbRepositry paymentDbRepositry;
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	
	public String  addPayment(int supplierId,double amount,int bankCode) throws SQLException
	{
		String returnValue="payment   added";
		
		if(!(dbCommonServices.checkValueExists("supplier","supplier_code",supplierId)).equals("exist"))
		{
			returnValue="SupplierID not exists";
		
		}
		else if(!(dbCommonServices.checkValueExists("bank_table","bank_code",bankCode)).equals("exist"))
		{
			returnValue="bank code not exists";
		}
		else
		{
			paymentDbRepositry.insertIntoPayment(supplierId,amount,bankCode);
		}
		return returnValue;
	}

	
	public String  deletePayment(int paymentNo) throws SQLException
	{
		
		String returnValue="payment deleted";
	
	
		if(!(dbCommonServices.checkValueExists("payment","payment_no",paymentNo)).equals("exist"))
	
		{
			returnValue="payment number not exist";
		}
		else
		{
			paymentDbRepositry.deleteFromPayment(paymentNo);
		}
		return returnValue;
	}
	
	public String  updatePayment(int paymentNo,int supplierCode,double amount,int bankCode) throws SQLException
	{
		
		String returnValue="payment updated";
		if(!(dbCommonServices.checkValueExists("payment","payment_no",paymentNo)).equals("exist"))
		{
		returnValue="payment number not exists";
		}
		else if(!(dbCommonServices.checkValueExists("supplier","supplier_code",supplierCode).equals("exist")))
		{
		returnValue="supplier code not exists";
		
		}
		else  if(!(dbCommonServices.checkValueExists("bank_table","bank_code",bankCode).equals("exist")))
		{
			returnValue="bank code not exists";	
		}
		else
		{
			paymentDbRepositry.updatePayment(paymentNo, supplierCode, amount, bankCode);
		}
		return returnValue;
	}
	
	public ArrayList<viewModel> viewPayment() throws ClassNotFoundException, SQLException, IOException
	{
		return paymentDbRepositry.readFromPayment();
	}
	

}
