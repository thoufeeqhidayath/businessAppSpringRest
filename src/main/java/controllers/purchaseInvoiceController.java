package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessapp.business.viewModel;
import services.purchaseInvoiceService;
import models.purchaseInvoiceModel;

public class purchaseInvoiceController {

	@Autowired
	private purchaseInvoiceService purchaseInvoiceService;
	
	@RequestMapping(value="/addPurchaseInvoice" ,method=RequestMethod.GET)
	public String addPurchaseInvoice(@RequestParam(value="supplierCode",defaultValue="000")int supplierCode,@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{ 
		return purchaseInvoiceService.addPurchaseInvoice(supplierCode,bankCode);
	}
	
	@RequestMapping(value="/deletePurchaseInvoice",method=RequestMethod.GET)
	public String deletePurchaseInvoice(@RequestParam(value="purchaseNo",defaultValue="000")int purchaseNo) throws SQLException
	{	
		return purchaseInvoiceService.deletePurchaseInvoice(purchaseNo);
	}
	
	@RequestMapping(value="/updatePurchaseInvoice",method=RequestMethod.GET)
	public String updatePurchaseInvoice(int purchaseNo,int supplierCode,int bankCode) throws SQLException
	{
		return purchaseInvoiceService.updatePurchaseInvoice(purchaseNo, supplierCode, bankCode);
	}
	
	@RequestMapping(value= "/viewPurchaseInvoices" ,method = RequestMethod.GET)
	public ArrayList<purchaseInvoiceModel> viewPurchaseInvoices() throws ClassNotFoundException, SQLException, IOException
	{
		return purchaseInvoiceService.viewPurchaseInvoices();
	}
	
	
	
}
