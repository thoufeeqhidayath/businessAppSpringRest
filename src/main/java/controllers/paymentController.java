package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.paymentService;
import models.paymentModel;

@RestController
public class paymentController {
	
	
	@Autowired
	private paymentService paymentService;
	
	
	@RequestMapping(value="/addpayment",method=RequestMethod.GET)
	public String  addPayment(@RequestParam(value="supplierId",defaultValue="000")int supplierId,@RequestParam(value="amount",defaultValue="000")double  amount,@RequestParam(value="bankCode",defaultValue="000")int  bankCode) throws SQLException
	{
		return paymentService.addPayment(supplierId, amount, bankCode);
	}
	
	
	
	@RequestMapping(value="/deletePayment",method=RequestMethod.GET)
	public String  deletePayment(@RequestParam(value="paymentNo",defaultValue="000")int paymentNo) throws SQLException
	{	
	    return paymentService.deletePayment(paymentNo);
	}
	
	
	
	@RequestMapping(value="/updatePayment",method=RequestMethod.GET)
	public String updatePayment(@RequestParam(value="paymentNo",defaultValue="000")int paymentNo,@RequestParam(value="supplierCode",defaultValue="000")int supplierCode,@RequestParam(value="amount",defaultValue="000")double amount,@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{
		return paymentService.updatePayment(paymentNo, supplierCode, amount, bankCode);
	}
	
	
	
	@RequestMapping(value= "/viewpayments" ,method = RequestMethod.GET)
	public  ArrayList<paymentModel> viewPayment() throws ClassNotFoundException, SQLException, IOException
	{
		return paymentService.viewPayment();
	}

}
