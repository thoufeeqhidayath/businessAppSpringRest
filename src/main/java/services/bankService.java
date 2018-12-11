package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.bankDbRepository;

import appDBrepository.dbCommonServices;
import businessapp.business.viewModel;

@Service
public class bankService {
	
	@Autowired
	private bankDbRepository bankDbRepository;
	
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	public String addBank(String bankName) throws SQLException
	{	
		    String returnValue="ADDED";
			bankDbRepository.insertIntoBank(bankName);	
			return returnValue;
		
	}
		
	public String deleteBank(int bankCode) throws SQLException
	{
		String returnValue="deleted";
		if(!(dbCommonServices.checkValueExists("bank_table","bank_code",bankCode)).equals("exist"))
	
		{
		returnValue="bank not exists";
		}
	
		else
		{
			bankDbRepository.deleteFromBank(bankCode);
		}
		return returnValue;	
	}

	
	
	public String updateBank(int bankCode,String bankName) throws SQLException
	{
		String returnValue="Updated";
		if(!(dbCommonServices.checkValueExists("bank_table","bank_code",bankCode)).equals("exist"))
	
		{
		returnValue="bank not exists";
		}
	
		else
		{
			bankDbRepository.updateBank(bankCode, bankName);
		}
		return returnValue;	
	}
	
	public ArrayList<viewModel> viewBank() throws ClassNotFoundException, SQLException, IOException
	{
		return bankDbRepository.readFromBank();
	}

}
