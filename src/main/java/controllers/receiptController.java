package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import businessapp.business.viewModel;
import services.receiptService;

@RestController
public class receiptController {

	@Autowired
	private receiptService receiptService;
	
	@RequestMapping(value="/addReceipt",method=RequestMethod.GET)
	public String  addReceipt(@RequestParam(value="customerCode",defaultValue="000")int customerCode,@RequestParam(value="amount",defaultValue="000")double amount,@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{
		return receiptService.addReceipt(customerCode, amount, bankCode);
	}
	
	@RequestMapping(value="/deleteReceipt",method=RequestMethod.GET)
	public String  deleteReceipt(@RequestParam(value="receiptCode",defaultValue="000")int receiptCode) throws SQLException
	{
		return receiptService.deleteReceipt(receiptCode);
	}
	
	@RequestMapping(value="/updateReceipt",method=RequestMethod.GET)
	public String updateReceipt(@RequestParam(value="receiptCode",defaultValue="000")int receiptCode,@RequestParam(value="customerCode",defaultValue="000")int customerCode,@RequestParam(value="amount",defaultValue="000")double amount,@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{
		return receiptService.UpdateReceipt(receiptCode, amount, customerCode, bankCode);
	}
	
	@RequestMapping(value= "/viewReceipt" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewReceipt() throws ClassNotFoundException, SQLException, IOException
	{
		return receiptService.viewReceipt();
	}

	
	
}
