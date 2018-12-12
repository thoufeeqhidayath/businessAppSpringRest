package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.dbCommonServices;
import appDBrepository.receiptDbRepository;
import businessapp.business.viewModel;
import models.receiptModel;
@Service
public class receiptService {
	
	
	@Autowired
	private receiptDbRepository receiptDbRepository;
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	
	
	public String addReceipt(int customerCode,double amount,int bankCode) throws SQLException
	{
		String returnValue="Receipt added";
		
		if(!(dbCommonServices.checkValueExists("customer","customer_code",customerCode)).equals("exist"))
		{
		returnValue="Customer code not exists";
		
		}else if(!(dbCommonServices.checkValueExists("bank_table","bank_code",bankCode)).equals("exist"))
		{
			returnValue="bank code not exists";
		}
		else
		{
			receiptDbRepository.insertIntoReceipt(customerCode, amount, bankCode);
		}	
		return returnValue;
	}
	
	
	public String deleteReceipt(int receiptCode) throws SQLException
	{
		String returnValue="Receipt deleted";
		
		if(!(dbCommonServices.checkValueExists("receipt","receipt_code",receiptCode)).equals("exist"))
		{
			returnValue="Receipt number not exist";
		}
		else
		{
			receiptDbRepository.deleteFromReceipt(receiptCode);
		}
		
		return returnValue;
	}
	
	public String UpdateReceipt(int receiptCode,double amount,int customerCode,int bankCode) throws SQLException
	{
		String returnValue="Receipt Updted";
		
		if(!(dbCommonServices.checkValueExists("receipt","receipt_code",receiptCode)).equals("exist"))
		{
			returnValue="Receipt number not exist";
		}
		else if(!(dbCommonServices.checkValueExists("customer","customer_code",customerCode)).equals("exist"))
		{
			returnValue="Customer code Doesn't Exist";
		}
		else if(!(dbCommonServices.checkValueExists("bank_table","bank_code",bankCode)).equals("exist"))
		{
			returnValue="Bank code Doesn't Exist";
		}
		
		else{
			receiptDbRepository.updateReceipt(receiptCode, customerCode, amount, bankCode);
		}
		
		return returnValue;
	}
	
	public ArrayList<receiptModel> viewReceipt() throws ClassNotFoundException, SQLException, IOException
	{
		return  receiptDbRepository.readFromReceipt();
	}


}
