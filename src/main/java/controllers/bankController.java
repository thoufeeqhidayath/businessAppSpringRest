package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.bankService;
import models.bankModel;


@RestController
public class bankController {
	
	
	@Autowired
	private bankService bankService;
	
	
	@RequestMapping(value="/addBank",method=RequestMethod.GET)
	public String addBank(@RequestParam(value="bankName",defaultValue="nothing")String bankName) throws SQLException
	{
		return bankService.addBank(bankName);
	}
	
	@RequestMapping(value="/deleteBank",method=RequestMethod.GET)
	public String deleteBank(@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{	
		return bankService.deleteBank(bankCode);		
	}
	
	@RequestMapping(value="/updateBank",method=RequestMethod.GET)
	public String updateBank(@RequestParam(value="bankCode",defaultValue="000")int bankCode,@RequestParam(value="bankName",defaultValue="000")String bankName) throws SQLException
	{	
		return bankService.updateBank(bankCode, bankName)	;
	}

	@RequestMapping(value= "/viewBank" ,method = RequestMethod.GET)
	public ArrayList<bankModel> viewBank() throws ClassNotFoundException, SQLException, IOException
	{
		return bankService.viewBank();
	}
}
